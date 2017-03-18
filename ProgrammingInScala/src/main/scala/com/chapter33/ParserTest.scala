package com.chapter33

import com.sun.tools.javac.code.Attribute.Error

import scala.util.parsing.combinator._
/**
  * Created by lgrcyanny on 17/2/19.
  */

class SimpleParser extends RegexParsers {
  case class WordFreq(word: String, count: Int) {
    override def toString = "Word <" + word + "> " +
      "occurs with frequency " + count
  }
  def word: Parser[String] = """[a-z]+""".r ^^ {w => w.toString}
  def count: Parser[Int] = """(0|[0-9]\d*)""".r ^^ {_.toInt}
  def freq: Parser[WordFreq] = word ~ count ^^ {case wr ~ fr => WordFreq(wr, fr)}
}

object SimpleParserTest extends SimpleParser {
  def main(args: Array[String]): Unit = {
    parse(freq, "johoy 1990") match {
      case Success(matched,_) => println(matched)
      case Failure(msg,_) => println("FAILURE: " + msg)
      case Error(msg,_) => println("ERROR: " + msg)
    }
  }
}
