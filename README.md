# DataStructure-Java
Implementation of High-Level Data Structure Using Java
## Tree/Graph
- [FenwickTree](https://github.com/KevinDeng31/DataStructure-Java/blob/master/FenwickTree.java)
- [SegmentTreeNode](https://github.com/KevinDeng31/DataStructure-Java/blob/master/SegmentTreeNode.java)
  - Segement Tree is used to calculate sum of an array given a specific range
  - Time complexity (given an array with length n):
    - To build a segment tree O(n). There are (2n - 1) nodes in this tree
    - To update a segment tree O(log(n)). After finding the leaf to update, we need to update one node at each level on the way back to root
    - To query a sum O(log(n)).
## Sort
- Quick Sort:[]()
