public class App {
    public static void main(String[] args) {
        System.out.println(encode("abc"));

    }

    public static String encode(String word) {
        System.out.println(word.length());
        char pos[] = new char[word.length()];
        for (int i = 0; i < word.length(); i++) {
            if (word.length() > 1) {
                if (word.length() % 2 == 0) {
                    if (i % 2 == 0) {
                        pos[(i + 2) % word.length()] = word.charAt(i);
                    } else {
                        pos[(i + 4) % word.length()] = word.charAt(i);
                    }
                } else {
                    if (i % 2 == 0) {
                        pos[(i + 1) % word.length()] = word.charAt(i);
                    } else {
                        if (i + 3 <= word.length()) {
                            pos[(i + 3) % word.length()] = word.charAt(i);
                        } else {
                            pos[(i + 4) % word.length()] = word.charAt(i);
                        }
                    }
                }
            }
        }
        int len = word.length();
        int shift = 0;
        for (int j = 0; j < 2; j++) {
            if (j == 0) {
                shift = len;
            } else {
                shift = shift * len;
            }
        }
        String fin = "";
        for (int k = 0; k < pos.length; k++) {

            char d = (char) ((pos[k] - 97 + shift) % 26 + 97);

            fin = fin + d;

        }

        return fin;

    }
}