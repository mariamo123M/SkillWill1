import java.lang.reflect.Array;
import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ArrayList<String> words = new ArrayList<>();

        words.add("Love");
        words.add("Horse");
        words.add("Lucky");
        words.add("Moon");
        words.add("Dog");
        words.add("Goat");
        words.add("Happy");
        words.add("sun");
        words.add("mountain");
        words.add("Star");

        for (int i = 0; i<words.size(); i++) {
            System.out.println(words.get(i));

        }
    }
}