import java.io.*;


class BufferReaderDemo {
    public static void main(String args[]) throws IOException {
        // ----- buffer reader ---------
//        String str;
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        System.out.println("Enter characters 'q' to quit.");
//        do {
//            str = br.readLine();
//            System.out.println("LINE: " + str);
//        } while (str != "q");

        // ------- read file ------------
        int i;
        FileInputStream fin = null;
        if (args.length != 1) {
            System.out.println("Input file name");
            return;
        }
        try {
            fin = new FileInputStream(args[0]);
            do {
                i = fin.read();
                if (i != -1) System.out.println((char) i);
            } while (i != -1);
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found.");
        } catch (IOException e) {
            System.out.println("An I/O Error occurs");
        } finally {
            try {
                if (fin != null) fin.close();
            } catch (IOException e) {
                System.out.println("Error closing file.");
            }
        }
    }
}