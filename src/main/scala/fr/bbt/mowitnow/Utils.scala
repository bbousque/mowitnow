package fr.bbt.mowitnow

import java.io.{File, FileNotFoundException}

import fr.bbt.mowitnow.AppClasses._

import scala.io.Source

/**
  * Created by brice on 15/10/2017.
  */
/**
  * Fonctions Utilitaires
  */
object Utils {

  /**
    * Fonctions utilitaires sur un Array
    * @param array
    */
  implicit class ArrayFonc(array: Array[String]) {
    /**
      * Rotation d'un Array
      * @param droite   Décale les données vers la droite. False vers la gauche
      * @return Le nouveau tableau décalé
      */
    def rotate(droite: Boolean) = {
      val (h, t) = {
        if (droite)
          array.splitAt(array.size - 1)
        else
          array.splitAt(1)
      }
      t ++ h
    }
  }

  /**
    * Plafonnement d'une valeur entière.
    * Si la valeur est supérieure au max on prend le max
    * Si la valeur est négative, on retourne 0
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

  /**
    * Fonction de parsing de String du fichier d'instruction
    * @param s
    */
  implicit class StringFonc(s : String) {
    /**
      * Création du tuple coordonnées à partir d'une chaîne de type X Y
      * @return Le tuple (x,y)
      */
    def toCoord() = s.split(" ") match {
      case Array(x, y) => (x.toInt, y.toInt)
      case _ => throw new InstructionParsingException(s"Erreur de parsing : $s")
    }
    /**
      * Création de l'état à partir d'une chaîne sous le format X Y D
      *
      * @return Un état initialisé
      */
    def toState() = s.split(" ") match {
      case Array(x, y, d) => {
        directionsOffset.get(d) match {
          case Some(v) => State((x.toInt, y.toInt), d)
          case None => throw new InstructionParsingException(s"Direction incorrect dans $s : $d")
        }
      }
      case _ => throw new InstructionParsingException(s"Erreur de parsing : $s")
    }
  }

  /**
    * Lecteur des instructions depuis un fichier
    * @param path Le chemin du fichier
    * @return Le contenu du fichier dans un Iterator
    */
  def instructionsFromPath(path : String) =
    loadInstructions(Source.fromFile(new File(path)).getLines())

  /**
    * Parsing de la liste complète des instructions
    * @param lines  La liste de ligne d'instruction
    * @return La liste des tondeuses initialisées
    */
  def loadInstructions(lines : Iterator[String]) = {
    val coordMax = lines.slice(0, 1).next().toCoord()

    lines.toArray.grouped(2).map {
      case Array(s, i) => new Tondeuse(s.toState(), i, coordMax)
      case _ => throw new InstructionParsingException(s"Erreur de format de fichier : $lines")
    }
  }

}
