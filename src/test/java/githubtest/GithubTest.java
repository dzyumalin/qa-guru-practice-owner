package githubtest;

import com.codeborne.selenide.Configuration;
import config.WebConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class GithubTest {

    WebConfig config = ConfigFactory
            .create(WebConfig.class, System.getProperties());

    @Test
    public void findGithub() {
        Configuration.browser = config.getBrowser();
        Configuration.browserVersion = config.getVersion();

        if(config.isRemote()) {
            Configuration.remote = config.getRemoteUrl();
        }
        open("https://github.com");
    }

}
