import criteria.OsQuery;
import criteria.OsQueryBuilder;
import criteria.OsSort;
import criteria.OsSpecification;
import criteria.OsSpecifications;
import util.JsonDslBuilder;

/**
 *
 *
 * @author Kevyn
 * @since 2026
 * @github https://github.com/KevynSantos
 */

public class OpenSearchCriteriaApplication {

    public static void main(String[] args) {

    	OsSpecification spec =
    		    OsSpecifications.term("nome.keyword", "kevyn").must()
    		        .or(OsSpecifications.term("nome.keyword", "joao")); // 👈 QUERY AQUI


    	OsQuery query = OsQueryBuilder.create()
    		    .where(spec)
    		    .source("nome", "email")
    		    .sort(
    		        OsSort.by("nome.keyword") // 👈 SOURCE AQUI
    		            .asc("idade")
    		            .desc("createdAt")
    		    )
    		    .build();


        System.out.println(
            JsonDslBuilder.toJson(query.toDsl()) // 👈 RESULTADO
        );
    }
}
