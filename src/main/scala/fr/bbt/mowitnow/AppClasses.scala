package fr.bbt.mowitnow

/**
  * Created by brice on 14/10/2017.
  */
object AppClasses {
  class Tondeuse(coord : (Int,Int), direction : String, instrs : String, cMax : (Int,Int)) extends TondeuseTrait {
    override val initState: State = State(coord,direction)
    override val instructions: String = instrs
    override val coordMax: (Int, Int) = cMax
  }
}
