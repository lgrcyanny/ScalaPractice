package patmat

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import patmat.Huffman._

@RunWith(classOf[JUnitRunner])
class HuffmanSuite extends FunSuite {
  trait TestTrees {
    val t1 = Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5)
    val t2 = Fork(Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5), Leaf('d',4), List('a','b','d'), 9)
  }

  test("weight of a larger tree") {
    new TestTrees {
      assert(weight(t1) === 5)
    }
  }

  test("chars of a larger tree") {
    new TestTrees {
      assert(chars(t2) === List('a','b','d'))
    }
  }

  test("string2chars(\"hello, world\")") {
    assert(string2Chars("hello, world") === List('h', 'e', 'l', 'l', 'o', ',', ' ', 'w', 'o', 'r', 'l', 'd'))
  }

  test("makeOrderedLeafList for some frequency table") {
    assert(makeOrderedLeafList(List(('t', 2), ('e', 1), ('x', 3))) === List(Leaf('e',1), Leaf('t',2), Leaf('x',3)))
  }

  test("combine of some leaf list") {
    val leaflist = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4))
    assert(combine(leaflist) === List(Fork(Leaf('e',1),Leaf('t',2),List('e', 't'),3), Leaf('x',4)))
  }

  test("decode and encode a very short text should be identity") {
    new TestTrees {
      assert(encode(t1)("ab".toList) == List(0, 1))
      assert(decode(t1, encode(t1)("ab".toList)) === "ab".toList)
      assert(decode(t1, quickEncode(t1)("ab".toList)) === "ab".toList)
    }
  }

  test("decode frenchCode") {
    assert(Huffman.decodedSecret == "huffmanestcool".toList)
  }

  test("make a huffman tree, encode and decode a long text") {
    info("The huffman tree is the same as the example tree in assignment4")
    val chars = "CDEFGHBBBAAAAAAAA".toList
    val codeTree = Huffman.createCodeTree("CDEFGHBBBAAAAAAAA".toList)
    val text = "BAC".toList
    val encodedRes = Huffman.encode(codeTree)(text)
    assert(encodedRes == List(1, 1, 1, 0, 1, 0, 0, 0))
    assert(encodedRes == Huffman.quickEncode(codeTree)(text))
    val decodedRes = Huffman.decode(codeTree, encodedRes)
    assert(text == decodedRes)
  }

  test("combine singleton and nill") {
    assert(Huffman.combine(List()).isEmpty)
    assert(Huffman.combine(List(new Leaf('c', 1))).length == 1)
  }
}
