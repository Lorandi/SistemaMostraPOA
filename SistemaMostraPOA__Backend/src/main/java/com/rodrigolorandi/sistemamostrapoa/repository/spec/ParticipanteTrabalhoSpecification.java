package com.rodrigolorandi.sistemamostrapoa.repository.spec;

import com.rodrigolorandi.sistemamostrapoa.entity.ParticipanteTrabalho;
import com.rodrigolorandi.sistemamostrapoa.enums.TipoParticipanteTrabalhoEnum;
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
public class ParticipanteTrabalhoSpecification implements Specification<ParticipanteTrabalho> {
    @Builder.Default
    private final transient Optional<String> name = Optional.empty();
    @Builder.Default
    private final transient Optional<String> email = Optional.empty();
    @Builder.Default
    private final transient Optional<String> cpf = Optional.empty();
    @Builder.Default
    private final transient Optional<String> phone = Optional.empty();
    @Builder.Default
    private final transient Optional<List<TipoParticipanteTrabalhoEnum>> tipoParticipante = Optional.empty();
    @Builder.Default
    private final transient Optional<List<Long>> trabalhoId = Optional.empty();


    @Override
    public Predicate toPredicate(Root<ParticipanteTrabalho> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder builder) {
        final var predicate = new ArrayList<Predicate>();
        name.ifPresent(n -> predicate.add(builder.like(builder.lower(root.get("name")), "%" + n.toLowerCase() + "%")));
        email.ifPresent(ce -> predicate.add(builder.like(builder.lower(root.get("email")), ce.toLowerCase())));
        cpf.ifPresent(ps -> predicate.add(root.get("cpf").in(ps)));
        phone.ifPresent(p -> predicate.add(builder.like(builder.lower(root.get("phone")), "%" + p.toLowerCase() + "%")));
        tipoParticipante.ifPresent(at -> predicate.add(root.get("tipoParticipante").in(at)));
        trabalhoId.ifPresent(ti -> predicate.add(root.get("trabalhoId").in(ti)));

        criteriaQuery.distinct(true);
        return builder.and(predicate.toArray(new Predicate[0]));
    }
}
