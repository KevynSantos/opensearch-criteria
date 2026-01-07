package util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

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
}
