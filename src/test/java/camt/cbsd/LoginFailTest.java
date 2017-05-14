package camt.cbsd;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertEquals;

/**
 * Created by PASAKORN on 14/5/2560.
 */
public class LoginFailTest {
    private WebDriver driver;
    private String baseUrl;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver",
                this.getClass().getClassLoader().getResource("").getPath() + "/chromedriver.exe");
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        baseUrl = "http://localhost:4200";
    }

    @Test
    public void notMatched(){
        driver.get(baseUrl + "/login");
        driver.findElement(By.id("username")).sendKeys("asd");
        driver.findElement(By.id("password")).sendKeys("asd");
        driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals("Unauthorized", driver.findElement(By.cssSelector("div.alert.alert-error")).getText());
    }

    @Test
    public void usernameEmpty(){
        driver.get(baseUrl + "/login");
        driver.findElement(By.id("password")).sendKeys("admin");
        driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
        assertEquals("Username is required", driver.findElement(By.cssSelector("span.help-block")).getText());

    }

    @Test
    public void passwordEmpty(){
        driver.get(baseUrl + "/login");
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
        assertEquals("Password is required", driver.findElement(By.cssSelector("span.help-block")).getText());

    }

    @Test
    public void usernameAndPasswordEmpty(){
        driver.get(baseUrl + "/login");
        driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
        assertEquals("Username is required", driver.findElement(By.cssSelector("span.help-block")).getText());
        assertEquals("Password is required", driver.findElement(By.xpath("//div[2]/span")).getText());

    }

}
