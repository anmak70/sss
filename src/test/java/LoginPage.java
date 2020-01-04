import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.cssSelector;

public class LoginPage {

    By loginLocator = cssSelector("[data-test-id=login] input");
    By passwordLocator = cssSelector("[data-test-id=password] input");
    By logButton = cssSelector("[data-test-id=action-login]");

    private SelenideElement loginField = $(loginLocator);
    private SelenideElement passwordField = $(passwordLocator);
    private SelenideElement loginButton = $(logButton);

    public VerificationPage validLogin(DataHelper.AuthInfo authInfo) {
         loginField.setValue(authInfo.getLogin()).waitUntil(Condition.visible, 15000);
         passwordField.setValue(authInfo.getPassword());
         loginButton.click();
         return new VerificationPage();
    }
}
