import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ScreenBase
{
    protected AndroidDriver<MobileElement> driver;
    protected WebDriverWait wait;

    protected ScreenBase(AndroidDriver _driver, int waitTimeoutSeconds)
    {
        driver = _driver;
        wait = new WebDriverWait(driver, waitTimeoutSeconds);
    }
}
