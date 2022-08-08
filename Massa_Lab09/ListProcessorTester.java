/**
 * Driver for Lab 9
 * @author: Dani Massa
 *
 * 'I affirm that I have carried out the attached academic endeavors with full academic honesty,
 * in accordance with the Union College Honor Code and the course syllabus.'
 **/

import java.util.ArrayList;
import java.util.Arrays;

public class ListProcessorTester
{
    public static void main(String [] args)
    {
        Testing.setVerbose(true);
        Testing.startTests();
        getMinTests();
        sortTests();
        Testing.finishTests();
    }

    public static void getMinTests()
    {
        Testing.testSection("Testing getMin and getMinIndex");
        
        ListProcessor lp = new ListProcessor();
        
        String[] strings = {"b", "e", "a", "d", "g", "k", "c", "r", "t", "v", "a", "c", "b"};

        ArrayList<String> originalList = new ArrayList<String>(Arrays.asList(strings));
        ArrayList<String> myList = new ArrayList<String>(originalList);
        // makes a copy of originalList

        
        String smallest = lp.getMin(myList);
        Testing.assertEquals("The minimum of a list of strings is the first in alphabetical order",
                       "a",
                       smallest);

        Testing.assertEquals("getMin should not modify myList",
                       originalList,
                       myList);

        Testing.assertEquals("getMinIndex should return the index of the first occurrence of the min element",
                       2,
                       lp.getMinIndex(myList));
    }

    public static void sortTests()
    {
        Testing.testSection("Testing sort");
        
        ListProcessor lp = new ListProcessor();
        
        String[] strings = {"b", "e", "a", "d", "g", "k", "c", "r", "t", "v", "a", "c", "b"};

        ArrayList<String> myList = new ArrayList<String>(Arrays.asList(strings));

        lp.sort(myList);

        String[] sortedStrings = {"a", "a", "b", "b", "c", "c", "d", "e", "g", "k", "r", "t", "v"};
        ArrayList<String> sortedList = new ArrayList<String>(Arrays.asList(sortedStrings));
        Testing.assertEquals("sort puts list in alphabetic order",
                       sortedList,
                       myList);
    }
}
