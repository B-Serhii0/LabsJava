public record Product(String article, String name, String category, int categoryId,
                      double price, boolean inStock, double rating, int discountPercentage) {
    @Override
    public String toString() {
        return String.format("%s | %-14s | %-10s | %8.2f | inStock=%-5b | rating=%.1f | -%d%%",
                article, name, category, price, inStock, rating, discountPercentage);
    }
}
