name := "hello-scala-grpc-protobuf"

version := "1.0"

scalaVersion := "2.11.8"

PB.targets in Compile := Seq(
  scalapb.gen(flatPackage = true, singleLineToString = true) → (sourceManaged in Compile).value
)

libraryDependencies ++= Seq(
    "io.grpc" % "grpc-netty" % "1.1.2",
    "com.trueaccord.scalapb" %% "scalapb-runtime" % com.trueaccord.scalapb.compiler.Version.scalapbVersion % "protobuf",
    "com.trueaccord.scalapb" %% "scalapb-runtime-grpc" % com.trueaccord.scalapb.compiler.Version.scalapbVersion,
    
    "org.scalatest" %% "scalatest" % "2.2.4" % Test
)

mainClass in (Compile, run) := Some("com.example.Main")
mainClass in (Compile, packageBin) := Some("com.example.Main")

fork in run := true
