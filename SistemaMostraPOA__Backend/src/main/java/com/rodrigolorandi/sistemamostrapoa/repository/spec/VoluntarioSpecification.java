package com.rodrigolorandi.sistemamostrapoa.repository.spec;

import com.rodrigolorandi.sistemamostrapoa.entity.Voluntario;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.Builder;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.Optional;


@Builder
public class VoluntarioSpecification implements Specification<Voluntario> {
    @Builder.Default
    private final transient Optional<String> name = Optional.empty();
    @Builder.Default
    private final transient Optional<String> email = Optional.empty();
    @Builder.Default
    private final transient Optional<String> cpf = Optional.empty();
    @Builder.Default
    private final transient Optional<String> phone = Optional.empty();
    @Builder.Default
    private final transient Optional<String> course = Optional.empty();


    @Override
    public Predicate toPredicate(Root<Voluntario> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder builder) {
        final var predicate = new ArrayList<Predicate>();
        name.ifPresent(n -> predicate.add(builder.like(builder.lower(root.get("name")), "%" + n.toLowerCase() + "%")));
        email.ifPresent(ce -> predicate.add(builder.like(builder.lower(root.get("email")), ce.toLowerCase())));
        cpf.ifPresent(ps -> predicate.add(root.get("cpf").in(ps)));
        phone.ifPresent(p -> predicate.add(builder.like(builder.lower(root.get("phone")), "%" + p.toLowerCase() + "%")));
        course.ifPresent(p -> predicate.add(builder.like(builder.lower(root.get("course")), "%" + p.toLowerCase() + "%")));

        criteriaQuery.distinct(true);
        return builder.and(predicate.toArray(new Predicate[0]));
    }
}
