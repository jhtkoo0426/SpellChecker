/**
 * This class implements binary search for finding a certain word in the dictionary.
 */

public class binarySearch
{
    public static int binarySearch(StringArray dictionary, String word, int low, int high)
    {
        if (high <= low) { return -1; }

        int mid = low + (high - low) / 2;
        int result_index = dictionary.get(mid).toLowerCase().compareTo(word);
        if (result_index > 0)
        {
            return binarySearch(dictionary, word, low, mid);
        }
        else if (result_index < 0)
        {
            return binarySearch(dictionary, word, mid+1, high);
        }
        else { return mid; }
    }
}
