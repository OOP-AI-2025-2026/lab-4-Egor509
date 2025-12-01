package ua.opnu;

public class DiscountBill extends GroceryBill {

    private boolean regularCustomer;
    private int discountCount;
    private double discountAmount;

    public DiscountBill(Employee clerk, boolean regularCustomer) {
        super(clerk);
        this.regularCustomer = regularCustomer;
        this.discountCount = 0;
        this.discountAmount = 0.0;
    }

    @Override
    public void add(Item i) {
        super.add(i);

        if (regularCustomer && i.getDiscount() > 0) {
            discountCount++;
            discountAmount += i.getDiscount();
        }
    }

    @Override
    public double getTotal() {
        return super.getTotal() - discountAmount;
    }

    public int getDiscountCount() {
        return discountCount;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public double getDiscountPercent() {
        double originalTotal = super.getTotal();
        if (originalTotal == 0) return 0.0;

        return 100.0 - ((originalTotal - discountAmount) * 100.0 / originalTotal);
    }
}