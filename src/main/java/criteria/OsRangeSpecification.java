package criteria;

import query.RangeCriterion;

public class OsRangeSpecification implements OsSpecification {

    private final String field;
    private Object gt;
    private Object gte;
    private Object lt;
    private Object lte;

    public OsRangeSpecification(String field) {
        this.field = field;
    }

    public OsRangeSpecification gt(Object value) {
        this.gt = value;
        return this;
    }

    public OsRangeSpecification gte(Object value) {
        this.gte = value;
        return this;
    }

    public OsRangeSpecification lt(Object value) {
        this.lt = value;
        return this;
    }

    public OsRangeSpecification lte(Object value) {
        this.lte = value;
        return this;
    }

    @Override
    public OsCriterion toPredicate() {
        RangeCriterion range = new RangeCriterion(field);

        if (gt != null)  range.gt(gt);
        if (gte != null) range.gte(gte);
        if (lt != null)  range.lt(lt);
        if (lte != null) range.lte(lte);

        return range;
    }
}
