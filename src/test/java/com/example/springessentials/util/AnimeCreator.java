package com.example.springessentials.util;

import com.example.springessentials.domain.Anime;

public class AnimeCreator {
    public static Anime createAnimeToBeSaved() {
        return Anime.builder()
                .nome("Hajime no Ippo")
                .build();
    }

    public static Anime createValidAnime() {
        return Anime.builder()
                .nome("Hajime no Ippo")
                .id(1L)
                .build();
    }

    public static Anime createValidUpdatedAnime() {
        return Anime.builder()
                .nome("Hajime no Ippo 2")
                .id(1L)
                .build();
    }
}
