package util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;

/**
*
*
* @author Kevyn
* @since 2026
* @github https://github.com/KevynSantos
*/

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ObjectNode;

public final class JsonDslBuilder {

    private static final ObjectMapper MAPPER = new ObjectMapper()
            .enable(SerializationFeature.INDENT_OUTPUT);

    private JsonDslBuilder() {}

    public static String toJson(Object dsl) {
        try {
            return MAPPER.writeValueAsString(dsl);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao gerar JSON DSL", e);
        }
    }
    
    public static ObjectNode toNode(String str) throws JsonMappingException, JsonProcessingException
    {
    	JsonNode jsonNode = MAPPER.readTree(str);
    	
    	ObjectNode node = null;

    	if (jsonNode.isObject()) {
    	    node = (ObjectNode) jsonNode;
    	}
    	
    	return node;
    }
}
