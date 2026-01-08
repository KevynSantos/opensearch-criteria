package query;

import criteria.OsCriterion;
import java.util.*;

public class TermCriterion implements OsCriterion {

    private final String field;
    private final Object value;

    private Double boost;
    private Boolean caseInsensitive;

    public TermCriterion(String field, Object value) {
        this.field = field;
        this.value = value;
    }

    public TermCriterion boost(double boost) {
        this.boost = boost;
        return this;
    }

    public TermCriterion caseInsensitive(boolean value) {
        this.caseInsensitive = value;
        return this;
    }

    @Override
    public Map<String, Object> toDsl() {

        // forma simples
        if (boost == null && caseInsensitive == null) {
            return Collections.singletonMap(
                "term",
                Collections.singletonMap(field, value)
            );
        }

        // forma expandida
        Map<String, Object> options = new LinkedHashMap<>();
        options.put("value", value);

        if (boost != null) {
            options.put("boost", boost);
        }

        if (caseInsensitive != null) {
            options.put("case_insensitive", caseInsensitive);
        }

        return Collections.singletonMap(
            "term",
            Collections.singletonMap(field, options)
        );
    }
}
