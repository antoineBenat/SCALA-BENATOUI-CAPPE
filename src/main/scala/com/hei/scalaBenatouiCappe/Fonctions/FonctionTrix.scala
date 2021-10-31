package com.hei.scalaBenatouiCappe.Fonctions

import com.hei.scalaBenatouiCappe.Fonctions
import com.hei.scalaBenatouiCappe.Objets.CallAPI
import scala.collection.mutable.ArrayBuffer

class FonctionTrix {

  val fonctionsAPI = new FonctionsAPI()


  /**
   * on isole les 10 premières valeurs de prix
   * cela va permettre de commencer à utiliser les données sans avoir de données précédente
   */
  def take10First(args: ArrayBuffer[Double]): ArrayBuffer[Double] = {
    var counter = 0
    val firstValues = ArrayBuffer[Double]()
    for (prix <- args if counter<10){
      counter = counter + 1
      firstValues += (prix)
    }
    firstValues
  }

  /**
   * On calcule la moyenne de ces 10 prix pour avoir une valeur utilisable
   */
  def moyenneOfFirsts(firstsValues: ArrayBuffer[Double]): Double ={

    var moyenne = 0.00
    for (value <- firstsValues  ){
      moyenne += value
    }
    moyenne = moyenne/firstsValues.length
    moyenne
  }
  /**
   * Calcul de la constante K
   * La constante k va dépendre de la priode utilisée pour l'analyse des données
   */
  def calculConstanteK(period: Int): Double={
    val k = 2.00/(period + 1.00)
    k
  }

  /**
   * création d'une fonction pour calculer la première valeur de ema
   * l'utilisation de cette fonction n'est pas obligatoire mais permet de séparer la première valeur des suivantes
   */
  def ema1(prixActuel: Double, moyenne: Double, k: Double): Double={
    var ema1 = ((prixActuel-moyenne)*k)+moyenne
    ema1
  }

  /**
   * calcul de la moyenne exponentielle mobile
   */
  def ema(prixActuel: Double, emaPrec: Double, k: Double): Double={
    var ema = ((prixActuel-emaPrec)*k)+emaPrec
    ema
  }
  /**
   * fonction permettant de supprimer les 10 premières valeurs utilisées pour calculer la moyenne
   */
  def usePrices(prix: ArrayBuffer[Double]): ArrayBuffer[Double] = {
    var prices = prix
    var count = 0
    prices.remove(0,10)
    prices

  }
  /**
   * fonction permettant de d'utiliser les fonctions et de les regrouper afin de l'utiliser dans le main
   * cette fonction va renvoyer un tableau avec toutes les valeurs EMA (moyenne exponentielle mobile)
   */
  def calculEma1(): ArrayBuffer[Double] ={

    val callAPI: CallAPI= new CallAPI()
    val fonctionsAPI: Fonctions.FonctionsAPI= new FonctionsAPI()
    val tab =  callAPI.callAPI()
    val prices = fonctionsAPI.ChooseColOfDouble(tab,1)
    var tabEma1 = ArrayBuffer[Double]()
    val first10 = take10First(prices)
    val moyenne1 = moyenneOfFirsts(first10)
    val k = calculConstanteK(10)

    prices.remove(0)
    val pricesApres = usePrices(prices)
    tabEma1 += ema(pricesApres(0),moyenne1,k)
    var EmaMoins1 = moyenne1

    pricesApres.foreach(price => {
      tabEma1 += ema(price, EmaMoins1, k)
      EmaMoins1 = ema(price, EmaMoins1, k)
    })

    tabEma1
  }
  /**
   * fonction qui reprend en partie la fonction ci-dessus mais pour calculer la moyenne exponentielle de la moyenne exponentielle de la moyenne exponentielle
   */
  def calculEma23(ema1: ArrayBuffer[Double]): ArrayBuffer[Double] ={
    val callAPI: CallAPI= new CallAPI()
    val fonctionsAPI: Fonctions.FonctionsAPI= new FonctionsAPI()
    val tab =  callAPI.callAPI()
    val prices = fonctionsAPI.ChooseColOfDouble(tab,1)
    var tabEma1 = ArrayBuffer[Double]()
    val first10 = take10First(prices)
    val moyenne1 = moyenneOfFirsts(first10)
    val k = calculConstanteK(10)
    prices.remove(0)
    val pricesApres = usePrices(prices)
    var ema2 = ArrayBuffer[Double]()
    ema2 += ema(pricesApres(0), moyenne1, k )
    var EmaMoins1 = moyenne1
    ema1.foreach(em =>{
      ema2 += ema(em, EmaMoins1, k)
      EmaMoins1 = ema(em, EmaMoins1, k)

    })


    ema2
  }
  /**
   * fonction permettant de calculer le TRIX, indicateur qui permet de montrer les tendances des cours
   */
  def trix(ema: ArrayBuffer[Double]): ArrayBuffer[Double] = {
    var tabTrix = ArrayBuffer[Double]()
    var emaMoins1 = ema(0)
    ema.foreach(em =>{
      tabTrix += ((em-emaMoins1)/emaMoins1)
      emaMoins1 = em
    })
    tabTrix.remove(0,2)
    tabTrix

  }

}
