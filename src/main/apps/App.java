package main.apps;

import java.util.ArrayList;

public class App {

    private final String Name;
    private final ArrayList<AppVersion> AppVersions;

    public App(String name) {
        Name = name;
        AppVersions = new ArrayList<>();
    }

    public String getName() {
        return Name;
    }

    public void addNewVersion(AppVersion appVersion) {
        AppVersions.add(appVersion);
    }

    public ArrayList<AppVersion> getAppVersions() {
        return AppVersions;
    }

    public AppVersion getLatestVersion() throws Exception {
        if (!AppVersions.isEmpty()) {
            if (AppVersions.stream().count() == 1) return AppVersions.get(0);
            else {
                AppVersion latest = AppVersions.get(0);

                for (AppVersion current : AppVersions) {
                    if (current.getVersion() > latest.getVersion()) {
                        latest = current;
                    } else continue;
                }
                return latest;
            }
        } else {
            throw new Exception("Not found any version of " + this.Name);
        }
    }

    public void addNewVersion(Integer version, String souceUrl) {
        addNewVersion((new AppVersion(Name, version, souceUrl)));
    }
}
