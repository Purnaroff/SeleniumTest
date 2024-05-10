import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class AddNewUser {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://shop.pragmatic.bg/admin/");
    }

//    @AfterMethod
//    public void tearDown() {
//        driver.quit();
//    }

    @Test
    public void userTest() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement username = driver.findElement(By.id("input-username"));
        username.sendKeys("admin");
        WebElement password = driver.findElement(By.id("input-password"));
        password.sendKeys("parola123!");
        WebElement loginButton = driver.findElement(By.xpath(".//*[@class='btn btn-primary']"));
        loginButton.click();
        WebElement customersDropdown = driver.findElement(By.xpath(".//*[@class='fa fa-user fw']"));
        customersDropdown.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@id='menu-customer']//li[1]/a")));
        WebElement customersOption = driver.findElement(By.xpath("//li[@id='menu-customer']//li[1]/a"));
        customersOption.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@class='fa fa-plus']/ ..")));
        WebElement addButton = driver.findElement(By.xpath(".//*[@class='fa fa-plus']/ .."));
        addButton.click();
        driver.findElement(By.id("input-firstname")).sendKeys("Ivan");
        driver.findElement(By.id("input-lastname")).sendKeys("Purnarov");
        String emailPrefix = RandomStringUtils.randomAlphabetic(7);
        String emailSuffix = RandomStringUtils.randomAlphabetic(5);
        String emailAddress = emailPrefix + "@" + emailSuffix + ".com";
        WebElement emailInputField = driver.findElement(By.id("input-email"));
        emailInputField.sendKeys(emailAddress);
        String gsm = RandomStringUtils.randomNumeric(10);
        WebElement gsmField = driver.findElement(By.id("input-telephone"));
        gsmField.sendKeys(gsm);
        WebElement passwordUser = driver.findElement(By.id("input-password"));
        passwordUser.sendKeys("1234567");
        WebElement passwordConfirm = driver.findElement(By.id("input-confirm"));
        passwordConfirm.sendKeys("1234567");

    }
}
