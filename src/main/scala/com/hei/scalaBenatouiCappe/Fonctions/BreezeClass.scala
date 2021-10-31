package com.hei.scalaBenatouiCappe.Fonctions

import breeze.linalg.{DenseVector, linspace}
import breeze.plot._
import breeze.stats.mode
import com.hei.scalaBenatouiCappe.Fonctions
import com.hei.scalaBenatouiCappe.Objets.CallAPI


import javax.sound.sampled.Line
import scala.collection.mutable.ArrayBuffer

class BreezeClass {
  /**
   * création des courbes qui représentent le TRIX et la triple moyenne exponentielle
   */

  def courbe(tabPrices: ArrayBuffer[Double], tabEma: ArrayBuffer[Double], trix: ArrayBuffer[Double]): Unit ={
    var fig = Figure()
    val p = fig.subplot(0)
    var tab2 = ArrayBuffer[Double]()
    var count = 315.00

    tabPrices.foreach(price =>{
      tab2 += count
      count = count -1

    })

    p +=plot(tab2.toArray, tabEma.toArray)
    p += plot(tab2.toArray,tabPrices.toArray)
    p.title = "moyenne mobile exponentielle"
    p.xlabel = "x axis"
    p.ylabel = "y axis"

    val p2 = fig.subplot(2,2,2)

    p2 +=plot(tab2.toArray, trix.toArray)

    p2.title = "Trix"
    p2.xlabel = "x axis"
    p2.ylabel = "y axis"

  }

}
