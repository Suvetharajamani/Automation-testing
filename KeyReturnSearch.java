

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Time;
import java.time.Duration;
import java.util.Set;

public class KeyReturnSearch {
    WebDriver driver;

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void searchGoogle() throws InterruptedException {
        driver.get("https://www.google.com");
        WebElement search = driver.findElement(By.name("q"));
        search.sendKeys("Java", Keys.RETURN);
        Thread.sleep(3000);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}