import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ChooseBusinessScreen extends ScreenBase
{

    private static final String businessNameId = "il.co.mintapp.buyme:id/businessName";
    private static final int businessIndex = 1;

    public ChooseBusinessScreen(AndroidDriver _driver, int timeoutInSeconds)
    {
        super(_driver, timeoutInSeconds);
    }

    public void SelectBusiness()
    {
        List<MobileElement> business = driver.findElements(By.id(businessNameId));
        business.get(businessIndex).click();
    }
}
