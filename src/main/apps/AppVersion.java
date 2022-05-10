package main.apps;

import java.util.Comparator;
import java.util.Locale;

public class AppVersion extends App {

    private static final String DefaultUrl = "www.default.com";
    private final Integer Version;
    private final String UrlSource;

    public AppVersion(String name, Integer version, String urlSource, Double price) {
        super(name, price);
        Version = version;
        UrlSource = urlSource;
    }

    public AppVersion(String name, Integer version, Double price) {
        super(name, price);
        Version = version;
        UrlSource = DefaultUrl;
    }


    public Integer getVersion() {
        return Version;
    }

    public String getUrlSource() {
        return UrlSource;
    }
}
