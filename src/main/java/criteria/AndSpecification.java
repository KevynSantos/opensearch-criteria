package criteria;

import query.BoolCriterion;

public class AndSpecification implements OsSpecification {

    private final OsSpecification left;
    private final OsSpecification right;

    public AndSpecification(OsSpecification left, OsSpecification right) {
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
                    bool.filter(cs.toPredicate());
                    break;
                case SHOULD:
                    bool.should(cs.toPredicate());
                    break;
                case MUST_NOT:
                    bool.mustNot(cs.toPredicate());
                    break;
                default:
                    bool.must(cs.toPredicate());
            }
        } else {
            bool.must(spec.toPredicate());
        }
    }
}
