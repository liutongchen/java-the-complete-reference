class AbstractClassDemo {
    public static void main(String args[]) {
        Rectangle rect = new Rectangle(1, 2);
        Triangle tri = new Triangle(3, 4);
        Figure f;

        f = rect;
        System.out.println("Rectangle area: " + f.area());
        System.out.println("-----------------------------");

        f = tri;
        System.out.println("Triangle area: " + f.area());
    }
}

abstract class Figure {
    double dim1;
    double dim2;

    Figure(double a, double b) {
        dim1 = a;
        dim2 = b;
    }

    abstract double area();
}

class Rectangle extends Figure {
    Rectangle(double a, double b) {
        super(a, b);
    }

    double area() {
        System.out.println("Inside rectangle");
        return dim1 * dim2;
    }
}

class Triangle extends Figure {
    Triangle(double a, double b) {
        super(a, b);
    }

    double area() {
        System.out.println("Inside triangle");
        return dim1 * dim2 / 2;
    }
}