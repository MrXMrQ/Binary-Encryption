public class Main {
    public static void main(String[] args) {
        String plaintext = "HalloWelt";
        String encryptText = encrypt(plaintext);
        String decryptText = decrypt(encryptText, plaintext.length());

        System.out.println(plaintext.toLowerCase());
        System.out.println(encryptText);
        System.out.println(decryptText);

        char c = ' ';
        System.out.println(c);
    }

    public static String encrypt(String text) {
        text = text.toLowerCase();
        StringBuilder encryptText = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            int ascii = text.charAt(i);
            String binary = Integer.toBinaryString(ascii);
            System.out.println(binary);
            for (int j = 0; j < binary.length(); j++) {
                if (binary.charAt(j) == '1') encryptText.append("-");
                else encryptText.append(".");
            }
        }
        return encryptText.toString();
    }

    public static String decrypt(String text, int length) {
        StringBuilder binaryValue = new StringBuilder();

        char[] binary = new char[text.length()];
        char[] decrypt = new char[length];

        int index = 0;

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == '-') binary[i] = '1';
            else binary[i] = '0';

            binaryValue.append(binary[i]);

            if (binaryValue.length() == 7) {
                int value = Integer.parseInt(binaryValue.toString(), 2);
                decrypt[index] = (char) (value);

                binaryValue = new StringBuilder();
                index++;
            }

        }
        return new String(decrypt);
    }
}