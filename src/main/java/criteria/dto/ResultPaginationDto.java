package criteria.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ResultPaginationDto {
	
	public ResultPaginationDto(String responseBody, Integer pageSize, Integer page) throws JsonMappingException, JsonProcessingException
	{
		ObjectMapper mapper = new ObjectMapper();
		JsonNode root = mapper.readTree(responseBody);
		int total = root.path("hits").path("total").path("value").asInt();
		JsonNode records = root.path("hits").path("hits");
		
		this.page = page;
		this.pageSize = pageSize;
		this.records = records;
		this.total = total;
	}
	
	private Integer page;
	
	private Integer pageSize;
	
	private Integer total;
	
	private JsonNode records;

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public JsonNode getRecords() {
		return records;
	}

	public void setRecords(JsonNode records) {
		this.records = records;
	}
	
	

}
