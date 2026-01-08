package criteria.aggregation.result;

import java.util.Map;

public class OsBucket {

    private final String key;
    private final long docCount;
    private final Map<String, Object> subAggregations;

    public OsBucket(String key, long docCount, Map<String, Object> subAggregations) {
        this.key = key;
        this.docCount = docCount;
        this.subAggregations = subAggregations;
    }

    public String getKey() {
        return key;
    }

    public long getDocCount() {
        return docCount;
    }

    public Map<String, Object> getSubAggregations() {
        return subAggregations;
    }
}
