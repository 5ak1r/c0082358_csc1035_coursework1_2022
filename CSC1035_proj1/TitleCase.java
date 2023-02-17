// I got this code from StackOverflow at the following link:
//https://stackoverflow.com/questions/1086123/is-there-a-method-for-string-conversion-to-title-case
package CSC1035_proj1;

public final class TitleCase {

    public static String toTitleCase(String input) {

        StringBuilder titleCase = new StringBuilder(input.length());
        boolean nextTitleCase = true;

        for (char c : input.toLowerCase().toCharArray()) {
            if (!Character.isLetterOrDigit(c)) {
                nextTitleCase = true;
            } else if (nextTitleCase) {
                c = Character.toTitleCase(c);
                nextTitleCase = false;
            }
            titleCase.append(c);
        }

        return titleCase.toString();
    }

}