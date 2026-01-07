package query;

import criteria.OsCriterion;
import java.util.*;

public class TermsCriterion implements OsCriterion {

    private final String field;
    private final Collection<?> values;

    public TermsCriterion(String field, Collection<?> values) {
        this.field = field;
        this.values = values;
    }

    @Override
    public Map<String, Object> toDsl() {
        return Collections.singletonMap(
            "terms",
            Collections.singletonMap(field, values)
        );
    }
}
