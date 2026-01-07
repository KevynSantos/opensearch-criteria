package criteria;

import java.util.*;

public class OsSort {

    private final List<Map<String, Object>> sorts = new ArrayList<>();

    private OsSort() {}

    public static OsSort by(String field) {
        OsSort sort = new OsSort();
        sort.asc(field);
        return sort;
    }

    public OsSort asc(String field) {
        sorts.add(
            Collections.singletonMap(
                field,
                Collections.singletonMap("order", "asc")
            )
        );
        return this;
    }

    public OsSort desc(String field) {
        sorts.add(
            Collections.singletonMap(
                field,
                Collections.singletonMap("order", "desc")
            )
        );
        return this;
    }

    public List<Map<String, Object>> toDsl() {
        return sorts;
    }
}
