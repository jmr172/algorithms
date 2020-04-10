/**
 * Created By:			  James Rogers
 * Created On:			  03/29/2020
 * Last Modified By:	James Rogers
 * Last Modified On:	03/29/2020
 * Purpose:
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.Math;
import java.util.*;

public class Project2 {

  public static BufferedReader buffered_reader;
  public static BufferedWriter buffered_writer;
  public static List<Integer> input_list;
  public static Integer[] input_array;
  public static List<Integer> output_list;
  public static Integer[] output_array;

  /**
  * @param args[]:  [path/to/input] [path/to/output]
  */
  public static void main(String[] args) {

    // Show the project banner
    Banner banner = new Banner();
    banner.show();

    if (args.length != 2) {
      System.out.println(args.length);
      System.out.println("Usage: java Project2 [path/to/input] [path/to/output]");
      System.exit(1);
    }

    // Open the input and output files
    try {
      buffered_reader = new BufferedReader(new FileReader(args[0]));
      buffered_writer = new BufferedWriter(new FileWriter(args[1]));
    } catch (IOException e) {
      System.err.println("Failed to open file: " + e.getMessage());
      return;
    }

    String in;
    input_list = new ArrayList<Integer>();
    try {
      while ((in = buffered_reader.readLine()) != null) {
          input_list.add(Integer.parseInt(in));
      }
    } catch (IOException e) {
      System.err.println("Failed to read from file: " + e.getMessage());
      return;
    }

    int num_elements = input_list.size();
    input_array = new Integer[num_elements];
    input_list.toArray(input_array);

    Integer[] quicksort_array = input_array.clone();
    Integer[] heapsort_array = input_array.clone();
    Integer[] introsort_array = input_array.clone();

    Integer[] new_arr = {8,7,6,5,4,3};

    Sorter sorter = new Sorter();

    System.out.println("Performing quicksort...");
    sorter.counter = 0;
    sorter.quicksort(quicksort_array, 0, quicksort_array.length - 1);
    System.out.println("Done with quicksort! Number of comparisons: " + sorter.counter);

    System.out.println("Performing heapsort...");
    sorter.counter = 0;
    sorter.heapsort(heapsort_array, 0, heapsort_array.length);
    System.out.println("Done with heapsort! Number of comparisons: " + sorter.counter);

    System.out.println("Performing introsort...");
    sorter.counter = 0;
    sorter.introsort(introsort_array, 0, introsort_array.length-1, 2*(int)Math.floor(Math.log(introsort_array.length)/Math.log(2)));
    System.out.println("Done with introsort! Number of comparisons: " + sorter.counter);

    try {
      buffered_writer.write("\nOutput of quicksort:\n");
      for (int val : quicksort_array) {
          buffered_writer.write(String.valueOf(val) + "\n");
      }

      buffered_writer.write("\nOutput of heapsort:\n");
      for (int val : heapsort_array) {
          buffered_writer.write(String.valueOf(val) + "\n");
      }

      buffered_writer.write("\nOutput of introsort:\n");
      for (int val : introsort_array) {
          buffered_writer.write(String.valueOf(val) + "\n");
      }

    } catch (IOException e) {
      System.err.println("Failed to write to output file: " + e.getMessage());
      return;
    }

    try {
      buffered_reader.close();
      buffered_writer.close();
    } catch (IOException e) {
      System.err.println("Failed to close file: " + e.getMessage());
      return;
    }
  }
}
