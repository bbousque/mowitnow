package fr.bbt.mowitnow

import org.scalatest.FunSuite

import scala.io.Source
import Utils._

/**
  * Created by brice on 15/10/2017.
  */
class UtilsTest extends FunSuite {

  test("Lecture Instructions") {
  val source = Source.fromURL(getClass.getResource("/instructions.txt")).getLines()

  loadInstructions(source).foreach(t => println(t.finalState))

    assert(true)
  }

}
