
ThisBuild / scalaVersion := "3.3.1"

val scalaJs211Version = "0.6.33"
val scalaJs331Version = "1.12.0"

organization := "com.github.aimmoth.scala-stack.js-compiler"
name := "scala-stack-js-compiler"
version := "2.0.0"

javacOptions ++= Seq("-source", "21", "-target", "21")

lazy val scala_js_compiler_servlet = project
  .in(file("."))
  .settings(
    libraryDependencies ++= {
      if (scalaVersion.value == "3.3.1") Seq(
        "org.scala-js" % "scalajs-linker_2.13" % scalaJs331Version,
        "org.scala-lang" %% "scala3-compiler" % scalaVersion.value,
        "org.ow2.asm" % "asm" % "9.7",
        "org.scalatest" %% "scalatest" % "3.2.18" % Test
      ) else if (scalaVersion.value == "2.11.12") Seq(
         "org.scala-lang" % "scala-library" % scalaVersion.value,
         "org.scala-js" % "scalajs-compiler_2.11.12" % scalaJs211Version,
         "org.scala-js" % "scalajs-library_2.11" % scalaJs211Version,
         "org.scala-js" % "scalajs-tools_2.11" % scalaJs211Version
      ) else throw new Exception("Unsupported scala version")
    }
  )