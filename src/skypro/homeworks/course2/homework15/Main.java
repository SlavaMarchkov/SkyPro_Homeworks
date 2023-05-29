package skypro.homeworks.course2.homework15;

import java.util.Arrays;

public class Main {

    public static void main(final String[] args) {

        IntegerList integerList = new IntegerListImpl();

        System.out.println(integerList.add(952));
        System.out.println(integerList.add(348));
        System.out.println(integerList.add(56));
        System.out.println(integerList.add(314));
        System.out.println(integerList.add(27));

        System.out.println(integerList.contains(56));
        System.out.println(integerList.contains(32));

//        System.out.println(integerList.indexOf(34));
//        System.out.println(integerList.indexOf(2));
//        System.out.println(integerList.lastIndexOf(56));

//        System.out.println(integerList.add(0, 78));

//        System.out.println(integerList.set(1, 980));

//        System.out.println(integerList.get(2));

//        System.out.println(integerList.remove(256));
//        System.out.println(integerList.remove(null));

        System.out.println(Arrays.toString(integerList.toArray()));

    }

}
