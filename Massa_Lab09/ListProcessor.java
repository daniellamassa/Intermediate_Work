
import java.util.ArrayList;

public class ListProcessor
{
    /**
     * Swaps elements i and j in the given list.
     */

    private void swap(ArrayList<String> aList, int i, int j)
    {
        String tmp = aList.get(i);
        aList.set(i, aList.get(j));
        aList.set(j, tmp);
    }

    /**
     * Finds the minimum element of a list and returns it.
     * Non-destructive (That means this method should not change aList.)
     *
     * @param aList the list in which to find the minimum element.
     * @return the minimum element of the list.
     */
    public String getMin(ArrayList<String> aList)
    {
        return getMin(aList, 0);
    }

    /**
     * private helper function that finds the minimum element of a list and returns it.
     * @param aList  the list in which to find the minimum element.
     * @param startingIndex position to start considering at.
     * @return the minimum element of the list.
     */
    private String getMin(ArrayList<String> aList, int startingIndex){
        if (aList.size()-1 == startingIndex) {
            return aList.get(startingIndex);
        }
        else {
            String minElement = getMin(aList, startingIndex+1);
            if (aList.get(startingIndex).compareTo(minElement)>0) {
                return minElement;
            }
            else {
                return aList.get(startingIndex);
            }
        }
    }

    /**
     * Finds the minimum element of a list and returns the index of that
     * element. If there is more than one instance of the minimum, then
     * the lowest index will be returned.  Non-destructive.
     *
     * @param aList the list in which to find the minimum element.
     * @return the index of the minimum element in the list.
     */
    public int getMinIndex(ArrayList<String> aList)
    {
        return getMinIndex(aList, 0);
    }

    /**
     * private helper function that finds the minimum element of a list and returns the index of that element.
     * If there is more than one instance of the minimum, then the lowest index will be returned.
     * @param aList the list in which to find the minimum element
     * @param startingIndex position to start considering at.
     * @return the index of the minimum element in the list.
     */
    private int getMinIndex(ArrayList<String> aList, int startingIndex){

        if (aList.size()-1 == startingIndex) {
            return startingIndex;
        }
        else {
            int minIndex = getMinIndex(aList, startingIndex+1);
            if (aList.get(startingIndex).compareTo(aList.get(minIndex)) > 0) {
                return minIndex;
            }
            else {
                return startingIndex;
            }
        }
    }

    /**
     * Sorts a list in place. I.E. the list is modified so that it is in order.
     *
     * @param aList: the list to sort.
     */
    public void sort(ArrayList<String> aList)
    {
        sort(aList, 0);
    }

    /**
     * Sorts a list in place. Modifies the original list, does not create new ones.
     * @param aList the list to sort
     * @param startingIndex position to start considering at.
     */
    private void sort(ArrayList<String> aList, int startingIndex){
        if (aList.size()-1 == startingIndex) {
            return;
        }
        else {
            int minIndex = getMinIndex(aList, startingIndex);
            if (minIndex != startingIndex) {
                swap(aList, minIndex, startingIndex);
                sort(aList, startingIndex+1);
            }else{
                sort(aList, startingIndex+1);
            }
        }
    }
}
    

