package pageObjects;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SettingPage {
	AndroidDriver<AndroidElement> driver;

	public SettingPage(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id = "org.wikipedia:id/menu_icon")
	private AndroidElement menuIconElement;
	
	@AndroidFindBy(id = "org.wikipedia:id/main_drawer_settings_container")
	private AndroidElement settingElement;
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.TextView[1]")
	private AndroidElement languageElement;
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[3]/android.widget.ImageView")
	private AndroidElement addLanguageElement;
	
	@AndroidFindBy(accessibility = "Search for a language")
	private AndroidElement searchLanguageElement;
	
	@AndroidFindBy(id = "org.wikipedia:id/search_src_text")
	private AndroidElement inputLanguageElement;
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]")
	private AndroidElement selectLanguageElement;
	
	@AndroidFindBy(accessibility  = "Navigate up")
	private AndroidElement navigateUpElement;
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[6]/android.widget.RelativeLayout/android.widget.TextView[1]")
	private AndroidElement theamElement;
	
	@AndroidFindBy(id = "org.wikipedia:id/button_theme_dark")
	private AndroidElement darkTheamElement;
	
	@AndroidFindBy(accessibility  = "More options")
	private AndroidElement languageMoreElement;
	
	@AndroidFindBy(id = "org.wikipedia:id/title")
	private AndroidElement titleElement;
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[3]/android.widget.CheckBox\")")
	private AndroidElement languageCheckBoxElement;
	
	@AndroidFindBy(accessibility  = "Delete selected items")
	private AndroidElement deleteIteamElement;
	
	@AndroidFindBy(id = "android:id/button1")
	private AndroidElement buttonElement;
	
	@AndroidFindBy(id = "org.wikipedia:id/button_theme_light")
	private AndroidElement lightTheamElement;
	
	public void navigate_to_setting_page() {
		menuIconElement.click();
		settingElement.click();
	}
	
	public void add_language(String language) throws Exception {
		languageElement.click();
		addLanguageElement.click();
		searchLanguageElement.click();
		Thread.sleep(2000);
		inputLanguageElement.sendKeys(language);
		selectLanguageElement.click();
		navigateUpElement.click();
	}
	
	public void change_theam() throws Exception {
		theamElement.click();
		darkTheamElement.click();
		Thread.sleep(1000);
		driver.navigate().back();
		driver.navigate().back();
		Thread.sleep(1000);
		//driver.navigate().back();
	}
	
	public void delete_language() throws Exception {
		Thread.sleep(5000);
		menuIconElement.click();
		settingElement.click();
		languageElement.click();
		languageMoreElement.click(); 	
		titleElement.click();
		languageCheckBoxElement.click();
		deleteIteamElement.click();
		buttonElement.click();
		navigateUpElement.click();
	}
	
	public void revert_theam() throws Exception {
		theamElement.click();
		lightTheamElement.click();
		driver.navigate().back();
		driver.navigate().back();
	}
}
