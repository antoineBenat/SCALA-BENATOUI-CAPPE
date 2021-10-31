package com.hei.scalaBenatouiCappe

import com.hei.scalaBenatouiCappe.Fonctions.{BreezeClass, FonctionTrix, FonctionsAPI}
import com.hei.scalaBenatouiCappe.Objets.CallAPI

import scala.collection.mutable.ArrayBuffer

object Main {
  def main(args: Array[String]): Unit = {
    val fonctionTrix = new FonctionTrix()
    val breezeClass = new BreezeClass()
    val callAPI: CallAPI= new CallAPI()
    val fonctionsAPI: Fonctions.FonctionsAPI= new FonctionsAPI()
    val tab =  callAPI.callAPI()
    val tabDate = fonctionsAPI.ColDate(tab)

    val prices = fonctionsAPI.ChooseColOfDouble(tab,1)

    var pricesFinal = prices

    pricesFinal.remove(0,10)

    val tabEma = fonctionTrix.calculEma1()

    val tabEma1 = fonctionTrix.calculEma23(tabEma)

    val tabEma2 = fonctionTrix.calculEma23(tabEma1)

    val trix = fonctionTrix.trix(tabEma2)

    breezeClass.courbe(prices,tabEma, trix)


  }
}
