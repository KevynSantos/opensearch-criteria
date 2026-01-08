package criteria.aggregation;

import java.util.*;

public class OsTermsAggregation implements OsAggregation {

    private final String name;
    private final String field;
    private Integer size;

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

    @Override
    public Map<String, Object> toDsl() {

        Map<String, Object> terms = new LinkedHashMap<>();
        terms.put("field", field);

        if (size != null) {
            terms.put("size", size);
        }

        Map<String, Object> termsWrapper = new LinkedHashMap<>();
        termsWrapper.put("terms", terms);

        Map<String, Object> aggregation = new LinkedHashMap<>();
        aggregation.put(name, termsWrapper);

        return aggregation;
    }

}
