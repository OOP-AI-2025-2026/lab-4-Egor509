package ua.opnu;

import java.util.ArrayList;
import java.util.List;


class Employee {
    private String name;
    public Employee(String name) { this.name = name; }
    public String getName() { return name; }
}

class Item {
    private String name;
    private double price;
    private double discount;

    public Item(String name, double price, double discount) {
        this.name = name;
        this.price = price;
        this.discount = discount;
    }

    public double getPrice() { return price; }
    public double getDiscount() { return discount; }
    public String toString() { return name + " " + price; }
}

class GroceryBill {
    private Employee clerk;
    private List<Item> items;
    private double total;

    public GroceryBill(Employee clerk) {
        this.clerk = clerk;
        this.items = new ArrayList<>();
        this.total = 0.0;
    }

    public void add(Item i) {
        items.add(i);
        total += i.getPrice();
    }

    public double getTotal() {
        return total;
    }

    public void printReceipt() {
        System.out.println("Чек (Касир: " + clerk.getName() + ")");
        for (Item i : items) {
            System.out.println(i);
        }
        System.out.println("Всього: " + getTotal());
    }

    public Employee getClerk() { return clerk; }
}

class Startup {
    private int startup_balance;
    public Startup(int balance) { this.startup_balance = balance; }
    public int getStartupBalance() { return startup_balance; }
}

class BankingAccount {
    private int balance;

    public BankingAccount(Startup s) {
        this.balance = s.getStartupBalance();
    }

    public void debit(int pennies) {
        balance -= pennies;
    }

    public void credit(int pennies) {
        balance += pennies;
    }

    public int getBalance() {
        return balance;
    }
}

class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() { return x; }
    public int getY() { return y; }

    public void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double distanceFromOrigin() {
        return Math.sqrt(x * x + y * y);
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}