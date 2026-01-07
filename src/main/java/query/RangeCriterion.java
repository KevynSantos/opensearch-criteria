package query;

import criteria.OsCriterion;
import java.util.*;

public class RangeCriterion implements OsCriterion {

    private final String field;
    private final Map<String, Object> operators = new LinkedHashMap<>();

    public RangeCriterion(String field) {
        this.field = field;
    }

    public RangeCriterion gte(Object value) {
        operators.put("gte", value);
        return this;
    }

    public RangeCriterion lte(Object value) {
        operators.put("lte", value);
        return this;
    }

    public RangeCriterion gt(Object value) {
        operators.put("gt", value);
        return this;
    }

    public RangeCriterion lt(Object value) {
        operators.put("lt", value);
        return this;
    }

    @Override
    public Map<String, Object> toDsl() {
        return Collections.singletonMap(
            "range",
            Collections.singletonMap(field, operators)
        );
    }
}
