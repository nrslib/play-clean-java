name := "playclean"
 
version := "1.0" 
      
lazy val `playclean` = (project in file(".")).enablePlugins(PlayJava, PlayEbean, PlayEnhancer)

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"
      
scalaVersion := "2.11.12"

libraryDependencies ++= Seq( javaJdbc , cache , javaWs )

unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )

playEbeanModels in Compile := Seq("models.*")
playEbeanDebugLevel := 4
