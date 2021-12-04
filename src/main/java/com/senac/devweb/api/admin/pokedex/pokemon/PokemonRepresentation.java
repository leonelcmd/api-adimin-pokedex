package com.senac.devweb.api.admin.pokedex.pokemon;

import com.senac.devweb.api.admin.pokedex.habilidade.Habilidade;
import com.senac.devweb.api.admin.pokedex.utils.TipoPokemon;
import com.senac.devweb.api.admin.pokedex.vantagem.Vantagem;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

public interface PokemonRepresentation {

    @Data
    @Getter
    @Setter
    class CreateOrUpdate {

        @NotNull(message = "Nome do Pokemon obrigatório")
        @Size(min = 5, max = 50, message = "Nome deve ter entre 5 e 50 caracteres")
        private String nome;

        @NotNull(message = "escolha a fase do pokemon cadastrado")
        private Pokemon.Fase fase;

        @NotNull(message = "Escolha o tipo do pokemon")
        private TipoPokemon tipoPokemon;

        private List<Vantagem> vantagens  = new ArrayList<>();

        private List<Habilidade> habilidades = new ArrayList<>();
    }

    @Data
    @Getter
    @Setter
    @Builder
    class Detail {
        private Integer id;
        private String nome;
        private Pokemon.Fase fase;
        private TipoPokemon tipoPokemon;
        private List<Vantagem> vantagens  = new ArrayList<>();
        private List<Habilidade> habilidades = new ArrayList<>();

        public static Detail from(Pokemon pokemon) {
            return Detail.builder()
                    .id(pokemon.getId())
                    .nome(pokemon.getNome())
                    .fase(pokemon.getFase())
                    .tipoPokemon(pokemon.getTipoPokemon())
                    .vantagens(pokemon.getVantagens())
                    .habilidades(pokemon.getHabilidades())
                    .build();
        }
    }
}
