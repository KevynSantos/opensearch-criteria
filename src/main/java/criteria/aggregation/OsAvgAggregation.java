package criteria.aggregation;

import java.util.*;

public class OsAvgAggregation implements OsAggregation {

    private final String name;
    private final String field;

    private OsAvgAggregation(String name, String field) {
        this.name = name;
        this.field = field;
    }

    public static OsAvgAggregation of(String name, String field) {
        return new OsAvgAggregation(name, field);
    }

    @Override
    public Map<String, Object> toDsl() {
        Map<String, Object> avg = new LinkedHashMap<>();
        avg.put("field", field);

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("avg", avg);

        Map<String, Object> wrapper = new LinkedHashMap<>();
        wrapper.put(name, body);

        return wrapper;
    }
}
