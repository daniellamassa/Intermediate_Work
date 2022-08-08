public class RecursionTester {


    public int findBest(int[] list, int startingIndex, int best) {
        if (startingIndex == list.length) {
            return best;
        }else {
            if (list[startingIndex] > best) {
                best = list[startingIndex];
                startingIndex += 1;

                return findBest(list, startingIndex, best);
            }
            else{
                startingIndex += 1;
                return findBest(list, startingIndex, best);
            }
        }
    }

    /*


    public void reverse(int[] someList) {
        reverse(someList, 0);


    }

     private void swap(int[] a, int i, int j) {
    }

    private int[] reverse(int[] aList, int startingIndex){
        if (startingIndex == aList.length/2) {
            return aList;
        }
        else{
            int i = startingIndex;
            int j = aList.length - startingIndex;
            if (i == j){
                return aList;
            }
            else{
                swap(aList, i, j);
                startingIndex ++;
                return reverse(aList, startingIndex);
            }
        }
    }

     */
}






