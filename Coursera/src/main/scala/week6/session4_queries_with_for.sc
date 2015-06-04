case class Book(title: String, authors: List[String])
val books = Set(
  Book("Book1", List("A1", "A2", "A3")),
  Book("Book2", List("B1", "B2", "B3")),
  Book("Book3", List("A1", "A2", "A3")),
  Book("Book4", List("C1", "C2", "C3")),
  Book("Book5", List("A1", "A2", "D3"))
)

for (b <- books; a <- b.authors if a.startsWith("A")) yield b.title

for {
  b1 <- books
  b2 <- books
  if (b1.title < b2.title)
  a1 <- b1.authors
  a2 <- b2.authors
  if a1 == a2
} yield a1
