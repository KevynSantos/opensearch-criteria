package criteria;

import java.util.*;
import query.*;

public final class OsSpecifications {

    private OsSpecifications() {}

    // ===== TERM =====
    public static OsSpecification term(String field, Object value) {
        return () -> new TermCriterion(field, value);
    }

    // ===== TERMS (IN) =====
    public static OsSpecification terms(String field, Collection<?> values) {
        return () -> new TermsCriterion(field, values);
    }

    // ===== MATCH =====
    public static OsSpecification match(String field, Object value) {
        return () -> new MatchCriterion(field, value);
    }
    
 // ===== RANGE =====
    public static OsRangeSpecification range(String field) {
        return new OsRangeSpecification(field);
    }


    // ===== OR com minimum_should_match =====
    public static OsSpecification or(
            OsSpecification left,
            OsSpecification right,
            int minimumShouldMatch
    ) {
        return () -> {
            return new query.BoolCriterion()
                .should(left.toPredicate())
                .should(right.toPredicate())
                .minimumShouldMatch(minimumShouldMatch);
        };
    }
}
