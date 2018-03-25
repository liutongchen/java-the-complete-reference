class Box {
    double width;
    double height;
    double depth;

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

    double volumn() {
        return width * height * depth;
    }
}

class OverloadBoxes {
    public static void main(String[] args) {
        double vol1, vol2, vol3;

        Box box1 = new Box();
        Box box2 = new Box(2);
        Box box3 = new Box(1, 2, 3);

        vol1 = box1.volumn();
        vol2 = box2.volumn();
        vol3 = box3.volumn();
        System.out.println("box1: " + vol1 + " box2: " + vol2 + " box3: " + vol3);
    }
}