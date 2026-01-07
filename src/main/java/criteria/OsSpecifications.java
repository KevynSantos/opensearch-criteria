package criteria;

/**
*
*
* @author Kevyn
* @since 2026
* @github https://github.com/KevynSantos
*/

import query.*;

public final class OsSpecifications {

    private OsSpecifications() {}

    public static OsSpecification match(String field, Object value) {
        return () -> new MatchCriterion(field, value);
    }

    public static OsSpecification term(String field, Object value) {
        return () -> new TermCriterion(field, value);
    }

    public static OsSpecification range(String field) {
        return () -> new RangeCriterion(field);
    }

    public static OsSpecification exists(String field) {
        return () -> new ExistsCriterion(field);
    }

    public static OsSpecification nested(String path, OsSpecification spec) {
        return () -> new NestedCriterion(path, spec.toPredicate());
    }
}
