import java.util.ArrayList;

public class MaxNumber {
    public static int findMax(ArrayList<Integer> listE, ArrayList<Integer> listL) {
        int maxE = Integer.MIN_VALUE;
        int maxL = Integer.MIN_VALUE;

        for (int num : listE) {
            if (num > maxE) {
                maxE = num;
            }
        }
        for (int num : listL) {
            if (num > maxL) {
                maxL = num;
            }
        }
        return Math.max(maxE, maxL);
    }
    public static void main (String[] args) {
        ArrayList<Integer> listE = new ArrayList<>();
        listE.add(1);
        listE.add(3);
        listE.add(9);

        ArrayList<Integer> listL = new ArrayList<>();
        listL.add(8);
        listL.add(4);
        listL.add(7);
            System.out.println("The largest number is:" +findMax(listE, listL));
    }
}