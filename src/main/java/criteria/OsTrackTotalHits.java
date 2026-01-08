package criteria;

public class OsTrackTotalHits {

    private final Object value;

    private OsTrackTotalHits(Object value) {
        this.value = value;
    }

    public static OsTrackTotalHits enable() {
        return new OsTrackTotalHits(true);
    }

    public static OsTrackTotalHits disable() {
        return new OsTrackTotalHits(false);
    }

    public static OsTrackTotalHits limit(int maxHits) {
        if (maxHits <= 0) {
            throw new IllegalArgumentException("maxHits must be > 0");
        }
        return new OsTrackTotalHits(maxHits);
    }

    public Object toDsl() {
        return value;
    }
}
