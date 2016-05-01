import collection.mutable.Stack
import org.scalatest._

class ExampleSpec extends FlatSpec with Matchers {

  "A Stack" should "pop values in last-in-first-out order" in {
    val stack = new Stack[Int]
    stack.push(1)
    stack.push(2)
    stack.pop() should be(2)
    stack.pop() should be(1)
  }

  it should "throw NoSuchElementException if an empty stack is popped" in {
    val emptyStack = new Stack[Int]
    a[NoSuchElementException] should be thrownBy {
      emptyStack.pop()
    }
  }

  "A number error" should "throw a divide by zero" in {
    a[java.lang.ArithmeticException] should be thrownBy {
      1 / 0
    }
  }

  sealed trait Animal
  sealed trait Mineral
  object Cat extends Animal
  "An object" should "be inherit properly" in {
    val cat = Cat
    cat shouldBe a [Animal]
    cat should not be a [Mineral]
  }
}

