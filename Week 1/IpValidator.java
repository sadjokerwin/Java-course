public class IpValidator{
    public static boolean validateIPv4Address(String str)        {
        String[] tokens = str.split("\\.");
//        System.out.println(tokens.length);
        if(tokens.length != 4) return false;
        else {
            for(int i =0; i<4; i++)
            {
                if(Integer.parseInt(tokens[i])==0)
                {
                    return tokens[i].length() == 1;
                }
                else if(Integer.parseInt(tokens[i]) < 0 || Integer.parseInt(tokens[i]) > 255) {
//                    System.out.println(Integer.parseInt(tokens[i]));
                    return false;
                }
            }
            return true;
        }
    }
    public static void testStr(String str)
    {
        System.out.println(Integer.parseInt(str));
    }
}

