import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginPageTests extends BaseTests {

    @Test
    public void goToLoginPage() {
        WebDriver currentDriver = driver.getInstance();
        String title = currentDriver.getTitle();

        Assert.assertTrue(title.contains("Вход"));

        currentDriver.findElement(By.cssSelector("*[data-at=at-mailtbx]")).sendKeys("bqa10");
        currentDriver.findElement(By.cssSelector("*[data-at=at-passtbx]")).sendKeys("p");
        currentDriver.findElement(By.cssSelector("*[data-at=at-loginbtn]")).click();

        driver.wait.until(ExpectedConditions.textToBe(By.cssSelector("*[data-at=at-emailtxt]"), "bqa10"));
    }
}
