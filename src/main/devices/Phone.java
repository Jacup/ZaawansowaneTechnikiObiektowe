package main.devices;

import main.apps.App;
import main.apps.AppVersion;
import main.creatures.Human;

import java.util.*;

public class Phone extends Device {

    private final ArrayList<AppVersion> installedApps = new ArrayList<>();
    private Human owner;

    public Phone(String producer, String model, int yearOfProduction, Double value) {
        super(model, producer, yearOfProduction, value);
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
        if (owner.getCash() < appName.getPrice()) throw new Exception(owner.getFullName() + " can't afford this app.");

        System.out.println("Choosen app: " + appName.getName() + ". " + "Latest available version: " + appName.getLatestVersion().getVersion());
        install(appName.getLatestVersion());
    }

    public void installApp(App appName, Integer versionToInstall) throws Exception {
        if (owner.getCash() < appName.getPrice()) throw new Exception(owner.getFullName() + "can't afford this app.");

        AppVersion foundVersion = appName.getAppVersions().stream().filter((version) -> version.getVersion() == versionToInstall).findFirst().orElseThrow(() -> new Exception("Not found " + appName.getName() + " in version " + versionToInstall));
        install(foundVersion);
    }


    private void install(AppVersion app) throws Exception {
        installedApps.add(app);
        System.out.println("Installed " + app.getName() + " (version: " + app.getVersion() + ") on device " + this.toString());
    }

    public Human getOwner() {
        return owner;
    }

    public void setOwner(Human owner) {
        this.owner = owner;
    }

    public boolean isInstalled(App app) {
        return this.installedApps.stream().anyMatch(x -> x.getName().equals(app.getName()));
    }

    public boolean isInstalled(String appName) {
        return this.installedApps.stream().anyMatch(x -> x.getName().equals(appName));
    }

    public Double getValueOfInstalledApps() {
        Double sum = 0.0;
        for (AppVersion app : installedApps) sum += app.getPrice();
        return sum;
    }
}
