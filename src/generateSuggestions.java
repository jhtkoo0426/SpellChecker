/**
 * This class creates a StringArray of suggestions for the user to choose from.
 * The current implementation only adds/removes/replaces one character or swap adjacent characters of a word.
 */

public class generateSuggestions
{
    public static String alphabets = "abcdefghijklmnopqrstuvwxyz";

    // Method that inserts a character at any index in the targeted word.
    public static StringArray addChar(String target)
    {
        StringArray foundWordsAdd = new StringArray();
        for (int i = 0; i < alphabets.length(); i++)
        {
            char alphabet = alphabets.charAt(i);
            for (int j = 0; j < target.length(); j++)
            {
                StringBuilder sb = new StringBuilder(target);
                sb.insert(j, alphabet);
                foundWordsAdd.add(sb.toString());
            }
        }
        return foundWordsAdd;
    }

    // Method that swaps adjacent characters in the targeted word
    // Characters are only swapped once per iteration
        // E.g. Target = "alpahbte", result can only be either "alphabte" or alpahbet", but not "alphabet".
    public static StringArray swapChar(String target)
    {
        StringArray foundWordsSwap = new StringArray();
        char[] c = target.toCharArray();
        for (int i = 0; i < target.length(); i++)
        {
            for (int j = 0; j < target.length(); j++)
            {
                char temp = c[i];
                if (i - j == 1 || j - i == 1) // Ensure adjacent characters are swapped
                {
                    c[i] = c[j];
                    c[j] = temp;
                    String swappedTarget = new String(c);
                    if (!foundWordsSwap.contains(swappedTarget))
                    {
                        foundWordsSwap.add(swappedTarget);
                    }
                }
            }
        }
        return foundWordsSwap;
    }

    public static StringArray removeChar(String target)
    {
        StringArray foundWordsChar = new StringArray();
        for (int i = 0; i < target.length(); i++)
        {
            String removed = target.substring(0, i) + target.substring(i+1);
            foundWordsChar.add(removed);
        }
        return foundWordsChar;
    }

    public static StringArray replaceChar(String target)
    {
        StringArray foundWordsReplace = new StringArray();
        for (int i = 0; i < target.length(); i++)
        {
            for (int j = 0; j < alphabets.length(); j++)
            {
                StringBuilder sb = new StringBuilder(target);
                sb.setCharAt(i, alphabets.charAt(j));
                foundWordsReplace.add(sb.toString());
            }
        }
        return foundWordsReplace;
    }

    // Long method that collects all suggestions for each possible case (add,remove,replace,swap) and returns results as
    // a StringArray.
    public static StringArray getSuggestions(String target)
    {
        StringArray generatedSuggestions = new StringArray();

        StringArray addResults = addChar(target); // Generated results from adding a character at any position
        for (int i = 0; i < addResults.size(); i++)
        {
            generatedSuggestions.add(addResults.get(i));
        }

        StringArray swapResults = swapChar(target); // Generated results from swapping 2 adjacent characters.
        for (int i = 0; i < swapResults.size(); i++)
        {
            generatedSuggestions.add(swapResults.get(i));
        }

        StringArray removeResults = removeChar(target); // Generated results from removing a character.
        for (int i = 0; i < removeResults.size(); i++)
        {
            generatedSuggestions.add(removeResults.get(i));
        }

        StringArray replaceResults = replaceChar(target); // Generated results from replacing a character.
        for (int i = 0; i < replaceResults.size(); i++)
        {
            generatedSuggestions.add(replaceResults.get(i));
        }
        return generatedSuggestions;
    }
}
