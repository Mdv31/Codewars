/***
 * Write a function that takes in a string of one or more words, and returns the same string,
 * but with all five or more letter words reversed (Just like the name of this Kata).
 * Strings passed in will consist of only letters and spaces. Spaces will be included only when more than one word is present.
 *
 * Examples: spinWords( "Hey fellow warriors" ) => returns "Hey wollef sroirraw" spinWords( "This is a test") =>
 * returns "This is a test" spinWords( "This is another test" )=> returns "This is rehtona test"
 */


public class SpinWords {

    public String spinWords(String sentence) {
        //TODO: Code stuff here
        String outText = "";
        String[] words = sentence.split(" ");

        for (String word : words)
            if (word.length() < 5) {
                if (outText.contentEquals("")) outText = word;
                else outText = outText + " " + word;
            } else {
                if (outText.contentEquals("")) outText = new StringBuilder(word).reverse().toString();
                else outText = outText + " " + new StringBuilder(word).reverse();
            }
        return outText;
    }
}