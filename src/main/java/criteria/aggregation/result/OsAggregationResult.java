package criteria.aggregation.result;

import java.util.Map;

//Map<String, Object> response = ... // JSON parseado

//Map<String, Object> aggs =
  //  (Map<String, Object>) response.get("aggregations");

//OsAggregationResult result = new OsAggregationResult(aggs);

//OsTermsAggregationResult statusAgg =
  //  new OsTermsAggregationResult(result.get("por_status"));

//for (OsBucket b : statusAgg.getBuckets()) {
  //  System.out.println(
    //    b.getKey() + " -> " + b.getDocCount()
    //);
//}


public class OsAggregationResult {

    private final Map<String, Object> aggregations;

    public OsAggregationResult(Map<String, Object> aggregations) {
        this.aggregations = aggregations;
    }

    public Map<String, Object> raw() {
        return aggregations;
    }

    @SuppressWarnings("unchecked")
    public Map<String, Object> get(String name) {
        return (Map<String, Object>) aggregations.get(name);
    }
}
