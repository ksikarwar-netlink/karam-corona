package models

import com.spark.corona.sample
import scala.collection.mutable.ListBuffer
case class Corona(name: String)

object coronaData {
 
  // called from com.spark.corona package 
  
   val deathbyCountry=sample.getdeathbycountry
   val case_death=sample.getcases_and_deathbycountry
   
  // top 5 country 
   def topfive() :List[Corona] ={
    

      var listper:List[Corona]=null
      var listBuff = new ListBuffer[Corona]()  
      
val x = deathbyCountry.toSeq.sortWith(_._2 > _._2).take(5)


for(i <- x){

 val data="\n  "+i._1 +" : "+(i._2)
  listBuff += Corona(data)
}
  listper=listBuff.toList
  
  for(i <- listper) {println (i)}
  
  
  listper
}
     
 // all country
   def allCountry() = {
      var listper:List[(String,String,String)]=null
      var listBuff = new ListBuffer[(String,String,String)]()  


      
      var sort=case_death.toSeq.sortWith( _._2._2 > _._2._2)
     
       
       
        for(i <- sort){
        
        
         val data="\n  "+i._1 +" : "+i._2._1+ ", "+i._2._2
         val d=(i._1,i._2._1.toString(),i._2._2.toString())
          listBuff += (d)
        }
          listper=listBuff.toList
        
          
  
  listper
}   

      def five() = {
      var listper:List[(String,String,String)]=null
      var listBuff = new ListBuffer[(String,String,String)]()  


      
      var sort=case_death.toSeq.sortWith( _._2._2 > _._2._2).take(5)
     
       
       
        for(i <- sort){
        
        
         val data="\n  "+i._1 +" : "+i._2._1+ ", "+i._2._2
         val d=(i._1,i._2._1.toString(),i._2._2.toString())
          listBuff += (d)
        }
          listper=listBuff.toList
        
          
  
  listper
}
   
   
   
   
}