package com.senac.devweb.api.admin.pokedex.vantagem;

import com.senac.devweb.api.admin.pokedex.pokemon.Pokemon;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class VantagemService {

    private VantagemRepository vantagemRepository;

    public Vantagem salvar(VantagemRepresentation.CreateOrUpdate createOrUpdate) {
        return this.vantagemRepository.save(Vantagem.builder()
                .pokemon(createOrUpdate.getPokemon())
                .imune(createOrUpdate.getImune())
                .pro(createOrUpdate.getPro())
                .tipoPokemon(createOrUpdate.getTipoPokemon())
                .build());
    }
}
