package criteria;

public interface OsSpecification {

    OsCriterion toPredicate();

    default OsSpecification and(OsSpecification other) {
        return new AndSpecification(this, other);
    }

    default OsSpecification or(OsSpecification other) {
        return new OrSpecification(this, other);
    }

    // 👇 NOVO
    default OsSpecification must() {
        return new ClauseSpecification(this, BoolClause.MUST);
    }

    default OsSpecification filter() {
        return new ClauseSpecification(this, BoolClause.FILTER);
    }

    default OsSpecification should() {
        return new ClauseSpecification(this, BoolClause.SHOULD);
    }

    default OsSpecification mustNot() {
        return new ClauseSpecification(this, BoolClause.MUST_NOT);
    }
}
