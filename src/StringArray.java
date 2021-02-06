import java.sql.SQLOutput;

/**
 * This class is dedicated to CW1 Question 1.
 */

public class StringArray
{
    // Instance Variables
    private String[] arr;
    private int max_size = 100;
    private int strArrLength;

    public StringArray()
    {
        this.arr = new String[max_size];
        this.strArrLength = 0;
    }

    public StringArray(StringArray a)
    {
        this.arr = a.arr;
    }

    // I added 4 additional public methods (checkUserNull, increaseArrSize, checkValidIndex & getLastIndex)

    // Additional method to check if the user entered a "null" value manually.
    // This "null" value will be treated as a valid element of the array.
    public boolean checkUserNull(String s)
    {
        if (s != null)
        {
            if (s.compareTo("null") == 1)
            {
                return true;
            }
        }
        return false;
    }

    // Additional method to increase the array size
    // Reference: https://www.tutorialspoint.com/how-to-resize-an-array-in-java
    public Object increaseArrSize(Object oldArr, int newSize)
    {
        int oldsize = java.lang.reflect.Array.getLength(oldArr);
        Class elementType = oldArr.getClass().getComponentType();
        Object newArr = java.lang.reflect.Array.newInstance(elementType, newSize);
        int preserveLen = Math.min(oldsize, newSize);
        if (preserveLen > 0)
        {
            System.arraycopy(oldArr, 0, newArr, 0, preserveLen);
        }
        max_size = max_size * 2;
        return newArr;
    }

    // Additional method to check if the index entered is valid
    public boolean checkValidIndex(int index)
    {
        return index >= 0 && index <= strArrLength;
    }

    // Additional method that returns the index of the last non-null element
    // (excluding "null" entered by user)
    public int getLastIndex()
    {
        int lastIndex = 0;
        for (int i = 0; i < size(); i++)
        {
            if (checkUserNull(arr[i]) || arr[i] != null)
            {
                lastIndex = i;
            }
        }
        return lastIndex;
    }

    public int size()
    {
        return strArrLength;
    }

    public boolean isEmpty()
    {
        return size() == 0;
    }

    public String get(int index)
    {
        if (checkValidIndex(index))
        {
            return arr[index];
        }
        else
        {
            return null;
        }
    }

    public void set(int index, String s)
    {
        if (arr[index] != null && checkValidIndex(index))
        {
            arr[index] = s;
        }
    }

    public void add(String s)
    {
        if (strArrLength + 1 <= max_size)
        {
            this.arr[strArrLength] = s;
            strArrLength++;
        }
        else
        {
            this.arr = (String[]) increaseArrSize(this.arr, max_size*2);
            arr[strArrLength] = s;
            strArrLength++;
        }
    }

    public void insert(int index, String s)
    {
        if (checkValidIndex(index))
        {
            for (int i = strArrLength; i >= index; i--)
            {
                if (i+1 > strArrLength)
                {
                    this.arr = (String[]) increaseArrSize(this.arr, max_size*2);
                }
                arr[i+1] = arr[i];
            }
            arr[index] = s;
            strArrLength++;
        }
    }

    public void remove(int index)
    {
        if (checkValidIndex(index))
        {
            for (int i = index; i < strArrLength; i++)
            {
                arr[i] = arr[i+1];
            }
            strArrLength--;
        }
    }

    public boolean contains(String s)
    {
        for (int i = 0; i <= strArrLength; i++)
        {
            if (get(i) != null)
            {
                if (s.toLowerCase().compareTo(get(i).toLowerCase()) == 0)
                {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean containsMatchingCase(String s)
    {
        for (int i = 0; i <= strArrLength; i++)
        {
            if (get(i) != null)
            {
                if (s.compareTo(get(i)) == 0)
                {
                    return true;
                }
            }
        }
        return false;
    }

    public int indexOf(String s)
    {
        for (int i = 0; i <= strArrLength; i++)
        {
            if (s.toLowerCase().compareTo(get(i).toLowerCase()) == 0)
            {
                return i;
            }
        }
        return -1;
    }

    public int indexOfMatchingCase(String s)
    {
        for (int i = 0; i <= strArrLength; i++)
        {
            if (get(i) != null)
            {
                if (s.compareTo(get(i)) == 0)
                {
                    return i;
                }
            }
        }
        return -1;
    }
}
