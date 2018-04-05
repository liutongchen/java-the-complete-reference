class Box {
    private double width;
    private double height;
    private double depth;

    //constructor used when no parameters specified
    Box() {
        width = height = depth = -1;
    }

    //constructor used when cube is created
    Box(double len) {
        width = height = depth = len;
    }

    //constructor used when all dimenstions specified
    Box(double w, double h, double d) {
        width = w;
        height = h;
        depth = d;
    }

    //constructor used when pass a box object
    Box(Box obj) {
        width = obj.width;
        height = obj.height;
        depth = obj.depth;
    }

    double volumn() {
        return width * height * depth;
    }
}

class BoxWeight extends Box {
    double weight;

    BoxWeight() {
        super();
        weight = -1;
    }

    BoxWeight(double len, double m) {
        super(len);
        weight = m;
    }

    BoxWeight(double w, double h, double d, double m) {
        super(w, h, d); // call superclass's constructor to initialize width, height and depth
        weight = m;
    }

    BoxWeight(BoxWeight obj) {
        super(obj);
        weight = obj.weight;
    }
}

class BoxDemo {
    public static void main(String args[]) {
        double vol;
        BoxWeight defaultBox= new BoxWeight();
        BoxWeight squareBox = new BoxWeight(4, 25);
        BoxWeight normalBox = new BoxWeight(1, 2, 3, 4);
        BoxWeight boxObj = new BoxWeight(squareBox);

        vol = defaultBox.volumn();
        System.out.println("Volumn of default box is: " + vol);
        System.out.println("Weight of default box is: " + defaultBox.weight);
        System.out.println("----------------------------------------");

        vol = squareBox.volumn();
        System.out.println("Volumn of square box is: " + vol);
        System.out.println("Weight of square box is: " + squareBox.weight);
        System.out.println("----------------------------------------");

        vol = normalBox.volumn();
        System.out.println("Volumn of normal box is: " + vol);
        System.out.println("Weight of normal box is: " + normalBox.weight);
        System.out.println("----------------------------------------");

        vol = boxObj.volumn();
        System.out.println("Volumn of boxObj is: " + vol);
        System.out.println("Weight of boxObj is: " + boxObj.weight);
        System.out.println("----------------------------------------");
    }
}