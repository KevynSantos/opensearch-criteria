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
    	
    	OsSpecification nomeSpec =
    		    OsSpecifications.term("nome.keyword", "kevyn").filter();

    		OsSpecification ativoSpec =								// 👈 QUERY AQUI
    		    OsSpecifications.term("ativo", true).filter();

    		OsSpecification spec = nomeSpec.and(ativoSpec);



    	OsQuery query = OsQueryBuilder.create()
    		    .where(spec)
    		    .source("nome", "email") // 👈 SOURCE AQUI
    		    .sort( 
    		        OsSort.empty().desc("nome.keyword") 
    		            .asc("idade")			// 👈 SORT AQUI
    		            .desc("createdAt")
    		    )
    		    .build();


        System.out.println(
            JsonDslBuilder.toJson(query.toDsl()) // 👈 RESULTADO
        );
    }
}
