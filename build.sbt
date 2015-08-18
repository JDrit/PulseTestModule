import sbtprotobuf.{ProtobufPlugin=>PB}
import AssemblyKeys._

name := "Pulse Test Module"

version := "1.0"

scalaVersion := "2.10.4"

Seq(PB.protobufSettings: _*)

version in protobufConfig := "2.6.1"

libraryDependencies += "org.apache.httpcomponents" % "httpclient" % "4.5"

assemblySettings

jarName in assembly := "testModule.jar"

mainClass in assembly := Some("net.digitalbebop.pulsetestmodule.Main")
