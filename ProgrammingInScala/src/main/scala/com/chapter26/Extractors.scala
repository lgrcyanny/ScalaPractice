package com.chapter26

/**
  * Created by lgrcyanny on 16/12/3.
  */
object Extractors {
  object Email {
    def apply(user: String, domain: String) = s"$user@$domain"
    // extractor method
    def unapply(str: String): Option[(String, String)] = {
      val parts = str.split("@")
      if (parts.length == 2) Some((parts(0), parts(1))) else None
    }
  }

  object Twice {
    def apply(s: String) = s + s
    def unapply(s: String): Option[String] = {
      val length = s.length / 2
      val half = s.substring(0, length)
      if (half == s.substring(length)) Some(half) else None
    }
  }

  object UpperCase {
    def unapply(str: String): Boolean = {
      str.toUpperCase == str
    }
  }

  object Domain {
    def apply(parts: String*) = parts.reverse.mkString(".")
    def unapplySeq(str: String): Option[Seq[String]] = {
      Some(str.split("\\.").reverse)
    }
  }

  def testEmail() = {
    val email = "john@gmail.com"
    email match {
      case Email(user, domain) =>
        println(s"valid address: $user@$domain")
      case x@_ =>
        println(s"Unknown Args:$x")
    }
  }

  def testEmailWithTwiceAndUpperCase(): Unit =  {
    val email = "XXXXXX@TOM.COM"
    email match {
      case Email(Twice(x @ UpperCase()), domain) =>
        println(s"match $x in domain: $domain")
      case _ =>
        println("no match")
    }
  }

  def testDomain() = {
    val str = "a.b.c.d.net"
    str match {
      case Domain("net", _*) => println("a net kind of domain")
      case x@_ =>
        println(s"args is $x")
    }
  }

  def main(args: Array[String]): Unit = {
    testEmail()
    testEmailWithTwiceAndUpperCase()
    testDomain()
  }

}
