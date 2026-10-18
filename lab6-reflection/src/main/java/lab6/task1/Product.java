package lab6.task1;


@MarginRule(minMarginPercent = 15.0)
public class Product {

    @NotBlank
    private String name;

    @Range(min = 0.01, max = 100_000)
    private double wholesalePrice;

    private double retailPrice;

    @Range(min = 0, max = 10_000)
    private int quantity;

    private boolean inStock;

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
