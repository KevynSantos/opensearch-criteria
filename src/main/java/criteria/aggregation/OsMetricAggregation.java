package criteria.aggregation;

import java.util.LinkedHashMap;
import java.util.Map;

public class OsMetricAggregation implements OsAggregation {

    private final String name;
    private final String type;
    private final String field;

    private OsMetricAggregation(String name, String type, String field) {
        this.name = name;
        this.type = type;
        this.field = field;
    }

    public static OsMetricAggregation avg(String name, String field) {
        return new OsMetricAggregation(name, "avg", field);
    }

    public static OsMetricAggregation sum(String name, String field) {
        return new OsMetricAggregation(name, "sum", field);
    }

    @Override
    public Map<String, Object> toDsl() {

        Map<String, Object> inner = new LinkedHashMap<>();
        inner.put("field", field);

        Map<String, Object> typeWrapper = new LinkedHashMap<>();
        typeWrapper.put(type, inner);

        Map<String, Object> aggregation = new LinkedHashMap<>();
        aggregation.put(name, typeWrapper);

        return aggregation;
    }

}
