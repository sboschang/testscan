package selenium_jmeter.selenium_jmeter;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Unit test for simple App.
 */
public class AppTest {
	ChromeDriver driver = null;
	private boolean acceptNextAlert = true;

	@Before
	public void setUp() {
		//StopWatch timer = new StopWatch();
		// Optional, if not specified, WebDriver will search your path for
		// chromedriver.
		System.setProperty("webdriver.chrome.driver", "D:/projects/dev_workspace/selenium/chromedriver.exe");
		//File cache = new File("E:\\Google_Cache\\"+System.currentTimeMillis());
		//cache.mkdirs();
		ChromeOptions options = new ChromeOptions();
		//options.addArguments("user-data-dir="+cache.getAbsolutePath());
		options.addArguments("--no-sandbox");
		options.addArguments("--headless");
		options.addArguments("--disable-dev-shm-usage");
		driver = new ChromeDriver(options);
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@After
	public void tearDown() throws Exception {
		driver.close();
		driver.quit();

	}

	/**
	 * Rigorous Test :-)
	 */
	@Test
	public void test1() {
		//StopWatch timer = new StopWatch();

		//timer.start();
		driver.get("https://smartrobot.scsb.com.tw/?eservice=mainweb");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		}		
		WebElement searchBox = driver.findElement(By.name("ChatMessage"));
		searchBox.sendKeys("你好");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}		
		WebElement btn_send = driver.findElement(By.className("btn_send"));
		btn_send.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}
		List<WebElement> msgs = driver.findElements(By.className("msg"));
		WebElement msg = msgs.get(msgs.size() - 1);
		//timer.stop();
		//System.out.println("times: " + timer.getTime() + " mills. ");
		assertEquals("你好，我是Pukii，祝您有個美好的一天!", msg.getText());
	}
}
