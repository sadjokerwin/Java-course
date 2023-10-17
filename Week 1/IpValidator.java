public class IPValidator {
    public static boolean validateIPv4Address(String str) {
        if (str.isEmpty()) return false;
        else if (str.toCharArray()[0] == '.') return false;
        String[] tokens = str.split("\\.");
//        System.out.println(tokens.length);
        if (tokens.length != 4) return false;
        else {
            for (int i = 0; i < 4; i++) {
                if (tokens[i].length() > 3) return false;
                else if (Integer.parseInt(tokens[i]) == 0) {
                    return tokens[i].length() == 1;
                } else if (Integer.parseInt(tokens[i]) < 0 || Integer.parseInt(tokens[i]) > 255) {
//                    System.out.println(Integer.parseInt(tokens[i]));
                    return false;
                }
            }
            return true;
        }
    }

}

