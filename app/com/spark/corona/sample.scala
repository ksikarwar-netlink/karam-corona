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

case class Person(name: String)
case class Corona(date: String, cases: Int, deaths: Int, country: String)
 
object sample {
  val path ="conf/Resources/corona.csv"
 
  

  val url = "https://opendata.ecdc.europa.eu/covid19/casedistribution/csv/"

def readcoronaCSV(): Seq[Corona] = {
    for {
      //line <- Source.fromFile(path).getLines().drop(1).toVector
       line <- scala.io.Source.fromURL(url).getLines().drop(1).toVector
       values = line.split(",").map(_.trim)
    } yield Corona(values(0), values(4).toInt, values(5).toInt, values(6))
  }


val corona=readcoronaCSV()

def getTotalNumber(): Int = corona size

def getdeathbycountry(): Map[String, Int] = {
    def sumdeath(death: Seq[Corona]): Int =
      death.map(_.deaths).sum
 
   
   corona.groupBy(_.country).mapValues(sumdeath(_))
   
  }

def getcases_and_deathbycountry(): Map[String,(Int,Int)] = {
    def sumdeath(cases: Seq[Corona]): (Int,Int) = {
     val death= cases.map(_.deaths).sum
     val Case= cases.map(_.cases).sum
     // salesOfAPaymentTyp.map(_.cases).sum
     (Case,death)
    }
//  val one= (corona.groupBy(_.country).mapValues(sumcases(_)),corona.groupBy(_.country).mapValues(sumcases(_)))
//  val  two= (sumdeath(_),sumcases(_))
   
   val pass=corona.groupBy(_.country).mapValues(sumdeath(_))
   
   pass
  }


def getNumberOfSalesGroupedByDay(): Map[String, Int] = {
    def extractDay(sale: Corona): String = {
      val parts = sale.date.split("/")
      parts(0) + "/" + parts(1)
    }
 
    corona.groupBy(extractDay(_)).mapValues(_.length)
  }

def getTotalNumberAndPriceOfSalesMadeAbroad(): (Int, Int) = {
    val filtered = corona.filter(_.country != "United States")
    (filtered.size, filtered.map(_.cases).sum)
  }



def getcases_and_death():(Int, Int) = {
    val filtered = corona//.filter(_.country != "United States")
    (filtered.map(_.deaths).sum, filtered.map(_.cases).sum)
  }

def getdate():(String) = {
    val date = corona.map(_.date).head
    date
  }


def getfileCreation():String = {
                   val file: Path = Paths.get(path);
                   val attr: BasicFileAttributes =
                          Files.readAttributes(file, classOf[BasicFileAttributes])
          
                   val cretime=attr.creationTime()
                   val credate = new Date( cretime.toMillis() )
                  
                   val pattern: String = "E, dd MMM yyyy"
                   val simpleDateFormat: SimpleDateFormat = new SimpleDateFormat(pattern)
                
                 //  val filemaxdate=getdate
                   val formatter1=new SimpleDateFormat("dd/MM/yyyy")
                 
                    val filemaxdate= formatter1.parse(getdate())
                    
                    
                   val date= simpleDateFormat.format(filemaxdate)
                
              date  
      }




}
