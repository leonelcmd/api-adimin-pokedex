package com.senac.devweb.api.admin.pokedex.pokemon;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/pokemon")
@AllArgsConstructor
@CrossOrigin("*")
public class PokemonController {
    private PokemonService pokemonService;
    //
    @PostMapping("/")
    public ResponseEntity<PokemonRepresentation.Detail> salvar(@Valid @RequestBody PokemonRepresentation.CreateOrUpdate createOrUpdate) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(PokemonRepresentation.Detail.from(this.pokemonService.salvar(createOrUpdate)));
    }
}
