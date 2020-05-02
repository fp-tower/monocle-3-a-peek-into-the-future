lazy val baseSettings: Seq[Setting[_]] = Seq(
  scalaVersion       := "2.13.2",
  scalacOptions     ++= Seq(
    "-deprecation",
    "-encoding",
    "UTF-8",
    "-feature",
    "-language:higherKinds",
    "-language:implicitConversions",
    "-language:existentials",
    "-language:postfixOps",
    "-unchecked",
    "-Ywarn-value-discard"
  ),
  resolvers += Resolver.sonatypeRepo("releases")
)

lazy val `monocle-3-a-peek-into-the-future` = project.in(file("."))
  .settings(moduleName := "monocle-3-a-peek-into-the-future")
  .settings(baseSettings: _*)
  .aggregate(core, slides)
  .dependsOn(core, slides)

lazy val core = project
  .settings(moduleName := "core")
  .settings(baseSettings: _*)


lazy val slides = project
  .dependsOn(core)
  .settings(moduleName := "slides")
  .settings(baseSettings: _*)
  .settings(
    mdocIn := baseDirectory.value / "mdoc",
    mdocOut := baseDirectory.value / "docs",
  )
  .enablePlugins(MdocPlugin)