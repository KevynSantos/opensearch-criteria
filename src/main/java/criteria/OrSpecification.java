package criteria;

import query.BoolCriterion;

public class OrSpecification implements OsSpecification {

    private final OsSpecification left;
    private final OsSpecification right;

    public OrSpecification(OsSpecification left, OsSpecification right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public OsCriterion toPredicate() {
        BoolCriterion bool = new BoolCriterion();

        apply(bool, left);
        apply(bool, right);

        return bool;
    }

    private void apply(BoolCriterion bool, OsSpecification spec) {
        if (spec instanceof ClauseSpecification) {
            ClauseSpecification cs = (ClauseSpecification) spec;
            switch (cs.getClause()) {
                case FILTER:
                    // ⚠ OR com filter não faz sentido sem bool interno
                    bool.should(cs.toPredicate());
                    break;
                case SHOULD:
                    bool.should(cs.toPredicate());
                    break;
                case MUST_NOT:
                    bool.mustNot(cs.toPredicate());
                    break;
                default:
                    bool.should(cs.toPredicate());
            }
        } else {
            bool.should(spec.toPredicate());
        }
    }
}
