package util;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;



public class BasePage {

	public void explicitWait(AndroidDriver<?> driver, AndroidElement element, int time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void dragAndDrop(AndroidDriver<?> driver, AndroidElement firstElement, AndroidElement secondElement) {
		TouchAction touch = new TouchAction(driver);
		touch.longPress(element(firstElement)).moveTo(element(secondElement)).release().perform();
	}
	
	public void dragAndDrop(AndroidDriver<?> driver, AndroidElement firstElement, AndroidElement secondElement, 
			long duration) {
		TouchAction touch = new TouchAction(driver);
		touch.longPress(longPressOptions().withElement(element(firstElement)).
				withDuration(ofSeconds(duration))).moveTo(element(secondElement)).release().perform();
	}
}
