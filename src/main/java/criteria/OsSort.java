package criteria;

import java.util.*;

public class OsSort {

    private final List<Map<String, Object>> sorts = new ArrayList<>();

    private OsSort() {}

    public static OsSort by(String field) {
        OsSort sort = new OsSort();
        return sort.asc(field); // opcional → veja abaixo
    }

    public static OsSort empty() {
        return new OsSort();
    }

    public OsSort asc(String field) {
        sorts.add(order(field, "asc"));
        return this;
    }

    public OsSort desc(String field) {
        sorts.add(order(field, "desc"));
        return this;
    }

    private Map<String, Object> order(String field, String direction) {
        return Collections.singletonMap(
            field,
            Collections.singletonMap("order", direction)
        );
    }

    public List<Map<String, Object>> toDsl() {
        return sorts;
    }
}
