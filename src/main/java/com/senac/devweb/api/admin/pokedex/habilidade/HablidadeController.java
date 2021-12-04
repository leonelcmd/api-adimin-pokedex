package com.senac.devweb.api.admin.pokedex.habilidade;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/habilidade")
@AllArgsConstructor
@CrossOrigin("*")
public class HablidadeController {

    private HabilidadeService habilidadeService;
//
    @PostMapping("/")
    public ResponseEntity<HabilidadeRepresentation.Detail> salvarHabilidade( @Valid @RequestBody HabilidadeRepresentation.CreateOrUpdate createOrUpdate) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(HabilidadeRepresentation.Detail.from(this.habilidadeService.salvar(createOrUpdate)));

    }

}
