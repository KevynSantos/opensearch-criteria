package criteria.aggregation.mapper;

import criteria.aggregation.dto.ChartDTO;
import criteria.aggregation.result.OsBucket;
import criteria.aggregation.result.OsDateBucket;
import criteria.aggregation.result.OsTermsAggregationResult;

public class OsChartMapper {

    public static ChartDTO fromTerms(
            OsTermsAggregationResult result
    ) {

        ChartDTO chart = new ChartDTO();

        for (OsBucket b : result.getBuckets()) {
            chart.add(
                b.getKey(),
                b.getDocCount()
            );
        }

        return chart;
    }

    public static ChartDTO fromDateHistogram(
            OsTermsAggregationResult result
    ) {

        ChartDTO chart = new ChartDTO();

        for (OsBucket b : result.getBuckets()) {
            OsDateBucket date = (OsDateBucket) b;

            chart.add(
                date.getKeyAsString(),
                date.getDocCount()
            );
        }

        return chart;
    }
}
