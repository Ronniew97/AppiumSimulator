package page;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import util.BasePage;

public class DragAndDropPage extends BasePage {

	AndroidDriver<?> driver;

	public DragAndDropPage(AndroidDriver<?> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
	}

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='android:id/message']")
	AndroidElement ALERT_MESSAGE;
	@AndroidFindBy(uiAutomator = "text(\"OK\")") AndroidElement OK_ALERT_BUTTON;
	@AndroidFindBy(uiAutomator = "text(\"Views\")") AndroidElement VIEWS_BUTTON;
	@AndroidFindBy(uiAutomator = "text(\"Drag and Drop\")") AndroidElement DRAG_AND_DROP_BUTTON;
	@AndroidFindBy(xpath = "//android.view.View[@index='4']") AndroidElement CIRCLE_POSITION_1;
	@AndroidFindBy(xpath = "//android.view.View[@index='2']") AndroidElement CIRCLE_POSITION_2;

	public void clickOkForAlert() {
		if (ALERT_MESSAGE.isDisplayed()) {
			OK_ALERT_BUTTON.click();
		}
	}

	public void clickViewsButton() {
		clickOkForAlert();
		explicitWait(driver, VIEWS_BUTTON, 3);
		VIEWS_BUTTON.click();
	}

	public void clickDragAndDropButton() {
		DRAG_AND_DROP_BUTTON.click();
	}
	
	public void dragElementAndDropIt() {
		dragAndDrop(driver,CIRCLE_POSITION_1, CIRCLE_POSITION_2);
	}
}
