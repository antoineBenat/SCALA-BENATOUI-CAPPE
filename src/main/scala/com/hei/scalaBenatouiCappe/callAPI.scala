package com.hei.scalaBenatouiCappe
import com.hei.scalaBenatouiCappe.Fonctions.FonctionsAPI
import play.api.libs.json.{JsValue, Json}
import scalaj.http.{Http, HttpResponse}

import scala.collection.mutable.ArrayBuffer
import java.util.Calendar
import com.hei.scalaBenatouiCappe.Objets.CallAPI


object Main {
  def main(args: Array[String]): Unit = {
    val callAPI: CallAPI= new CallAPI()
    val fonctionsAPI: Fonctions.FonctionsAPI= new FonctionsAPI()
    val tab =  callAPI.callAPI()
    print(fonctionsAPI.toDouble(tab(1)(1)))
    fonctionsAPI.printTab(tab)
  }
}

//Pour afficher un élément => allElement(..)(..)
