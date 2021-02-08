plugins {
  kotlin("jvm") version "1.4.21"
  application
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
  mavenCentral()
}

dependencies {
  implementation(kotlin("stdlib"))
  implementation("com.google.code.gson:gson:2.8.6")
}

application {
  mainClass.set("com.example.test.JsonTest")
}
