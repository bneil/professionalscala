package com.example

object Factorial {
  def main(args: Array[String]): Unit = {
    println(factorial(5))
  }

  def factorial(n:Int):Int = {
    if (n==0) { 1 }
    else { n * factorial(n-1) }
  }

  def testCore() = Core.testMethod()
}
