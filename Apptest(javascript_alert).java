package com.example;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.nio.file.Files;
import java.time.Duration;
import java.io.IOException;
// import org.testng.Assert;
import org.testng.annotations.AfterTest;
public class AppTest {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;
    JavascriptExecutor js;


  @BeforeTest
  public void beforeTest() {
 WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        actions = new Actions(driver);
        js = (JavascriptExecutor) driver;

  }


@Test
public void loginTest() throws InterruptedException, IOException {
    WebDriver driver = new ChromeDriver();
  driver.manage().window().maximize();

    driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    Thread.sleep(2000);
   driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
   Alert alert = driver.switchTo().alert();
   System.out.println(alert.getText());
   Thread.sleep(2000);
   alert.accept();
   System.out.println("Alert accepted");
   Thread.sleep(2000);

   driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
   Alert confirm = driver.switchTo().alert();
   System.out.println(confirm.getText());
   Thread.sleep(2000);
   confirm.accept();
   System.out.println("Confirm accepted");
   Thread.sleep(2000);

  driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
   Alert prompt = driver.switchTo().alert();
   System.out.println(prompt.getText());
   Thread.sleep(2000);
   prompt.sendKeys("Hello");
   Thread.sleep(2000);
   prompt.accept();
   System.out.println("prompt accepted");
   Thread.sleep(2000);


}

@AfterTest
public void afterTest() {
  driver.quit();
}

}