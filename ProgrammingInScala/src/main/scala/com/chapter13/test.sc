object Person {
  private def password = "1212"
}

class Person {
  import Person._
  println(password)
}

val p = new Person

