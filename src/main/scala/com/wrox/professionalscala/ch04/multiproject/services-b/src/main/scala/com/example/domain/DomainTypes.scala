package com.example.domain

import java.util.UUID

object DomainTypes {
  case class Test(message: String, x: Int)
  case class Person(id: Int, name: String, age: Int)
}

