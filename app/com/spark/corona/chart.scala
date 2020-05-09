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
import scala.collection.mutable.Buffer
import org.omg.CORBA._PolicyStub
import java.util.stream.Collectors
import java.util.Arrays


object chart {
  
  
  
  
  def trendCase(p_country: String) :(String,String,String,String)={
            val url="https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv"
            var data=scala.io.Source.fromURL(url).getLines().toArray
           
         //  println(" \n first DATA :  \n\n"+data.mkString(",")) 
            
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
            
        
       
            
                    var karam=data.filter(_.contains(p_country))
         
      
           var a :Buffer[String] =null
            var listBuff = new ListBuffer[String] 
                 for(i <-  karam)  { 
                    a=i.split(",").toBuffer
                   a -= (a(0),a(1),a(2),a(3))
                  
                   listBuff+=a.mkString(",")
                   
                 }
              
            var list=listBuff.toList
      
             
     
             
            val donutsGroup = list
     
            val cnd=   donutsGroup.map(_.split(",").map(_.toInt).toList)
      
         
            val sum=   cnd.transpose.map(_.sum) 
       
      
           
                 var contrydata= sum //length.toList
              var incre="" 
      
               var list1 = contrydata.toBuffer
               var list2 = contrydata.toBuffer 
               var len=list2.length 
               list2 -=(list2(len-1) ) 

               list2= (0 +: list2)//.map(_.toString())
               var sub=list1 zip list2 map(x=>x._1.toInt-x._2.toInt) 
               
              incre=sub.mkString(",")
  
               
               
               
               
               

               var chartdata=contrydata.mkString(",")
   
               
               var strDate=listdate.head.split("-")
               var (mnt,day,yr)=(strDate(0),strDate(1),strDate(2))
                 
        var passdate=listdate.head
        var lastdate = listdate.last  
              
      (passdate,lastdate,chartdata,incre)
     }
  
  // Death
   def trendDeath(p_country: String) :(String,String,String,String)={
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
            
                var karam=data.filter(_.contains(p_country))
         
      
           var a :Buffer[String] =null
            var listBuff = new ListBuffer[String] 
                 for(i <-  karam)  { 
                    a=i.split(",").toBuffer
                   a -= (a(0),a(1),a(2),a(3))
                  
                   listBuff+=a.mkString(",")
                   
                 }
              
            var list=listBuff.toList
      
             
     
             
            val donutsGroup = list
     
            val cnd=   donutsGroup.map(_.split(",").map(_.toInt).toList)
      
         
            val sum=   cnd.transpose.map(_.sum) 
      
           
                 var contrydata= sum //length.toList
              var incre="" 
          
               var list1 = contrydata.toBuffer
               var list2 = contrydata.toBuffer 
               var len=list2.length 
               list2 -=(list2(len-1) ) 

               list2= (0 +: list2)//.map(_.toString())
               var sub=list1 zip list2 map(x=>x._1.toInt-x._2.toInt) 
               
              incre=sub.mkString(",")
  
               
               
               
               
               

               var chartdata=contrydata.mkString(",")
               var strDate=listdate.head.split("-")
               var (mnt,day,yr)=(strDate(0),strDate(1),strDate(2))
                 
        var passdate=listdate.head
        var lastdate = listdate.last  
              
      (passdate,lastdate,chartdata,incre)
     }
  
  
  //REcover
   
    def trendRecover(p_country: String) :(String,String,String,String)={
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
            
                  var karam=data.filter(_.contains(p_country))
         
      
           var a :Buffer[String] =null
            var listBuff = new ListBuffer[String] 
                 for(i <-  karam)  { 
                    a=i.split(",").toBuffer
                   a -= (a(0),a(1),a(2),a(3))
                  
                   listBuff+=a.mkString(",")
                   
                 }
              
            var list=listBuff.toList
      
             
     
             
            val donutsGroup = list
     
            val cnd=   donutsGroup.map(_.split(",").map(_.toInt).toList)
      
         
            val sum=   cnd.transpose.map(_.sum) 
       
       
  
           
                 var contrydata= sum //length.toList
              var incre="" 
       
               var list1 = contrydata.toBuffer
               var list2 = contrydata.toBuffer 
               var len=list2.length 
               list2 -=(list2(len-1) ) 

               list2= (0 +: list2)//.map(_.toString())
               var sub=list1 zip list2 map(x=>x._1.toInt-x._2.toInt) 
               
              incre=sub.mkString(",")
  
               
               
               
               
               

               var chartdata=contrydata.mkString(",")
               var strDate=listdate.head.split("-")
               var (mnt,day,yr)=(strDate(0),strDate(1),strDate(2))
                 
        var passdate=listdate.head
        var lastdate = listdate.last  
              
      (passdate,lastdate,chartdata,incre)
     }
  
  
}
