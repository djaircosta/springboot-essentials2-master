package com.example.springessentials.requests;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AnimePostRequestBody {
    @NotEmpty(message = "O nome do anime não pode ser vazio")
    @Schema(description = "Este é o nome do anime", example = "Tensei Shittara Slime Datta ken", required = true)
    private String nome;

}
