package config;

import org.aeonbits.owner.ConfigFactory;

public class ConfigHelper {
    public static String getBaseUrl() {
        return getRemoteConfig().webBaseUrl();
    }

    public static String getRemoteDriver() {
        // https://%s:%s@selenoid.autotests.cloud/wd/hub/
        return String.format(System.getProperty("web.remote.driver"),
                getRemoteConfig().selenoidDriverUser(),
                getRemoteConfig().selenoidDriverPassword());
    }

    public static boolean isRemoteWebDriver() {
        return System.getProperty("web.remote.driver") != null;
    }

    public static String getWebVideoStorage() {
        return System.getProperty("video.storage");
    }

    public static boolean isVideoOn() {
        return getWebVideoStorage() != null;
    }

    private static RemoteConfig getRemoteConfig() {
        return ConfigFactory.newInstance().create(RemoteConfig.class, System.getProperties());
    }
}

