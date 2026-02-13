package com.marcpellicer.tema4gradle;

import dev.langchain4j.model.openai.OpenAiChatModel;

public class Main {

    public static void main(String[] args) {

        var model = OpenAiChatModel.builder()
                .baseUrl("http://localhost:11434/v1")
                .apiKey("demo")
                .modelName("gemma:2b")
                .build();

        String respuesta = model.chat("Explica qué es Gradle en una frase corta");
        System.out.println(respuesta);
    }
}