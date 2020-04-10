/**
 * Created By:			  James Rogers
 * Created On:			  03/29/2020
 * Last Modified By:	James Rogers
 * Last Modified On:	03/29/2020
 * Purpose:			      Holds the functions for introsort, heapsort, and quicksort
 */

import java.util.*;

public class Sorter {

  public int counter;

  // Empty constructor
  public Sorter() {
    this.counter = 0;
  }

  // Reference: https://courses.cs.washington.edu/courses/cse373/01sp/Lect18_2up.pdf
  // Java is pass by reference, so all operations are done in place on the original array
  public void quicksort(Integer[] input, int x, int y) {
    if (x < y) {
      int index = part(input, x, y);
      quicksort(input, x, index-1);
      quicksort(input, index+1, y);
    }
  }

  public void heapsort(Integer[] input, int x, int y) {
    // Create a heap, remove one element, reconstruct the heap, continue
    for (int i = (((y-x)/2)-1); i >= 0; i--) {
      heapify(input, y-x, i);
    }

    for (int i = y-x-1; i > 0; i--) {
      swapper(input, 0, i);
      heapify(input, i, 0);
    }
  }

  // Reference: https://en.wikipedia.org/wiki/Introsort
  public void introsort(Integer[] input, int x, int y, int depth) {
    // Choose whether to switch to insertion sort or not
    // Threshold is arbitrarily chosen at 25
    if ((y-x) < 25) {
      insertionsort(input, x, y);
    }
    else {
      if (depth == 0) {
        heapsort(input, x, y);
        return;
      }
      depth--;

      // reusing the partition function from quicksort
      int index = part(input, x, y);
      int new_depth = depth;
      introsort(input, x, index-1, new_depth);
      introsort(input, index+1, y, new_depth);
    }
  }

  // Reference: https://www.khanacademy.org/computing/computer-science/algorithms/insertion-sort/a/insertion-sort
  public void insertionsort(Integer[] input, int x, int y) {
    for (int i = x; i <= y; i++) {
      int key = input[i];
      int j = i;
      while ((j > x) && (input[j-1] > key)) {
        this.counter++;
        input[j] = input[j - 1];
        j--;
      }
      input[j] = key;
    }
  }

  public int part(Integer[] input, int x, int y) {
    // From assignment: Assume partition pivot element is chosen as the final element of the array
    // int pivot = input[y];


    // Median of three implementation
    Integer[] median_calc = {input[x], input[y], input[y-x]};
    insertionsort(median_calc, 0, 2);
    int pivot = median_calc[1];

    int index_of_pivot;
    if (input[x] == pivot) {
      index_of_pivot = x;
    }
    else if (input[y] == pivot) {
      index_of_pivot = y;
    }
    else {
      index_of_pivot = y-x;
    }

    swapper(input, index_of_pivot, y);

    int index_of_low = x-1;

    for (int i = x; i < y; i++) {
      this.counter++;
      if (input[i] < pivot) {
        index_of_low++;
        swapper(input, index_of_low,  i);
      }
    }

    swapper(input, index_of_low+1, y);
    return (index_of_low + 1);
  }

  // Referenced a slide deck from RIT https://www.cs.rit.edu/~lr/courses/alg/student/1/heapsort.pdf
  public void heapify(Integer[] input, int x, int y) {
    int val = y;
    int left = ((2 * y) + 1);
    int right = ((2 * y) + 2);
    this.counter++;

    if (left < x) {
      if (input[left] > input[val]) {
        val = left;
      }
    }

    if (right < x) {
      if (input[right] > input[val]) {
        val = right;
      }
    }

    if (y != val) {
      swapper(input, y, val);
      heapify(input, x, val);
    }
  }

  public void swapper(Integer[] input, int a, int b) {
    int holder = input[a];
    input[a] = input[b];
    input[b] = holder;
  }

}
