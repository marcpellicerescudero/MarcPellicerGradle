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

tasks.register<Exec>("ollamaVersion") {
    group = "custom"
    if (System.getProperty("os.name").lowercase().contains("win")) {
        commandLine("cmd", "/c", "ollama --version")
    } else {
        commandLine("ollama", "--version")
    }
}

tasks.register<Exec>("ollamaPs") {
    group = "custom"
    if (System.getProperty("os.name").lowercase().contains("win")) {
        commandLine("cmd", "/c", "ollama ps")
    } else {
        commandLine("ollama", "ps")
    }
}

tasks.register("llmInfo") {
    group = "custom"
    dependsOn("ollamaVersion", "ollamaPs")
    doLast {
        println("Demo finalizada")
    }
}