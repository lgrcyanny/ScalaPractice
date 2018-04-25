package com.cyanny.learning.scala.reflection

import scala.reflect.runtime.{universe => ru}

object Overview {

  // Inspecting runtime type
  def example1() = {
    val l = List(1, 2, 3)
    def getTypeTag[T: ru.TypeTag](obj: T) = ru.typeTag[T]
    val theType = getTypeTag(l).tpe
    println(theType)
    val decls = theType.decls.take(10)
    println(decls)
  }

  // INSTANTIATING A TYPE AT RUNTIME
  case class Person(name: String, age: Int)
  def example2() = {
    val mirror = ru.runtimeMirror(Person.getClass.getClassLoader)
    val classPerson = ru.typeOf[Person].typeSymbol.asClass
    val classMirror: ru.ClassMirror = mirror.reflectClass(classPerson)
    val ctor: ru.MethodSymbol = ru.typeOf[Person].decl(ru.termNames.CONSTRUCTOR).asMethod
    val ctorm: ru.MethodMirror = classMirror.reflectConstructor(ctor)
    val p = ctorm("Mike", 24)
    println(p)
  }

//  ACCESSING AND INVOKING MEMBERS OF RUNTIME TYPES
  case class Purchase(name: String, orderNumber: Int, var shipped: Boolean)
  def example3() = {
    val m = ru.runtimeMirror(getClass.getClassLoader)
    val p = Purchase("Jeff Lebowski", 23819, true)
    val shippingTermSymb = ru.typeOf[Purchase].decl(ru.TermName("shipped")).asTerm
    val im = m.reflect(p)
    val shippingFieldMirror = im.reflectField(shippingTermSymb)
    println(shippingFieldMirror.get)
    println(shippingFieldMirror.set(false))
    println(shippingFieldMirror.get)
  }

  // Runtime classes in java vs runtime classes in scala
  class E {
    type T
    val x: Option[T] = None
  }
  class C extends E
  class D extends C
  def example4() = {
    val c = new C { type T = String }
    val d = new D {type T = String}
    println(c.getClass.isAssignableFrom(d.getClass)) // should be true, but false here

    def m[T: ru.TypeTag, U: ru.TypeTag](x: T, y: U): Boolean = {
      val leftTag = ru.typeTag[T]
      val rightTag = ru.typeTag[U]
      leftTag.tpe <:< rightTag.tpe
    }
    println(m(d, c))
  }

  def main(args: Array[String]): Unit = {
    example1()
    example2()
    example3()
    example4()
  }
}
