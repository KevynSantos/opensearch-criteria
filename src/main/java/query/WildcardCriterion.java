package query;

import criteria.OsCriterion;
import java.util.*;

public class WildcardCriterion implements OsCriterion {

    private final String field;
    private final String value;
    private boolean caseInsensitive;

    public WildcardCriterion(String field, String value) {
        this.field = field;
        this.value = value;
    }

    public WildcardCriterion caseInsensitive(boolean enabled) {
        this.caseInsensitive = enabled;
        return this;
    }

    @Override
    public Map<String, Object> toDsl() {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("value", value);

        if (caseInsensitive) {
            body.put("case_insensitive", true);
        }

        Map<String, Object> wildcard = new LinkedHashMap<>();
        wildcard.put(field, body);

        return Collections.singletonMap("wildcard", wildcard);
    }
}
