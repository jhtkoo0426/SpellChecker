/**
 * This class deals with taking a user input and removing punctuations from it.
 */
public class stringProcesses
{
    // Method that returns an Input, and is used in the "removePunctuationString" method.
    public static Input readUserInput()
    {
        Input in = new Input();
        System.out.print("Enter a string: ");
        return in;
    }

    public static StringArray removePunctuationString(Input input)
    {
        String user_string = input.nextLine();

        StringArray stringArray = new StringArray();
        String[] res = user_string.split(" ");
        for (int i = 0; i < res.length; i++)
        {
            res[i] = res[i].replaceAll("[^a-zA-Z- ]", ""); // Remove non-alphabetic characters
            stringArray.add(res[i]);
        }
        System.out.println("=====================================================================");
        System.out.println("[CONFIRM MESSAGE] String contents have been converted into StringArray.");
        System.out.println("=====================================================================");
        return stringArray;
    }
}
