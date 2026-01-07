package query;

/**
*
*
* @author Kevyn
* @since 2026
* @github https://github.com/KevynSantos
*/

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
