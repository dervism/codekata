# minesweeper-kata

Takes in a Json string and reverses the string values it contains:

Input:
```
{"a": [1, {"b": [2, {"c": "Hello,"}]}, {"b": [{"c": "world!"}]}]}
```

A custom deserializer will then produce the following domain model:

```
MapNode[value={
    a=ListNode[value=[
        IntNode[value=1], 
        MapNode[value={
            b=ListNode[value=[
                IntNode[value=2], 
                MapNode[value={c=StringNode[value=,olleH]}]]]}
            ], 
        MapNode[value={
            b=ListNode[value=[
                MapNode[value={c=StringNode[value=!dlrow]}]]]}
]]]}]
```
