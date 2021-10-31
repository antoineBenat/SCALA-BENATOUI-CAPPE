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
   * Enregistrement dans un ArrayBuffer des toutes les dates de la liste
   * @param ArrayBuffer[Array[Any]]
   * @return ArrayBuffer[String]
   */
  def ColDate(allElement: ArrayBuffer[Array[Any]]):ArrayBuffer[String]={
    val listDate= ArrayBuffer[String]()
    allElement.foreach(element=> {
      listDate += element(0).toString;
    })
    return listDate
  }

  /**
   * Enregistrement dans un ArrayBuffer des toutes les valeur de la liste pour une colonne choisie
   * @param ArrayBuffer[Array[Any]]
   * @return ArrayBuffer[Double]
   */
  def ChooseColOfDouble(allElement: ArrayBuffer[Array[Any]],nbrCol:Integer):ArrayBuffer[Double]={
    val list= ArrayBuffer[Double]()
    allElement.foreach(element=> {
      list += toDouble(element(nbrCol));
    })
    return list
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
