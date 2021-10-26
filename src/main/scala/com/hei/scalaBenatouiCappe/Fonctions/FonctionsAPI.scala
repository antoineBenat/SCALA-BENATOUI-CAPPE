package com.hei.scalaBenatouiCappe.Fonctions

import scala.collection.mutable.ArrayBuffer

class FonctionsAPI {
  //Affichage de la liste compléte
  def printTab(allElement:ArrayBuffer[Array[Any]]) {
    for (element <- allElement) {
      println(element.mkString(" ", " ", " "))
    }
  }
  //Fonction permettant de récupérer un Int depuis un "Any"
  def toDouble(any: Any): Double ={
    val i = any.asInstanceOf[Double]
    return i
  }

}
