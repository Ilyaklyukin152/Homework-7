import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        printTask(1);
        checkIsLeapYearAndPrint(2024);

        printTask(2);
        checkValidSystemAndPrint(1, 2025);

        printTask(3);
        int deliveryDays = getDeliveryDays(120);
        if (deliveryDays == -1) {
            System.out.println("Доставки нет");
        } else {
            System.out.println("Потребуется дней: " + deliveryDays);
        }
    }

    public static void checkIsLeapYearAndPrint(int year) {
        if (year >= 1584 && (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            System.out.println(year + " год является високосным");
        } else {
            System.out.println(year + " год не является високосным");
        }
    }

    public static void checkValidSystemAndPrint(int system, int clientDeviceYear) {
        int currentYear = LocalDate.now().getYear();
        if (system < 0 || system > 1 || clientDeviceYear < 1900 || clientDeviceYear > currentYear) {
            System.out.println("Некорректные данные");
            return;
        }
        if (system == 0 && clientDeviceYear < currentYear) {
            System.out.println("Установите облегченную версию приложения для iOS по ссылке");
        } else if (system == 0 && clientDeviceYear >= currentYear) {
            System.out.println("Установите версию приложения для iOS по ссылке");
        } else if (system == 1 && clientDeviceYear < currentYear) {
            System.out.println("Установите облегченную версию приложения для Android по ссылке");
        } else if (system == 1 && clientDeviceYear >= currentYear) {
            System.out.println("Установите версию приложения для Android по ссылке");
        }
    }

    public static int getDeliveryDays(int deliveryDistance) {
        if (deliveryDistance <= 20) {
            return 1;
        } else if (deliveryDistance > 20 && deliveryDistance <= 60) {
            return 2;
        } else if (deliveryDistance > 60 && deliveryDistance <= 100) {
            return 3;
        } else {
            return -1;
        }
    }

    public static void printTask(int number) {
        System.out.println("\nЗадача " + number);
    }
}
