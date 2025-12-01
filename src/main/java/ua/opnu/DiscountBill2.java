package ua.opnu;

public class DiscountBill2 {

    private GroceryBill bill;
    private boolean regularCustomer;
    private int discountCount;
    private double discountAmount;

    public DiscountBill2(Employee clerk, boolean regularCustomer) {
        this.bill = new GroceryBill(clerk);
        this.regularCustomer = regularCustomer;
        this.discountCount = 0;
        this.discountAmount = 0.0;
    }

    public void add(Item i) {
        bill.add(i);

        if (regularCustomer && i.getDiscount() > 0) {
            discountCount++;
            discountAmount += i.getDiscount();
        }
    }

    public double getTotal() {
        return bill.getTotal() - discountAmount;
    }

    public int getDiscountCount() {
        return discountCount;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public double getDiscountPercent() {
        double originalTotal = bill.getTotal();
        if (originalTotal == 0) return 0.0;
        return 100.0 - ((originalTotal - discountAmount) * 100.0 / originalTotal);
    }

    public void printReceipt() {
        bill.printReceipt();
        System.out.println("Знижка клієнта: " + discountAmount);
        System.out.println("До сплати: " + getTotal());
    }
}