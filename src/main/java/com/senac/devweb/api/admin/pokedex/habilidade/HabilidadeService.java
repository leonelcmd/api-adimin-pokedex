package com.senac.devweb.api.admin.pokedex.habilidade;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class HabilidadeService {

    private HabilidadeRepository habilidadeRepository;

    public Habilidade salvar(HabilidadeRepresentation.CreateOrUpdate createOrUpdate) {

        return this.habilidadeRepository.save(Habilidade.builder()
                .pokemon(createOrUpdate.getPokemon())
                .nome(createOrUpdate.getNome())
                .descricao(createOrUpdate.getDescricao())
                .build());
    }

}
