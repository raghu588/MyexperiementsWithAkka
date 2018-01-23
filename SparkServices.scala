package SparkAkkaHTTP

import akka.http.scaladsl.model.{ ContentTypes, HttpEntity }
import akka.http.scaladsl.server.Directives._
import org.apache.spark.{ SparkConf, SparkContext }

trait SparkServices {

    val sparkConf = new SparkConf().setAppName("spark-akka-http").setMaster("local")
    val sc = new SparkContext(sparkConf)
    val route =
      path("") {
        get {
          complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, s"<h1>SparkVersionUsingHere: ${sc.version}</h1>"))
          //complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, "Spark version in this template"))
        }
      }
}