/**
 * This class deals with plural/ing-form of words.
 * It can only remove words that end with "s", "ing", "ings", "ies", "es" and "ves" at the moment.
 */

public class removeGrammarClass
{
    public static String removeS(String target)
    {
        target = target.replaceAll("s$", "");
        return target;
    }

    public static String removeIng(String target)
    {
        target = target.replaceAll("ing$", "");
        return target;
    }

    public static String removeIngs(String target)
    {
        target = target.replaceAll("ings$", "");
        return target;
    }

    public static String removeEs(String target)
    {
        target = target.replaceAll("es$", "");
        return target;
    }

    public static String replaceIes(String target)
    {
        target = target.replaceAll("ies$", "y");
        return target;
    }

    public static String replaceVesF(String target)
    {
        target = target.replaceAll("ves$", "f");
        return target;
    }

    // For special cases like "life", "knife"
    public static String replaceVesFe(String target)
    {
        target = target.replaceAll("ves$", "fe");
        return target;
    }

    public static boolean removeGrammar(String target, StringArray dictionary)
    {
        String resS = removeS(target); // Target that only ends with "s"
        String resIng = removeIng(target); // Target that only ends with "ing"
        String resIngs = removeIngs(target); // Target that only ends with "ings"
        String resEs = removeEs(target); // Target that only ends with "es"
        String resIes = replaceIes(target); // Target that only ends with "ies"
        String resVesF = replaceVesF(target); // Target that only ends with "ves", replaces with "f"
        String resVesFe = replaceVesFe(target); // Target that only ends with "ves", replaces with "fe"

        return dictionary.contains(resS) || dictionary.contains(resIng) || dictionary.contains(resIngs) ||
                dictionary.contains(resEs) || dictionary.contains(resIes) || dictionary.contains(resVesF) ||
                dictionary.contains(resVesFe);
    }
}
