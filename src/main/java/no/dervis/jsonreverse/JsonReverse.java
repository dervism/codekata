package no.dervis.jsonreverse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.NumericNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class JsonReverse {

    // algebraic type definitions
    sealed interface Node permits StringNode, MapNode, ListNode, IntNode { }
    record StringNode(String value) implements Node {}
    record IntNode(Integer value) implements Node {}
    record MapNode(Map<String, Node> value) implements Node {}
    record ListNode(List<Node> value) implements Node {}

    // function that makes char array to list of strings
    static final Function<char[], List<String>> toListFn = array ->
            IntStream
                    .range(0, array.length)
                    .map(i -> array[i])
                    .mapToObj(Character::toString).toList();

    // function that makes a string list to a reversed string
    static final Function<List<String>, String> reverseFn = c -> c.stream()
            .collect(Collector.of(() -> new ArrayDeque<String>(),
                            ArrayDeque::addFirst,
                            (a, b) ->  a))
            .stream().map(Object::toString).collect(Collectors.joining());

    // composed function that reverses a string
    static final Function<String, String> transformFn = s -> reverseFn.compose(toListFn).apply(s.toCharArray());

    // mapping function that, given a string and a mapping function, produces another string
    static final BiFunction<String, Function<String, String>, String> transform = String::transform;

    // function that reverses a string using a transform function
    static final Function<String, String> reverseStringFn = s -> transform.apply(s, transformFn);

    // custom deserializer to map to our own types
    public static Node parseNode(JsonNode node) {
        return switch (node) {
            case ArrayNode a -> {
                final var list = new LinkedList<Node>();
                a.forEach(element -> list.add(parseNode(element)));
                yield new ListNode(list);
            }
            case ObjectNode o -> {
                final var map = new LinkedHashMap<String, Node>();
                o.fields().forEachRemaining(entrySet -> map.put(entrySet.getKey(), parseNode(entrySet.getValue())));
                yield new MapNode(map);
            }
            case TextNode a -> new StringNode( reverseStringFn.apply(a.textValue()));
            case NumericNode a -> new IntNode(a.intValue());
            default -> throw new RuntimeException("What is this?! ");
        };
    }

    public static void main(String[] args) throws JsonProcessingException {

        JsonNode node = new ObjectMapper().readTree("""
                {"a": [1, {"b": [2, {"c": "Hello,"}]}, {"b": [{"c": "world!"}]}]}
                """);
        System.out.println(parseNode(node));
    }
}
