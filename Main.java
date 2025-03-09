//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        int a = 2;
        int b = 3;
        int d = 1;
        int i = 1;

        while (i < b){
            i ++;
            d *= a;
        }
            System.out.println("while:" + d);
    }
}