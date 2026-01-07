package criteria;

/**
*
*
* @author Kevyn
* @since 2026
* @github https://github.com/KevynSantos
*/

import java.util.*;

public class OsSource {

    private Boolean enabled;
    private List<String> includes;
    private List<String> excludes;

    private OsSource() {}

    public static OsSource enable() {
        OsSource s = new OsSource();
        s.enabled = true;
        return s;
    }

    public static OsSource disable() {
        OsSource s = new OsSource();
        s.enabled = false;
        return s;
    }

    public static OsSource include(String... fields) {
        OsSource s = new OsSource();
        s.includes = Arrays.asList(fields);
        return s;
    }

    public static OsSource exclude(String... fields) {
        OsSource s = new OsSource();
        s.excludes = Arrays.asList(fields);
        return s;
    }

    public Object toDsl() {
        if (enabled != null) {
            return enabled;
        }

        Map<String, Object> source = new LinkedHashMap<>();

        if (includes != null && !includes.isEmpty()) {
            source.put("includes", includes);
        }

        if (excludes != null && !excludes.isEmpty()) {
            source.put("excludes", excludes);
        }

        return source;
    }
}
