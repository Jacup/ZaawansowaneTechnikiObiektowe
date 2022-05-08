package main.apps;

public class AppVersion extends App{

    private static final String DefaultUrl = "www.default.com";
    private final Integer Version;
    private final String UrlSource;

    public AppVersion(String name, Integer version, String urlSource) {
        super(name);
        Version = version;
        UrlSource = urlSource;
    }

    public AppVersion(String name, Integer version) {
        super(name);
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
