
public class Number {
    public static void main(String[] args) {
        int num = 3;
        int num1 = 5;
        int result = 2;

        for (int i = 1; i < num1; i++) {
          result *= num;
        }
        System.out.println("for:"+result);
    }
}