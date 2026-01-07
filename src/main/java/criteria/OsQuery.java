package criteria;

import java.util.*;

public class OsQuery {

    private final Object query;
    private final Integer from;
    private final Integer size;
    private final Object sort;
    private final OsSource source;

    public OsQuery(
            Object query,
            Integer from,
            Integer size,
            Object sort,
            OsSource source
    ) {
        this.query = query;
        this.from = from;
        this.size = size;
        this.sort = sort;
        this.source = source;
    }

    public Map<String, Object> toDsl() {
        Map<String, Object> dsl = new LinkedHashMap<>();

        if (source != null) {
            dsl.put("_source", source.toDsl());
        }

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

        return dsl;
    }
}
