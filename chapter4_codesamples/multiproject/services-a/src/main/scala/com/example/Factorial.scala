package com.example

object Factorial {
  def main(args: Array[String]): Unit = {
    println(factorial(5))
  }

  def factorial(n: Int, acc:Int = 0): Int = {
    if(n == 0){ acc }
    else factorial(n-1, acc+n)
  }

  def testCore() = Core.testMethod()
}
