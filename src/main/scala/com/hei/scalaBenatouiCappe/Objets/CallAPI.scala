package com.hei.scalaBenatouiCappe.Objets

import play.api.libs.json.{JsValue, Json}
import scalaj.http.{Http, HttpResponse}

import java.util.Calendar
import scala.collection.mutable.ArrayBuffer

class CallAPI {
  def callAPI():ArrayBuffer[Array[Any]]={
    val request: HttpResponse[String] = Http("https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=DAI.DEX&outputsize=full&datatype=json&apikey=EXALLWIOROD5BP80").param("q","monkeys").asString
    val json : JsValue  = Json.parse(request.body)
    val now = Calendar.getInstance()
    val names: List[String] = List("1. open","2. high","3. low","4. close","5. volume");
    val allElement = ArrayBuffer[Array[Any]]()
    for( x <-0 to 500) {
      now.set(2021,10,26)
      val element: Array[Any] = new Array[Any](6);
      now.set(Calendar.DATE, (now.get(Calendar.DATE) - x))
      try {
        val date: String = now.get(Calendar.YEAR) + "-" +  "%02d".format(now.get(Calendar.MONTH)) + "-" + "%02d".format(now.get(Calendar.DATE))
        element(0) = date
        for (x <- 1 to 5){
          element(x) = (json("Time Series (Daily)")(date)(names(x-1)).toString()).slice(1,(json("Time Series (Daily)")(date)(names(x-1)).toString()).size-2).toDouble
        }
        allElement += element
      }catch{
        case exception: Exception=>{
        }
      }
    }
    return allElement
  }
}

}
