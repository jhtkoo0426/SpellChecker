/**
 * This class is dedicated to CW1 Question 2 & 3.
 * This class only contains the core parts of the Spell Checker.
 * The 5 additional classes, "stringProcesses", "fileProcesses", "generateSuggestions", "removeGrammarClass"
 * and "binarySearch" are used to assist this class.
 * NOTE: Punctuations will not appear in the output file.
 */

public class spellCheck
{
    public static Input in = new Input();

    // Method that asks the user for the input format (String/File).
    // Depending on the response, the program will carry out various actions. (See lines ___-___)
    public String inputOrFile()
    {
        System.out.println("Will you enter a string or pass a file into the program?");
        System.out.print("Type in 'string' or 'file': ");
        return in.nextLine();
    }

    // Method that asks the user for the target file's name.
    public String getFilename()
    {
        System.out.println("Please make sure the target document is within the /src directory!");
        System.out.print("Please enter the file name: ");
        return in.nextLine();
    }

    // Method that converts the 'words' file into a dictionary.
    public StringArray createDictionary()
    {
        StringArray dictionary = new StringArray();
        FileInput input = new FileInput("words");
        while (input.hasNextLine())
        {
            String s = input.nextLine();
            dictionary.add(s);
        }
        return dictionary;
    }

    // Method that checks if a word exists in the dictionary using binary search.
    // See the binarySearch class for details.
    public boolean checkExistsBinary(String word, StringArray dictionary)
    {
        int result = binarySearch.binarySearch(dictionary, word, 0, dictionary.size());
        // Returns false if word does not exist; otherwise returns true.
        return result >= 0;
    }

    // NOTE: THE METHODS BELOW ARE THE MAIN METHODS FOR THE SPELLCHECK ALGORITHM

    // Method that takes an unmatched word, generates a StringArray of all possible suggestions, then filters
    // suggestions that are not in the dictionary. See the generateSuggestions class for details.
    public StringArray filter(String unmatchedWord, StringArray dictionary)
    {
        StringArray suggestions = generateSuggestions.getSuggestions(unmatchedWord);
        StringArray finalSuggestions = new StringArray();
        for (int i = 0; i < suggestions.size(); i++)
        {
            if (checkExistsBinary(suggestions.get(i), dictionary))
            {
                finalSuggestions.add(suggestions.get(i));
            }
        }
        return finalSuggestions;
    }

    // Method for formatting results. It prints suggested words with better display.
    public StringArray findSuggestions(String unmatchedWord, StringArray dictionary)
    {
        StringArray finalArray = filter(unmatchedWord, dictionary);
        System.out.print("Unmatched Word: " + unmatchedWord);
        if (finalArray.isEmpty())
        {
            System.out.println(" | No suggestions ");
        }
        else
        {
            System.out.print(" | Suggestions: ");
            for (int j = 0; j < finalArray.size(); j++)
            {
                System.out.print(finalArray.get(j));
                if (j != finalArray.size() - 1)
                {
                    System.out.print(",");
                }
            }
            System.out.println("");
        }
        return finalArray;
    }

    // Method that allows user to choose a suggestion
    public String chooseSuggestion()
    {
        System.out.print("Enter your preferred suggestion: ");
        return in.nextLine();
    }

    // Method that writes the final, corrected version of the string/file to a new file.
    public void exportResult(StringArray targetArray)
    {
        FileOutput out = new FileOutput("src/output_result.txt");
        for (int i = 0; i < targetArray.size(); i++)
        {
            out.writeString(targetArray.get(i) + " ");
            if (i % 15 == 0 && i != 0)
            {
                out.writeEndOfLine();
            }
        }
        out.close();
    }

    // Method that counts and displays how many unmatched words were found.
    public void countUnmatchedWords(StringArray targetArray, StringArray dictionary)
    {
        int counter = 0;
        for (int i = 0; i < targetArray.size(); i++)
        {
            String targetWord = targetArray.get(i);
            // removeGrammarClass removes various patterns at the end of a word. See the removeGrammarClass for details.
            if (!removeGrammarClass.removeGrammar(targetWord, dictionary))
            {
                counter++;
            }
        }
        System.out.println("Found " + counter + " unmatched words.");
        System.out.println("=====================================================================");
    }

    // Method for running the core part of the spellCheck algorithm, including removing unnecessary grammar, return
    // suggestions, and allow users to enter their preferred correction.
    // This method will also return the final, corrected version of the string/ file details the user entered.
    public StringArray runAllSpellCheckMethods(StringArray targetArray)
    {
        StringArray dictionary = createDictionary();
        countUnmatchedWords(targetArray, dictionary);
        for (int i = 0; i < targetArray.size(); i++)
        {
            String targetWord = targetArray.get(i);
            // removeGrammarClass removes various patterns at the end of a word. See the removeGrammarClass for details.
            if (!removeGrammarClass.removeGrammar(targetWord, dictionary)) // Target word does not exist
            {
                StringArray suggestions = findSuggestions(targetWord, dictionary); // Generate Suggestions for the word
                if (!suggestions.isEmpty())
                {
                    String result = chooseSuggestion(); // Allows user to choose a suggestion
                    if (suggestions.contains(result))
                    {
                        targetArray.set(i, result);
                    }
                }
            }
        }
        return targetArray;
    }

    // Method that runs the whole spellCheck algorithm for a file
    public void runSpellCheckFile()
    {
        FileInput fileInput = fileProcesses.readFileInput(); // See the fileProcesses class for details
        StringArray extractedArray = fileProcesses.removePunctuationFile(fileInput); // See the fileProcesses class for details
        StringArray convertedArray = runAllSpellCheckMethods(extractedArray); // Main method for spellCheck
        exportResult(convertedArray);
        System.out.println("=====================================================================");
        System.out.println("The corrected file has been saved to src/output_result!");
    }

    // Method that runs the whole spellCheck algorithm for a string
    public void runSpellCheckString()
    {
        Input input = stringProcesses.readUserInput(); // See the stringProcesses class for details
        StringArray extractedArray = stringProcesses.removePunctuationString(input); // See the stringProcesses class for details
        StringArray convertedArray = runAllSpellCheckMethods(extractedArray); // Main method for spellCheck
        exportResult(convertedArray);
        System.out.println("=====================================================================");
        System.out.println("The corrected string has been saved to src/output_result!");
    }

    // Method that determines which type of input the user has given and carries out corresponding spellCheck methods.
    public void run()
    {
        System.out.println("              Spell Check Program (with suggested words)             ");
        System.out.println("=====================================================================");
        String user_choice = inputOrFile();
        if (user_choice.compareTo("file") == 0)
        {
            runSpellCheckFile();
        }
        else if (user_choice.compareTo("string") == 0)
        {
            runSpellCheckString();
        }
        else
        {
            System.out.println("Your response was invalid. Try again.");
        }
    }

    public static void main(String[] args)
    {
        new spellCheck().run();
    }
}
