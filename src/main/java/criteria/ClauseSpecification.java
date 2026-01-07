package criteria;

public class ClauseSpecification implements OsSpecification {

    private final OsSpecification spec;
    private final BoolClause clause;

    public ClauseSpecification(OsSpecification spec, BoolClause clause) {
        this.spec = spec;
        this.clause = clause;
    }

    public BoolClause getClause() {
        return clause;
    }

    @Override
    public OsCriterion toPredicate() {
        return spec.toPredicate();
    }
}
