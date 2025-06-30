
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Time;
import java.time.Duration;
import java.util.Set;

public class DataDrivenLogin {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void loginWithCSV() throws Exception {
        driver.get("https://demoqa.com/login");
        BufferedReader reader = new BufferedReader(new FileReader("data.csv"));
        String line = reader.readLine();
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");
            WebElement user = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userName")));
            user.clear();
            user.sendKeys(data[0]);
            WebElement pass = driver.findElement(By.id("password"));
            pass.clear();
            pass.sendKeys(data[1]);
            driver.findElement(By.id("login")).click();
            Thread.sleep(2000);
            driver.get("https://demoqa.com/login");
        }
        reader.close();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
