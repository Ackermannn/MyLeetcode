package HJ5_进制转换;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()){

            String a = scan.next();
            System.out.println(Integer.decode(a));
        }
    }
}
