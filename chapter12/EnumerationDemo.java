
/**
 * EnumerationDemo
 */

public class EnumerationDemo {
    private enum Apple {
        Johnathon(1), GoldenDel(2), RedDel(3), Winesap(4), Cortland(5);

        private int price;

        Apple(int p) {
            price = p;
        }

        public int getPrice() {
           return price; 
        }
    }
    
    public static void main(String[] args) {
        Apple ap;
        System.out.println("Here are all Apple constants: ");

        // use values()
        for (Apple a : Apple.values()) {
            System.out.println(a + " has price: " + a.getPrice());
        }
        System.out.println();

        // use valueOf()
        ap = Apple.valueOf("Winesap");
        System.out.println("ap contains " + ap);

        // use ordinal()
        System.out.println("Order of Johnathon: " + Apple.Johnathon.ordinal());

        // use compareTo()
        if (Apple.Johnathon.compareTo(Apple.Winesap) < 0) {
            System.out.println("Johnathon comes before Winesap");
        }

        // use equals()
        if (Apple.Johnathon.equals(Apple.Johnathon)) {
            System.out.println("This is a stupid comparison");
        }
    }
}