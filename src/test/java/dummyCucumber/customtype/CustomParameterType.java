package dummyCucumber.customtype;


import dummyCucumber.domainobjects.Product;
import io.cucumber.java.ParameterType;

public class CustomParameterType {

    @ParameterType(".*")
    public Product product(String name){

        return new Product(name.replace("\"", ""));
    }
}
