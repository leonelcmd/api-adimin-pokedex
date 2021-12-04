package com.senac.devweb.api.admin.pokedex.vantagem;

import com.querydsl.core.types.Predicate;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;


import java.util.List;

public interface VantagemRepository extends PagingAndSortingRepository<Vantagem, Long>, QuerydslPredicateExecutor<Vantagem> {

    /**
     * metodo responsavel por retornar as vantagens e desvantagens de um pokemon
     * @param filter
     * @return
     */
     List<Vantagem> findAll(Predicate filter);
}
