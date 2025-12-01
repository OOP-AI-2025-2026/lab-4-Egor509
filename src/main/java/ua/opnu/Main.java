package ua.opnu;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Тест Завдання 1 (DiscountBill) ===");
        testDiscountBill();

        System.out.println("\n=== Тест Завдання 2 (MinMaxAccount) ===");
        testMinMaxAccount();

        System.out.println("\n=== Тест Завдання 3 (Point3D) ===");
        testPoint3D();

        System.out.println("\n=== Тест Завдання 4 (DiscountBill2 - Композиція) ===");
        testDiscountBill2();
    }

    private static void testDiscountBill() {
        Employee clerk = new Employee("Іван");
        Item apple = new Item("Яблуко", 20, 2);
        Item milk = new Item("Молоко", 30, 0);
        Item bread = new Item("Хліб", 15, 3);

        DiscountBill bill = new DiscountBill(clerk, true);
        bill.add(apple);
        bill.add(milk);
        bill.add(bread);

        System.out.println("Загальна сума (зі знижкою): " + bill.getTotal());
        System.out.println("Кількість товарів зі знижкою: " + bill.getDiscountCount());
        System.out.println("Сума знижки: " + bill.getDiscountAmount());
        System.out.println("Відсоток знижки: " + String.format("%.2f", bill.getDiscountPercent()) + "%");
    }

    private static void testMinMaxAccount() {
        Startup startup = new Startup(1000);
        MinMaxAccount acc = new MinMaxAccount(startup);

        acc.debit(200);
        acc.credit(500);
        acc.debit(1000);

        System.out.println("Поточний баланс: " + acc.getBalance());
        System.out.println("Мін. баланс: " + acc.getMin());
        System.out.println("Макс. баланс: " + acc.getMax());
    }

    private static void testPoint3D() {
        Point3D p1 = new Point3D(1, 2, 3);
        Point3D p2 = new Point3D(4, 6, 8);

        System.out.println("Точка 1: " + p1);
        System.out.println("Точка 2: " + p2);
        System.out.println("Відстань між точками: " + String.format("%.2f", p1.distance(p2)));
        System.out.println("Відстань p1 від початку: " + String.format("%.2f", p1.distanceFromOrigin()));
        System.out.println("Z координата p1: " + p1.getZ());

        p1.setLocation(10, 10);
        System.out.println("Після setLocation(10, 10): " + p1);
    }

    private static void testDiscountBill2() {
        Employee clerk = new Employee("Марія");
        Item tea = new Item("Чай", 50, 5);

        DiscountBill2 bill = new DiscountBill2(clerk, true);
        bill.add(tea);

        System.out.println("Всього (композиція): " + bill.getTotal());
        System.out.println("Сума знижки: " + bill.getDiscountAmount());
    }
}