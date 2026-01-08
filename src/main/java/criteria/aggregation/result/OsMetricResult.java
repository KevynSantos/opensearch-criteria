package criteria.aggregation.result;

import java.util.Map;

public class OsMetricResult {

    private final Double value;

    public OsMetricResult(Map<String, Object> aggregation) {
        Object v = aggregation.get("value");
        this.value = v == null ? null : ((Number) v).doubleValue();
    }

    public Double getValue() {
        return value;
    }
}
