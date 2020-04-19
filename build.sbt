name := """corona-application"""
organization := "com.example"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)


scalaVersion := "2.11.12"
val sparkVersion = "2.4.5"
autoScalaLibrary := false





libraryDependencies ++= Seq(
  cache,
  ws,
  "org.scalatestplus.play" %% "scalatestplus-play" % "4.0.1" % Test,
  "com.lihaoyi" %% "ujson" % "0.7.1",
  guice,
   "com.h2database" % "h2" % "1.3.168",
 "javax.persistence" % "javax.persistence-api" % "2.2",
 "org.apache.commons" % "commons-io" % "1.3.2",
  			
   			"org.scalatest" % "scalatest_2.11" % "2.2.4" % "test",
		   
		    "org.webjars" % "bootstrap" % "3.3.6",
			"com.heroku.sdk" % "heroku-deploy" % "0.1.5"
)

libraryDependencies ~= { _.map(_.exclude("org.slf4j", "slf4j-log4j12")) }







