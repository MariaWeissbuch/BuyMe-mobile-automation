import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ChooseCategoryScreen extends ScreenBase
{
    private static final String categoriesElementId = "il.co.mintapp.buyme:id/i_shadow";
    private static final int categoryIndex = 2;

    public ChooseCategoryScreen(AndroidDriver _driver, int timeoutInSeconds)
    {
        super(_driver, timeoutInSeconds);
    }

    public void ChooseCategory()
    {
        List<MobileElement> categories = driver.findElements(By.id(categoriesElementId));
        categories.get(categoryIndex).click();
    }
}
