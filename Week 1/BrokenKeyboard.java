public class BrokenKeyboard {
    public static int calculateFullyTypedWords(String message, String brokenKeys) {
        if(message.isEmpty()) return 0;

        String[] tokens;
        if (message.split("\\s+").length == 0) return 0;
        else tokens = message.trim().split("\\s+");

        char[] letters = brokenKeys.toCharArray();
        int result = tokens.length;
        for (int i = 0; i < tokens.length; i++) {
            for (int j = 0; j < letters.length; j++) {
                if (tokens[i].indexOf(letters[j]) >= 0) {
                    result--;
                    break;
                }
            }

        }
        return result;
    }
}
