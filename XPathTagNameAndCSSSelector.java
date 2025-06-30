public class XPathTagNameAndCSSSelector {
    WebDriver driver;

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void byTagAndCSS() throws InterruptedException {
        driver.get("https://demoqa.com/automation-practice-form");
        WebElement tagNameElement = driver.findElement(By.tagName("input"));
        WebElement cssSelectorElement = driver.findElement(By.cssSelector("input[id='userEmail']"));
        tagNameElement.sendKeys("Using TagName");
        Thread.sleep(1000);
        cssSelectorElement.sendKeys("css@example.com");
        Thread.sleep(2000);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}