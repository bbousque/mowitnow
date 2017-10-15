package fr.bbt.mowitnow

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

}
