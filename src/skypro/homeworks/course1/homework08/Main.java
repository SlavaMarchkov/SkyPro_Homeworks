package skypro.homeworks.course1.homework08;

public class Main {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
        task5();
        task6();
        task7();
        task8();
    }

    public static void task1() {
        System.out.println("Задача 1");

        byte byteVar = 127;
        short shortVar = 10000;
        int intVar = 1000000;
        long longVar = 9_223_000_000_000_000_000L;
        float piFloat = 3.14f;
        double piDouble = 3.1415926535;

        System.out.println("Значение переменной byteVar с типом byte равно " + byteVar);
        System.out.println("Значение переменной shortVar с типом short равно " + shortVar);
        System.out.println("Значение переменной intVar с типом int равно " + intVar);
        System.out.println("Значение переменной longVar с типом long равно " + longVar);
        System.out.println("Значение переменной piFloat с типом float равно " + piFloat);
        System.out.println("Значение переменной piDouble с типом double равно " + piDouble);
    }

    public static void task2() {
        System.out.println("Задача 2");

        float f = 27.12f;
        long l = 987678965549L;
        double d = 2.786;
        short shortPos = 569;
        short shortNeg = -159;
        int i = 27897;
        byte b = 67;
    }

    public static void task3() {
        System.out.println("Задача 3");

        byte class1Number = 23;
        byte class2Number = 27;
        byte class3Number = 30;
        short paperSheets = 480;

        short sheetsPerStudent = (short) (paperSheets / (class1Number + class2Number + class3Number));

        System.out.println("На каждого ученика рассчитано " + sheetsPerStudent + " листов бумаги");
    }

    public static void task4() {
        System.out.println("Задача 4");

        byte minutes = 2;
        byte bottles = 16;

        byte bottlesPerMinute = (byte) (bottles / minutes);
        int bottlesPer20Minutes = bottlesPerMinute * 20;
        int bottlesPerDay = bottlesPerMinute * 60 * 24;
        int bottlesPer3Days = bottlesPerDay * 3;
        int bottlesPerMonth = bottlesPerDay * 30;

        System.out.println("За 20 минут машина произвела " + bottlesPer20Minutes + " штук бутылок");
        System.out.println("За сутки машина произвела " + bottlesPerDay + " штук бутылок");
        System.out.println("За 3 дня машина произвела " + bottlesPer3Days + " штук бутылок");
        System.out.println("За 1 месяц машина произвела " + bottlesPerMonth + " штук бутылок");
    }

    public static void task5() {
        System.out.println("Задача 5");

        byte whiteCansPerClass = 2;
        byte brownCansPerClass = 4;
        byte totalCans = 120;

        byte totalClasses = (byte) (totalCans / (whiteCansPerClass + brownCansPerClass));
        byte totalWhiteCans = (byte) (totalClasses * whiteCansPerClass);
        byte totalBrownCans = (byte) (totalClasses * brownCansPerClass);

        System.out.println("В школе, где " + totalClasses + " классов, нужно " + totalWhiteCans + " банок белой краски и " + totalBrownCans + " банок коричневой краски");
    }

    public static void task6() {
        System.out.println("Задача 6");

        byte bananas = 5; // Бананы — 5 штук (1 банан — 80 грамм).
        byte weightGrBanana = 80;
        short milkMl = 200; // Молоко — 200 мл (100 мл = 105 грамм).
        byte weightGrMilkPer100Ml = 105;
        byte iceCream = 2; // Мороженое-пломбир — 2 брикета по 100 грамм.
        byte weightGrIceCream = 100;
        byte eggs = 4; // Яйца сырые – 4 яйца (1 яйцо — 70 грамм).
        byte weightGrEgg = 70;

        short totalGrBananas = (short) (bananas * weightGrBanana); // 400
        short totalGrMilk = (short) (milkMl / 100 * weightGrMilkPer100Ml); // 210
        short totalGrIceCreams = (short) (iceCream * weightGrIceCream); // 200
        short totalGrEggs = (short) (eggs * weightGrEgg); // 280

        short weightGrBreakfast = (short) (totalGrBananas + totalGrMilk + totalGrIceCreams + totalGrEggs);
        int grPerKg = 1000;
        float weightKgBreakfast = weightGrBreakfast / (float) grPerKg;

        System.out.println("Вес спортзавтрака в граммах: " + weightGrBreakfast + " г");
        System.out.println("Вес спортзавтрака в килограммах: " + weightKgBreakfast + " кг");
    }

    public static void task7() {
        System.out.println("Задача 7");

        byte weightToLose = 7; // 7 кг
        short grPerDayOption1 = 250; // 250 г в день
        short grPerDayOption2 = 500; // 500 г в день

        int grPerKg = 1000; // в 1 кг 1000 г
        byte daysOption1 = (byte) (weightToLose * grPerKg / grPerDayOption1);
        byte daysOption2 = (byte) (weightToLose * grPerKg / grPerDayOption2);
        byte avgDays = (byte) (weightToLose * grPerKg / ((grPerDayOption1 + grPerDayOption2) / 2));

        System.out.println("Если спортсмен будет терять каждый день по 250 грамм, то на похудение уйдет " + daysOption1 + " дней.");
        System.out.println("Если спортсмен будет терять каждый день по 500 грамм, то на похудение уйдет " + daysOption2 + " дней.");
        System.out.println("Среднее количество дней для достижения результата похудения: " + avgDays + " дней.");
    }

    public static void task8() {
        System.out.println("Задача 8");

        float yearlyIncrease = 0.1f; // Каждый год повышение составляет 10% от текущей зарплаты.
        int salaryMasha = 67_760;
        int salaryDenis = 83_690;
        int salaryKristina = 76_230;

        int salaryMashaAfterIncrease = (int) (salaryMasha + salaryMasha * yearlyIncrease);
        int yearlyMashaSurplus= (salaryMashaAfterIncrease - salaryMasha) * 12;

        int salaryDenisAfterIncrease = (int) (salaryDenis + salaryDenis * yearlyIncrease);
        int yearlyDenisSurplus= (salaryDenisAfterIncrease - salaryDenis) * 12;

        int salaryKristinaAfterIncrease = (int) (salaryKristina + salaryKristina * yearlyIncrease);
        int yearlyKristinaSurplus= (salaryKristinaAfterIncrease - salaryKristina) * 12;

        System.out.println("Маша теперь получает " + salaryMashaAfterIncrease + " рублей. Годовой доход вырос на " + yearlyMashaSurplus + " рублей.");
        System.out.println("Денис теперь получает " + salaryDenisAfterIncrease + " рублей. Годовой доход вырос на " + yearlyDenisSurplus + " рублей.");
        System.out.println("Кристина теперь получает " + salaryKristinaAfterIncrease + " рублей. Годовой доход вырос на " + yearlyKristinaSurplus + " рублей.");
    }
}
