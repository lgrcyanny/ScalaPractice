package com.chapter26

/**
  * Created by lgrcyanny on 16/12/5.
  */
object RegexTest {
  val Decimal = """(-)?(\d+)(\.\d*)?""".r

  def main(args: Array[String]): Unit = {
    "-1.23" match {
      case Decimal(sign, integerpart, decimalpart) =>
        println(s"$sign, $integerpart, $decimalpart")
    }
  }

}
