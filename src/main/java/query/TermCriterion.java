package query;

import criteria.OsCriterion;
import java.util.*;

public class TermCriterion implements OsCriterion {

    private final String field;
    private final Object value;

    public TermCriterion(String field, Object value) {
        this.field = field;
        this.value = value;
    }

    @Override
    public Map<String, Object> toDsl() {
        return Collections.singletonMap(
            "term",
            Collections.singletonMap(field, value)
        );
    }
}
