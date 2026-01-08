package criteria;

import criteria.aggregation.OsAggregation;

/**
*
*
* @author Kevyn
* @since 2026
* @github https://github.com/KevynSantos
*/

public class OsQueryBuilder {

    private OsSpecification specification;
    private Integer from;
    private Integer size;
    private Object sort;
    private OsSource source;
    private Object trackTotalHits;
    private Object aggregations;


    public static OsQueryBuilder create() {
        return new OsQueryBuilder();
    }
    
    public OsQueryBuilder page(OsPageRequest pageRequest) {
        this.from = pageRequest.getFrom();
        this.size = pageRequest.getSize();
        return this;
    }

    public OsQueryBuilder trackTotalHits(boolean enabled) {
        this.trackTotalHits = enabled;
        return this;
    }
    
    public OsQueryBuilder aggregations(OsAggregation aggregation) {
        this.aggregations = aggregation.toDsl();
        return this;
    }

    public OsQueryBuilder trackTotalHits(OsTrackTotalHits track) {
        this.trackTotalHits = track.toDsl();
        return this;
    }


    
    public OsQueryBuilder addOrUpdateWhere(OsSpecification spec) {
        if (this.specification == null) {
            this.specification = spec;
        } else {
            this.specification = this.specification.and(spec);
        }
        return this;
    }


    public OsQueryBuilder where(OsSpecification spec) {
        this.specification = spec;
        return this;
    }
    
    public OsQueryBuilder sort(OsSort sort) {
        this.sort = sort.toDsl();
        return this;
    }


    public OsQueryBuilder from(int from) {
        this.from = from;
        return this;
    }

    public OsQueryBuilder size(int size) {
        this.size = size;
        return this;
    }

    public OsQueryBuilder sort(Object sort) {
        this.sort = sort;
        return this;
    }

    // ---------- SOURCE ----------

    public OsQueryBuilder source(String... fields) {
        this.source = OsSource.include(fields);
        return this;
    }

    public OsQueryBuilder sourceExclude(String... fields) {
        this.source = OsSource.exclude(fields);
        return this;
    }

    public OsQueryBuilder source(boolean enabled) {
        this.source = enabled
            ? OsSource.enable()
            : OsSource.disable();
        return this;
    }

    // ----------------------------

    public OsQuery build() {
        Object queryDsl = specification != null
            ? specification.toPredicate().toDsl()
            : null;

        return new OsQuery(
            queryDsl,
            from,
            size,
            sort,
            source,
            trackTotalHits,
            aggregations
        );
    }
}
