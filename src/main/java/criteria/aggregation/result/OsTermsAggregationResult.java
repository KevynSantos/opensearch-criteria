package criteria.aggregation.result;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OsTermsAggregationResult {

    private final List<OsBucket> buckets = new ArrayList<>();

    @SuppressWarnings("unchecked")
    public OsTermsAggregationResult(Map<String, Object> aggregation) {

        List<Map<String, Object>> rawBuckets =
            (List<Map<String, Object>>) aggregation.get("buckets");

        for (Map<String, Object> b : rawBuckets) {
            buckets.add(
                new OsBucket(
                    b
                )
            );
        }
    }

    public List<OsBucket> getBuckets() {
        return buckets;
    }
}
