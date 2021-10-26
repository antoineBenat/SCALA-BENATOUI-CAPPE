package com.hei.scalaBenatouiCappe
import play.api.libs.json.{JsValue, Json}
import scalaj.http.{Http, HttpResponse}
import scala.collection.mutable.ArrayBuffer
import java.util.Calendar

object CallAPI{
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
object Main {

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


  def main(args: Array[String]): Unit = {
    val tab =  CallAPI.callAPI()
    print(toDouble(tab(1)(1)))
    printTab(tab)
  }
}

//Pour afficher un élément => allElement(..)(..)
