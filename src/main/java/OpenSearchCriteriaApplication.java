import criteria.OsQuery;
import criteria.OsQueryBuilder;
import criteria.OsSpecification;
import criteria.OsSpecifications;
import util.JsonDslBuilder;

public class OpenSearchCriteriaApplication {

    public static void main(String[] args) {

    	OsSpecification spec =
    		    OsSpecifications.term("nome.keyword", "kevyn").must()
    		        .and(OsSpecifications.term("nome.keyword", "joao"));


        OsQuery query = OsQueryBuilder.create()
            .where(spec)
            .source("nome", "email") // 👈 SOURCE AQUI
            .build();

        System.out.println(
            JsonDslBuilder.toJson(query.toDsl())
        );
    }
}
