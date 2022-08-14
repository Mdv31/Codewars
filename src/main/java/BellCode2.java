import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 Дана таблица:
 Имя|Возраст|Должность|Зарплата
 Кирилл|26|Middle java dev|150000 руб
 Виталий|28|Senior java automation QA|2000$
 Александр|31|junior functional tester|50000 руб
 Дементий|35|dev-ops|1500$

 Данная таблица представлена в формате
 List<Map<String,String>>, где каждый элемент list - строка, key в map - название столбца, value в map - значение ячейки

 Задача:

 - вывести имена всех сотрудников, младше 30.
 - вывести имена всех сотрудников, получающих зарплату в рублях.
 - вывести средний возраст всех сотрудников.
 * решение на Java
 * будет плюсом использование stream API
 */

public class BellCode2 {

    //вывести имена сотрудников с возрастом меньше 30
    public static void fun1(List<Map<String, String>> myList, int age) {
        for (Map<String, String> myMap : myList) { //for(int i = 0 ; i < myList.size() ; i++)
            int valueAge = Integer.parseInt(myMap.get("Возраст"));
            if (valueAge < age) {
                System.out.println(myMap.get("Имя") + " младше " + age + " лет: ");
            }
        }
    }

    public static void fun1_StreamApi(List<Map<String, String>> myList, int age) {
        myList.stream()
                .filter(x -> Integer.parseInt(x.get("Возраст")) < age)
                .forEach(x -> System.out.println(x.get("Имя") + " младше " + age + " лет: "));
    }

    //вывести имена всех сотрудников, получающих зарплату в рублях.
    public static void fun2(List<Map<String, String>> myList, String money) {
        for (Map<String, String> myMap : myList) { //for(int i = 0 ; i < myList.size() ; i++)
            if (myMap.get("Зарплата").contains(money))
                System.out.println(myMap.get("Имя") + " получает зарплату в " + money);
        }
    }

    public static void fun2_StreamApi(List<Map<String, String>> myList, String money) {
        myList.stream()
                .filter(x -> x.get("Зарплата").contains(money))
                .forEach(x -> System.out.println(x.get("Имя") + " получает зарплату в " + money));
    }

    //вывести средний возраст всех сотрудников
    public static void fun3(List<Map<String, String>> myList) {
        int sumAge = 0;
        for (Map<String, String> myMap : myList) { //for(int i = 0 ; i < myList.size() ; i++)
            sumAge = sumAge + Integer.parseInt(myMap.get("Возраст"));
        }
        System.out.println("Средний возраст всех сотрудников: " + (double) sumAge / myList.size());
    }

    public static void fun3_StreamApi(List<Map<String, String>> myList) {
        System.out.println("Средний возраст всех сотрудников: " + myList.stream()
                .mapToInt(x -> Integer.parseInt(x.get("Возраст"))).average().getAsDouble());
    }

    public static void main(String[] args) {

        List<Map<String, String>> myList = new ArrayList<>();

        Map<String, String> myMap = new HashMap<>();
        myMap.put("Имя", "Кирилл");
        myMap.put("Возраст", "26");
        myMap.put("Должность", "Middle java dev");
        myMap.put("Зарплата", "150000 руб");

        Map<String, String> myMap1 = new HashMap<>();
        myMap1.put("Имя", "Виталий");
        myMap1.put("Возраст", "28");
        myMap1.put("Должность", "Senior java automation QA");
        myMap1.put("Зарплата", "12000 $");

        Map<String, String> myMap2 = new HashMap<>();
        myMap2.put("Имя", "Александр");
        myMap2.put("Возраст", "31");
        myMap2.put("Должность", "Sjunior functional tester");
        myMap2.put("Зарплата", "50000 руб");

        Map<String, String> myMap3 = new HashMap<>();
        myMap3.put("Имя", "Дементий");
        myMap3.put("Возраст", "35");
        myMap3.put("Должность", "dev-ops");
        myMap3.put("Зарплата", "1500$");

        myList.add(myMap);
        myList.add(myMap1);
        myList.add(myMap2);
        myList.add(myMap3);

        fun1(myList, 30); //вывести имена сотрудников с возрастом меньше 30
        fun1_StreamApi(myList, 30);

        fun2(myList, "руб"); //вывести имена всех сотрудников, получающих зарплату в рублях.
        fun2_StreamApi(myList, "руб");

        fun3(myList); //вывести средний возраст всех сотрудников
        fun3_StreamApi(myList);
    }

}
