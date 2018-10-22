package Utility;


import java.security.MessageDigest;

public class Digester {

    private String salt = "ThisIsMySalt!";
    private static MessageDigest digester;

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

        return Digester.performHashing(str+this.salt);
    }

    /**
     * Performing MD5 hashing of string
     * @param str input
     * @return MD5 hash of string
     */
    private static String performHashing(String str){
        digester.update(str.getBytes());
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
