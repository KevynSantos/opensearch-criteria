package criteria;

/**
*
*
* @author Kevyn
* @since 2026
* @github https://github.com/KevynSantos
*/

import query.*;

public final class OsRestrictions {

    private OsRestrictions() {}

    public static OsCriterion match(String field, Object value) {
        return new MatchCriterion(field, value);
    }

    public static OsCriterion term(String field, Object value) {
        return new TermCriterion(field, value);
    }

    public static RangeCriterion range(String field) {
        return new RangeCriterion(field);
    }

    public static BoolCriterion bool() {
        return new BoolCriterion();
    }
}
