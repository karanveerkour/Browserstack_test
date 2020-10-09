package pageObjects;


import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
//import junit.framework.Assert;
//import org.junit.Assert;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ListPage {
	AndroidDriver<AndroidElement> driver;

	public ListPage(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id = "org.wikipedia:id/text_input")
	private AndroidElement list1NameElement;

	@AndroidFindBy(id = "org.wikipedia:id/secondary_text_input")
	private AndroidElement list1DescElement;

	@AndroidFindBy(id = "android:id/button1")
	private AndroidElement list1OkElement;

	@AndroidFindBy(accessibility  = "My lists")
	private AndroidElement listElement;

	@AndroidFindBy(id = "org.wikipedia:id/view_onboarding_action_negative")
	private AndroidElement listLandingElement;

	@AndroidFindBy(accessibility  = "More options")
	private AndroidElement listMoreElement;

	@AndroidFindBy(id = "org.wikipedia:id/reading_lists_overflow_create_new_list")
	private AndroidElement createList1Element;

	@AndroidFindBy(accessibility  = "Add this article to a reading list")
	private AndroidElement addListElement;

	@AndroidFindBy(id = "org.wikipedia:id/onboarding_button")
	private AndroidElement addListConfirmElement;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.TextView[1]")
	private AndroidElement gotItElement;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ImageView")
	private AndroidElement crateList2Element;

	@AndroidFindBy(id = "org.wikipedia:id/page_action_overflow_feed")
	private AndroidElement moreExploreElement;

	@AndroidFindBy(id = "org.wikipedia:id/page_list_item_title")
	private AndroidElement list1IteamElement;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.TextView[1]")
	private AndroidElement savedList1Element;

	@AndroidFindBy(accessibility  = "Navigate up")
	private AndroidElement navigateUpElement;

	@AndroidFindBy(xpath  = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[4]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView")
	private AndroidElement list1DeleteElement;

	public void add_page_to_list(String listName, String listDescription) throws InterruptedException {
		list1NameElement.sendKeys(listName);
		list1DescElement.sendKeys(listDescription);
		Thread.sleep(1000);
		list1OkElement.click();		
		Thread.sleep(1000);
	}
	
	public void create_list_from_homePage(String listName, String listDescription) throws InterruptedException {
		Thread.sleep(2000);
		listElement.click();
	   // AndroidElement assertElement = (AndroidElement) driver.findElementById("org.wikipedia:id/empty_title");
	   // Assert.assertEquals(assertElement.getText(),"No saved pages yet");
		//listLandingElement.click();
		//Thread.sleep(1000);
		listMoreElement.click();
		Thread.sleep(1000);
		createList1Element.click();
		Thread.sleep(1000);
		add_page_to_list(listName,listDescription);
	}

	public void add_page_to_list1() throws InterruptedException {
		addListElement.click();
		Thread.sleep(1000);
		addListConfirmElement.click();
		Thread.sleep(1000);
		gotItElement.click();
	}

	public void navigate_to_list_landing_page() throws InterruptedException {
		//Thread.sleep(1000);
		AndroidElement listLandingElement = (AndroidElement) driver.findElementByXPath("//android.widget.FrameLayout[@content-desc=\"My lists\"]/android.widget.ImageView");
		listLandingElement.click();
		Thread.sleep(1000);
		
	}
	public void add_page_to_list2(String listName, String listDescription) throws InterruptedException {
		AndroidElement emulatorListElement = (AndroidElement) driver.findElementByXPath("//android.view.View[@content-desc=\"LaserJet\"]/android.widget.TextView");
		emulatorListElement.click();
		Thread.sleep(1000);
		crateList2Element.click();
		Thread.sleep(1000);
		add_page_to_list(listName,listDescription);
		driver.navigate().back();
		AndroidElement el26 = (AndroidElement) driver.findElementByAccessibilityId("More options");
		el26.click();
		AndroidElement el27 = (AndroidElement) driver.findElementById("org.wikipedia:id/page_action_overflow_feed");
		el27.click();
	}
	

	public void delete_list1() throws InterruptedException {
		savedList1Element.click();
		Thread.sleep(1000);
		list1IteamElement.click();
		//Assert.assertEquals(list1IteamElement.getText(), "BrowserStack");
		Thread.sleep(1000);
		navigateUpElement.click();
		Thread.sleep(1000);
		listMoreElement.click();
		Thread.sleep(1000);
		list1DeleteElement.click();
		Thread.sleep(1000);    
		list1OkElement.click();
		Thread.sleep(1000);  
	}

	public void delete_list2() throws InterruptedException {
		savedList1Element.click();
		Thread.sleep(1000);    
		//Assert.assertEquals(list1IteamElement.getText(), "Emulator");
		listMoreElement.click();
		Thread.sleep(1000);
		list1DeleteElement.click();
		Thread.sleep(1000);
		list1OkElement.click();
		Thread.sleep(1000); 
	}

	public void delete_list() throws InterruptedException {
		
		//listMoreElement.click();
		//Thread.sleep(1000);
		//moreExploreElement.click();
		//Thread.sleep(1000);
		//AndroidElement historyElement = (AndroidElement) driver.findElementByXPath("//android.widget.FrameLayout[@content-desc=\"History\"]/android.widget.ImageView");
		//historyElement.click();
	//	AndroidElement checkListElement = (AndroidElement) driver.findElementByXPath("//android.widget.FrameLayout[@content-desc=\"My lists\"]/android.widget.ImageView");
	//	checkListElement.click();
		//Thread.sleep(1000);
		delete_list1();
		delete_list2(); 
	}
}
