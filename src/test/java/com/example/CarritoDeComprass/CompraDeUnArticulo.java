package com.example.CarritoDeComprass;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class CompraDeUnArticulo {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  JavascriptExecutor js;
  @Before
  public void setUp() throws Exception {
	File file = new File("../KR-exported-java-junit-maven-project/chromedriver2.exe");
    System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
    driver = new ChromeDriver();
    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    js = (JavascriptExecutor) driver;
  }

  @Test
  public void testCompraDeUnArticulo() throws Exception {
    driver.get("http://automationpractice.com/index.php?id_category=3&controller=category");
    driver.findElement(By.linkText("Sign in")).click();
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("camilaandreamontenegrotapias@gmail.com");
    driver.findElement(By.id("passwd")).click();
    driver.findElement(By.id("passwd")).clear();
    driver.findElement(By.id("passwd")).sendKeys("12345");
    driver.findElement(By.xpath("//button[@id='SubmitLogin']/span")).click();
    driver.findElement(By.linkText("Women")).click();
    driver.findElement(By.xpath("//div[@id='center_column']/ul/li/div/div[2]/div[2]/a/span")).click();
    driver.findElement(By.xpath("//div[@id='layer_cart']/div/div[2]/div[4]/a/span")).click();
    driver.findElement(By.xpath("//div[@id='center_column']/p[2]/a/span")).click();
    driver.findElement(By.xpath("//div[@id='center_column']/form/p/button/span")).click();
    driver.findElement(By.id("cgv")).click();
    driver.findElement(By.xpath("//form[@id='form']/p/button/span")).click();
    driver.findElement(By.linkText("Pay by check (order processing will be longer)")).click();
    driver.findElement(By.xpath("//p[@id='cart_navigation']/button/span")).click();
    driver.findElement(By.xpath("//div[@id='center_column']/p")).click();
    try {
      assertEquals("Your order on My Store is complete.", driver.findElement(By.xpath("//div[@id='center_column']/p")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
  }
 

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
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

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
