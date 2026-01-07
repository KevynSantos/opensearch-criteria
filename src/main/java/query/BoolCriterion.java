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

/**
 * Representa uma query bool do OpenSearch
 */
public class BoolCriterion implements OsCriterion {

    private final List<OsCriterion> must = new ArrayList<>();
    private final List<OsCriterion> filter = new ArrayList<>();
    private final List<OsCriterion> should = new ArrayList<>();
    private final List<OsCriterion> mustNot = new ArrayList<>();
    private Integer minimumShouldMatch;

    public BoolCriterion must(OsCriterion c) {
        if (c != null) must.add(c);
        return this;
    }

    public BoolCriterion filter(OsCriterion c) {
        if (c != null) filter.add(c);
        return this;
    }

    public BoolCriterion should(OsCriterion c) {
        if (c != null) should.add(c);
        return this;
    }

    public BoolCriterion mustNot(OsCriterion c) {
        if (c != null) mustNot.add(c);
        return this;
    }

    public BoolCriterion minimumShouldMatch(int value) {
        this.minimumShouldMatch = value;
        return this;
    }


    @Override
    public Object toDsl() {
        Map<String, Object> bool = new LinkedHashMap<>();

        if (!must.isEmpty()) bool.put("must", toList(must));
        if (!filter.isEmpty()) bool.put("filter", toList(filter));
        if (!should.isEmpty()) bool.put("should", toList(should));
        if (!mustNot.isEmpty()) bool.put("must_not", toList(mustNot));
        
        if (minimumShouldMatch != null) {
            bool.put("minimum_should_match", minimumShouldMatch);
        }


        return Collections.singletonMap("bool", bool);
    }

    private List<Object> toList(List<OsCriterion> list) {
        List<Object> result = new ArrayList<>();
        for (OsCriterion c : list) {
            result.add(c.toDsl()); // ✅ agora bate
        }
        return result;
    }
}
