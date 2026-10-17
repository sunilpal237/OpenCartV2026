package testBase;

import org.testng.Assert;
import org.testng.annotations.Test;

import PagesObjects.Searchpage;

public class TC003_SearchProduct extends BaseClass {

    @Test
    public void VerifyProduct() {
        logger.info("Starting TC003_SearchProduct");

        // Change remark: product search is public, so this test does not invoke the login test.
        String expectedProduct = p.getProperty("ProductName");
        Assert.assertNotNull(expectedProduct, "ProductName must be set in config.properties");
        Assert.assertFalse(expectedProduct.trim().isEmpty(), "ProductName must not be blank");

        Searchpage searchPage = new Searchpage(driver);
        searchPage.Setproductname(expectedProduct);
        searchPage.clicksearchbtn();

        String actualProduct = searchPage.validateprodutlist();
        Assert.assertEquals(
            actualProduct,
            expectedProduct,
            "The expected product was not found in the search results"
        );

        // Change remark: removed catch-and-fail so TestNG preserves the original failure details.
        logger.info("Finished TC003_SearchProduct");
    }
}
