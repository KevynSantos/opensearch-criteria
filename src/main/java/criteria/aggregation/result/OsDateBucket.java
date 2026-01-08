package criteria.aggregation.result;

import java.util.Map;

public class OsDateBucket extends OsBucket {

    private final String keyAsString;

    public OsDateBucket(Map<String, Object> bucket) {
        super(bucket);
        this.keyAsString = (String) bucket.get("key_as_string");
    }

    public String getKeyAsString() {
        return keyAsString;
    }
}
