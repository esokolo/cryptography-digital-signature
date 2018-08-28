import java.awt.*;
import java.io.*;
import java.math.BigInteger;
import java.util.BitSet;
import java.util.Random;
import java.util.Scanner;
/**
 * Created by rohangoel on 11/28/17.
 */
public class ChangeByte {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //DigitalSignature dg = new DigitalSignature();
        int index;
        System.out.println("Enter the File Name (.signed) :" );
        String filename = sc.nextLine();
        System.out.println("Message in File");
        messageKey readfile = DigitalSignature.readFile(filename);
        BigInteger bigInteger = readfile.getSignedBigInteger();
        byte[] array = bigInteger.toByteArray();
        if (array[0] == 0) {
            byte[] tmp = new byte[array.length - 1];
            System.arraycopy(array, 1, tmp, 0, tmp.length);
            array = tmp;
        }
        DigitalSignature.printByteArray(array);
        //DigitalSignature.printByteArray(readfile.getMessage());
     //   System.out.println(array.length);
        byte[] message = readfile.getMessage();
      //  System.out.println(message.length);


        DigitalSignature.printByteArray(readfile.getMessage());
        System.out.print("\nEnter the index (starting from 1) of byte you want to change: ");
        index = sc.nextInt();

        if(index <= 128)
        {
            array[index-1]= (byte) (index*Math.random());
            bigInteger = new BigInteger(array);
        }
        else {
            index = index-128;
            message[index] = (byte) (index*Math.random());
        }

        messageKey sendMessage = new messageKey(bigInteger, message);
        try {
            FileOutputStream sendMessageFile = new FileOutputStream(new File(filename));
            ObjectOutputStream sendMessageOut = new ObjectOutputStream(sendMessageFile);
            sendMessageOut.writeObject(sendMessage);
            System.out.println("Message Tampered Successfully. Try Receiving the file now.");
        }catch (Exception e){e.printStackTrace();}
    }
}
