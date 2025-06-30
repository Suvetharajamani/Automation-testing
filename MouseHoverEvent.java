public class MouseHoverEvent {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void hoverUsingXPathAndEC() throws InterruptedException {
        driver.get("https://demoqa.com/menu");

        Actions action = new Actions(driver);

        WebElement mainItem2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Main Item 2']")));
        action.moveToElement(mainItem2).perform();
        Thread.sleep(1000);

        WebElement subSubList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='SUB SUB LIST »']")));
        action.moveToElement(subSubList).perform();
        Thread.sleep(1000);

        WebElement subSubItem2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Sub Sub Item 2']")));
        action.moveToElement(subSubItem2).perform();
        Thread.sleep(1000);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
