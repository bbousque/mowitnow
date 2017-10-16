package fr.bbt.mowitnow

import org.scalatest.FunSuite

import scala.io.Source
import Utils._

/**
  * Created by brice on 15/10/2017.
  */
class UtilsTest extends FunSuite {

  test("Rotation d'une liste") {
    assert(Array("1","2","3").rotate(true).mkString(",").equals(Array("3","1","2").mkString(",")))
  }

  test("Maximum d'une valeur entière") {
    assert((maxVal(1,3),maxVal(4,3),maxVal(-2,3)) equals (1,3,0))
  }

  test("Parsing coordonées en tuple") {
    assert("1 1".toCoord() equals (1,1))
  }

  test("Parsing de l'état depuis une string") {
    assert("1 1 N".toState().toString equals "1 1 N")
  }

  test("Lecture Instructions") {
    val source = Source.fromURL(getClass.getResource("/instructions.txt")).getLines()

    assert(
      loadInstructions(source).map(_.initState.toString).mkString(",") equals "1 2 N,3 3 E"
    )
  }

}
