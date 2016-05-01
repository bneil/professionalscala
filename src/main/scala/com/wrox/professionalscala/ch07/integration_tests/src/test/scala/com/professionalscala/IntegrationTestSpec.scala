package com.professionalscala

import org.scalatest._

class IntegrationTestSpec extends FlatSpec with Matchers {

  object Cat extends Animal
  "An object" should "be inherit properly" in {
    val cat = Cat
    cat shouldBe a [Animal]
    cat should not be a [Mineral]
  }

  val allHorses = Array(PaintHorse, PaintHorse, MrEd)

  "A Horse" should "always be a horse" in {
    for(horse <- allHorses.filter(_ == PaintHorse)){
      horse should be (PaintHorse)
    }
  }

  it should "unless its the famous Mr. Ed" in {
    val mrEd = allHorses contains MrEd
    mrEd should be (true)
  }

  it should "understand the difference between horses" in {
    for(horse <- allHorses){
      val isItAHorse = HorseOfCourse(horse)
      horse match {
        case PaintHorse => isItAHorse should be("horse")
        case MrEd => isItAHorse should be("mr ed")
        case _ => isItAHorse should be("not a horse or mr ed")
      }
    }
  }
}

