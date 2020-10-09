package pageObjects;

import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage {
	AndroidDriver<AndroidElement> driver;

	public LoginPage(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id = "org.wikipedia:id/fragment_onboarding_skip_button")
    private AndroidElement skipElement;
    
	@AndroidFindBy(id = "org.wikipedia:id/view_announcement_action_positive")
    private AndroidElement announcementElement;
	
	@AndroidFindBy(id = "org.wikipedia:id/create_account_login_button")
    private AndroidElement loginButtonElement;
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.EditText")
    private AndroidElement userNameElement;
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.EditText")
    private AndroidElement passWordElement;
	
	@AndroidFindBy(id = "org.wikipedia:id/login_button")
    private AndroidElement signInElement;
	
	@AndroidFindBy(id = "org.wikipedia:id/dialog_checkbox")
    private AndroidElement checkBoxElement;
	
	@AndroidFindBy(id = "android:id/button2")
    private AndroidElement dismissElement;
	
	@AndroidFindBy(id = "org.wikipedia:id/menu_icon")
    private AndroidElement menuElement;
	
	@AndroidFindBy(id = "org.wikipedia:id/main_drawer_login_button")
    private AndroidElement logOutElement;
	
	@AndroidFindBy(id = "android:id/button1")
    private AndroidElement logOutOkElement;
	
	
	public void loginSetup() throws Exception {
		skipElement.click();
		Thread.sleep(1000);
		announcementElement.click();
		Thread.sleep(1000);
		loginButtonElement.click();	
	}

	public void enterUserName(String userName) throws Exception {
		userNameElement.sendKeys(userName);
		Thread.sleep(1000);
	}

	public void enterPassword(String password) throws Exception {
		passWordElement.click();
		passWordElement.sendKeys(password);
		Thread.sleep(1000);
	}

	public void clickLoginButton() throws Exception {
		signInElement.click();
		Thread.sleep(2000);
		//checkBoxElement.click();
		//dismissElement.click();
		//Thread.sleep(5000);
	}
	
	public void logOut_from_wiki() throws InterruptedException {
		Thread.sleep(1000);
	    menuElement.click();
	    logOutElement.click();
	    logOutOkElement.click();
	}
}