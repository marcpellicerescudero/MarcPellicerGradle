package com.marcpellicer.tema4gradle;

import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.data.message.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        var model1 = OpenAiChatModel.builder()
                .baseUrl("http://localhost:11434/v1")
                .apiKey("demo")
                .modelName("gemma:2b")
                .build();

        String respuesta = model1.chat("Explica qué es Gradle en una frase corta");
        System.out.println(respuesta);

        var model2 = OpenAiChatModel.builder()
                .baseUrl("http://localhost:11434/v1")
                .apiKey("demo")
                .modelName("gemma:2b")
                .build();

        // Historial compartido
        List<ChatMessage> history = new ArrayList<>();

        // Personalidad opcional
        history.add(new SystemMessage("Eres una IA experta en tecnología."));

        // IA 1 hace pregunta
        history.add(new UserMessage("¿Es mejor Gradle o Maven? Responde brevemente."));
        AiMessage respuesta1 = model1.chat(history).aiMessage();
        history.add(respuesta1);

        System.out.println("IA 1: " + respuesta1.text());

        // IA 2 responde
        history.add(new UserMessage("Responde a la opinión anterior y da tu punto de vista."));
        AiMessage respuesta2 = model2.chat(history).aiMessage();
        history.add(respuesta2);

        System.out.println("IA 2: " + respuesta2.text());
    }
}