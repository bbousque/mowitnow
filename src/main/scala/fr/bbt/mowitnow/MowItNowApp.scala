package fr.bbt.mowitnow

import fr.bbt.mowitnow.AppClasses.Tondeuse

/**
  * Created by brice on 15/10/2017.
  */
object MowItNowApp extends App {
  val coordMax = (5,5)
  Array(
    new Tondeuse((1,2),"N","GAGAGAGAA",coordMax),
    new Tondeuse((3,3),"E","AADAADADDA",coordMax)
  )
    .map(_.launch)
    .foreach(println)
}
