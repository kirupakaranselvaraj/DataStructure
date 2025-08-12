package Array;

public class ToggleCaseConverter {
    public static void main(String[] args) {

        String name = "Kirupakaran";
        String emp = "";
        char[] arr = name.toCharArray();

        for (char i : arr) {
            if (i >= 'A' && i <= 'Z') {
                emp += (char) (i + 32);
            } else if (i >= 'a' && i <= 'z') {
                emp += (char) (i - 32);
            } else if (i == ' ') {
                emp += " ";
            }
        }
        System.out.println(emp);
    }
}
