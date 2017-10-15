package fr.bbt.mowitnow

import fr.bbt.mowitnow.AppClasses.{State, Tondeuse}

/**
  * Created by brice on 15/10/2017.
  */
object MowItNowApp extends App {
  val coordMax = (5,5)
  Array(
    new Tondeuse(State((1,2),"N"),"GAGAGAGAA",coordMax),
    new Tondeuse(State((3,3),"E"),"AADAADADDA",coordMax)
  )
    .foreach(t => println(t.finalState))
}
