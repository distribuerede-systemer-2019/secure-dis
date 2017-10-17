package Utility;


import java.security.MessageDigest;

public class Digester {

    private String salt;
    private static MessageDigest digester;

    public Digester() {
        this.salt = "test";
    }
    static {
        try {
            digester = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setSalt(String salt) {

        this.salt = salt;
    }

    /**
     * Hash string with MD5 hashing
     * @param str input string
     * @return MD5 hash of string
     */
    public  String hash(String str) {

        return Digester.performHashing(str);
    }

    /**
     * Hash string AND salt with MD5 hash
     * @param str input string
     * @return MD5 hashed of string
     */
    public String hashWithSalt(String str){

        //Alternativ løsningsforslag - Andys løsning
        // String test = Digester.performHashing(str + "prøve");
        // return test;

        str = str + this.salt;

        return Digester.performHashing(str);
    }

    /**
     * Performing MD5 hashing of string
     * @param test input
     * @return MD5 hash of string
     */
    private static String performHashing(String test){
        // vigtigste metode, som laver hash for os
        digester.update(test.getBytes());
        byte[] hash = digester.digest();
        StringBuilder hexString = new StringBuilder();
        for (byte aHash : hash) {
            if ((0xff & aHash) < 0x10) {
                hexString.append("0" + Integer.toHexString((0xFF & aHash)));
            } else {
                hexString.append(Integer.toHexString(0xFF & aHash));
            }
        }
        return hexString.toString();
    }

}
