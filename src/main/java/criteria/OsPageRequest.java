package criteria;

public class OsPageRequest {

    private final int page;
    private final int size;

    private OsPageRequest(int page, int size) {
        if (page < 0) {
            throw new IllegalArgumentException("page must be >= 0");
        }
        if (size <= 0) {
            throw new IllegalArgumentException("size must be > 0");
        }
        this.page = page;
        this.size = size;
    }

    public static OsPageRequest of(int page, int size) {
        return new OsPageRequest(page, size);
    }

    public int getPage() {
        return page;
    }

    public int getSize() {
        return size;
    }

    public int getFrom() {
        return page * size;
    }
}
