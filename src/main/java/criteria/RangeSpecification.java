package criteria;

import query.RangeCriterion;

public class RangeSpecification implements OsSpecification {

    private final RangeCriterion criterion;

    public RangeSpecification(String field) {
        this.criterion = new RangeCriterion(field);
    }

    public RangeSpecification gte(Object value) {
        criterion.gte(value);
        return this;
    }

    public RangeSpecification lte(Object value) {
        criterion.lte(value);
        return this;
    }

    public RangeSpecification gt(Object value) {
        criterion.gt(value);
        return this;
    }

    public RangeSpecification lt(Object value) {
        criterion.lt(value);
        return this;
    }

    /** 👈 NOVO */
    public RangeSpecification format(String format) {
        criterion.format(format);
        return this;
    }

    @Override
    public OsCriterion toPredicate() {
        return criterion;
    }
}
