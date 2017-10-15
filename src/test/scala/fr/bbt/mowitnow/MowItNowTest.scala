package fr.bbt.mowitnow

import org.scalatest.FunSuite
import AppClasses._

/**
  * Created by brice on 15/10/2017.
  */
class MowItNowTest extends FunSuite with TondeuseTrait {

  test("Turn Right") {
/*    assert(
      (
        newDirection(State((0,0),"N"), 'D').direction,
        newDirection(State((0,0),"E"), 'D').direction,
        newDirection(State((0,0),"S"), 'D').direction,
        newDirection(State((0,0),"W"), 'D').direction
        )
        equals ("E","S","W","N")
    )*/
  }

  test("Turn Left") {
/*    assert(
      (
        newDirection(State((0,0),"N"), 'G').direction,
        newDirection(State((0,0),"W"), 'G').direction,
        newDirection(State((0,0),"S"), 'G').direction,
        newDirection(State((0,0),"E"), 'G').direction
        )
        equals ("W","S","E","N")
    )*/
  }

  test("Go Ahead without Max") {
    val coord = (2,2)
    val maxCoord = (5,5)
    /*    val goAheadFn = goAhead(maxCoord)

        assert(
          (
            goAheadFn(State(coord, "N")),
            goAheadFn(State(coord, "S")),
            goAheadFn(State(coord, "E")),
            goAheadFn(State(coord, "W"))
            )
            equals ((2,3),(2,1),(3,2),(1,2))
        )*/
  }

  test("Go Ahead with Max") {
    val coord : (Int,Int) = (2,2)
    val maxCoord : (Int,Int) = (2,2)
    /*    val goAheadFn = goAhead(maxCoord)

        assert(
          (
            goAheadFn(State(coord, "N")),
            goAheadFn(State(coord, "S")),
            goAheadFn(State(coord, "E")),
            goAheadFn(State(coord, "W"))
            )
            equals ((2,2),(2,1),(2,2),(1,2))
        )*/
  }
  test("Execute Instructions - Premier") {
    val initState = State((1,2),"N")
    val maxCoord: (Int, Int) = (5, 5)
    /*    val goAheadFn = goAhead(maxCoord)

        val finalState = launch(goAheadFn)(initState,"GAGAGAGAA")

        assert(finalState.toString equals "1 3 N")*/
  }
  test("Execute Instructions - Second") {
    val initState = State((3, 3),"E")
    val maxCoord: (Int, Int) = (5, 5)
    /*    val goAheadFn = goAhead(maxCoord)

        val finalState = launch(goAheadFn)(initState,"AADAADADDA")

        assert(finalState.toString equals "5 1 E")*/
  }
  override val initState: State = State((0,0),"N")
  override val coordMax: (Int, Int) = (5,5)
  override val instructions: String = ""
}
