package fr.bbt.mowitnow

/**
  * Created by brice on 14/10/2017.
  */
object AppClasses {
  /**
    * Paramétrage des déplacements en fonction de la direction
    */
  val directionsOffset = Map(
    "N" -> (0,1),
    "W" -> (-1,0),
    "S" -> (0,-1),
    "E" -> (1,0)
  )

  /**
    * Exception de parsing des instructions
    * @param m Le message d'erreur
    */
  class InstructionParsingException(val m : String) extends Exception(m)

  /**
    * Classe représentant l'état de la tondeuse
    *
    * @param coord        Coordonnées courantes
    * @param direction    Direction courante
    */
  case class State(coord : (Int,Int), direction : String) {
    override def toString: String = s"${coord._1} ${coord._2} $direction"
  }

  /**
    * Classe Tondeuse
    * @param state    Etat initial
    * @param instrs   Liste des instructions A,D ou G concaténées
    * @param cMax     Coordonnées maximum autorisées pour les déplacements sous la forme (x,y)
    */
  class Tondeuse(state : State, instrs : String, cMax : (Int,Int)) extends TondeuseTrait {
    override val initState: State = state
    override val instructions: String = instrs
    override val coordMax: (Int, Int) = cMax

    override def toString: String = s"Etat ${state.toString} - Instructions $instructions - Limites $cMax"
  }
}
