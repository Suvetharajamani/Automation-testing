public class SwitchToNewTab {
    WebDriver driver;

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void switchTabs() throws InterruptedException {
        driver.get("https://demoqa.com/browser-windows");

        String mainWindow = driver.getWindowHandle();
        driver.findElement(By.id("tabButton")).click();

        Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
            if (!window.equals(mainWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }

        Thread.sleep(2000);
        driver.switchTo().window(mainWindow);
        Thread.sleep(2000);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
