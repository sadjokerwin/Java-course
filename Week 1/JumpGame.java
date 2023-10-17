public class JumpGame {
    public static boolean canWin(int[] array) {
        return canWinHelper(array, 0);
    }

    public static boolean canWinHelper(int[] array, int position) {
        if (position == array.length - 1) {
            return true;
        }
        int maxSteps = array[position];
        for (int i = 1; i <= maxSteps; i++) {
            int nextPosition = position + i;
            if (canWinHelper(array, nextPosition)) {
                return true;
            }
        }
        return false;
    }

}
