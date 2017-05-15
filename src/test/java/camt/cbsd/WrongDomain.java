package camt.cbsd;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by PASAKORN on 15/5/2560.
 */
public class WrongDomain {
    private WebDriver driver;
    private String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver",
                this.getClass().getClassLoader().getResource("").getPath() + "/chromedriver.exe");
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        baseUrl = "http://localhost:4200";
    }

    @Test
    public void wrongDomainTest(){
        driver.get(baseUrl + "/logins");
        assertEquals("The resource you have asked is not in the server", driver.findElement(By.cssSelector("h2")).getText());
        assertTrue(isElementPresent(By.cssSelector("h2")));
        try {
            assertEquals("", driver.findElement(By.cssSelector("img")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertTrue(isElementPresent(By.cssSelector("img")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }

    }
    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
