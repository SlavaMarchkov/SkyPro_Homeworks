package skypro.homeworks.course1.homework02;

public class Main {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
        task5();
        task6();
        task7();
    }

    public static void task1() {
        System.out.println("Задача 1");

        byte age = 18;

        if (age >= 18) {
            System.out.println("Возраст " + age + ", человек совершеннолетний.");
        } else {
            System.out.println("Возраст " + age + ", человек несовершеннолетний.");
        }
    }

    public static void task2() {
        System.out.println("Задача 2");

        byte temperature = 10;

        if (temperature <= 5) {
            System.out.println("На улице " + temperature + " градусов, нужно надеть шапку.");
        } else {
            System.out.println("На улице " + temperature + " градусов, можно идти без шапки.");
        }
    }

    public static void task3() {
        System.out.println("Задача 3");

        byte speed = 70;

        if (speed <= 60) {
            System.out.println("Можно ездить спокойно.");
        } else {
            System.out.println("Придется заплатить штраф.");
        }
    }

    public static void task4() {
        System.out.println("Задача 4");

        byte age = 45;

        if (age >= 2 && age <= 6) {
            System.out.println("Возраст " + age + ", нужно ходить в детский сад.");
        } else if (age > 7 && age <= 18) {
            System.out.println("Возраст " + age + ", нужно ходить в школу.");
        } else if (age > 18 && age <= 24) {
            System.out.println("Возраст " + age + ", нужно ходить в университет.");
        } else if (age > 24) {
            System.out.println("Возраст " + age + ", нужно ходить на работу.");
        }
    }

    public static void task5() {
        System.out.println("Задача 5");

        byte age = 10;
        boolean isAdultHere = true;

        if (age < 5) {
            System.out.println("Возраст ребенка " + age + ", на аттракционе кататься нельзя.");
        } else if (age >= 5 && age < 14 && isAdultHere) {
            System.out.println("Возраст ребенка " + age + ", можно кататься на аттракционе в сопровождении взрослого.");
        } else if (age >= 5 && age < 14 && !isAdultHere) {
            System.out.println("Возраст ребенка " + age + ", нельзя кататься на аттракционе без сопровождения взрослого.");
        } else if (age >= 14) {
            System.out.println("Возраст ребенка " + age + ", можно кататься на аттракционе без сопровождения взрослого.");
        }
    }

    public static void task6() {
        System.out.println("Задача 6");

        byte wagonCapacity = 102;
        byte wagonSeats = 60;
        byte passenger = 103;

        if (passenger <= wagonSeats) {
            System.out.println("В вагоне есть сидячее место.");
        } else if (passenger > wagonSeats && passenger <= wagonCapacity) {
            System.out.println("В вагоне есть стоячее место.");
        } else if (passenger > 102) {
            System.out.println("Вагон уже полностью забит.");
        }
    }

    public static void task7() {
        System.out.println("Задача 7");

        int one = 57;
        int two = 58;
        int three = 59;

        if (one > two) {
            if (one >= three) {
                System.out.println("Большее из трёх чисел: " + one);
            } else {
                System.out.println("Большее из трёх чисел: " + three);
            }
        } else if (two > one) {
            if (two >= three) {
                System.out.println("Большее из трёх чисел: " + two);
            } else {
                System.out.println("Большее из трёх чисел: " + three);
            }
        } else {
            if (one > three) {
                System.out.println("Большее из трёх чисел: " + one);
            } else if (three > one) {
                System.out.println("Большее из трёх чисел: " + three);
            } else {
                System.out.println("Все числа равны.");
            }
        }
    }
}
