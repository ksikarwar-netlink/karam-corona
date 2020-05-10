package com.spark.corona

import scala.io.Source

import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

import java.util.Calendar
import java.text.SimpleDateFormat
import java.util.Date
import scala.collection.mutable.ArrayBuffer
import java.nio.file.attribute.BasicFileAttributes
import scala.collection.mutable.ListBuffer
import play.api.Play
 import java.lang.ClassLoader

//case class Person2(name: String)
case class Corona2(date: String,country: String, cases: String, deaths: String,recovered : String,active :String )
 
object sample2 {

 
   val filedate=getfileCreation()._1+".csv"
  
   val url = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_daily_reports/"+filedate
  
   def coronatimeseries() :Array[String]={
            val url="https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv"
            val data=scala.io.Source.fromURL(url).getLines().toArray
           
       
        data
     }
  
  
   
  
   
       var line = scala.io.Source.fromURL(url).getLines().toVector//.take(100)
  
       line=line.map(_.replaceAll("\"Korea, South\"", "Korea South")
                      .replaceAll("Bonaire, Sint Eustatius and Saba", "Bonaire Sint Eustatius and Saba")
                      ) 
   

       val firstrow=line.head.split(",")
       var country=firstrow.indexOf("Country_Region")
       var date=firstrow.indexOf("Last_Update")
       var confirm=firstrow.indexOf("Confirmed")
       var death=firstrow.indexOf("Deaths")
       var recover=firstrow.indexOf("Recovered")
       var active=firstrow.indexOf("Active")
   
 
 def readcoronaCSV(): Seq[Corona2] = {
    for {
       line <- line.drop(1).toVector//.take(100)
      values = line.split(",").map(_.trim)
//       .filter(! _.contains("127.766922"))
//                                           .filter(! _.contains("-68.2385"))
  
       
    } yield Corona2(values(date),values(country) ,values(confirm), values(death), values(recover), values(active))
  }

      
   
       
 //.filter(_.country != "United States")

val corona=readcoronaCSV()



def getcases_and_deathbycountry(): Map[String,(Int,Int,Int,Int)] = {
    def sumdeath(cases: Seq[Corona2]): (Int,Int,Int,Int) = {
     val death= cases.map(_.deaths.toInt).sum
     val Case= cases.map(_.cases.toInt).sum
     val recovered= cases.map(_.recovered.toInt).sum
     val active= cases.map(_.active.toInt).sum
   
     (Case,death,recovered,active)
    }
  
   val pass=corona.groupBy(_.country).mapValues(sumdeath(_))
   
   pass
  }


def getNumberOfSalesGroupedByDay(): Map[String, Int] = {
    def extractDay(sale: Corona2): String = {
      val parts = sale.date.split("/")
      parts(0) + "/" + parts(1)
    }
 
    corona.groupBy(extractDay(_)).mapValues(_.length)
  }

// total cases and death widget
def getcases_and_death():(Int, Int,Int,Int) = {
    val filtered = corona//.filter(_.country != "United States")
    (filtered.map(_.cases.toInt).sum,
     filtered.map(_.deaths.toInt).sum,
     filtered.map(_.recovered.toInt).sum,
     filtered.map(_.active.toInt).sum)
  }



def getdate():(String) = {
    val date = corona.map(_.date).head
    date
  }


def getfileCreation():(String,String) = {
          
            val data=coronatimeseries().take(1).mkString(",").split(",")//.getLines().take(1)
            val date=data.last
        
            val formatter=new SimpleDateFormat("MM/dd/yy")
            val formatter1=new SimpleDateFormat("MM-dd-yyyy")           
            val filemaxdate= formatter.parse(date)
           
            val lastdate=formatter1.format(filemaxdate)
            
            
            val pattern: String = "E, dd MMM yyyy"
                   val simpleDateFormat: SimpleDateFormat = new SimpleDateFormat(pattern)
                
                 //  val filemaxdate=getdate
                   val formatter2=new SimpleDateFormat("MM-dd-yyyy")
                 
                    val fileupdatedate= formatter2.parse(lastdate)
                    
                    
                   val updatedate= simpleDateFormat.format(fileupdatedate)
                
             
            
            
            
        (lastdate,updatedate )
      }

/*def lastupdate():String = {
                
                   val pattern: String = "E, dd MMM yyyy"
                   val simpleDateFormat: SimpleDateFormat = new SimpleDateFormat(pattern)
                
                 //  val filemaxdate=getdate
                   val formatter1=new SimpleDateFormat("dd/MM/yyyy")
                 
                    val filemaxdate= formatter1.parse(getfileCreation)
                    
                    
                   val date= simpleDateFormat.format(filemaxdate)
                
              date  
      }*/


}
