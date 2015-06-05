import java.io.File

import scala.io.Source
object session7_phone_keys_mnemonics {

  lazy val in = Source.fromFile("/Users/lgrcyanny/Codecookies/scalaworkspace/Coursera/src/main/resources/words.txt")
  // Get All words from file
  lazy val words = in.getLines.toList.filter(word => word forall (_.isLetter))

  val mnem = Map('2' -> "ABC", '3' -> "DEF", '4' -> "GHI",
    '5' -> "JKL", '6' -> "MNO", '7' -> "PQRS",
    '8' -> "TUV", '9' -> "WXYZ"
  )

  val charCode: Map[Char, Char] =
    for ((num, chars) <- mnem; c <- chars) yield c -> num


  def wordCode(word: String) = word.toUpperCase map charCode

  //wordCode("JAVa")

  // a map from a digit strings to words list
  // an inverted index of words
  lazy  val wordsForNum: Map[String, Seq[String]] =
    words groupBy wordCode withDefaultValue(Seq())


  def encode(number: String): Set[List[String]] =
    if (number.isEmpty) Set(List())
    else {
      for {
        split <- 1 to number.length
        word <- wordsForNum(number take split)
        rest <- encode(number drop split)
      } yield word :: rest
    }.toSet

  //encode("7225247386")

  def translate(number: String): Set[String] =
    encode(number) map (_.mkString(" "))

  // val res = translate("7225247386")
  // res.foreach(println)
}