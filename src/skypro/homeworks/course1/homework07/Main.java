package skypro.homeworks.course1.homework07;

public class Main {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
    }

    private static void task1() {
        System.out.println("Задание 1. Високосный год");
        int year = 2020;
        checkYear(year);
    }

    private static void checkYear(int year) {
        String leapYear = (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))
                ? year + " год является високосным"
                : year + " год не является високосным";
        System.out.println(leapYear);
    }

    private static void task2() {
        System.out.println("Задание 2. Версия банковского приложения");
//        int clientDeviceYear = LocalDate.now().getYear();
        int clientDeviceYear = 2014;
        byte clientOS = 1; // 0 — iOS, 1 — Android
        checkClientDevice(clientOS, clientDeviceYear);
    }

    private static void checkClientDevice(byte OS, int year) {
        if (year < 2015 && OS == 0) {
            System.out.println("Установите облегченную версию приложения для iOS по ссылке");
        } else if (year < 2015 && OS == 1) {
            System.out.println("Установите облегченную версию приложения для Android по ссылке");
        } else if (OS == 0) {
            System.out.println("Установите версию приложения для iOS по ссылке");
        } else if (OS == 1) {
            System.out.println("Установите версию приложения для Android по ссылке");
        }
    }

    private static void task3() {
        System.out.println("Задание 3. Доставка банковской карты");
        int deliveryDistance = 95;
        int days = getDeliveryDays(deliveryDistance);
        if (days == 0) {
            System.out.println("Доставки нет");
        } else {
            System.out.println("Потребуется дней: " + days);
        }
    }

    private static int getDeliveryDays(int distance) {
        int days = 1; // срок доставки 1 день

        if (distance > 0 && distance < 20) {
            return days;
        } else if (distance >= 20 && distance < 60) {
            days = days + 1;
        } else if (distance >= 60 && distance < 100) {
            days = days + 2;
        } else {
            days = 0;
        }

        return days;
    }
}