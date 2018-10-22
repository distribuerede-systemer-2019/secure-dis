package Utility;

public final class Encryption {

    public static String encryptDecryptXOR(String rawString) {

        char[] key = {'C', 'B', 'S'};

        // Stringbuilder enables you to play around with strings and make useful stuff
        StringBuilder thisIsEncrypted = new StringBuilder();

        for (int i = 0; i < rawString.length(); i++) {
            thisIsEncrypted.append((char) (rawString.charAt(i) ^ key[i % key.length]));
        }

        // We return the encrypted string
        return thisIsEncrypted.toString();
    }
}
