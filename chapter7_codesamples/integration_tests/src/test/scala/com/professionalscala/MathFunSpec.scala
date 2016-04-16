package com.professionalscala

import org.scalatest._
import org.scalatest.prop.GeneratorDrivenPropertyChecks

class MathFunSpec extends WordSpec with GeneratorDrivenPropertyChecks with Matchers {

  implicit override val generatorDrivenConfig = PropertyCheckConfig(minSuccessful = 2, minSize = 1, maxSize = 10)

  "A series of numbers" should {
    forAll { (n: Int) =>
      whenever (n > 1) { MathFun.sumOfSeries(n) should be >= 0.0 }
    }
  }
}
