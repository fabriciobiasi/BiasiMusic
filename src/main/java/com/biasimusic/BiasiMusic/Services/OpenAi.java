package com.biasimusic.BiasiMusic.Services;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

public class OpenAi {
    public static String descricao(String texto){
    OpenAiService service = new OpenAiService(System.getenv("OPENAI_APIKEY"));


    CompletionRequest requisicao = CompletionRequest.builder()
            .model("gpt-3.5-turbo-instruct")
            .prompt("Fale deste artista: " + texto)
            .maxTokens(1000)
            .temperature(0.7)
            .build();


    var resposta = service.createCompletion(requisicao);
        return resposta.getChoices().get(0).getText();
}
}