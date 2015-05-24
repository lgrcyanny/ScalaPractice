object example {
  def sum1(a: Int, b: Int): Int= {
    if (a > b) 0 else a + sum1(a + 1, b)
  }

  sum1(1, 3)



  def sum2(f: Int => Int, a: Int, b: Int): Int = {
    if (a > b) 0 else f(a) + sum2(f, a + 1, b)
  }

  def cube(x: Int): Int = x * x * x

  sum2(cube, 1, 3)

  sum2((x) => x * x, 1, 3)


  def sum3(f: Int => Int, a: Int, b: Int): Int = {
    def recurSum(acc: Int, a: Int): Int = {
      if (a > b) acc else recurSum(f(a) + acc, a + 1)
    }
    recurSum(0, a)
  }

  def factorial(n: Int):Int = {
    def loop(acc: Int, n: Int): Int = {
      if (n == 0) 1 else loop(acc * n, n - 1)
    }
    loop(1, n)
  }

  sum3(factorial, 3, 4)


}