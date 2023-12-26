package dummyCucumber.stepdefinations;

import dummyCucumber.context.TestContext;
import dummyCucumber.domainobjects.Product;
import dummyCucumber.pages.CartPage;
import dummyCucumber.pages.PageFactoryManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class CartSTpeDefinitions {
    private final CartPage cartPage;
    public CartSTpeDefinitions(TestContext context) {
        cartPage = PageFactoryManager.getCartPage(context.driver);
    }

    @Then("I should see {int} {product} in the cart")
    public void i_should_see_in_the_cart(int quantity, Product product) {
        Assert.assertEquals(product.getName() , cartPage.getProductName());
        Assert.assertEquals(quantity , cartPage.getProductQty());
    }

}
