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
import play.api.libs.json.JsObject
import play.api.libs.json.Json


object chart {
  
  
  
  
  def trendCase(p_country: String) :(String,String,String)={
            val url="https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv"
            var data=scala.io.Source.fromURL(url).getLines().toArray
           
          
            
            val dateser=data.take(1).mkString(",").split(",")
            var ndateser=  dateser.toBuffer
            
             ndateser -= ("Lat", "Long","Province/State","Country/Region")
            
             
              var listdate:List[String]=null
      var listBuffdate = new ListBuffer[String] 
             
            for(x <- ndateser){
              
               val formatter=new SimpleDateFormat("MM/dd/yy")
            val formatter1=new SimpleDateFormat("MM-dd-yyyy")           
            val filemaxdate= formatter.parse(x)
            val lastdate=formatter1.format(filemaxdate)
            listBuffdate += lastdate 
            
            }
            listdate = listBuffdate.toList
            
          //  for(x <- listdate) println(x)
            
        
            var cntrydata=data.filter(_.contains(p_country)).toBuffer
             
          //  cntrydata -= ("Country/Region")//.drop(1)
            
            var length=cntrydata.mkString(",").split(",").toBuffer
            
            length -= (length(0),length(1),length(2),length(3))
            
            
              
               var contrydata=length.toList
               
               var chartdata=contrydata.mkString(",")
               var strDate=listdate.head.split("-")
               var (mnt,day,yr)=(strDate(0),strDate(1),strDate(2))
                 
        var passdate=listdate.head
        var lastdate = listdate.last  
              
      (passdate,lastdate,chartdata)
     }
  
  // Death
   def trendDeath(p_country: String) :(String,String,String)={
            val url="https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_deaths_global.csv"
            var data=scala.io.Source.fromURL(url).getLines().toArray
           
          
            
            val dateser=data.take(1).mkString(",").split(",")
            var ndateser=  dateser.toBuffer
            
             ndateser -= ("Lat", "Long","Province/State","Country/Region")
            
             
              var listdate:List[String]=null
      var listBuffdate = new ListBuffer[String] 
             
            for(x <- ndateser){
              
               val formatter=new SimpleDateFormat("MM/dd/yy")
            val formatter1=new SimpleDateFormat("MM-dd-yyyy")           
            val filemaxdate= formatter.parse(x)
            val lastdate=formatter1.format(filemaxdate)
            listBuffdate += lastdate 
            
            }
            listdate = listBuffdate.toList
            
          //  for(x <- listdate) println(x)
        
            var cntrydata=data.filter(_.contains(p_country)).toBuffer
             
          //  cntrydata -= ("Country/Region")//.drop(1)
            
            var length=cntrydata.mkString(",").split(",").toBuffer
            
            length -= (length(0),length(1),length(2),length(3))
            
            
              
               var contrydata=length.toList
               
               var chartdata=contrydata.mkString(",")
               var strDate=listdate.head.split("-")
               var (mnt,day,yr)=(strDate(0),strDate(1),strDate(2))
                 
        var passdate=listdate.head
        var lastdate = listdate.last  
              
      (passdate,lastdate,chartdata)
     }
  
  
  //REcover
   
    def trendRecover(p_country: String) :(String,String,String)={
            val url="https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_recovered_global.csv"
            var data=scala.io.Source.fromURL(url).getLines().toArray
           
          
            
            val dateser=data.take(1).mkString(",").split(",")
            var ndateser=  dateser.toBuffer
            
             ndateser -= ("Lat", "Long","Province/State","Country/Region")
            
             
              var listdate:List[String]=null
      var listBuffdate = new ListBuffer[String] 
             
            for(x <- ndateser){
              
               val formatter=new SimpleDateFormat("MM/dd/yy")
            val formatter1=new SimpleDateFormat("MM-dd-yyyy")           
            val filemaxdate= formatter.parse(x)
            val lastdate=formatter1.format(filemaxdate)
            listBuffdate += lastdate 
            
            }
            listdate = listBuffdate.toList
            
          //  for(x <- listdate) println(x)
        
            var cntrydata=data.filter(_.contains(p_country)).toBuffer
             
          //  cntrydata -= ("Country/Region")//.drop(1)
            
            var length=cntrydata.mkString(",").split(",").toBuffer
            
            length -= (length(0),length(1),length(2),length(3))
            
            
              
               var contrydata=length.toList
               
               var chartdata=contrydata.mkString(",")
               var strDate=listdate.head.split("-")
               var (mnt,day,yr)=(strDate(0),strDate(1),strDate(2))
                 
        var passdate=listdate.head
        var lastdate = listdate.last  
              
      (passdate,lastdate,chartdata)
     }
  
  
}