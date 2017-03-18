package com.chapter33

import scala.util.parsing.combinator.JavaTokenParsers


class JSONParserTest extends JavaTokenParsers {
  def parseTrue: Parser[Boolean] = "true" ^^ {x => true}
}

object JSONParserTest extends JSONParserTest {
  def main(args: Array[String]): Unit = {
    parse(parseTrue, "true") match {
      case Success(result, _) => println(s"got result=$result")
    }
  }

}
