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

import com.spark.corona._
import models.coronaData


import java.io.File
import java.nio.file.{Files, Path}
import javax.inject._
import java.nio.file.Paths
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.InetAddress;

import akka.stream.IOResult
import akka.stream.scaladsl._
import akka.util.ByteString
import play.api._
import play.api.data.Form
import play.api.data.Forms._
import play.api.libs.streams._
import play.api.mvc.MultipartFormData.FilePart
import play.api.mvc._
import play.core.parsers.Multipart.FileInfo

import play.api.Play.current
import play.api.i18n.Messages.Implicits._

case class FormData(name: String)

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {


  
  /**
   * Create an Action to render an HTML page.
   *
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */

  
 
  
  
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
    
      println("function call country name href: "+data(0))
    
    
    Ok(views.html.explore.render(data))
  }
  
  
   def index(name: String) = Action { implicit request: Request[AnyContent] =>
    
    
     
           
       val trendCase=chart.trendCase(name)
        
       val trendDeath=chart.trendDeath(name)
       val trendRec=chart.trendRecover(name)
       
         val passdate =trendCase._1
          var strDate=passdate.split("-")
               var (mnt,day,yr)=((strDate(0).toInt)-1,strDate(1),strDate(2))
         
         val dataCase = "["+trendCase._3+"]"
          val dataDeath = "["+trendDeath._3+"]"
           val dataRec = "["+trendRec._3+"]"
         
         
         val lastdata = trendCase._2
         val date =yr+", " +mnt+", "+day
     
          Ok(views.html.index.render(date,lastdata,name,dataCase,dataDeath,dataRec))
  }
  
 
  def corona() = Action { implicit request: Request[AnyContent] =>
   
       val lastupdate=sample2.getfileCreation._2
       val topfive = coronaData.five()
        val formatter = java.text.NumberFormat.getIntegerInstance
       val dc=  sample2.getcases_and_death
      
       var totaldeath =formatter.format(dc._2)
       var totalcases =formatter.format(dc._1)
       var totalrecover =formatter.format(dc._3)
       var totalactive =formatter.format(dc._4)
    

     
       
       Ok(views.html.hello.render(topfive,lastupdate,totalcases,totaldeath,totalrecover,totalactive))
  
  }
 
 
  
   
  
   
   
}
