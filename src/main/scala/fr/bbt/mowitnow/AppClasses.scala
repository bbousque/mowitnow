package fr.bbt.mowitnow

/**
  * Created by brice on 14/10/2017.
  */
object AppClasses {

  /**
    * Classe représentant l'état de la tondeuse
    *
    * @param coord        Coordonnées courantes
    * @param direction    Direction courante
    */
  case class State(coord : (Int,Int), direction : String) {
    override def toString: String = s"${coord._1} ${coord._2} $direction"
  }

  class Tondeuse(state : State, instrs : String, cMax : (Int,Int)) extends TondeuseTrait {
    override val initState: State = state
    override val instructions: String = instrs
    override val coordMax: (Int, Int) = cMax
  }
}
