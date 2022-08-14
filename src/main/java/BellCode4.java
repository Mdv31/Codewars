/**
 * Планируется к реализации следующий класс:
 * public class Item {
 * int weight;
 * int cost;
 * String name;
 * }
 * <p>
 * Дописать необходимые методы для этого класса, чтобы можно было сравнивать объекты,
 * считая их равными в случае совпадения параметров weight и cost.
 */

public class BellCode4 {

    int weight;
    int cost;
    String name;

    public BellCode4(int weight, int cost, String name) {
        this.cost = cost;
        this.weight = weight;
        this.name = name;
    }

    public static void equalsItems(BellCode4 itemOne, BellCode4 itemTwo) {
        if (itemOne.getCost() == itemTwo.getCost() && itemOne.getWeight() == itemTwo.getWeight())
            System.out.println("Предметы равны");
        else System.out.println("Предметы не равны");

    }

    public static void main(String[] args) {

        BellCode4 itemOne = new BellCode4(100, 100, "item 1");
        BellCode4 itemTwo = new BellCode4(1000, 100, "item 2");

        equalsItems(itemOne, itemTwo);

    }

    public int getWeight() {
        return weight;
    }

    public int getCost() {
        return cost;
    }
}
