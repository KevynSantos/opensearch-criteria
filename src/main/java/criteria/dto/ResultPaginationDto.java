package criteria.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ResultPaginationDto {

    private final Integer page;
    private final Integer pageSize;
    private final Integer total;
    private final JsonNode records;

    public ResultPaginationDto(String responseBody, Integer pageSize, Integer page)
            throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(responseBody);

        this.total = root.path("hits").path("total").path("value").asInt();
        this.records = root.path("hits").path("hits");
        this.page = page;
        this.pageSize = pageSize;
    }

    public Integer getPage() { return page; }
    public Integer getPageSize() { return pageSize; }
    public Integer getTotal() { return total; }
    public JsonNode getRecords() { return records; }
}

