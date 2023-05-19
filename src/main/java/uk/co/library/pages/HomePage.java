package uk.co.library.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import uk.co.library.utility.Utility;


public class HomePage extends Utility {
    private static final Logger log = LogManager.getLogger(HomePage.class.getName());
    public HomePage(){
        PageFactory.initElements(driver,this);
    }


    @CacheLookup
    @FindBy(id = "keywords")
    WebElement jobTitleField;

    @CacheLookup
    @FindBy(xpath = "//input[@id='location']")
    WebElement locationField;

    @CacheLookup
    @FindBy(id = "distance")
    WebElement distanceDropDown;

    @CacheLookup
    @FindBy(xpath = "//button[@id='toggle-hp-search']")
    WebElement moreSearchOptionLink;

    @CacheLookup
    @FindBy(xpath = "//input[@id='salarymin']")
    WebElement salaryMin;

    @CacheLookup
    @FindBy(xpath = "//input[@id='salarymax']")
    WebElement salaryMax;

    @CacheLookup
    @FindBy(xpath = "//select[@id='salarytype']")
    WebElement salaryTypeDropDown;

    @CacheLookup
    @FindBy(id = "tempperm")
    WebElement jobTypeDropDown;

    @CacheLookup
    @FindBy(id = "hp-search-btn")
    WebElement findJobButton;

    @FindBy(id ="gdpr-consent-notice")
    WebElement iframe;

    @FindBy(xpath = "//button[@id='save']")
    WebElement acceptCookies;
    public void acceptCookies(){
        switchToIframe(iframe);
        clickOnElement(acceptCookies);
        driver.switchTo().defaultContent();
        log.info("Acceptcookies:"+acceptCookies.toString());
    }

    public void enterJobTitle(String jobTitle) {
        //Reporter.log("Enter job title " + jobTitleField.toString() + "<br>");
        log.info("Enter Job tilte:"+ jobTitleField.toString());
        sendTextToElement(jobTitleField, jobTitle);
    }

    public void enterLocation(String location) {
        //Reporter.log("Enter location " + jobTitleField.toString() + "<br>");
        log.info("EnterLocation:"+ locationField.toString());
        sendTextToElement(locationField, location);

    }

    public void selectDistance(String distance) {
        //Reporter.log("Enter distance " + distanceDropDown.toString() + "<br>");
        log.info("Select Distance:"+ distanceDropDown.toString());
        selectByVisibleTextFromDropDown(distanceDropDown,distance);
    }
    public void MoreSearchOptionLink(){
        //Reporter.log("Click on more option link " + moreSearchOptionLink.toString() + "<br>");
        log.info("More search optional link:"+ moreSearchOptionLink.toString());
        clickOnElement(moreSearchOptionLink);

    }
    public void enterMinSalary(String minSalary){
        //Reporter.log("Enter min salary" + salaryMin.toString() + "<br>");
        log.info("Enter min salary:"+ minSalary.toString());
        sendTextToElement(salaryMin,minSalary);

    }
    public void enterMaxSalary(String maxSalary){
        //Reporter.log("Enter salary max " + salaryMax.toString() + "<br>");
        log.info("Enter max salary:"+ maxSalary.toString());
        sendTextToElement(salaryMax,maxSalary);
    }
    public void selectSalaryType(String sType){
        //Reporter.log("Select salary type" + salaryTypeDropDown.toString() + "<br>");
        log.info("Select salary type:"+ salaryTypeDropDown.toString());
        selectByVisibleTextFromDropDown(salaryTypeDropDown,sType);
    }
    public void selectJobType(String jobType){
       // Reporter.log("Select job type " + jobTypeDropDown.toString() + "<br>");
        log.info("select job type:"+ jobType.toString());
        selectByVisibleTextFromDropDown(jobTypeDropDown,jobType);

    }
    public void clickOnFindJobsButton(){
       // Reporter.log("Finds jobs button " + findJobButton.toString() + "<br>");
        log.info("find job button:"+ findJobButton.toString());
        clickOnElement(findJobButton);

    }
}
