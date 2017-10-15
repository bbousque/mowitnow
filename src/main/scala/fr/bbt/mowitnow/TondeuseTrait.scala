package fr.bbt.mowitnow
/**
  * Created by brice on 14/10/2017.
  */

import Utils._
import fr.bbt.mowitnow.AppClasses.State
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
    * Liste des directions disponibles
    */
  val directions = Array("N","W","S","E")

  /**
    * Fonction de rotation spécialisée pour nos directions
    */
  val rotate = rotateArray(directions)

  /**
    * Définition des rotations en fonction de l'instruction
    */
  val rotateFn = Map(
    'D' -> rotate(1),
    'G' -> rotate(-1)
  )

  /**
    * Paramétrage des déplacements en fonction de la direction
    */
  val moveVals = Map(
    "N" -> (0,1),
    "E" -> (1,0),
    "S" -> (0,-1),
    "W" -> (-1,0)
  )

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
      state.copy(direction = rotateFn.getOrElse(instruction,directions)(directions.indexOf(state.direction)))

    /**
      * Nouvel état après une avancée
      *
      * @return Le nouvel état
      */
    def goAhead() = {
      val mv = moveVals.getOrElse(state.direction, (0,0))

      state.copy(coord = (
        maxVal(state.coord._1 + mv._1, coordMax._1),
        maxVal(state.coord._2 + mv._2, coordMax._2)
      ))
    }
  }

  /**
    * Application des instructions de la tondeuse
    * @return L'état final de la tondeuse
    */
  def finalState = instructions.foldLeft(initState) {
    (state, instruction) => {
      instruction match {
        case 'A' => state.goAhead()
        case 'D' | 'G' => state.rotate(instruction)
      }
    }
  }
}
