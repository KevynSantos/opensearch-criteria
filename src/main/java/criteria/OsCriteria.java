package criteria;

import query.BoolCriterion;
import java.util.*;

public class OsCriteria {

    private final BoolCriterion rootBool = new BoolCriterion();

    public static OsCriteria create() {
        return new OsCriteria();
    }

    public OsCriteria must(OsCriterion c) {
        rootBool.must(c);
        return this;
    }

    public OsCriteria filter(OsCriterion c) {
        rootBool.filter(c);
        return this;
    }

    public OsCriteria should(OsCriterion c) {
        rootBool.should(c);
        return this;
    }

    public OsCriteria mustNot(OsCriterion c) {
        rootBool.mustNot(c);
        return this;
    }

    public Map<String, Object> build() {
        return Collections.singletonMap("query", rootBool.toDsl());
    }
}
