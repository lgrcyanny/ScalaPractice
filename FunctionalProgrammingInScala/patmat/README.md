Some Issues when I implement Huffman algorithm
=================

1.**decode** function error<br>
the previouse implementation is:<br>

```scala
def decode(tree: CodeTree, bits: List[Bit]): List[Char] = {
    def iter(current_tree: CodeTree, bits: List[Bit]): List[Char] = bits match {
      case Nil => Nil // How about current_tree is Leaf?
      case b :: bs => {
        current_tree match {
          case Leaf(c, w) => c :: iter(tree, bs) // It's not corrent, should be bits
          case Fork(left, right, chars, weight) => if (b == 0) iter(left, bs, acc) else iter(right, bs)
        }
      }
    }
    iter(tree, bits, Nil)
}
```
Now I found that won't pass the test, So I found I missed the case that when bits is Nil, the tree may be Leaf, and when bits is not Empty and tree is leaf, `c :: iter(tree, bs)`, which is not right, becase bs should be bits, the correct version is:
```scala
  def decode(tree: CodeTree, bits: List[Bit]): List[Char] = {
    def iter(current_tree: CodeTree, bits: List[Bit], acc: List[Char]): List[Char] = bits match {
      case Nil => {
        current_tree match {
          case Leaf(c, w) => acc ++ List(c) // When the bits is empty, there is possible now at Leaf node
          case Fork(left, right, chars, weight) => acc
        }
      }
      case b :: bs => {
        current_tree match {
          case Leaf(c, w) => iter(tree, bits, acc ++ List(c))
          case Fork(left, right, chars, weight) => if (b == 0) iter(left, bs, acc) else iter(right, bs, acc)
        }
      }
    }
    iter(tree, bits, Nil)
  }
```

2.**combine** function issue<br>
+ I didn't think about the case when trees.length <= 1
+ When new tree weight equals to some existed trees, the new tree should be put after existed trees, that is put inner node after outer node, so `new_trees span (x => weight(x) < weight(new_tree))` should be `new_trees span (x => weight(x) <= weight(new_tree))`, should be "<=", not "<"

```scala
  def combine(trees: List[CodeTree]): List[CodeTree] = {
    if (trees.length <= 1) trees
    else {
      val two_elements = trees take 2
      val new_tree: CodeTree = makeCodeTree(two_elements(0), two_elements(1))
      val new_trees = trees drop 2
      val (first, rest) = new_trees span (x => weight(x) <= weight(new_tree)) // Put inner node after outer node
      first ++ List(new_tree) ++ rest
    }
  }
```

3.**encode** function issue<br>
When accumulate bits, I use "0 :: bits", it's not correct, becase Cons operation is prepend, the bits sequence will be reverse, what I need is `append`, so accumulation should be `bits ++ List(0)`

```scala
  def encode(tree: CodeTree)(text: List[Char]): List[Bit] = {
    def encodeSingleChar(tree: CodeTree, c: Char, bits: List[Bit]): List[Bit] = tree match {
      case Leaf(c1, w) => bits
      case Fork(left, right, cs, w) => {
        if (chars(left).contains(c)) {
          encodeSingleChar(left, c, bits ++ List(0)) // should not be 0 :: bits
        } else if (chars(right).contains(c)){
          encodeSingleChar(right, c, bits ++ List(1))
        } else {
          throw new Error("Can't find " + c + " in codetree")
        }
      }
    }
    text match {
      case Nil => Nil
      case x :: xs => encodeSingleChar(tree, x, Nil) ++ encode(tree)(xs)
    }
  }
```