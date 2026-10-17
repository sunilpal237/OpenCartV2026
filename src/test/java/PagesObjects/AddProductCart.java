package PagesObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddProductCart extends BasePage {

    public AddProductCart(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//p[@class='price']")
    private WebElement productPrice;

    @FindBy(xpath = "//div[contains(@class,'product-layout')]//button[contains(@onclick,'cart.add')]")
    private WebElement addCartButton;

    // Change remark: target the success alert shown after adding a product, not the button.
    @FindBy(css = "div.alert-success")
    private WebElement confirmationMessage;

    public String getPrice() {
        return productPrice.getText();
    }

    public void clickaddcart() {
        addCartButton.click();
    }

    public String getconfmess() {
        return confirmationMessage.getText();
    }
}
