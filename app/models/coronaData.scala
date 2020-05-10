package models

import com.spark.corona.{sample,sample2}
import scala.collection.mutable.ListBuffer
case class Corona(name: String)

object coronaData {
 
  // called from com.spark.corona package 
  

   val case_death=sample2.getcases_and_deathbycountry
  

     
 // all country
   def allCountry() = {
      var listper:List[(String,String,String,String,String,String)]=null
      var listBuff = new ListBuffer[(String,String,String,String,String,String)]()  


      
      var sort=case_death.toSeq.sortWith( _._2._1 > _._2._1).filter(! _._1.contains("Sint Eustatius and Saba\""))
     
   
       
        for(i <- sort){
        
        
          
         val data="\n  "+i._1 +" : "+i._2._1+ ", "+i._2._2+ ", "+i._2._3+ ", "+i._2._4
      
         
         
         
         var country=i._1.replace("United_States_of_America", "USA")
                       
                               // .replace("Sint Eustatius and Saba\"", "Netherlands")
                                .replace("", "")
            
                             
          //  println(country)                      
                                
                                
        val href= "/trend?name="+country.replace(" ", "%20")
        
        
      // println(country,href)
         
         val d=(country,i._2._1.toString(),i._2._2.toString()
             ,i._2._3.toString(),i._2._4.toString(),href)
          listBuff += (d)
        }
          listper=listBuff.toList
        
  
  listper
}   

      def five() = {
        
        
      var listper:List[(String,String,String,String)]=null
      var listBuff = new ListBuffer[(String,String,String,String)]()  


      
      var sort=case_death.toSeq.sortWith( _._2._1 > _._2._1).take(5).filter(! _._1.contains("Sint Eustatius and Saba\""))
     
       
       
        for(i <- sort){
        val country=i._1.replace("karam", "Saint")
                         
                            //   .replace("Sint Eustatius\"", "Netherlands")
                              
        
                                
             val href= "/trend?name="+country.replace(" ", "%20")              
                                
       //  val data="\n  "+i._1 +" : "+i._2._1+ ", "+i._2._2
         val d=(country,i._2._1.toString(),i._2._2.toString(),href)
          listBuff += (d)
        }
          listper=listBuff.toList
        
          
  
  listper
}
   
   
   
   
}
