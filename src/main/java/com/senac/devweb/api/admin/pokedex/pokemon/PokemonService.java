package com.senac.devweb.api.admin.pokedex.pokemon;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PokemonService {

    private PokemonRepository pokemonRepository;

    public Pokemon salvar(PokemonRepresentation.CreateOrUpdate createOrUpdate) {

        return this.pokemonRepository.save(Pokemon.builder()
                .nome(createOrUpdate.getNome())
                .fase(createOrUpdate.getFase())
                .habilidades(createOrUpdate.getHabilidades())
                .tipoPokemon(createOrUpdate.getTipoPokemon())
                .vantagens(createOrUpdate.getVantagens())
                .build());
    }
}
