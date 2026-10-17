package testBase;



import org.testng.Assert;
import org.testng.annotations.Test;

import PagesObjects.AddProductCart;
import PagesObjects.Searchpage;

// Change remark: extends BaseClass to reuse its WebDriver, config properties, logger, and setup/teardown.
public class TC004_AddCart extends BaseClass {

    @Test(groups = "Regression")
    public void VerifyAddProductToCart() {
        logger.info("Starting TC004_AddCart");

        String expectedProduct = p.getProperty("ProductName");
        Assert.assertNotNull(expectedProduct, "ProductName must be set in config.properties");
        Assert.assertFalse(expectedProduct.trim().isEmpty(), "ProductName must not be blank");

        Searchpage searchPage = new Searchpage(driver);
        searchPage.Setproductname(expectedProduct);
        searchPage.clicksearchbtn();

        String displayedProduct = searchPage.validateprodutlist();
        Assert.assertEquals(displayedProduct, expectedProduct, "Expected product was not found");

        AddProductCart cartPage = new AddProductCart(driver);

        // Change remark: compare the base product price with the expected amount before adding.
        String priceText = cartPage.getPrice();
        priceText = priceText.split("Ex Tax:")[0].trim();
        Assert.assertEquals(priceText, "$123.20", "Price not match");
        

        cartPage.clickaddcart();
        String confirmation = cartPage.getconfmess();

        Assert.assertTrue(
            confirmation.contains("Success") && confirmation.contains(expectedProduct),
            "Add-to-cart confirmation did not mention the expected product. Actual message: " + confirmation
        );

        logger.info("Finished TC004_AddCart");
    }
}


