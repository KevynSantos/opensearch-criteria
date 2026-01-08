package criteria.aggregation.result;

import java.util.HashMap;
import java.util.Map;

public class OsBucket {
	//utilizando subAggregations
	//for (OsBucket bucket : statusAgg.getBuckets()) {

	 //   OsMetricResult avg =
	//        new OsMetricResult(
	 //           bucket.getSubAggregation("media_idade")
	  //      );

	  //  System.out.println(
	  //      bucket.getKey() + " → " + avg.getValue()
	  //  );
	//}


    private final String key;
    private final long docCount;
    private final Map<String, Object> subAggregations = new HashMap<>();

    @SuppressWarnings("unchecked")
    public OsBucket(Map<String, Object> bucket) {
        this.key = String.valueOf(bucket.get("key"));
        this.docCount = ((Number) bucket.get("doc_count")).longValue();

        // tudo que NÃO é key / doc_count é sub-aggregation
        for (Map.Entry<String, Object> e : bucket.entrySet()) {
            if (!"key".equals(e.getKey()) && !"doc_count".equals(e.getKey())) {
                subAggregations.put(e.getKey(), e.getValue());
            }
        }
    }

    public String getKey() {
        return key;
    }

    public long getDocCount() {
        return docCount;
    }

    public boolean hasSubAggregation(String name) {
        return subAggregations.containsKey(name);
    }

    @SuppressWarnings("unchecked")
    public Map<String, Object> getSubAggregation(String name) {
        return (Map<String, Object>) subAggregations.get(name);
    }
}
