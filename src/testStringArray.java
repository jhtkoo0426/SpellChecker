import java.util.Arrays;

/**
 * Remember to remove this class after testing.
 * Make sure that everything works!
 */
public class testStringArray
{
    public static void main(String[] args)
    {
        System.out.println("- Test 0: StringArray Class copy constructor");
        StringArray stringArray = new StringArray();
        StringArray stringArrayCC = new StringArray(stringArray);

        System.out.println("- Test 1: size() method");
        stringArrayCC.add("test string");
        System.out.println(stringArrayCC.size());

        System.out.println("- Test 2: isEmpty() method");
        System.out.println(stringArrayCC.isEmpty());

        System.out.println("- Test 3: get() method");
        System.out.println(stringArrayCC.get(0));
        System.out.println(stringArrayCC.get(1));

        System.out.println("- Test 4: set() method");
        stringArrayCC.set(0, "set() method, Replaced string");
        stringArrayCC.set(1, "set() method check null works");
        System.out.println(stringArrayCC.get(0));
        System.out.println(stringArrayCC.get(1));

        System.out.println("- Test 5: add() method");
        stringArrayCC.add("Added string");
        System.out.println(stringArrayCC.get(0));
        System.out.println(stringArrayCC.get(1));
        System.out.println(stringArrayCC.get(2));

        System.out.println("- Test 6: insert() method");
        stringArrayCC.insert(1, "Inserted string");
        stringArrayCC.insert(-1, "negative index");
        System.out.println(stringArrayCC.get(0));
        System.out.println(stringArrayCC.get(1));
        System.out.println(stringArrayCC.get(2));
        System.out.println(stringArrayCC.get(3));

        System.out.println("- Test 7: remove() method");
        stringArrayCC.remove(1);
        for (int i = 0; i <= stringArrayCC.size(); i++)
        {
            System.out.println(stringArrayCC.get(i));
        }

        System.out.println("- Test 8: contains() method");
        System.out.println(stringArrayCC.contains("Added string"));

        System.out.println("- Test 9: containsMatchingCase() method");
        System.out.println(stringArrayCC.containsMatchingCase("Replaced string"));
        System.out.println(stringArrayCC.containsMatchingCase("replaced string"));
        System.out.println(stringArrayCC.containsMatchingCase("Added string"));
        System.out.println(stringArrayCC.containsMatchingCase("added string"));

        System.out.println("- Test 10: indexOf() method");
        stringArrayCC.add("Added string");
        for (int i = 0; i < stringArrayCC.size(); i++)
        {
            System.out.println(stringArrayCC.get(i));
        }
        System.out.println(stringArrayCC.indexOf("added string"));

        System.out.println("- Test 11: indexOfMatchingCase() method");
        System.out.println(stringArrayCC.indexOfMatchingCase("Replaced string"));
        System.out.println(stringArrayCC.indexOfMatchingCase("replaced string"));
        System.out.println(stringArrayCC.indexOfMatchingCase("Added string"));
        System.out.println(stringArrayCC.indexOfMatchingCase("added string"));

        System.out.println("- Test 12: Check insert() maximum case");
        for (int i = 2; i < 12; i++)
        {
            stringArrayCC.insert(i,"test insert to max");
        }
        for (int i = 0; i < stringArrayCC.size(); i++)
        {
            System.out.println(i + ": " + stringArrayCC.get(i));
        }

        System.out.println("- Test 13: Check insert() maximum case 2.0");
        stringArrayCC.insert(11, "insert one more");
        System.out.println("current size: " + stringArrayCC.size());
        for (int i = 0; i < stringArrayCC.size(); i++)
        {
            System.out.println(i + ": " + stringArrayCC.get(i));
        }
        System.out.println("- Test 14: Check add() maximum case (should increase array size and add)");
        stringArrayCC.add("just one more...");
        System.out.println(stringArrayCC.size());

        System.out.println("- Test 15: Check random stuff");
        System.out.println(stringArrayCC.containsMatchingCase("Test insert to max"));
        System.out.println(stringArrayCC.containsMatchingCase("test insert to max"));
        System.out.println(stringArrayCC.indexOf("Test insert to max"));
        System.out.println(stringArrayCC.indexOfMatchingCase("Test insert to max"));

        System.out.println("- Test 16: Test insert() at invalid index");
        stringArrayCC.insert(20, "test invalid insert");
        stringArrayCC.insert(10, "test invalid insert 2");
        for (int i = 0; i < 22; i++)
        {
            System.out.println(i + ": " + stringArrayCC.get(i));
        }
    }
}
