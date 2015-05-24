object example {
  def sum1(f: Int => Int): (Int, Int) => Int = {
    def sum(a: Int, b: Int): Int = {
      if (a > b) 0 else f(a) + sum(a + 1, b)
    }
    sum
  }

  val square = sum1(x => x * x)
  square(1, 2)

  sum1(x => x + 1)(1, 10)

  def sum2(f: Int => Int)(a: Int, b: Int): Int = {
    if (a > b) 0 else f(a) + sum2(f)(a + 1, b)
  }

  sum2(x => x * x * x)(1, 3)


  //1. define a product function

  def product(f: Int => Int)(a: Int, b: Int): Int = {
    if (a > b) 1
    else f(a) * product(f)(a + 1, b)
  }
  product(x => x)(1, 3)

  // 2. define factorial function with product

  def factorail(n: Int) = product(x => x)(1, n)

  factorail(5)

  // 3. generalize product and sum function
  def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int = {
    if (a > b) zero
    else combine(f(a), mapReduce(f, combine, zero)(a + 1, b))
  }

  def sum3(f: Int => Int)(a: Int, b: Int): Int =
    mapReduce(f, (x, y) => x + y, 0)(a, b)

  sum3(x => x)(1, 2)

  def product2(f: Int => Int)(a: Int, b: Int): Int =
    mapReduce(f, (x, y) => x * y, 1)(a, b)

  product2(x => x)(1, 4)

  def f = (x: Int) => ((y: Int) => ((z: Int) => x / y + z))

  f(4)(2)(1)
}