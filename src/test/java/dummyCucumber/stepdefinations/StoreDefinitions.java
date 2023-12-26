package dummyCucumber.stepdefinations;

import dummyCucumber.apis.CartApi;
import dummyCucumber.constants.EndPoint;
import dummyCucumber.context.TestContext;
import dummyCucumber.domainobjects.BillingDetails;
import dummyCucumber.domainobjects.Product;
import dummyCucumber.pages.CartPage;
import dummyCucumber.pages.StorePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class StoreDefinitions {

    private final WebDriver driver;
    private final TestContext context;

    public StoreDefinitions(TestContext context) {
        this.context = context;
        driver = context.driver;
    }
    @Given("I'm on the Store Page")
    public void i_m_on_the_store_page() {
        new StorePage(driver).load(EndPoint.STORE.url);
    }
    @When("I add a {product} to the cart")
    public void i_add_a_to_the_cart(Product product) {
        new StorePage(driver).addToCart(product.getName());
    }

    @And("I have a product in the cart")
    public void iHaveAProductInTheCart() {
 //       new StorePage(driver).addToCart("Blue Shoes");
        CartApi cartApi = new CartApi(context.cookies.getCookies());
        cartApi.addToCart(1215, 1);
        context.cookies.setCookies(cartApi.getCookies());
        context.cookies.injectCookiesToBrowser(context.driver);
    }
}
