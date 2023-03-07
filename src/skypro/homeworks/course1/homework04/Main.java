package skypro.homeworks.course1.homework04;

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
        task9();
        task10();
        task11();
        task12();
        task13();
        task14();
        task15();
        task16();
        task17();
        task18();
    }

    private static void task1() {
        System.out.println("Задача 1");
        // С помощью цикла for выведите в консоль все числа от 1 до 10.

        for (int i = 1; i <= 10; i++) {
            System.out.print(i + "\t");
        }

        System.out.println();
    }

    private static void task2() {
        System.out.println("Задача 2");
        // С помощью цикла for выведите в консоль все числа от 10 до 1.

        for (int i = 10; i >= 1; i--) {
            System.out.print(i + "\t");
        }

        System.out.println();
    }

    private static void task3() {
        System.out.println("Задача 3");
        // Выведите в консоль все четные числа от 0 до 17.

        for (int i = 0; i < 17; i += 2) {
            System.out.print(i + "\t");
        }

        System.out.println();
    }

    private static void task4() {
        System.out.println("Задача 4");
        // Выведите в консоль все числа от 10 до −10 от бо́льшего числа к меньшему.

        for (int i = 10; i >= -10; i--) {
            System.out.print(i + "\t");
        }

        System.out.println();
    }

    private static void task5() {
        System.out.println("Задача 5");
        // Выведите в консоль все високосные года, начиная с 1904 года до 2096.

        for (int i = 1904; i <= 2096; i += 4) {
            System.out.println(i + " год является високосным");
        }
    }

    private static void task6() {
        System.out.println("Задача 6");
        // Выведите в консоль последовательность чисел 7 14 21 28 35 42 49 56 63 70 77 84 91 98

        for (int i = 7; i <= 98; i += 7) {
            System.out.print(i + " ");
        }

        System.out.println();
    }

    private static void task7() {
        System.out.println("Задача 7");
        // Выведите в консоль последовательность чисел 1 2 4 8 16 32 64 128 256 512

        for (int i = 1; i <= 512; i *= 2) {
            System.out.print(i + " ");
        }

        System.out.println();
    }

    private static void task8() {
        System.out.println("Задача 8");
        // Посчитайте с помощью цикла for сумму годовых накоплений,
        // если каждый месяц вы будете откладывать по 29 000 рублей «в банку».
        // Выведите сумму накоплений за каждый месяц в консоль в формате:
        // «Месяц …, сумма накоплений равна … рублей».

        int deposit = 29_000;
        int total = 0;

        for (int month = 1; month <= 12; month++) {
            total += deposit;
            System.out.println("Месяц " + month + ", сумма накоплений равна " + total + " рублей");
        }
    }

    private static void task9() {
        System.out.println("Задача 9");
        // Перепишите решение задачи выше при условии,
        // что деньги вы откладывать будете не «в банку», а в банк под проценты — 12% годовых.
        // Выведите сумму накоплений за каждый месяц в консоль в формате:
        // «Месяц …, сумма накоплений равна … рублей».

        int deposit = 29_000;
        int total = 0;

        for (int month = 1; month <= 12; month++) {
            total = total + total / 100;
            total += deposit;
            System.out.println("Месяц " + month + ", сумма накоплений равна " + total + " рублей");
        }
    }

    private static void task10() {
        System.out.println("Задача 10");
        // Напишите программу, которая выводит в консоль таблицу умножения на 2.

        int num = 2;

        for (int i = 1; i <= 10; i++) {
            System.out.println(num + "*" + i + "=" + (num * i));
        }
    }

    private static void task11() {
        System.out.println("Часть 2. Задача 1");
        // С помощью цикла while посчитайте, сколько месяцев потребуется,
        // чтобы накопить 2 459 000 рублей при условии,
        // что первоначально мы имеем 0 рублей и готовы откладывать по 15 тысяч рублей.

        int deposit = 15_000;
        int total = 0;
        int month = 1;

        while (total < 2_459_000) {
            total += deposit;
            System.out.println("Месяц " + month + ", сумма накоплений равна " + total + " рублей");
            month++;
        }
    }

    private static void task12() {
        System.out.println("Часть 2. Задача 2");
        // Выведите в одну строку через пробел числа от 1 до 10 с помощью цикла while.
        // На следующей строке выведите числа в обратном порядке от 10 до 1 с помощью цикла for.

        int i = 0;

        while (i < 10) {
            i++;
            System.out.print(i + " ");
        }

        System.out.println();

        for (; i >= 1; i--) {
            System.out.print(i + " ");
        }

        System.out.println();
    }

    private static void task13() {
        System.out.println("Часть 2. Задача 3");
        // В стране Y население равно 12 миллионов человек.
        // Рождаемость составляет 17 человек на 1000, смертность — 8 человек.
        // Рассчитайте, какая численность населения будет через 10 лет,
        // если показатели рождаемости и смертности постоянны.
        // В консоль выведите результат операции на каждый год в формате:
        // «Год …, численность населения составляет …».

        int birthRate = 17;
        int deathRate = 8;
        int population = 12_000_000;
        int year = 1;

        while (year <= 10) {
            int bornPerYear = population * birthRate / 1000;
            int diedPerYear = population * deathRate / 1000;
            population = population + bornPerYear - diedPerYear;

            System.out.println("Год " + year + ", численность населения составляет " + population + " человек");

            year++;
        }
    }

    private static void task14() {
        System.out.println("Часть 2. Задача 4");
        // Василий решил положить деньги на накопительный счет,
        // где каждый месяц к сумме его вклада добавляется еще 7%.
        // Первоначальная сумма вклада — 15 тысяч рублей.
        // Вычислите и выведите в консоль, сколько месяцев Василию нужно будет копить,
        // чтобы собрать сумму в 12 миллионов рублей при условии,
        // что процент банка от накоплений не меняется, а всегда равен 7%.
        // Выведите в консоль результат программы с указанием суммы накоплений по каждому месяцу.

        int percent = 7;
        int month = 1;
        int total = 15_000;

        while (total < 12_000_000) {
            total = total + total * percent / 100;
            System.out.println("Месяц " + month + ", сумма накоплений " + total + " руб.");
            month++;
        }
    }

    private static void task15() {
        System.out.println("Часть 2. Задача 5");
        // Видоизмените программу таким образом, чтобы в консоль выводились не все месяцы подряд,
        // а только каждый шестой. Должны быть видны накопления за 6, 12, 18, 24-й и следующие месяцы.

        int percent = 7;
        int month = 1;
        int total = 15_000;

        while (total < 12_000_000) {
            total = total + total * percent / 100;
            if (month % 6 == 0) {
                System.out.println("Месяц " + month + ", сумма накоплений " + total + " руб.");
            }
            month++;
        }
    }

    private static void task16() {
        System.out.println("Часть 2. Задача 6");
        // Василий решил, что будет копить деньги ближайшие 9 лет.
        // Он хочет знать, какой будет сумма его накоплений каждые полгода на протяжении этих 9 лет.
        // Исходная сумма всё та же — 15 тысяч рублей, проценты банка – 7% ежемесячно.
        // Напишите программу, которая будет выводить сумму накоплений за каждые полгода в течение 9 лет.

        int percent = 7;
        int month = 1;
        int total = 15_000;

        while (month < 12 * 9) {
            total = total + total * percent / 100;
            if (month % 6 == 0) {
                System.out.println("Месяц " + month + ", сумма накоплений " + total + " руб.");
            }
            month++;
        }
    }

    private static void task17() {
        System.out.println("Часть 2. Задача 7");
        // В компании пятница — отчетный день.
        // Нужно написать программу, которая считает дни месяца по датам,
        // определяет, какой день пятница, и выводит сообщение с напоминанием,
        // что нужно подготовить еженедельный отчет.
        // Создайте переменную типа int, которая хранит в себе номер первой пятницы месяца
        // (число от 1 до 7).
        // Выведите на каждую пятницу месяца (включая полученную) сообщение следующего вида:
        // «Сегодня пятница, ...-е число. Необходимо подготовить отчет».
        // В нашем месяце 31 день. В результате у вас должно получиться от 4 до 5 сообщений
        // с напоминаниями по разным датам.

        int fridayIndex = 4;

        for (int day = 1; day <= 31; day++) {
            if (day == fridayIndex) {
                System.out.println("Сегодня пятница, " + day + "-е число. Необходимо подготовить отчет");
                fridayIndex += 7;
            }
        }
    }

    private static void task18() {
        System.out.println("Часть 2. Задача 8");
        // Нам нужно написать астрономическое приложение, которое считает,
        // когда над Землей пролетает комета.
        // Известно, что комета пролетает каждый 79-й год, начиная с нулевого.
        // В консоль нужно вывести все годы за последние 200 лет, когда появлялась комета,
        // а также следующий год ее появления (ближайшие 100 лет).
        // Для вычисления периода можно создать две дополнительные переменные,
        // которые содержат год за 200 лет до текущего (из созданной ранее переменной)
        // в качестве старта и 100 лет после в качестве завершения периода расчета.

        int curYear = 2023;
        int startYear = curYear - 200;
        int endYear = curYear + 100;

        for (int year = startYear; year <= endYear; year++) {
            if (year % 79 == 0) {
                System.out.println(year);
            }
        }
    }
}
