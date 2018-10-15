package selenium_jmeter.selenium_jmeter;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * Unit test for simple App.
 */
public class ScsbAppTest2 {
	RemoteWebDriver driver = null;

	@Before
	public void setUp() throws MalformedURLException {
		DesiredCapabilities caps = DesiredCapabilities.chrome();
		caps.setBrowserName("chrome");
		caps.setVersion("ANY");
		caps.setPlatform(Platform.ANY);
		// caps.setCapability("maxInstances", 15);
		// caps.setCapability("headless", true);
		// caps.setCapability("disable-dev-shm-usage", true);
		// caps.setCapability("no-sandbox", true);

		driver = new RemoteWebDriver(new URL("http://10.1.3.250:4444/wd/hub"), caps);
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@After
	public void tearDown() throws Exception {
		// driver.close();
		driver.quit();

	}

	/**
	 * Rigorous Test :-)
	 */
	@Test
	public void test2() {
		// StopWatch timer = new StopWatch();

		// timer.start();
		driver.get("https://smartrobot.scsb.com.tw/?eservice=mainweb");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}
		WebElement searchBox = driver.findElement(By.name("ChatMessage"));
		searchBox.sendKeys("你好");
		try {
			Thread.sleep(1000);
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
		// timer.stop();
		// System.out.println("times: " + timer.getTime() + " mills. ");
		assertEquals("你好，我是Pukii，祝您有個美好的一天!", msg.getText());
	}
}
