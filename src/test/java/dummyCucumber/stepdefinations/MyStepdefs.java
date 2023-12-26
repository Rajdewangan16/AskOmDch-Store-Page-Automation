package dummyCucumber.stepdefinations;


import dummyCucumber.constants.EndPoint;
import dummyCucumber.constants.MyConstants;
import dummyCucumber.context.TestContext;
import dummyCucumber.domainobjects.BillingDetails;
import dummyCucumber.domainobjects.Product;
import dummyCucumber.factory.DriverFactory;
import dummyCucumber.pages.CartPage;
import dummyCucumber.pages.CheckoutPage;
import dummyCucumber.pages.StorePage;
import dummyCucumber.utils.ConfigLoader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;


import java.util.List;
import java.util.Map;

public class MyStepdefs {

    private final WebDriver driver;


    public MyStepdefs(TestContext context) {
        driver = context.driver;
    }

    @Given("I'm a guest customer")
    public void iMAGuestCustomer() {
        new StorePage(driver).load(MyConstants.STORE);
    }


}
