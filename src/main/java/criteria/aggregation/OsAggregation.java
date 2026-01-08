package criteria.aggregation;

import java.util.Map;

//OsQuery query = OsQueryBuilder.create()
//.where(spec)
//.aggregations(
//    OsTermsAggregation
//        .of("por_unidade", "idUnidadeNegocio")
//        .size(10)
//)
//.size(0)
//.build();


public interface OsAggregation {
    Map<String, Object> toDsl();
}
