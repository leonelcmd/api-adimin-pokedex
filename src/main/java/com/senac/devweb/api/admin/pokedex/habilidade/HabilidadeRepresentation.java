package com.senac.devweb.api.admin.pokedex.habilidade;

import com.senac.devweb.api.admin.pokedex.pokemon.Pokemon;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public interface HabilidadeRepresentation {

    @Data
    @Getter
    @Setter
    class CreateOrUpdate {

        @NotNull(message = "O pokemon é obrigatório")
        private Pokemon pokemon;

        @NotNull(message = "O nome da habilidade é obrigatório!")
        @Size(max = 40, min = 1, message = "O nome da habilidade deve ter entre 1 e 40 caracteres")
        private String nome;

        /* a descrição não é obrigatória,
        porém se houver descrição a quant
        min de caracteres deve ser 10 */

        @Size(max = 80, min = 10, message = "A descrição deve ter entre 10 e 80 caracteres! ")
        private String descricao;
    }

    @Data
    @Getter
    @Setter
    @Builder
    class Detail {
        private Integer id;
        private String nome;
        private String descricao;

        public static Detail from(Habilidade habilidade) {
            return Detail.builder()
                    .id(habilidade.getId())
                    .nome(habilidade.getNome())
                    .descricao(habilidade.getDescricao())
                    .build();
        }
    }
}
