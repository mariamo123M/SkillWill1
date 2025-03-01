//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static int sumOfStringLenghts (String str1, String str2, String str3) {
        return str1.length() + str2.length() + str3.length();
    }
    public static void main(String[] args) {
        System.out.println("total lenght:" + sumOfStringLenghts("Hello", "Dear", "Friend" ));
    }
}