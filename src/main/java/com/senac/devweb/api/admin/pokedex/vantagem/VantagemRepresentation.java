package com.senac.devweb.api.admin.pokedex.vantagem;

import com.senac.devweb.api.admin.pokedex.pokemon.Pokemon;
import com.senac.devweb.api.admin.pokedex.utils.TipoPokemon;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotNull;

public interface VantagemRepresentation {

    @Data
    @Getter
    @Setter
    class CreateOrUpdate {

        @NotNull(message = "O pokemon é obrigatório")
        private Pokemon pokemon;

        @NotNull(message = "Informe se essa vantagem é contra ou a favor do pokemon")
        private Boolean pro;

        @NotNull(message = "Se este pokemon tiver imunidade a algum tipo marque sim ")
        private Boolean imune;

        @NotNull(message = "Escolha o tipo de pokemon em desvantagem")
        private TipoPokemon tipoPokemon;

    }

    @Data
    @Getter
    @Setter
    @Builder
    class Detail {
        private Integer id;
        private Pokemon pokemon;
        private Boolean pro;
        private Boolean imune;
        private TipoPokemon tipoPokemon;

        public static Detail from(Vantagem vantagem) {
            return Detail.builder()
                    .id(vantagem.getId())
                    .imune(vantagem.getImune())
                    .pokemon(vantagem.getPokemon())
                    .tipoPokemon(vantagem.getTipoPokemon())
                    .pro(vantagem.getPro())
                    .build();
        }
    }
}
