package test;

import java.net.MalformedURLException;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import page.DragAndDropPage;
import util.AppFactory;

public class DragAndDropTest {

	AndroidDriver<?> driver;
	
	@Test
	public void userShouldBeAbleToDragACircleAndDropIt() throws MalformedURLException {
		driver = AppFactory.launchApp();
		DragAndDropPage dragAndDrop = new DragAndDropPage(driver);
		dragAndDrop.clickViewsButton();
		dragAndDrop.clickDragAndDropButton();
		dragAndDrop.dragElementAndDropIt();
		AppFactory.deleteApp(driver);
	}
}
