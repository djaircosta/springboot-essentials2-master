package com.example.springessentials.util;

import com.example.springessentials.requests.AnimePutRequestBody;

public class AnimePutRequestBodyCreator {
    public static AnimePutRequestBody createAnimePutRequestBody(){
        return  AnimePutRequestBody.builder()
                .id(AnimeCreator.createValidUpdatedAnime().getId())
                .nome(AnimeCreator.createValidUpdatedAnime().getNome())
                .build();
    }
}
