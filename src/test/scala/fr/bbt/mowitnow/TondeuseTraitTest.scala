package fr.bbt.mowitnow

import org.scalatest.FunSuite
import AppClasses._

/**
  * Created by brice on 15/10/2017.
  */
class TondeuseTraitTest extends FunSuite {

  val t = new TondeuseTrait {
    override val coordMax: (Int, Int) = (5,5)
    override val instructions: String = ""
    override val initState: State = State((1,1),"N")
  }
  import t._

  test("Rotation de la tondeuse") {
    assert(
      (t.initState.rotate('D').direction equals "E") && (t.initState.rotate('G').direction equals "W")
    )
  }

  test("Avancée de la tondeuse sans limite") {
    assert(
      (t.initState.goAhead().coord equals (1,2))
        && (t.initState.copy(direction = "E").goAhead().coord equals (2,1))
    )
  }

  test("Avancée de la tondeuse avec limite") {
    val tLim = new TondeuseTrait {
      override val coordMax: (Int, Int) = (1,1)
      override val instructions: String = ""
      override val initState: State = State((1,1),"N")
    }
    import tLim._
    assert(
      (tLim.initState.goAhead().coord equals (1,1))
        && (tLim.initState.copy(direction = "E").goAhead().coord equals (1,1))
    )
  }

  test("Test complet Tondeuse n°1") {
    val t = new TondeuseTrait {
      override val coordMax: (Int, Int) = (5,5)
      override val instructions: String = "GAGAGAGAA"
      override val initState: State = State((1,2),"N")
    }

    assert(t.finalState.toString equals "1 3 N")
  }

  test("Test complet Tondeuse n°2") {
    val t = new TondeuseTrait {
      override val coordMax: (Int, Int) = (5,5)
      override val instructions: String = "AADAADADDA"
      override val initState: State = State((3,3),"E")
    }

    assert(t.finalState.toString equals "5 1 E")
  }

}
