import com.logicovercode.bsbt.scala_module.ScalaBuild

sbtPlugin := true

val githubRepo = githubHosting("logicovercode", "FluentStyleSbtPlugin", "techLeadAtLogicOverCode", "techlead@logicovercode.com")

val moduleBuild = ScalaBuild("com.logicovercode", "fluent-style-sbt", "0.0.526")
  .sourceDirectories("plugin", "docker-containers" /*,"proto-grpc-support"*/)
  //TODO : this dependency is for docker (make this dependency conditional, depending on jdk version)
  .dependencies(
    "javax.activation" % "activation" % "1.1.1",
    "com.logicovercode" %% "fsbt-commons" % "0.0.003",
  )
  .sbtPlugins(
    "com.logicovercode" %% "fluent-style-sbt-core" % "0.0.426",
    /*this will automatically fetch flyway-sbt, sbt-pack for sbt projects that depends on fluent-style-sbt*/
    "org.xerial.sbt" % "sbt-pack" % "0.13",
    "com.github.cb372" % "sbt-explicit-dependencies" % "0.2.16"
  )
  .sbtPlugins("com.thesamet" % "sbt-protoc" % "1.0.0")
  .dependencies("com.thesamet.scalapb" %% "compilerplugin" % "0.9.0")
  .testDependencies( "org.scalatest" %% "scalatest" % "3.2.7" )
  .testSourceDirectories("dependencies-spec", "docker-containers-spec")
  .scalaVersions(scala_2_12_MaxVersion)
  .javaCompatibility("1.8", "1.8")
  .publish(githubRepo.developer, MIT_License, githubRepo, Opts.resolver.sonatypeStaging)

val basePluginProject = (project in file("."))
  .settings( moduleBuild.settings )

