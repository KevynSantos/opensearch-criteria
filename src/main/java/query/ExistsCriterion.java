package query;

import criteria.OsCriterion;
import java.util.Collections;

public class ExistsCriterion implements OsCriterion {

    private final String field;

    public ExistsCriterion(String field) {
        this.field = field;
    }

    @Override
    public Object toDsl() {
        return Collections.singletonMap(
            "exists",
            Collections.singletonMap("field", field)
        );
    }
}
