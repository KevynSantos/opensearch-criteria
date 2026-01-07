package criteria;

import query.BoolCriterion;

public interface OsCriterion {

    Object toDsl();

    default OsCriterion and(OsCriterion other) {
        return new BoolCriterion().must(this).must(other);
    }

    default OsCriterion or(OsCriterion other) {
        return new BoolCriterion().should(this).should(other);
    }

    default OsCriterion not() {
        return new BoolCriterion().mustNot(this);
    }
}
