package dummyCucumber.stepdefinations;

import dummyCucumber.constants.EndPoint;
import dummyCucumber.context.TestContext;
import dummyCucumber.domainobjects.BillingDetails;
import dummyCucumber.pages.CartPage;
import dummyCucumber.pages.CheckoutPage;
import dummyCucumber.pages.PageFactoryManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import javax.xml.stream.events.EndDocument;

public class CheckoutStepDefinitions {

    private final CheckoutPage checkoutPage;
    private final TestContext context;
    public CheckoutStepDefinitions(TestContext context) {
        checkoutPage = PageFactoryManager.getCheckoutPage(context.driver);
        this.context = context;
    }

    @And("my billing details are")
    public void myBillingDetailsAre(BillingDetails billingDetails) {
        context.billingDetails = billingDetails;
    }



    @When("I provide billing details")
    public void iProvideBillingDetails() {
        checkoutPage.setBillingDetails(context.billingDetails);
    }

    @And("I place an order")
    public void iPlaceAnOrder() {
        checkoutPage.placeOrder();
    }

    @Then("the order should be placed successfully")
    public void theOrderShouldBePlacedSuccessfully() {
        Assert.assertEquals("Thank you. Your order has been received.",
                checkoutPage.getNotice());

    }
    @And("I'm on the Checkout page")
    public void iMOnTheCheckoutPage() {
        checkoutPage.load(EndPoint.CHECKOUT.url);

    }
}
