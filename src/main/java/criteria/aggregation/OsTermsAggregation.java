package criteria.aggregation;

import java.util.*;

public class OsTermsAggregation implements OsAggregation {

    private final String name;
    private final String field;
    private Integer size;

    private final List<OsAggregation> subAggregations = new ArrayList<>();

    private OsTermsAggregation(String name, String field) {
        this.name = name;
        this.field = field;
    }

    public static OsTermsAggregation of(String name, String field) {
        return new OsTermsAggregation(name, field);
    }

    public OsTermsAggregation size(int size) {
        this.size = size;
        return this;
    }
    
    /* =====================================================
     * Metric Aggregations
     * ===================================================== */

    public OsTermsAggregation metricAvg(String name, String field) {
        this.subAggregations.add(
            OsAvgAggregation.of(name, field)
        );
        return this;
    }

    /* =====================================================
     * Sub-Aggregations
     * ===================================================== */

    public OsTermsAggregation subAggregation(OsAggregation aggregation) {
        this.subAggregations.add(aggregation);
        return this;
    }

    @Override
    public Map<String, Object> toDsl() {

        /* ---------- terms ---------- */

        Map<String, Object> terms = new LinkedHashMap<>();
        terms.put("field", field);

        if (size != null) {
            terms.put("size", size);
        }

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("terms", terms);

        /* ---------- sub aggregations ---------- */

        if (!subAggregations.isEmpty()) {
            Map<String, Object> aggs = new LinkedHashMap<>();

            for (OsAggregation agg : subAggregations) {
                aggs.putAll(agg.toDsl());
            }

            body.put("aggs", aggs);
        }

        /* ---------- wrapper ---------- */

        Map<String, Object> aggregation = new LinkedHashMap<>();
        aggregation.put(name, body);

        return aggregation;
    }
}
