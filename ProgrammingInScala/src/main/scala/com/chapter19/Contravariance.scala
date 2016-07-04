package com.chapter19

/**
  * Created by lgrcyanny on 16/6/18.
  */
object Contravariance {

  class Publication(val title: String)
  class Book(title: String) extends Publication(title)
  object Library {
    val books = List(new Book("Harry Potter"), new Book("Game of Throne"))
    def printBooks(info: Book => AnyRef) = {
      for (book <- books) {
        println(info(book))
      }
    }
  }

  def main(args: Array[String]) {
    val getTitle = (b: Book) => b.title
    Library.printBooks(getTitle)
  }
}
