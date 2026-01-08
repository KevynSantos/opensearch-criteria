package criteria.aggregation;

import java.util.LinkedHashMap;
import java.util.Map;

//Leitura pratica
//OsTermsAggregationResult hist =
//new OsTermsAggregationResult(result.get("por_mes"));

//for (OsBucket b : hist.getBuckets()) {
//OsDateBucket date = (OsDateBucket) b;
//System.out.println(
//    date.getKeyAsString() + " -> " + date.getDocCount()
//);
//}


public class OsDateHistogramAggregation implements OsAggregation {

    private final String name;
    private final String field;
    private String calendarInterval;
    private String fixedInterval;

    private OsDateHistogramAggregation(String name, String field) {
        this.name = name;
        this.field = field;
    }

    public static OsDateHistogramAggregation of(String name, String field) {
        return new OsDateHistogramAggregation(name, field);
    }

    public OsDateHistogramAggregation calendarInterval(String interval) {
        this.calendarInterval = interval;
        return this;
    }

    public OsDateHistogramAggregation fixedInterval(String interval) {
        this.fixedInterval = interval;
        return this;
    }

    @Override
    public Map<String, Object> toDsl() {

        Map<String, Object> histogram = new LinkedHashMap<>();
        histogram.put("field", field);

        if (calendarInterval != null) {
            histogram.put("calendar_interval", calendarInterval);
        }
        if (fixedInterval != null) {
            histogram.put("fixed_interval", fixedInterval);
        }

        Map<String, Object> wrapper = new LinkedHashMap<>();
        wrapper.put("date_histogram", histogram);

        Map<String, Object> agg = new LinkedHashMap<>();
        agg.put(name, wrapper);

        return agg;
    }
}
