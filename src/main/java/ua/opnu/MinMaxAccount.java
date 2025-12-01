package ua.opnu;

public class MinMaxAccount extends BankingAccount {

    private int minBalance;
    private int maxBalance;

    public MinMaxAccount(Startup s) {
        super(s);
        int initialBalance = getBalance();
        this.minBalance = initialBalance;
        this.maxBalance = initialBalance;
    }

    @Override
    public void debit(int pennies) {
        super.debit(pennies);
        updateMinMax();
    }

    @Override
    public void credit(int pennies) {
        super.credit(pennies);
        updateMinMax();
    }

    private void updateMinMax() {
        int currentBalance = getBalance();
        if (currentBalance < minBalance) {
            minBalance = currentBalance;
        }
        if (currentBalance > maxBalance) {
            maxBalance = currentBalance;
        }
    }

    public int getMin() {
        return minBalance;
    }

    public int getMax() {
        return maxBalance;
    }
}