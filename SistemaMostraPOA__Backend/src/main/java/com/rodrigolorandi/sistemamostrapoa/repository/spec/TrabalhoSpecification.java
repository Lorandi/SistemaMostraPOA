package com.rodrigolorandi.sistemamostrapoa.repository.spec;

import com.rodrigolorandi.sistemamostrapoa.entity.Trabalho;
import com.rodrigolorandi.sistemamostrapoa.enums.ApresentacaoEnum;
import com.rodrigolorandi.sistemamostrapoa.enums.TematicasEnum;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.Builder;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Builder
public class TrabalhoSpecification implements Specification<Trabalho> {
    @Builder.Default
    private final transient Optional<String> titulo = Optional.empty();
    @Builder.Default
    private final transient Optional<List<ApresentacaoEnum>> apresentacao = Optional.empty();
    @Builder.Default
    private final transient Optional<List<TematicasEnum>> tematica = Optional.empty();
    @Builder.Default
    private final transient Optional<String> observacao = Optional.empty();

    @Override
    public Predicate toPredicate(Root<Trabalho> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder builder) {
        final var predicate = new ArrayList<Predicate>();
        titulo.ifPresent(n -> predicate.add(builder.like(builder.lower(root.get("titulo")), "%" + n.toLowerCase() + "%")));
        apresentacao.ifPresent(at -> predicate.add(root.get("apresentacao").in(at)));
        tematica.ifPresent(at -> predicate.add(root.get("tematica").in(at)));
        observacao.ifPresent(n -> predicate.add(builder.like(builder.lower(root.get("observacao")), "%" + n.toLowerCase() + "%")));

        criteriaQuery.distinct(true);
        return builder.and(predicate.toArray(new Predicate[0]));
    }
}
