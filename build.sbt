lazy val commonSettings = Seq(
  version := "1.0",
  organization := "de.tu_dortmund.cs.ls14",
  
  scalaVersion := "2.11.11",

  resolvers ++= Seq(
    Resolver.sonatypeRepo("releases"),
    Resolver.sonatypeRepo("snapshots"),
    Resolver.typesafeRepo("releases")
  ),

  scalacOptions ++= Seq(
    "-unchecked",
    "-deprecation",
    "-feature",
    "-language:implicitConversions"
  )
)

lazy val root = (Project(id = "cls-simulation", base = file(".")))
  .settings(commonSettings: _*)
  .settings(
    moduleName := "cls-simulation",
    libraryDependencies ++= Seq(
      "de.tu_dortmund.cs.ls14" %% "cls-scala" % "1.2.0-SNAPSHOT"
    )
  )
