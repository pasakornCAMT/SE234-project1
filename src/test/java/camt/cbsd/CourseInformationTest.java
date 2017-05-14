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
public class CourseInformationTest {
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
    public void courseInfoTestAsAdmin(){
        driver.get(baseUrl + "/login");
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("admin");
        driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertTrue(isElementPresent(By.cssSelector("button.btn.btn-primary")));
        try {
            assertEquals("#", driver.findElement(By.cssSelector("th")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertTrue(isElementPresent(By.cssSelector("th")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("Couse ID", driver.findElement(By.xpath("//th[2]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertTrue(isElementPresent(By.xpath("//th[2]")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("Course Name", driver.findElement(By.xpath("//th[3]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertTrue(isElementPresent(By.xpath("//th[3]")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("1", driver.findElement(By.cssSelector("td")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertTrue(isElementPresent(By.cssSelector("td")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("953331", driver.findElement(By.xpath("//td[2]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertTrue(isElementPresent(By.xpath("//td[2]")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("CBSD", driver.findElement(By.xpath("//td[3]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertTrue(isElementPresent(By.xpath("//td[3]")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("2", driver.findElement(By.xpath("//tr[2]/td")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertTrue(isElementPresent(By.xpath("//tr[2]/td")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("953323", driver.findElement(By.xpath("//tr[2]/td[2]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertTrue(isElementPresent(By.xpath("//tr[2]/td[2]")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("Software Construction", driver.findElement(By.xpath("//tr[2]/td[3]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertTrue(isElementPresent(By.xpath("//tr[2]/td[3]")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("3", driver.findElement(By.xpath("//tr[3]/td")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertTrue(isElementPresent(By.xpath("//tr[3]/td")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("953499", driver.findElement(By.xpath("//tr[3]/td[2]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertTrue(isElementPresent(By.xpath("//tr[3]/td[2]")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("Software Project", driver.findElement(By.xpath("//tr[3]/td[3]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertTrue(isElementPresent(By.xpath("//tr[3]/td[3]")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }

    }

    @Test
    public void courseInfoTestAsUser(){
        driver.get(baseUrl + "/login");
        driver.findElement(By.id("username")).sendKeys("user");
        driver.findElement(By.id("password")).sendKeys("user");
        driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertTrue(isElementPresent(By.cssSelector("button.btn.btn-primary")));
        try {
            assertEquals("#", driver.findElement(By.cssSelector("th")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertTrue(isElementPresent(By.cssSelector("th")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("Couse ID", driver.findElement(By.xpath("//th[2]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertTrue(isElementPresent(By.xpath("//th[2]")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("Course Name", driver.findElement(By.xpath("//th[3]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertTrue(isElementPresent(By.xpath("//th[3]")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("1", driver.findElement(By.cssSelector("td")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertTrue(isElementPresent(By.cssSelector("td")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("953331", driver.findElement(By.xpath("//td[2]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertTrue(isElementPresent(By.xpath("//td[2]")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("CBSD", driver.findElement(By.xpath("//td[3]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertTrue(isElementPresent(By.xpath("//td[3]")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("2", driver.findElement(By.xpath("//tr[2]/td")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertTrue(isElementPresent(By.xpath("//tr[2]/td")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("953323", driver.findElement(By.xpath("//tr[2]/td[2]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertTrue(isElementPresent(By.xpath("//tr[2]/td[2]")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("Software Construction", driver.findElement(By.xpath("//tr[2]/td[3]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertTrue(isElementPresent(By.xpath("//tr[2]/td[3]")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("3", driver.findElement(By.xpath("//tr[3]/td")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertTrue(isElementPresent(By.xpath("//tr[3]/td")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("953499", driver.findElement(By.xpath("//tr[3]/td[2]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertTrue(isElementPresent(By.xpath("//tr[3]/td[2]")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("Software Project", driver.findElement(By.xpath("//tr[3]/td[3]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertTrue(isElementPresent(By.xpath("//tr[3]/td[3]")));
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
