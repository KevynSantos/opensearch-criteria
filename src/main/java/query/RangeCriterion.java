package query;

import criteria.OsCriterion;
import java.util.*;

public class RangeCriterion implements OsCriterion {

    private final String field;

    private Object gte;
    private Object lte;
    private Object gt;
    private Object lt;
    private String format;

    public RangeCriterion(String field) {
        this.field = field;
    }

    public RangeCriterion gte(Object value) {
        this.gte = value;
        return this;
    }

    public RangeCriterion lte(Object value) {
        this.lte = value;
        return this;
    }

    public RangeCriterion gt(Object value) {
        this.gt = value;
        return this;
    }

    public RangeCriterion lt(Object value) {
        this.lt = value;
        return this;
    }

    /** 👈 NOVO */
    public RangeCriterion format(String format) {
        this.format = format;
        return this;
    }

    @Override
    public Map<String, Object> toDsl() {

        Map<String, Object> rangeBody = new LinkedHashMap<>();

        if (gte != null) rangeBody.put("gte", gte);
        if (lte != null) rangeBody.put("lte", lte);
        if (gt != null)  rangeBody.put("gt", gt);
        if (lt != null)  rangeBody.put("lt", lt);

        if (format != null) {
            rangeBody.put("format", format);
        }

        Map<String, Object> fieldWrapper = new LinkedHashMap<>();
        fieldWrapper.put(field, rangeBody);

        return Collections.singletonMap("range", fieldWrapper);
    }
}
