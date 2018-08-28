/**
 * Created by rohangoel on 11/25/17.
 */

import java.math.BigInteger;
import java.security.*;

public class MD {
    public static void main(String[] args) throws Exception {
        String S1 = new String("Here is the original string!  Cool!");


        MessageDigest message = MessageDigest.getInstance("MD5");


        byte[] bytes = S1.getBytes();

        message.update(bytes);

        byte[] digest = message.digest();

        System.out.println(digest.length);

        BigInteger bigInteger = new BigInteger(1, digest);
        //System.out.println("Equal");
    }
}

