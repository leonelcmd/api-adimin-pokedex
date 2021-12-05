package com.senac.devweb.api.admin.pokedex.vantagem;

import com.senac.devweb.api.admin.pokedex.habilidade.HabilidadeRepresentation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/vantagem")
@AllArgsConstructor
@CrossOrigin("*")
public class VantagemController {

    private VantagemService vantagemService;

    //
    @PostMapping("/")
    public ResponseEntity<VantagemRepresentation.Detail> salvar(@Valid @RequestBody VantagemRepresentation.CreateOrUpdate createOrUpdate) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(VantagemRepresentation.Detail.from(this.vantagemService.salvar(createOrUpdate)));
    }
}
