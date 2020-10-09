package pageObjects;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class HomePage {
	AndroidDriver<AndroidElement> driver;

	public HomePage(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

    @AndroidFindBy(id = "org.wikipedia:id/dialog_checkbox")
    private AndroidElement checkBoxElement;
    
    @AndroidFindBy(id = "android:id/button2")
    private AndroidElement dismissElement;
    

	public void navigateTo_HomePage() throws InterruptedException {
		Thread.sleep(8000);
		checkBoxElement.click();
		dismissElement.click();
	}

}