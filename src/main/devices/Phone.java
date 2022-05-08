package main.devices;

import main.apps.App;
import main.apps.AppVersion;

public class Phone extends Device {
    public Phone(String producer, String model, int yearOfProduction, Double value) {
        super(model, producer, yearOfProduction,value );
    }

    @Override
    public void turnOn() {
        System.out.println("TURNING ON PHONE");
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public void installApp(App appName) throws Exception {
        System.out.println(
                "Choosen app: " + appName.getName() + ". " +
                        "Latest available version: " + appName.getLatestVersion().getVersion());
        install(appName.getLatestVersion());
    }

    public void installApp(App appName, Integer versionToInstall) throws Exception {
        AppVersion foundVersion = appName.getAppVersions().stream()
                .filter((version) -> version.getVersion() == versionToInstall)
                .findFirst()
                .orElseThrow(() -> new Exception("Not found " + appName.getName() + " in version " + versionToInstall));
        install(foundVersion);
    }


    private void install(AppVersion app) {
        System.out.println("Installed " + app.getName() + " (version: "+ app.getVersion() + ") on device " + this.toString());
    }
}
