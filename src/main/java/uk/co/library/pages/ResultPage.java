package uk.co.library.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import uk.co.library.browserfactory.ManageBrowser;
import uk.co.library.utility.Utility;


public class ResultPage extends Utility {
    private static final Logger log = LogManager.getLogger(HomePage.class.getName());

    public ResultPage() {
        PageFactory.initElements(ManageBrowser.driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//h1[@class='search-header__title']")
    WebElement resultText;


    public void verifyTheResults(String expected) {
        String actualText = getTextFromElement(resultText);
        String expectedText = expected;
        Assert.assertEquals(actualText, expectedText, "Verify Results Title");
        log.info("verify the result:"+ resultText.toString());
        // Reporter.log("Verify result title" + resultText.toString() + "<br>");
    }
}
