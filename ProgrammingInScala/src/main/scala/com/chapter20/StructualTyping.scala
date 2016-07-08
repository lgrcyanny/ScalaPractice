package com.chapter20

/**
  * Created by lgrcyanny on 16/7/7.
  */
object StructualTyping {
  class Grass
  abstract class Animal {
    type SuitableFood = Grass
  }
  class Pasture {
    val animals: List[Animal {type SuitableFood = Grass}] = Nil
  }

  def using[T <: {def close(): Unit}, S](obj: T)(operation: T => S) = {
    val res = operation(obj)
    obj.close()
    res
  }

}
