package com.hei.scalaBenatouiCappe.Fonctions

import scala.collection.mutable.ArrayBuffer

class FonctionsAPI {

  /**
   * Affichage de la liste compléte
   * @param ArrayBuffer[Array[Any]]
   * @return String
   */

  def printTab(allElement:ArrayBuffer[Array[Any]]): String = {
    for (element <- allElement) {
      println(element.mkString(" ", " ", " "))
    }
    return allElement(0).mkString(" ", " ", " ")
  }

  /**
   * Conversion d'un objet de type Double en data double
   * @param Any
   * @return Double
   */

  //Fonction permettant de récupérer un Double depuis un "Any"
  def toDouble(any: Any): Double ={
    val i = any.asInstanceOf[Double]
    return i
  }

  /**
   * Affichage de la liste compléte, méthode de vérification
   * @param ArrayBuffer[Array[Any]]
   * @return String
   */

  def testPrinTab(allElement: ArrayBuffer[Array[Any]]):String={
    allElement.foreach(element=> {
      println(element.mkString(" ", " ", " "))
    })
    return allElement(0).mkString(" ", " ", " ")
  }
}
