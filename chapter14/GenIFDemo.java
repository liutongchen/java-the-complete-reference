// A Min/Max interface
interface MinMax<T extends Comparable<T>> {
    T min();
    T max();
}

class MyClass<T extends Comparable<T>> implements MinMax<T> {
    T[] vals;

    MyClass(T[] o) { vals = o; }

    // Return the minimum value in vals
    public T min() {
        T v = vals[0];
        for (int i = 1; i < vals.length; i++) {
            if (vals[i].compareTo(v) < 0) {
                v = vals[i];
            }
        }
        return v;
    }

    public T max() {
        T v = vals[0];
        for (int i = 1; i < vals.length; i++) {
            if (vals[i].compareTo(v) > 0) {
                v = vals[i];
            }
        }
        return v;
    }
}

class GenIFDemo {
    public static void main(String[] args) {
        Integer[] numList = { 1, 2, 3 };
        Character[] charList = { 'b', 'd', 'k'};

        MyClass<Integer> iob = new MyClass<Integer>(numList);
        MyClass<Character> cob = new MyClass<Character>(charList);

        System.out.println("Max value in numList: " + iob.max());
        System.out.println("Min value in numList: " + iob.min());
        System.out.println("Max value in charList: " + cob.max());
        System.out.println("Min value in charList: " + cob.min());
    }
}