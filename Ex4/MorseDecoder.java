import java.util.Objects;

public class MorseDecoder
{
    BTree<String> morseTree;
// An empty default builder that initializes a tree according to a Morse code.
   public MorseDecoder()
    {
        this.morseTree = new BTree<String>();
        morseTree.addByPath("start", "");
        morseTree.addByPath("E", "L");
        morseTree.addByPath("I", "LL");
        morseTree.addByPath("S", "LLL");
        morseTree.addByPath("H", "LLLL");
        morseTree.addByPath("V", "LLLR");
        morseTree.addByPath("U", "LLR");
        morseTree.addByPath("F", "LLRL");
        morseTree.addByPath("A", "LR");
        morseTree.addByPath("R", "LRL");
        morseTree.addByPath("L", "LRLL");
        morseTree.addByPath("W", "LRR");
        morseTree.addByPath("P", "LRRL");
        morseTree.addByPath("J", "LRRR");
        morseTree.addByPath("T", "R");
        morseTree.addByPath("N", "RL");
        morseTree.addByPath("D", "RLL");
        morseTree.addByPath("B", "RLLL");
        morseTree.addByPath("X", "RLLR");
        morseTree.addByPath("K", "RLR");
        morseTree.addByPath("C", "RLRL");
        morseTree.addByPath("Y", "RLRR");
        morseTree.addByPath("M", "RR");
        morseTree.addByPath("G", "RRL");
        morseTree.addByPath("Z", "RRLL");
        morseTree.addByPath("Q", "RRLR");
        morseTree.addByPath("O", "RRR");
    }
// Prints a string that represents the Morse tree by pre-order printing.
    public String toString()
    {
        return this.morseTree.pre();
    }
// The method accepts as a parameter a Morse string consisting of dots and characters only.
// The method returns the string of the letter represented by the string.
    public String decode(String morseStr)
    {
        String result = morseTree.findByPath(replaceMorseToLetters(morseStr));
        if (result == null || result.length() > 1)
            return "";
        else return result;
    }
// A private method that replaces the characters line and point with the characters 'R' and 'L'.
    private String replaceMorseToLetters(String morse)
    {
        if (morse == null || morse.equals("") || morse.contains("R") || morse.contains("L"))
            return "";
        return morse.replace('.', 'L').replace('-', 'R');
    }
}
