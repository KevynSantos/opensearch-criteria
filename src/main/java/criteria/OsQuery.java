package criteria;

import java.util.LinkedHashMap;
import java.util.Map;

public class OsQuery {

    private final Object query;
    private final Integer from;
    private final Integer size;
    private final Object sort;
    private final OsSource source;
    private final Object trackTotalHits;
    private final Object aggregations;

    public OsQuery(
        Object query,
        Integer from,
        Integer size,
        Object sort,
        OsSource source,
        Object trackTotalHits,
        Object aggregations
    ) {
        this.query = query;
        this.from = from;
        this.size = size;
        this.sort = sort;
        this.source = source;
        this.trackTotalHits = trackTotalHits;
        this.aggregations = aggregations;
    }

    public Map<String, Object> toDsl() {
        Map<String, Object> dsl = new LinkedHashMap<>();

        if (query != null) {
            dsl.put("query", query);
        }
        if (from != null) {
            dsl.put("from", from);
        }
        if (size != null) {
            dsl.put("size", size);
        }
        if (sort != null) {
            dsl.put("sort", sort);
        }
        if (source != null) {
            dsl.put("_source", source.toDsl());
        }
        if (trackTotalHits != null) {
            dsl.put("track_total_hits", trackTotalHits);
        }
        
        if (aggregations != null) {
            dsl.put("aggs", aggregations);
        }


        return dsl;
    }
}
