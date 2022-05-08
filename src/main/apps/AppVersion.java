package main.apps;

public class AppVersion extends App{

    private final Integer Version;
    private final String UrlSource;

    public AppVersion(String name, Integer version, String urlSource) {
        super(name);
        Version = version;
        UrlSource = urlSource;
    }

    public Integer getVersion() {
        return Version;
    }

    public String getUrlSource() {
        return UrlSource;
    }

}
