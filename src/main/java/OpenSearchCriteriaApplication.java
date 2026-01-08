import java.util.List;

import criteria.OsQuery;
import criteria.OsQueryBuilder;
import criteria.OsSort;
import criteria.OsSpecification;
import criteria.OsSpecifications;
import criteria.aggregation.OsDateHistogramAggregation;
import criteria.aggregation.OsTermsAggregation;
import criteria.aggregation.pipeline.OsBucketSelectorAggregation;
import util.JsonDslBuilder;

/**
 * Exemplo completo de uso do OpenSearch Criteria DSL.
 *
 * Demonstra:
 *  - Filtros (term, bool, filter)
 *  - Composição de Specification (and / or)
 *  - Ordenação
 *  - Source filtering
 *  - Aggregations
 *  - Sub-aggregations
 *  - Pipeline aggregation (bucket_selector)
 *  - Date histogram (gráficos)
 *
 * @author Kevyn
 * @since 2026
 */
public class OpenSearchCriteriaApplication {

    public static void main(String[] args) {
    	
    	/**
		WHERE
    	nome = 'kevyn'
		AND ativo = true
		AND (status = 'ATIVO' OR status = 'PENDENTE')
		AND createdAt BETWEEN '2024-01-01' AND '2024-12-31'

    	 */

        /* =========================================================
         * 1️⃣ FILTERS (WHERE / AND)
         * ========================================================= */

        OsSpecification nomeSpec =
            OsSpecifications
                .term("nome.keyword", "kevyn")
                .filter(); // filter = AND sem score

        OsSpecification ativoSpec =
            OsSpecifications
                .term("ativo", true)
                .filter();

        // nome AND ativo
        OsSpecification baseSpec =
            nomeSpec.and(ativoSpec);


        /* =========================================================
         * 2️⃣ OR / SHOULD
         * ========================================================= */

        OsSpecification statusSpec =
            OsSpecifications
                .term("status.keyword", "ATIVO")
                .or(
                    OsSpecifications.term("status.keyword", "PENDENTE")
                );


        /* =========================================================
         * 3️⃣ RANGE (tempo)
         * ========================================================= */

        OsSpecification periodoSpec =
            OsSpecifications
                .range("createdAt")
                .gte("2024-01-01")
                .lte("2024-12-31")
                .filter();


        /* =========================================================
         * 4️⃣ QUERY FINAL (merge de tudo)
         * ========================================================= */

        OsSpecification querySpec =
            baseSpec
                .and(statusSpec)
                .and(periodoSpec);


        /* =========================================================
         * 5️⃣ SORT
         * ========================================================= */

        OsSort sort =
            OsSort
                .empty()
                .desc("createdAt")
                .asc("nome.keyword");


        /* =========================================================
         * 6️⃣ AGGREGATIONS
         * ========================================================= */

        // 6.1 Agrupamento por status
        OsTermsAggregation porStatus =
            OsTermsAggregation
                .of("por_status", "status.keyword");

        // 6.2 Sub-aggregation: média de idade
        porStatus.metricAvg("media_idade", "idade");

        // 6.3 Pipeline: HAVING count > 10
        porStatus.subAggregation(
            OsBucketSelectorAggregation
                .of("somente_com_volume")
                .path("total", "_count")
                .script("params.total > 10")
        );

        // 6.4 Date histogram (gráfico por mês)
        OsDateHistogramAggregation porMes =
            OsDateHistogramAggregation
                .of("por_mes", "createdAt")
                .calendarInterval("month");


        /* =========================================================
         * 7️⃣ BUILD DA QUERY
         * ========================================================= */

        OsQuery query =
            OsQueryBuilder
                .create()
                .where(querySpec)
                .source("nome", "email", "status", "createdAt")
                .sort(sort)
                .aggregations(porStatus)
                .aggregations(porMes)
                .trackTotalHits(true)
                .build();


        /* =========================================================
         * 8️⃣ RESULTADO FINAL
         * ========================================================= */

        System.out.println(
            JsonDslBuilder.toJson(query.toDsl())
        );
    }
}
