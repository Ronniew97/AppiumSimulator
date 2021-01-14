package page;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import util.BasePage;

public class AlarmPage extends BasePage {
	
	AndroidDriver<AndroidElement> driver;

	public AlarmPage(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
	}

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='android:id/message']")
	AndroidElement ALERT_MESSAGE;
	@AndroidFindBy(xpath = "//android.widget.Button[@text='OK']") AndroidElement OK_ALERT_BUTTON;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='App']") AndroidElement APP_BUTTON;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Alarm']") AndroidElement ALARM_BUTTON;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Alarm Controller']") AndroidElement ALARM_CONTROLLER_BUTTON;
	@AndroidFindBy(xpath = "//android.widget.Button[@text='One Shot Alarm']") AndroidElement ONE_SHOT_ALARM_BUTTON;

	public void clickOkButtonForAlert() {
		if (ALERT_MESSAGE.isDisplayed()) {
			OK_ALERT_BUTTON.click();
		}
	}
	
	public void clickAppButton() {
		clickOkButtonForAlert();
		explicitWait(driver, APP_BUTTON, 10);
		APP_BUTTON.click();
	}

	public void clickAlarmButton() {
		ALARM_BUTTON.click();
	}

	public void clickAlarmControllerButton() {
		ALARM_CONTROLLER_BUTTON.click();
	}

	public void clickOneShotAlarmButton() {
		ONE_SHOT_ALARM_BUTTON.click();
	}

	public void takeScreenShotAtTheEndOfTest(AndroidDriver<?> driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) (driver);
		File SourceFile = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(SourceFile, new File("screenshots//" + "alarmtest" + System.currentTimeMillis() + ".png"));
	}

}
