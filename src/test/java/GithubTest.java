import com.codeborne.selenide.Configuration;
import config.WebConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.byName;

public class GithubTest {

    WebConfig config = ConfigFactory
            .create(WebConfig.class, System.getProperties());

    @Test
    public void findGithubRepository() {
        Configuration.browser = config.getBrowser();
        Configuration.browserVersion = config.getVersion();

        if(config.isRemote()) {
            Configuration.remote = config.getRemoteUrl();
        }
        open(TestData.BASE_URL);
        $(byName("q")).val(TestData.GITHUB_PROFILE).pressEnter();
        $$("ul.repo-list li").first().$("a").click();
        $("h1").shouldHave(text(TestData.REPOSITORY));
        sleep(7000);
    }

}
