package models

import com.spark.corona.{sample,sample2}
import scala.collection.mutable.ListBuffer
case class Corona(name: String)

object coronaData {
 
  // called from com.spark.corona package 
  
//   val deathbyCountry=sample.getdeathbycountry
//   val case_death=sample.getcases_and_deathbycountry
  
  // val deathbyCountry=sample2.getdeathbycountry
   val case_death=sample2.getcases_and_deathbycountry
  
  
   
  // top 5 country 
/*   def topfive() :List[Corona] ={
    

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
}*/
     
 // all country
   def allCountry() = {
      var listper:List[(String,String,String,String,String)]=null
      var listBuff = new ListBuffer[(String,String,String,String,String)]()  


      
      var sort=case_death.toSeq.sortWith( _._2._1 > _._2._1)
     
       
       
        for(i <- sort){
        
        
         val data="\n  "+i._1 +" : "+i._2._1+ ", "+i._2._2+ ", "+i._2._3+ ", "+i._2._4
         
         val country=i._1.replace("United_States_of_America", "USA")
                         .replace("United_Kingdom", "UK")
                         .replace("Bosnia_and_Herzegovina", "B&H")
                         .replace("United_Arab_Emirates", "UAE")
                         .replace("Democratic_Republic_of_the_Congo", "DROC")
                         .replace("Cases_on_an_international_conveyance_Japan", "Int_conveyance_Japan")
                         .replace("United_Republic_of_Tanzania", "Tanzanian")
                         .replace("Saint_Vincent_and_the_Grenadines", "Saint Vincent")
                          .replace("Falkland_Islands_(Malvinas)", "Falkland_Islands")
                           .replace("Central_African_Republic", "Central_Africa")
                            .replace("Sao_Tome_and_Principe", "Sao_Tome&Principe")
                             .replace("Turks_and_Caicos_islands", "Turks&Caicos")
                              .replace("United_States_Virgin_Islands", "U.S Virgin Islands")
                               .replace("", "")
                                .replace("", "")
                                
        // .map(_.replaceAll("United_States_of_America", "USA"))
         
         val d=(country,i._2._1.toString(),i._2._2.toString()
             ,i._2._3.toString(),i._2._4.toString())
          listBuff += (d)
        }
          listper=listBuff.toList
        
          
  
  listper
}   

      def five() = {
        
        
      var listper:List[(String,String,String)]=null
      var listBuff = new ListBuffer[(String,String,String)]()  


      
      var sort=case_death.toSeq.sortWith( _._2._1 > _._2._1).take(5)
     
       
       
        for(i <- sort){
        val country=i._1.replace("United_States_of_America", "USA")
                         .replace("United_Kingdom", "UK")
                         .replace("Bosnia_and_Herzegovina", "B&H")
                         .replace("United_Arab_Emirates", "UAE")
                         .replace("Democratic_Republic_of_the_Congo", "DROC")
                         .replace("Cases_on_an_international_conveyance_Japan", "Int_conveyance_Japan")
                         .replace("United_Republic_of_Tanzania", "Tanzanian")
                         .replace("Saint_Vincent_and_the_Grenadines", "Saint Vincent")
                          .replace("Falkland_Islands_(Malvinas)", "Falkland_Islands")
                           .replace("Central_African_Republic", "Central_Africa")
                            .replace("Sao_Tome_and_Principe", "Sao_Tome&Principe")
                             .replace("Turks_and_Caicos_islands", "Turks&Caicos")
                              .replace("United_States_Virgin_Islands", "U.S Virgin Islands")
                               .replace("", "")
                                .replace("", "")
        
         val data="\n  "+i._1 +" : "+i._2._1+ ", "+i._2._2
         val d=(country,i._2._1.toString(),i._2._2.toString())
          listBuff += (d)
        }
          listper=listBuff.toList
        
          
  
  listper
}
   
   
   
   
}