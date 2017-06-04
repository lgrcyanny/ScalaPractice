package com.learning.puzzlers
import collection.immutable.HashSet
/**
  * Created by lgrcyanny on 17/5/22.
  */
object AEqualityCase {
  trait TraceHashCode {
    override def hashCode(): Int = {
      println(s"TRACE hashcode for ${this}")
      super.hashCode()
    }
  }

  // mix in trait at instantiation
  case class Country(isoCode: String)
  def newSwitzInst = new Country("CH") with TraceHashCode
  // mix in trait at declaration time
  case class CountryWithTrace(isoCode: String) extends
    TraceHashCode
  def newSwitzDecl = CountryWithTrace("CH")

  def main(args: Array[String]): Unit = {
    val countriesInst = HashSet(newSwitzInst)
    println(countriesInst.iterator contains newSwitzInst)
    println(countriesInst contains newSwitzInst)
    val countriesDecl = HashSet(newSwitzDecl)
    println(countriesDecl.iterator contains newSwitzDecl)
    println(countriesDecl contains newSwitzDecl)
  }

}
