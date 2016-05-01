package com.professionalscala

import scala.language.postfixOps

object MathFun {
  def sumOfSeries(range: Int): Double = {
    if(range >= 100) 0.0
    else if(range <= 0) 0.0
    else {
      println(range)
      1 to range map (x => 1.0 / (x * x)) sum
    }
  }
}
