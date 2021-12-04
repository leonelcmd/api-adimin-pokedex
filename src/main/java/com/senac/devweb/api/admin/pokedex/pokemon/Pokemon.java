package com.senac.devweb.api.admin.pokedex.pokemon;

import com.senac.devweb.api.admin.pokedex.habilidade.Habilidade;
import com.senac.devweb.api.admin.pokedex.utils.TipoPokemon;
import com.senac.devweb.api.admin.pokedex.vantagem.Vantagem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Table(name= "pokemon")
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_pokemon")
    private Integer id;

    @Column(name="nome")
    @NotNull(message = "Nome do Pokemon obrigatório")
    @Size(min = 5, max = 50, message = "Nome deve ter entre 5 e 50 caracteres")
    private String nome;

    @Column(name="fase")
    @NotNull(message = "escolha a fase do pokemon cadastrado")
    private Fase fase;

    @Column(name="tipo")
    @Enumerated(EnumType.STRING)
    @NotNull(message = "Escolha o tipo do pokemon")
    private TipoPokemon tipoPokemon;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "pokemon", orphanRemoval = true)
    private List<Vantagem> vantagens  = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "pokemon", orphanRemoval = true)
    private List<Habilidade> habilidades = new ArrayList<>();

    enum Fase {
        PRIMARIA,
        SECUNDARIA,
        FINAL
    }
}
