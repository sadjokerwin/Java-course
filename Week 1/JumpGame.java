public class JumpGame {
    public static boolean canWin(int[] array)
    {
        int counter = 0;
        while(array[counter]!=0 && counter > array.length) counter += array[counter];
        return counter == array.length-1;
    }
}
