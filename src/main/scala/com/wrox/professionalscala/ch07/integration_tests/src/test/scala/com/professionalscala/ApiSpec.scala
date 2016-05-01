package com.professionalscala

import org.scalatest.concurrent.Eventually
import org.scalatest.mock.MockitoSugar
import org.scalatest.selenium.HtmlUnit
import org.scalatest.{FlatSpec, ShouldMatchers}

class ApiSpec extends FlatSpec with ShouldMatchers with HtmlUnit with Eventually with MockitoSugar {

  val host = "http://localhost:8080/"

  "This is a test route" should "should have the test content" in {
    go to (host + "testRoute")
    pageSource should be ("This is a test route")
  }

  "This is a google search for Groundhog Day" should "should be greater than 90%" in {
    go to "http://www.google.com"
    click on "q"
    textField("q").value = "Groundhog Day Rotten Tomatoes"
    submit()
    eventually {
      val rawRating = find(cssSelector("div.f.slp")).get.underlying.getText
      val rating = rawRating.replaceAll("\n","").replaceAll("  Rating: ","").replaceAll("%.*$","").toInt
      rating should be > 90
    }
  }
}
