package com.hei.scalaBenatouiCappe
import play.api.libs.json.{JsValue, Json}
import scalaj.http.{Http, HttpResponse}

import java.util.Calendar


object Main {
  def main(args: Array[String]): Unit = {
    val request: HttpResponse[String] = Http("https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=DAI.DEX&outputsize=full&datatype=json&apikey=EXALLWIOROD5BP80").param("q","monkeys").asString
    val json : JsValue  = Json.parse(request.body)
    val now = Calendar.getInstance()
    val names: List[String] = List("1. open","2. high","3. low","4. close","5. volume");
    val allElement = Array.ofDim[Any](500,1)
    var index =0;
    for( x <-0 to 500) {
      now.set(2021,10,12)
      val element: Array[Any] = new Array[Any](6);
      now.set(Calendar.DATE, (now.get(Calendar.DATE) - x))
      try {
        val date: String = now.get(Calendar.YEAR) + "-" +  "%02d".format(now.get(Calendar.MONTH)) + "-" + "%02d".format(now.get(Calendar.DATE))
        element(0) = '"'+date+'"'
        element(1) = (json("Time Series (Daily)")(date)("1. open").toString()).slice(1,(json("Time Series (Daily)")(date)("1. open").toString()).size-2).toDouble
        element(2) = (json("Time Series (Daily)")(date)("2. high").toString()).slice(1,(json("Time Series (Daily)")(date)("2. high").toString()).size-2).toDouble
        element(3) = (json("Time Series (Daily)")(date)("3. low").toString()).slice(1,(json("Time Series (Daily)")(date)("3. low").toString()).size-2).toDouble
        element(4) = (json("Time Series (Daily)")(date)("4. close").toString()).slice(1,(json("Time Series (Daily)")(date)("4. close").toString()).size-2).toDouble
        element(5) = (json("Time Series (Daily)")(date)("5. volume").toString()).slice(1,(json("Time Series (Daily)")(date)("5. volume").toString()).size-2).toDouble
        allElement(index) = element
        index=index+1
      }catch{
        case exception: Exception=>{
        }
      }
    }

    //Affichage de la liste compléte
   var x=0
    while (allElement(x).mkString(",") != "null") {
      println(allElement(x).mkString(","))
      x+=1
    }

    //Fonction permettant de récupérer un Int depuis un "Any"
    def toInt(any: Any): Int ={
      val i = any.asInstanceOf[Double].toInt
      return i
    }
    //Exemple de valeur pour le 4éme élément de la 3éme jourée
    val j=toInt(allElement(3)(4))




  }
}

//Pour afficher un élément => allElement(..)(..)
