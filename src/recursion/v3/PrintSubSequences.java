package recursion.v3;

public class PrintSubSequences {

    public static void main(String[] args) {

        String s = "abc";
        printSubSequences(s, "");
    }

    private static void printSubSequences(String input, String output) {
        if(input.isEmpty()) {
            System.out.println(output);
            return;
        }

        printSubSequences(input.substring(1), output );
        printSubSequences(input.substring(1), output + input.charAt(0));
    }
}
