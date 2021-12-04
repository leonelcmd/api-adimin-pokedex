package com.senac.devweb.api.admin.pokedex.habilidade;

import com.senac.devweb.api.admin.pokedex.pokemon.Pokemon;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Getter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Table(name= "ability")
public class Habilidade {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_ability")
    private Integer id;

    @NotNull(message = "O pokemon é obrigatório")
    @ManyToOne
    @JoinColumn(name = "id_pokemon", referencedColumnName="id_pokemon")
    private Pokemon pokemon;

    @NotNull(message = "O nome da habilidade é obrigatório!")
    @Size(max = 40, min = 1, message = "O nome da habilidade deve ter entre 1 e 40 caracteres")
    @Column(name="name")
    private String nome;

    @Size(max = 80, min = 10, message = "A descrição deve ter entre 10 e 80 caracteres! ")
    @Column(name="description")
    private String descricao;


}
