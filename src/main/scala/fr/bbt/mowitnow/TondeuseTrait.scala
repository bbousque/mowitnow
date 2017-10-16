package fr.bbt.mowitnow
/**
  * Created by brice on 14/10/2017.
  */
import Utils._
import fr.bbt.mowitnow.AppClasses._
/**
  * Interface Tondeuse
  */
trait TondeuseTrait {
  /**
    * Etat initial de la tondeuse
    */
  val initState : State

  /**
    * Instructions passées à la tondeuse
    */
  val instructions : String

  /**
    * Coordonnées maximum du terrain
    */
  val coordMax : (Int, Int)

  /**
    * Liste des directions
    */
  val directions = directionsOffset.keys.toArray
  /**
    * Fonctions appliquées à l'état
    *
    * @param state  L'état
    */
  implicit class StateFunc(state: State) {
    /**
      * Rotation de l'état
      *
      * @param instruction  Instruction de rotation (D ou G)
      * @return Le nouvel état
      */
    def rotate(instruction : Char) =
      state.copy(direction = directions.rotate(instruction == 'D')(directions.indexOf(state.direction)))

    /**
      * Nouvel état après une avancée
      *
      * @return Le nouvel état
      */
    def goAhead() = {
      val mv = directionsOffset.getOrElse(state.direction, (0,0))

      state.copy(coord = (
        maxVal(state.coord._1 + mv._1, coordMax._1),
        maxVal(state.coord._2 + mv._2, coordMax._2)
      ))
    }

    /**
      * Application de l'instruction à l'état en cours
      * @param instruction  L'instruction A, D ou G
      * @return             Le nouvel état
      */
    def apply(instruction : Char) = instruction match {
      case 'A' => state.goAhead()
      case 'D' | 'G' => state.rotate(instruction)
      case _ => {
        println(s"Instruction $instruction non comprise et ignorée")
        state
      }
    }
  }

  /**
    * Calcul de l'état final après application des instructions
    * @return L'état final de la tondeuse
    */
  def finalState = instructions.foldLeft(initState) {
    (state, instruction) => state.apply(instruction)
  }
}
