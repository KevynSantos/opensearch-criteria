package query;

/**
*
*
* @author Kevyn
* @since 2026
* @github https://github.com/KevynSantos
*/

import criteria.OsCriterion;
import java.util.*;

public class NestedCriterion implements OsCriterion {

    private final String path;
    private final OsCriterion query;

    public NestedCriterion(String path, OsCriterion query) {
        this.path = path;
        this.query = query;
    }

    @Override
    public Object toDsl() {
        Map<String, Object> nested = new LinkedHashMap<>();
        nested.put("path", path);
        nested.put("query", query.toDsl());

        return Collections.singletonMap("nested", nested);
    }
}
