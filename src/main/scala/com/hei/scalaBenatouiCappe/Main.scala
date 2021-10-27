package com.hei.scalaBenatouiCappe

import com.hei.scalaBenatouiCappe.Fonctions.FonctionsAPI
import com.hei.scalaBenatouiCappe.Objets.CallAPI

object Main {
  def main(args: Array[String]): Unit = {

    val callAPI: CallAPI= new CallAPI()
    val fonctionsAPI: Fonctions.FonctionsAPI= new FonctionsAPI()
    val tab =  callAPI.callAPI()

    fonctionsAPI.testPrinTab(tab)
    println(fonctionsAPI.toDouble(tab(1)(1)))

  }
}
