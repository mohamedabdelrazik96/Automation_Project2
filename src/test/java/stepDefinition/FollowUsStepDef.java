package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.FollowUsPage;

import java.util.ArrayList;

import static pages.FollowUsPage.link_of_Facebook;
import static stepDefinition.Hooks.driver;

public class FollowUsStepDef {
    ArrayList<String> Tab = new ArrayList<>(Hooks.driver.getWindowHandles());
    @Given("user click icon link")
    public void goToLink() throws InterruptedException {
        link_of_Facebook().click();
        Thread.sleep(2000);
       Tab = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(Tab.get(1));
    }

    @And("user go to facebook")
    public void assertUrl(){
        Assert.assertEquals(Hooks.driver.getCurrentUrl(),"https://www.facebook.com/nopCommerce");
    }
    @Then("go to home page")
    public void goToHome() throws InterruptedException {


        Tab = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(Tab.get(0));
        Thread.sleep(3000);
    }
    @Given("user click twitter icon link")
    public void goToTwitter() throws InterruptedException {
       FollowUsPage.link_of_Twitter().click();
        Thread.sleep(3000);
        Tab = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(Tab.get(1));
    }

    @And("user go to twitter")
    public void assertTwitterUrl() throws InterruptedException {
        Assert.assertEquals(Hooks.driver.getCurrentUrl(),"https://twitter.com/nopCommerce");

    }

}
