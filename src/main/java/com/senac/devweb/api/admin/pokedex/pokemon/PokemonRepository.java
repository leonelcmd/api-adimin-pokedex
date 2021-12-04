package com.senac.devweb.api.admin.pokedex.pokemon;

import com.querydsl.core.types.Predicate;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PokemonRepository extends PagingAndSortingRepository<Pokemon, Integer>, QuerydslPredicateExecutor<Pokemon> {

    /**
    * metodo responsavel por retornar o lista de pokemons
    * @param filter
    * @return
    */
    List<Pokemon> findAll(Predicate filter);
}
