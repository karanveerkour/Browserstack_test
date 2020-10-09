package stepDefinitions;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
//import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pageObjects.HomePage;
import pageObjects.ListPage;
import pageObjects.LoginPage;
import pageObjects.SearchPage;
import pageObjects.SettingPage;

public class StepsForWikiTest {
	// AndroidDriver<AndroidElement> driver;
	WebDriver driver;
	HomePage home;
	LoginPage loginPage;
	ListPage listPage;
	SearchPage searchPage;
	SettingPage settingPage;
	DesiredCapabilities caps;
	public static String BrowserStackUserName = "karanvirkour1";
	public static String accessKey = "enter access key here";
	static int scenarioIndex = 1;

	@Before
	public void setUp() throws Exception {

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("browserName", "android");
		caps.setCapability("device", "Samsung Galaxy S8");
		caps.setCapability("realMobile", "true");
		caps.setCapability("os_version", "7.0");
		caps.setCapability("name", "Android Device Browser Test");
		// caps.setCapability("browserstack.local", "true");
		caps.setCapability("browserstack.debug", "true");
		caps.setCapability("browserstack.console", "info");
		caps.setCapability("acceptSslCerts", "true");

		driver = new RemoteWebDriver(
				new URL("http://" + BrowserStackUserName + ":" + accessKey + "@hub-cloud.browserstack.com/wd/hub"),
				caps);
		driver.get("https://qa-nationalgridqa.cs165.force.com");
		Thread.sleep(5000);

		Thread.sleep(5000);
		System.out.println(driver.getTitle());
		driver.quit();
		// stop the Local instance
		// bsLocal.stop();
		System.out.println("Test Completed");

		scenarioIndex = scenarioIndex + 1;
	}

	@Given("^user is on Login page$")
	public void user_is_on_Login_page() throws Throwable {
		// driver = new AndroidDriver<AndroidElement>(new
		// URL("https://"+BrowserStackUserName+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub"),
		// caps);
		// loginPage = new LoginPage(driver);
		loginPage.loginSetup();
	}

	@When("^The username is entered as \"([^\"]*)\"$")
	public void the_username_is_entered_as(String userName) throws Throwable {
		loginPage.enterUserName(userName);
	}

	@And("^The password is entered as \"([^\"]*)\"$")
	public void the_password_is_entered_as(String password) throws Throwable {
		loginPage.enterPassword(password);
	}

	@And("^The login button is clicked$")
	public void the_login_button_is_clicked() throws Throwable {
		loginPage.clickLoginButton();
	}

	@When("^I create \"([^\"]*)\" from landing page for \"([^\"]*)\"$")
	public void i_create_from_landing_page_for(String listName, String listDescription) throws Throwable {
		// listPage = new ListPage(driver);
		listPage.create_list_from_homePage(listName, listDescription);
	}

	@Then("^I Search for BrowserStack page$")
	public void i_Search_for_BrowserStack_page() throws Throwable {
		// searchPage = new SearchPage(driver);
		searchPage.perform_Search();
	}

	@And("^I am able to add page to list$")
	public void i_am_able_to_add_page_to_list() throws Throwable {
		listPage.add_page_to_list1();
	}

	@And("^I am able to click on Emulator link from searched page$")
	public void i_am_able_to_click_on_Emulator_link_from_searched_page() throws Throwable {
		searchPage.check_link_on_page();
	}

	@And("^I am able to create \"([^\"]*)\" from searched page for \"([^\"]*)\"$")
	public void i_am_able_to_create_list_from_searched_page_for(String listName, String listDescription)
			throws Throwable {
		listPage.add_page_to_list2(listName, listDescription);
	}

	/*
	 * @Then("^I logout from Wikipedia|$") public void i_logout_from_Wikipedia()
	 * throws Throwable { loginPage.logOut_from_wiki(); }
	 */

	@When("^I go to saved list landing page$")
	public void i_go_to_saved_list_landing_page() throws Throwable {
		// listPage = new ListPage(driver);
		listPage.navigate_to_list_landing_page();
	}

	@Then("^I am able to delete saved list$")
	public void i_am_able_to_delete_saved_list() throws Throwable {
		listPage.delete_list();
	}

	@When("^I go to setting page$")
	public void i_go_to_setting_page() throws Throwable {
		// settingPage = new SettingPage(driver);
		settingPage.navigate_to_setting_page();
	}

	@Then("^I am able to add \"([^\"]*)\" language$")
	public void i_am_able_to_add_language(String language) throws Throwable {
		settingPage.add_language(language);

	}

	@And("^I am able to change Wikipedia theme$")
	public void i_am_able_to_change_Wikipedia_theam() throws Throwable {
		settingPage.change_theam();
	}

	@And("^I am able to delete language$")
	public void i_am_able_to_delete_language() throws Throwable {
		settingPage.delete_language();

	}

	@And("^I am able to revert theam from setting$")
	public void i_am_able_to_revert_theam_from_setting() throws Throwable {
		settingPage.revert_theam();

	}

	@Then("^Load Google\\.com on browser$")
	public void load_Google_com_on_browser() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

	}

	@Given("^Load Chrome Browser in Browser Stack$")
	public void load_Chrome_Browser_in_Browser_Stack() throws Throwable {

		// Write code here that turns the phrase above into concrete actions

	}

}
/*
 * @After public void i_logout_from_Wikipedia() throws Throwable {
 * loginPage.logOut_from_wiki(); driver.quit(); }
 */
