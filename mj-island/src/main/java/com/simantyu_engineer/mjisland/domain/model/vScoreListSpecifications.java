package com.simantyu_engineer.mjisland.domain.model;

import org.springframework.data.jpa.domain.Specification;
import jakarta.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class vScoreListSpecifications {

    public static Specification<vScoreList> filter(
            Date eventDateFrom,
            Date eventDateTo,
            String groupId) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (eventDateFrom != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("event_date"), eventDateFrom));
            }

            if (eventDateTo != null) {
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("event_date"), eventDateTo));
            }
            if (groupId != null) {
                predicates.add(criteriaBuilder.equal(root.get("group_id"), groupId));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}