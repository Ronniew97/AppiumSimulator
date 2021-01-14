package test;

import java.io.IOException;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import page.AlarmPage;
import util.AppFactory;

public class AlarmTest {

	AndroidDriver<AndroidElement> driver;
	
	@Test
	public void userShouldBeAbleToSetAlarm() throws IOException{
		driver = AppFactory.launchApp();
		AlarmPage alarm = new AlarmPage(driver);
		alarm.clickAppButton();
		alarm.clickAlarmButton();
		alarm.clickAlarmControllerButton();
		alarm.clickOneShotAlarmButton();
		alarm.takeScreenShotAtTheEndOfTest(driver);
		AppFactory.deleteApp(driver);
	}
	
}
