name := "merry-fxmas"
organization := "com.franklinchen"
version := "1.0"

scalaVersion in ThisBuild := "2.12.3"
run := (run in Compile in core).evaluated

lazy val macros = (project in file("macros")).settings(
 libraryDependencies += "org.scala-lang" % "scala-reflect" % scalaVersion.value
)

lazy val core = (project in file("core")) dependsOn macros
