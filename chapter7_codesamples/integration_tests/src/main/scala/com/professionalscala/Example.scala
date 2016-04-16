package com.professionalscala

object HelloWorld {
  def main(args: Array[String]) {
  }
}

trait Animal
trait Mineral
trait Horse extends Animal
object PaintHorse extends Horse
object MrEd extends Horse

object HorseOfCourse{

  def isHorseOrMrEd: Animal => String = {
    case PaintHorse => "horse"
    case MrEd => "mr ed"
    case _ => "not a horse or mr ed"
  }

  def apply(x: Animal) = isHorseOrMrEd(x)

}

class Fraction(n: Int, d: Int) {

  require(d != 0)
  require(d != Integer.MIN_VALUE)
  require(n != Integer.MIN_VALUE)

  val numer = if (d < 0) -1 * n else n
  val denom = d.abs

  override def toString = numer + " / " + denom
}

