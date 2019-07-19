import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.aspectj.weaver.ast.And;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PurchaseScreen extends ScreenBase
{
    private static final String priceEditId = "il.co.mintapp.buyme:id/priceEditText";
    private static final String sumToInput = "100";
    private static final String purchaseButtonId = "il.co.mintapp.buyme:id/purchaseButton";

    public PurchaseScreen(AndroidDriver _driver, int timeoutInSeconds)
    {
        super(_driver, timeoutInSeconds);
    }

    public void EnterSum()
    {
        MobileElement sumField = driver.findElement(By.id(priceEditId));
        wait.until(ExpectedConditions.visibilityOf(sumField));
        sumField.click();
        sumField.sendKeys(sumToInput);
    }

    public void PressPurchase()
    {
        MobileElement purchase = driver.findElement(By.id(purchaseButtonId));
        wait.until(ExpectedConditions.visibilityOf(purchase));
        purchase.click();
    }
}
