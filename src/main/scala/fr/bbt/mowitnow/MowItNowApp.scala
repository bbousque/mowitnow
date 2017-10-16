package fr.bbt.mowitnow

import java.io.FileNotFoundException

import fr.bbt.mowitnow.AppClasses.InstructionParsingException
import fr.bbt.mowitnow.Utils._

/**
  * Created by brice on 15/10/2017.
  */
object MowItNowApp extends App {
  args match {
    case Array(filePath) => {
      try {
        println(s"Lecture du fichier $filePath ...")

        instructionsFromPath(filePath)
          .zipWithIndex
          .foreach { case(t,i) => {
            println(
              s"""
                 | Tondeuse n°${i+1}
                 | ${t.toString}
                 | Etat Final après instructions : ${t.finalState}
               """.stripMargin
            )
          }}

      } catch {
        case e : FileNotFoundException => println(s"Fichier $filePath non trouvé")
        case e : InstructionParsingException => println(e.getMessage)
      }
    }
    case _ => println("Usage : MowIItNowApp [chemin vers le fichier]")
  }
}
