package criteria;

@FunctionalInterface
public interface OsSpecification {

    OsCriterion toPredicate();

    default OsSpecification and(OsSpecification other) {
        return () -> this.toPredicate().and(other.toPredicate());
    }

    default OsSpecification or(OsSpecification other) {
        return () -> this.toPredicate().or(other.toPredicate());
    }

    default OsSpecification not() {
        return () -> this.toPredicate().not();
    }
}
