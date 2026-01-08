package criteria.aggregation.dto;

import java.util.ArrayList;
import java.util.List;

//OsAggregationResult aggResult = ...;

//OsTermsAggregationResult hist =
 //   new OsTermsAggregationResult(
 //       aggResult.get("por_mes")
 //   );

//ChartDTO chart =
//    OsChartMapper.fromDateHistogram(hist);


public class ChartDTO {

    private final List<String> labels = new ArrayList<>();
    private final List<Number> values = new ArrayList<>();

    public void add(String label, Number value) {
        labels.add(label);
        values.add(value);
    }

    public List<String> getLabels() {
        return labels;
    }

    public List<Number> getValues() {
        return values;
    }
}
