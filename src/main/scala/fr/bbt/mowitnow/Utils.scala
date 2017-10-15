package fr.bbt.mowitnow

import java.io.File

import fr.bbt.mowitnow.AppClasses._

import scala.io.Source

/**
  * Created by brice on 15/10/2017.
  */
/**
  * Fonctions Utilitaires
  */
object Utils {

  def rotateArray(directions: Array[String]) =
    (direction: Int) => {
      val (h, t) = {
        if (direction >= 0)
          directions.splitAt(directions.size - 1)
        else
          directions.splitAt(1)
      }
      t ++ h
    }

  /**
    *
    * @param newVal
    * @param maxVal
    * @return
    */
  def maxVal(newVal : Int, maxVal : Int) = newVal match {
    case v : Int if v < 0 => 0
    case v : Int if v > maxVal => maxVal
    case _ => newVal
  }

  def getCoordFromString(coordString : String) = coordString.split(" ") match { case Array(x,y) => (x.toInt,y.toInt) }
  /**
    * Création de l'état à partir d'une chaîne
    *
    * @param stateString Chaîne sous le format X Y D
    * @return Un état initialisé
    */
  def stateFromString(stateString : String) = stateString.split(" ") match {
    case Array(x,y,d) => State((x.toInt,y.toInt),d)
  }

  def getInstructionsFromPath(path : String) = loadInstructions(Source.fromFile(new File(path)).getLines())

  def loadInstructions(lines : Iterator[String]) = {
    val coordMax = getCoordFromString(lines.slice(0, 1).next())

    lines.toList.grouped(2).map {
      case List(s, i) => new Tondeuse(stateFromString(s), i, coordMax)
    }.toArray
  }

}
