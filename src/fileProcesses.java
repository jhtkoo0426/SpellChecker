/**
 * This class deals with taking an input file and removing punctuations from it.
 */
public class fileProcesses
{
    // Method that returns a FileInput, and is used in the "removePunctuationFile" method.
    // NOTE: The target file should be saved in the src/ directory.
    public static FileInput readFileInput()
    {
        String filename = new spellCheck().getFilename();
        return new FileInput("src/" + filename);
    }

    public static StringArray removePunctuationFile(FileInput input)
    {
        StringArray fileArr = new StringArray();
        while (input.hasNext())
        {
            String s = input.next();
            s = s.replaceAll("[^a-zA-Z- ]", ""); // Remove non-alphabetic characters
            fileArr.add(s);
        }
        System.out.println("=====================================================================");
        System.out.println("[CONFIRM MESSAGE] File contents have been converted into StringArray.");
        System.out.println("=====================================================================");
        input.close();
        return fileArr;
    }
}
