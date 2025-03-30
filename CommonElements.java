import java.beans.PropertyEditorSupport;
import java.util.HashSet;
import java.util.Set;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class CommonElements {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        set1.add(3);
        set1.add(4);
        set1.add(9);
        set1.add(7);

        set2.add(9);
        set2.add(4);
        set2.add(24);
        set2.add(12);

        Set<Integer> common = findCommonElements(set1, set2);
        System.out.println("CommonElements: " + common);
    }
    public static Set<Integer> findCommonElements(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> result = new HashSet<>();
        for (Integer num : set1) {
            if (set2.contains(num)) {
                result.add(num);
            }
        }
        return result;
    }
}

