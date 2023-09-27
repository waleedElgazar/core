package com.waleedreda.core.specification;

import com.waleedreda.core.common.CriteriaConjunctionOperatorEnum;
import com.waleedreda.core.common.CriteriaOperatorEnum;
import com.waleedreda.core.criteria.BaseCriteriaFilter;
import com.waleedreda.core.entity.BaseEntity;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;


public abstract class BaseSpecificationBuilder<E extends BaseEntity, C extends BaseCriteriaFilter> {
    public BaseSpecificationBuilder() {
    }

    public abstract Specification<E> getSearchSpecification(C criteriaFilter);

    protected Specification<E> addSpecification(Specification<E> baseSpec, CriteriaConjunctionOperatorEnum conjOperator, Specification<E> otherSpec) {
        if (null == baseSpec) {
            return Specification.where(otherSpec);
        } else {
            return conjOperator == CriteriaConjunctionOperatorEnum.OR ? Specification.where(baseSpec).or(otherSpec) : Specification.where(baseSpec).and(otherSpec);
        }
    }

    protected Specification<E> buildSpecification(String attributeName, Comparable attributeValue, CriteriaOperatorEnum operator) {
        return (root, query, criteriaBuilder) -> {
            Path path = this.getPath(root, attributeName);
            switch (operator) {
                case LIKE:
                    String likeValue = "%" + attributeValue + "%";
                    return criteriaBuilder.like(criteriaBuilder.lower(path), likeValue.toLowerCase());
                case GREATER_THAN:
                    return criteriaBuilder.greaterThan(path, attributeValue);
                case GREATER_THAN_OR_EQUAL:
                    return criteriaBuilder.greaterThanOrEqualTo(path, attributeValue);
                case LESS_THAN:
                    return criteriaBuilder.lessThan(path, attributeValue);
                case LESS_THAN_OR_EQUAL:
                    return criteriaBuilder.lessThanOrEqualTo(path, attributeValue);
                case GE:
                    return criteriaBuilder.ge(path, (Number)attributeValue);
                case GT:
                    return criteriaBuilder.gt(path, (Number)attributeValue);
                case LE:
                    return criteriaBuilder.le(path, (Number)attributeValue);
                case LT:
                    return criteriaBuilder.lt(path, (Number)attributeValue);
                case EQ:
                default:
                    return criteriaBuilder.equal(path, attributeValue);
            }
        };
    }

    private Path<E> getPath(Root<E> root, String attributeName) {
        Path<E> path = root;
        String[] var4 = attributeName.split("\\.");
        int var5 = var4.length;

        for(int var6 = 0; var6 < var5; ++var6) {
            String part = var4[var6];
            path = ((Path)path).get(part);
        }

        return (Path)path;
    }
}
