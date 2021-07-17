package config;

import org.aeonbits.owner.Config;

import static org.aeonbits.owner.Config.LoadType.MERGE;

@Config.LoadPolicy(MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/${stage}.properties"
})

public interface WebConfig extends Config {

    @Key("driver.remote")
    boolean isRemote();

    @Key("driver.browser")
    String getBrowser();

    @Key("driver.version")
    String getVersion();

    @Key("driver.url")
    String getRemoteUrl();

}
