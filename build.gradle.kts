plugins {
    id("java")
    id("application")
}

group = "com.marcpellicer.tema4gradle"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(platform("dev.langchain4j:langchain4j-bom:1.10.0"))
    implementation("dev.langchain4j:langchain4j-open-ai")
}

application {
    mainClass.set("com.marcpellicer.tema4gradle.Main")
}