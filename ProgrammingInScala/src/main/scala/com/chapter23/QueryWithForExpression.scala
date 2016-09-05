package com.chapter23

/**
  * Created by lgrcyanny on 16/8/24.
  */
object QueryWithForExpression {
  case class Book(title: String, authors: String*)

  val books: List[Book] =
    List(
      Book(
        "Structure and Interpretation of Computer Programs",
        "Abelson, Harold", "Sussman, Gerald J."
      ), Book(
        "Principles of Compiler Design",
        "Aho, Alfred", "Ullman, Jeffrey"
      ),
      Book(
        "Programming in Modula-2",
        "Wirth, Niklaus"
      ), Book(
        "Elements of ML Programming",
        "Ullman, Jeffrey"
      ), Book(
        "The Java Language Specification", "Gosling, James",
        "Joy, Bill", "Steele, Guy", "Bracha, Gilad"
      )
    )

  def main(args: Array[String]) {
    val res = for (b <- books; a <- b.authors if a.startsWith("St")) yield b
    println(res)
  }

}
