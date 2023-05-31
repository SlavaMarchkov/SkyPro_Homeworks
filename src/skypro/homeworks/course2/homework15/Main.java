package skypro.homeworks.course2.homework15;

import java.util.Arrays;

public class Main {

    public static void main(final String[] args) {

        IntegerList integerList = new IntegerListImpl();

        for (int i = 1; i < 11; i++) {
            integerList.add(i);
        }

        System.out.println(integerList.size());
        System.out.println(integerList.contains(9));
        System.out.println(integerList.indexOf(3));
        System.out.println(integerList.indexOf(84));
        System.out.println(integerList.lastIndexOf(5));

        System.out.println(integerList.add(0, 78));

        System.out.println(integerList.set(1, 980));

        System.out.println(integerList.get(2));

        System.out.println(integerList.remove(Integer.valueOf(980)));
        System.out.println(integerList.remove(1));
//        System.out.println(integerList.remove(null));

        System.out.println(Arrays.toString(integerList.toArray()));

    }

}
