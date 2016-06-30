import sbt._
import Keys._

object MyBuild extends Build {
  override lazy val settings = super.settings ++ Seq(
    organization := "com.franklinchen",
    version := "1.0.0",
    scalaVersion := "2.11.8",
    scalacOptions += "-deprecation"
  )

  lazy val root: Project = Project(
    "root",
    file(".")
  ).settings(settings ++ Seq(
      run <<= run in Compile in core
    )
  ).aggregate(macros, core)

  lazy val macros: Project = Project(
    "macros",
    file("macros")
  ).settings(settings ++ Seq(
      libraryDependencies += "org.scala-lang" % "scala-reflect" % scalaVersion.value
    )
  )

  lazy val core: Project = Project(
    "core",
    file("core")
  ).dependsOn(macros)
}
