import com.hei.scalaBenatouiCappe.Fonctions
import org.scalatest.freespec.AnyFreeSpec

import scala.collection.mutable.ArrayBuffer
import com.hei.scalaBenatouiCappe.Fonctions.FonctionsAPI
class FonctionsAPITest extends AnyFreeSpec{

  val fonctionsAPI: Fonctions.FonctionsAPI= new FonctionsAPI()

  "My function  " - {
    ": printTab for ArrayBuffer[Array['val1',2,2.23],Array['val2',3,1.42]]" - {
      "should return same tab" in {
        var tabElement=Array[Any]("val1",2,2.23);
        var tabElement2=Array[Any]("val2",3,1.42);
        var tabAllElement=ArrayBuffer(tabElement,tabElement2);
        assert(fonctionsAPI.printTab(tabAllElement)==fonctionsAPI.testPrinTab(tabAllElement))
      }
    }
  }

  "My function "-{
    ":toDouble() for '3.34' java.Object.Double "-{
      "should return 3.34 double primitive data type"-{
        var x = ("3.34").toDouble
        assert(fonctionsAPI.toDouble(x)==3.34)
      }
    }
  }
}
