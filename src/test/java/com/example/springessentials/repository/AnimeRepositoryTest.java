package com.example.springessentials.repository;

import com.example.springessentials.domain.Anime;
import com.example.springessentials.util.AnimeCreator;
import lombok.extern.log4j.Log4j2;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Optional;


@DataJpaTest
@DisplayName("Testes para Anime Repository")
class AnimeRepositoryTest {
    @Autowired
    private AnimeRepository animeRepository;

    @Test
    @DisplayName("Save persists anime when sucessful")
    void save_PersistAnime_WhenSucessful() {
        Anime animeToBeSaved = AnimeCreator.createAnimeToBeSaved();

        Anime savedAnime = this.animeRepository.save(animeToBeSaved);

        Assertions.assertThat(savedAnime).isNotNull();

        Assertions.assertThat(savedAnime.getId()).isNotNull();

        Assertions.assertThat(savedAnime.getNome()).isEqualTo(animeToBeSaved.getNome());
    }

    @Test
    @DisplayName("Save updates  anime when sucessful")
    void save_UpdateAnime_WhenSucessful() {
        Anime animeToBeSaved = AnimeCreator.createAnimeToBeSaved();

        Anime savedAnime = this.animeRepository.save(animeToBeSaved);

        savedAnime.setNome("Overlord");

        Anime animeUpdated = this.animeRepository.save(savedAnime);

        Assertions.assertThat(animeUpdated).isNotNull();

        Assertions.assertThat(animeUpdated.getId()).isNotNull();

        Assertions.assertThat(animeUpdated.getNome()).isEqualTo(savedAnime.getNome());
    }

    @Test
    @DisplayName("Delete removes anime when sucessful")
    void delete_RemovesAnime_WhenSucessful() {
        Anime animeToBeSaved = AnimeCreator.createAnimeToBeSaved();

        Anime savedAnime = this.animeRepository.save(animeToBeSaved);

        this.animeRepository.delete(savedAnime);

        Optional<Anime> animeOptional = this.animeRepository.findById(savedAnime.getId());

        Assertions.assertThat(animeOptional).isEmpty();

    }

    @Test
    @DisplayName("Find by name returns list of anime when sucessful")
    void findByName_ReturnsListOfAnime_WhenSucessful() {
        Anime animeToBeSaved = AnimeCreator.createAnimeToBeSaved();

        Anime savedAnime = this.animeRepository.save(animeToBeSaved);

        String nome = savedAnime.getNome();

        List<Anime> animes = this.animeRepository.findByNome(nome);

        Assertions.assertThat(animes)
                .isNotEmpty()
                .contains(savedAnime);
    }

    @Test
    @DisplayName("Find by name returns empty list when no anime is found")
    void findByName_ReturnsEmptyList_WhenAnimeIsNotFound() {
        List<Anime> animes = this.animeRepository.findByNome("nome");

        Assertions.assertThat(animes).isEmpty();
    }

    @Test
    @DisplayName("Save throw ConstraintViolationException when name is empty")
    void save_ConstraintViolationException_WhenNameIfEmpty() {
        Anime anime = new Anime();
//        Assertions.assertThatThrownBy(() ->  this.animeRepository.save(anime))
//                .isInstanceOf(ConstraintViolationException.class);

        Assertions.assertThatExceptionOfType(ConstraintViolationException.class)
                .isThrownBy(() -> this.animeRepository.save(anime))
                .withMessageContaining("O nome do anime não pode ser vazio");
    }

}