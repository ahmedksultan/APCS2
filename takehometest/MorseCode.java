import java.util.*;

public class MorseCode {

  //Creating a dictionary, characters to morse code
  public static Map<Character, String> morse = new HashMap<Character, String>();

  public static void main(String[] args) {
    morse.put('a', ".-");
    morse.put('b', "-...");
    morse.put('c', "-.-.");
    morse.put('d', "-..");
    morse.put('e', ".");
    morse.put('f', "..-.");
    morse.put('g', "--.");
    morse.put('h', "....");
    morse.put('i', "..");
    morse.put('j', ".---");
    morse.put('k', "-.-");
    morse.put('l', ".-..");
    morse.put('m', "--");
    morse.put('n', "-.");
    morse.put('o', "---");
    morse.put('p', ".--.");
    morse.put('q', "--.-");
    morse.put('r', ".-.");
    morse.put('s', "...");
    morse.put('t', "-");
    morse.put('u', "..-");
    morse.put('v', "...-");
    morse.put('w', ".--");
    morse.put('x', "-..-");
    morse.put('y', "-.--");
    morse.put('z', "--..");

    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine().toLowerCase();
    if (input.charAt(0) == '.' || input.charAt(0) == '-') {
      System.out.println(translateToEnglish(input));
    }
    else {
      System.out.println(translateToMorse(input));
    }
  }

  //- . ... - >>> TEST

  public static String translateToEnglish(String input) {
    String result = "";
    String[] splitSnippets = input.split(" ");
    for (int i = 0; i < splitSnippets.length; i++) {
      if (splitSnippets[i] != " ") {
        result += analyze(splitSnippets[i]);
      }
    }
    return result;
  }

  public static String analyze(String snippet) {
    for (Character a: morse.keySet()) {
      if (morse.get(a).equals(snippet)) {
        return "" + a;
      }
    }
    return "";
  }

  public static String translateToMorse(String input) {
    String result = "";
    for (int i = 0; i < input.length(); i++) {
      if (input.charAt(i) != ' ') {
        result += morse.get(input.charAt(i)) + " ";
      }
      result += "";
    }
    return result;
  }

}
