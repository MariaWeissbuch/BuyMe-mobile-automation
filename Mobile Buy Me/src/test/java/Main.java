import com.aventstack.extentreports.Status;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.URL;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Main {

    private static AndroidDriver<MobileElement> driver;
    private static ReportsHandler reports = new ReportsHandler();
    private static int elementVisibilityTimeout;

    @BeforeClass
    public static void SetUp() throws IOException, ParserConfigurationException, SAXException
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        String platformNameFromXml = XMLHandler.getData("platformName");
        String deviceNameFromXml = XMLHandler.getData("deviceName");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platformNameFromXml);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceNameFromXml);

        // the app and entry point
        String appActivityFromXml = XMLHandler.getData("appActivity");
        String appPackageFromXml = XMLHandler.getData("appPackage");
        capabilities.setCapability("appPackage", appPackageFromXml);
        capabilities.setCapability("appActivity", appActivityFromXml);

        int timeoutFromXml = Integer.parseInt(XMLHandler.getData("appiumTimeout"));
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, timeoutFromXml);

        elementVisibilityTimeout = Integer.parseInt(XMLHandler.getData("elementVisibilityTimeout"));

        // init driver and set timeout
        String appiumUrl = XMLHandler.getData("appiumUrl");
        driver = new AndroidDriver(new URL(appiumUrl), capabilities);

        // initialize reporting module
        reports.InitializeReporting();

    }

    @Test
    public void Test01_loginScreen() throws IOException
    {
        LoginScreen login = new LoginScreen(driver, elementVisibilityTimeout);
        login.ClickLoginButton();

        reports.CreateScreenShot(driver);
        reports.Log(Status.PASS, "Clicking login button");
    }

    @Test
    public void Test02_loginOptions() throws IOException
    {
        //Google Log in screen 2
        LoginOptionsScreen loginOptions = new LoginOptionsScreen(driver, elementVisibilityTimeout);
        loginOptions.SelectGoogleAccountLogin();

        reports.CreateScreenShot(driver);
        reports.Log(Status.PASS, "Selecting google account for login");
    }

    @Test
    public void Test03_categoryScreen() throws IOException
    {
        //Chose a category screen 3
        ChooseCategoryScreen categoryScreen = new ChooseCategoryScreen(driver, elementVisibilityTimeout);
        categoryScreen.ChooseCategory();

        reports.CreateScreenShot(driver);
        reports.Log(Status.PASS, "Selecting category");
    }

    @Test
    public void Test04_chooseBusinessScreen() throws IOException
    {
        // Chose a business screen 4
        ChooseBusinessScreen chooseBusiness = new ChooseBusinessScreen(driver, elementVisibilityTimeout);
        chooseBusiness.SelectBusiness();

        reports.CreateScreenShot(driver);
        reports.Log(Status.PASS, "Selecting business");
    }

    @Test
    public void Test05_purchaseScreen() throws IOException
    {
        //Enter sum screen 5
        PurchaseScreen purchase = new PurchaseScreen(driver, elementVisibilityTimeout);
        purchase.EnterSum();

        reports.CreateScreenShot(driver);
        reports.Log(Status.PASS, "Entered gift amount");

        //Press purchase
        purchase.PressPurchase();

        reports.CreateScreenShot(driver);
        reports.Log(Status.PASS, "Clicking purchase");
    }

    @Test
    public void Test06_blessingScreen() throws IOException
    {
        //scroll screen 6
        BlessingScreen blessing = new BlessingScreen(driver, elementVisibilityTimeout);
        blessing.ScrollDown();

        //receiver name
        blessing.EnterReceiverName();

        reports.CreateScreenShot(driver);
        reports.Log(Status.PASS, "Entered receiver name");

        //enter a blessing
        blessing.EnterBlessing();

        reports.CreateScreenShot(driver);
        reports.Log(Status.PASS, "Entered blessing");

        //enter sender name
        blessing.EnterSenderName();

        reports.CreateScreenShot(driver);
        reports.Log(Status.PASS, "Entered sender name");

        //Continue
        blessing.Proceed();

        reports.CreateScreenShot(driver);
        reports.Log(Status.PASS, "Clicking proceed to next screen");
    }

    @Test
    public void Test07_shipmentOptions() throws SAXException, ParserConfigurationException, IOException
    {
        //press radio button screen 7
        ShipmentOptionsScreen shipmentOptions = new ShipmentOptionsScreen(driver, elementVisibilityTimeout);
        shipmentOptions.SelectShipmentTime();

        reports.CreateScreenShot(driver);
        reports.Log(Status.PASS, "Selecting shipment time");

        //mail checkbox
        shipmentOptions.SelectMailCheckbox();

        reports.CreateScreenShot(driver);
        reports.Log(Status.PASS, "Selected mail checkbox");

        //mail filed
        String mail = XMLHandler.getData("senderMail");
        shipmentOptions.EnterEmail(mail);

        reports.CreateScreenShot(driver);
        reports.Log(Status.PASS, "Entered mail in text box");

        shipmentOptions.Proceed();

        reports.CreateScreenShot(driver);
        reports.Log(Status.PASS, "Proceeding to checkout");
    }

    @AfterClass
    public static void Finalize()
    {
        driver.quit();
        reports.FinalizeExtentReport();
    }
}
