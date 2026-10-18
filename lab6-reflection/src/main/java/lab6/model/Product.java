package lab6.model;

import lab6.annotation.MarginRule;
import lab6.annotation.NotBlank;
import lab6.annotation.Range;

@MarginRule(minMarginPercent = 15.0)
public class Product {

    @NotBlank
    private String name;                // String

    @Range(min = 0.01, max = 100_000)
    private double wholesalePrice;      // double

    private double retailPrice;         // double

    @Range(min = 0, max = 10_000)
    private int quantity;               // int

    private boolean inStock;            // boolean

    public Product(String name, double wholesalePrice, double retailPrice, int quantity, boolean inStock) {
        this.name = name;
        this.wholesalePrice = wholesalePrice;
        this.retailPrice = retailPrice;
        this.quantity = quantity;
        this.inStock = inStock;
    }

    @Override
    public String toString() {
        return "Product{name='" + name + "', wholesale=" + wholesalePrice + ", retail=" + retailPrice
                + ", quantity=" + quantity + ", inStock=" + inStock + "}";
    }
}
