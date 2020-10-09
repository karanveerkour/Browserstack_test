package pageObjects;

import org.openqa.selenium.support.PageFactory;
import java.util.List;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SearchPage {
	AndroidDriver<AndroidElement> driver;

	public SearchPage(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	//@AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc=\\\"Explore\\\"]/android.widget.ImageView")
	//private AndroidElement exploreListElement;

	@AndroidFindBy(accessibility  = "Search Wikipedia")
	private AndroidElement searchElement;

	@AndroidFindBy(id  = "org.wikipedia:id/search_src_text")
	private AndroidElement insertTextElement;

	@AndroidFindAll({@AndroidBy(className = "android.widget.TextView")})
	 private List<AndroidElement> allProductsName;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView/android.view.ViewGroup[1]/android.widget.TextView[1]")
	private AndroidElement browserStackSearchElement;

	//@AndroidFindBy(xpath = "//android.view.View[@content-desc=\\\"emulators\\\"]/android.widget.TextView")
	//private AndroidElement emulatorLinkElement;

	@AndroidFindBy(id  = "org.wikipedia:id/link_preview_primary_button")
	private AndroidElement primaryButtonElement;


	public void perform_Search() throws InterruptedException {
		AndroidElement exploreListElement = (AndroidElement) driver.findElementByXPath("//android.widget.FrameLayout[@content-desc=\"Explore\"]/android.widget.ImageView");
		exploreListElement.click();
		searchElement.click();
		insertTextElement.sendKeys("BrowserStack");
		Thread.sleep(5000);
		assert(allProductsName.size() > 0);
		browserStackSearchElement.click();
		Thread.sleep(5000);
	}

	public void check_link_on_page() throws InterruptedException {
		AndroidElement emulatorLinkElement = (AndroidElement) driver.findElementByXPath("//android.view.View[@content-desc=\"emulators\"]/android.widget.TextView");
		emulatorLinkElement.click();
		Thread.sleep(1000);
		primaryButtonElement.click();
	}
}