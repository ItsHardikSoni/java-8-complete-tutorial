import java.util.ArrayList;
import java.util.Arrays;

class ArrayToArrayList {
    public static void main(String[] args) {
        String[] languages = {"Java", "Python", "C++"};
        ArrayList<String> list = new ArrayList<>(Arrays.asList(languages));
        System.out.println(list);
    }
}
