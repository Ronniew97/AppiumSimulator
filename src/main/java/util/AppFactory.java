package util;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class AppFactory {
	
	static AndroidDriver<AndroidElement> driver;

	public static AndroidDriver<AndroidElement> launchApp() throws MalformedURLException {
		File f = new File("apps");
		File fs = new File(f, "ApiDemos-debug.apk");
		URL url = new URL("http://127.0.0.1:4723/wd/hub");

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "GalaxyRonnie");
		capabilities.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		capabilities.setCapability(AndroidMobileCapabilityType.SKIP_DEVICE_INITIALIZATION, true);
		capabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);		
		capabilities.setCapability(MobileCapabilityType.SUPPORTS_ALERTS, true);
		driver = new AndroidDriver<AndroidElement>(url, capabilities);
		return driver;
	}
	
	public static void deleteApp(AndroidDriver<?> driver) {
		driver.removeApp("io.appium.android.apis");
	}
	
}
