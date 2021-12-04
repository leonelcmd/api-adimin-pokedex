package com.senac.devweb.api.admin.pokedex.vantagem;

import com.senac.devweb.api.admin.pokedex.pokemon.Pokemon;
import com.senac.devweb.api.admin.pokedex.utils.TipoPokemon;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Table(name= "vantagem")
public class Vantagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_vantagem")
    private Integer id;

    @NotNull(message = "O pokemon é obrigatório")
    @ManyToOne
    @JoinColumn(name = "id_pokemon", referencedColumnName="id_pokemon")
    private Pokemon pokemon;

    @NotNull(message = "Informe se essa vantagem é contra ou a favor do pokemon")
    @Column(name = "pro")
    private Boolean pro;

    @NotNull(message = "Se este pokemon tiver imunidade a algum tipo marque sim ")
    @Column(name = "imune")
    private Boolean imune;

    @NotNull(message = "Escolha o tipo de pokemon em desvantagem")
    @Column(name = "tipo")
    private TipoPokemon tipoPokemon;
}
