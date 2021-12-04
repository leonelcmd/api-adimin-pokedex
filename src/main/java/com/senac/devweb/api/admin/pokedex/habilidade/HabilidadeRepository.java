package com.senac.devweb.api.admin.pokedex.habilidade;

import com.querydsl.core.types.Predicate;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

// comecei o desenvolvimento pelo rep
@Service
public interface HabilidadeRepository extends PagingAndSortingRepository<Habilidade, Long>, QuerydslPredicateExecutor<Habilidade> {

    /**
     * metodo responsavel por retornar as habilidades por pokemon
     * @param filter
     * @return
     */
    List<Habilidade> findAll(Predicate filter);

}
