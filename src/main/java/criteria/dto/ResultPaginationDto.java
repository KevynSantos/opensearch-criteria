package criteria.dto;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

public class ResultPaginationDto {
	
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
