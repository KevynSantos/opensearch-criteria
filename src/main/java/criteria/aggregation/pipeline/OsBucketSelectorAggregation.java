package criteria.aggregation.pipeline;

import java.util.LinkedHashMap;
import java.util.Map;

import criteria.aggregation.OsAggregation;

//OsBucketSelectorAggregation selector =
//OsBucketSelectorAggregation.of("filtrar")
//.path("total", "_count")
//.script("params.total > 10");

public class OsBucketSelectorAggregation implements OsAggregation {

    private final String name;
    private final Map<String, String> bucketsPath = new LinkedHashMap<>();
    private String script;

    private OsBucketSelectorAggregation(String name) {
        this.name = name;
    }

    public static OsBucketSelectorAggregation of(String name) {
        return new OsBucketSelectorAggregation(name);
    }

    public OsBucketSelectorAggregation path(String alias, String path) {
        bucketsPath.put(alias, path);
        return this;
    }

    public OsBucketSelectorAggregation script(String script) {
        this.script = script;
        return this;
    }

    @Override
    public Map<String, Object> toDsl() {

        Map<String, Object> selector = new LinkedHashMap<>();
        selector.put("buckets_path", bucketsPath);
        selector.put("script", script);

        Map<String, Object> wrapper = new LinkedHashMap<>();
        wrapper.put("bucket_selector", selector);

        Map<String, Object> agg = new LinkedHashMap<>();
        agg.put(name, wrapper);

        return agg;
    }
}
