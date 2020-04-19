package controllers

import javax.inject._
import play.api._
import play.api.mvc._


import play.api.mvc.{Action, AnyContent, Controller}
import scala.concurrent.Future
import play.api.mvc._
import play.api.mvc.Results.{Ok, BadRequest}
import play.mvc.Results.badRequest
import play.api.libs.json.Json

import com.spark.corona.{sample}
import models.coronaData


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.InetAddress;

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  
 /*
   val conf = new SparkConf().set("spark.sql.caseSensitive", "true").set("spark.sql.crossJoin.enabled", "true").set("spark.driver.allowMultipleContexts", "true").set("spark.driver.memory", "4g").set("spark.executor.memory", "4g").set("spark.executor.cores", "8")

         Logger.getLogger("org").setLevel(Level.OFF)
Logger.getLogger("akka").setLevel(Level.OFF) 
 
      var sc = new SparkContext(conf)
      var spark = SparkSession.builder().appName("Spark").config(conf).getOrCreate()
     
      val spark = SparkSession.builder()
    .appName("Spark")
    .master("local")
    .getOrCreate()
      var sqlContext = new SQLContext(sc)
      
 */
  
  /**
   * Create an Action to render an HTML page.
   *
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index())
  }
  
  def getHerokuAssignedPort(): Int = {
    val processBuilder: ProcessBuilder = new ProcessBuilder()
    if (processBuilder.environment().get("PORT") != null) {
      java.lang.Integer.parseInt(processBuilder.environment().get("PORT"))
    }
// if we're not in heroku, just return the default:
    4567
  }

  def explore() = Action { implicit request: Request[AnyContent] =>
    
      /*val result=sample.pdfString()
       val res_pdf=result._1
      val res_date=result._2*/
       
    val data=coronaData.allCountry
    
    Ok(views.html.explore.render(data))
  }
  
 
  def corona() = Action { implicit request: Request[AnyContent] =>
   
       val lastupdate=sample.getfileCreation()
       val topfive = coronaData.five()
        val formatter = java.text.NumberFormat.getIntegerInstance
       val dc=  sample.getcases_and_death
      
       var death =formatter.format(dc._1)
       var cases =formatter.format(dc._2)
      
    


     
       
       Ok(views.html.hello.render(topfive,lastupdate,cases,death))
  
  }
  

   
  
   
   
}
