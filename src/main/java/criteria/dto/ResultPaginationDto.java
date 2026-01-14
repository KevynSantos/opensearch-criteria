package criteria.dto;

import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ResultPaginationDto {

    private final Integer pageSize;
    private final Integer total;
    private final JsonNode records;
    private final List<Object> searchAfter;

    public ResultPaginationDto(String responseBody, Integer pageSize)
            throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(responseBody);

        JsonNode hitsNode = root.path("hits").path("hits");

        this.total = root.path("hits").path("total").path("value").asInt();
        this.records = hitsNode;
        this.pageSize = pageSize;

        if (hitsNode.isArray() && hitsNode.size() > 0) {
            JsonNode lastHit = hitsNode.get(hitsNode.size() - 1);
            JsonNode sortNode = lastHit.path("sort");

            this.searchAfter = sortNode.isArray()
                ? mapper.convertValue(sortNode, List.class)
                : null;
        } else {
            this.searchAfter = null;
        }
    }

    public Integer getPageSize() { return pageSize; }
    public Integer getTotal() { return total; }
    public JsonNode getRecords() { return records; }
    public List<Object> getSearchAfter() { return searchAfter; }
}
