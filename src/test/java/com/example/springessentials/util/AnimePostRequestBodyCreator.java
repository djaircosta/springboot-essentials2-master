package com.example.springessentials.util;

import com.example.springessentials.requests.AnimePostRequestBody;

public class AnimePostRequestBodyCreator {
    public static AnimePostRequestBody createAnimePostRequestBody(){
        return AnimePostRequestBody.builder()
                .nome(AnimeCreator.createAnimeToBeSaved().getNome())
                .build();
    }
}
