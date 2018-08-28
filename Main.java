/**
 * Created by rohangoel on 11/30/17.
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean isContinue = true;
        int option;
        String filename;
        Scanner sc = new Scanner(System.in);
        DigitalSignature dg = new DigitalSignature();
        while(isContinue){
            System.out.println("Please Select the Functionality from Menu options");
            System.out.println("1. Send ");
            System.out.println("2. Receive ");
            System.out.println("3. Exit ");
            option = sc.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Enter the file name: (.txt): ");
                    filename = sc.next();
                    System.out.println(filename);
                    dg.send(filename);
                    break;
                case 2:
                    System.out.println("Enter the file name: (.txt.signed): ");
                    filename = sc.next();
                    dg.receive(filename);
                    break;
                case 3:
                    isContinue = false;
                    break;
                default:
                    System.out.println("No such Option! Please Select the Correct Option");
                    break;
            }
        }
    }
}
