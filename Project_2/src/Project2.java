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
  public static int[] input_array;
  public static List<Integer> output_list;
  public static int[] output_array;

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

    try {
      buffered_reader.close();
      buffered_writer.close();
    } catch (IOException e) {
      System.err.println("Failed to close file: " + e.getMessage());
      return;
    }

    // // String to be used when reading lines from the files
    // String in;
    //
    // // Read from input table file and construct two dimensional array of input
    // int counter = 0;
    // int num_points = 0;
    // int num_comparisons = 0;
    // try {
    //   // Count the number of data points
    //   while (euclidean_reader.readLine() != null) {
    //     num_points++;
    //   }
    //
    //   // Reset file pointer back to head
    //   euclidean_reader.close();
    //   euclidean_reader = new BufferedReader(new FileReader(args[0]));
    //
    //   // Create array to hold file input
    //   input_array = new double[num_points][2];
    //
    //   // Create array to hold every comparison and their results
    //   num_comparisons = (int)(Double.valueOf(num_points + 1) * (Double.valueOf(num_points) / 2) - Double.valueOf(num_points));
    //   comparison_array = new double[num_comparisons][3];
    //
    //   // Read all the data points from file to array
    //   while ((in = euclidean_reader.readLine()) != null) {
    //     String[] handler = in.split(",");
    //     double value = Double.parseDouble(handler[0]);
    //     input_array[counter][0] = Double.parseDouble(handler[0]);
    //     input_array[counter][1] = Double.parseDouble(handler[1]);
    //     // System.out.println("Point " + counter + ": " + (int)input_array[counter][0] + ", " + (int)input_array[counter][1]);
    //     counter++;
    //   }
    //   System.out.println();
    // } catch (IOException e) {
    //   System.err.println("Failed to read from file: " + e.getMessage());
    //   return;
    // }

    // // Create a eculidean object
    // Euclidean euclidean = new Euclidean();

    // // Part 1.1 of the assignment
    // // Brute force calculate the distance between every point
    // euclidean.calc_all(input_array, comparison_array, num_points);
    // // for (int i = 0; i < num_comparisons; i++) System.out.println("Point " + (int)comparison_array[i][0] + " -> Point " + (int)comparison_array[i][1] + ": " + comparison_array[i][2]);
    //
    // System.out.println("\nThe two closest points are Point " + (int)euclidean.closest_pair[0][0]
    //                   + " and Point "+ (int)euclidean.closest_pair[0][1]
    //                   + " with a distance of " + euclidean.closest_pair[0][2]);
    // System.out.print("Total number of comparisons: ");
    // System.out.println(num_comparisons);
    // System.out.println();

    // Part 2.2 of the assignment
    // comparison_array = new double[num_comparisons][3];
    // int total_comparisons = euclidean.calc_fast(input_array, comparison_array, num_points);

    // System.out.println("\nThe left closest points are Point " + (int)euclidean.left_closest_pair[0][0]
    //                   + " and Point "+ (int)euclidean.left_closest_pair[0][1]
    //                   + " with a distance of " + euclidean.left_closest_pair[0][2] + "\n");
    //
    // System.out.println("\nThe right closest points are Point " + (int)euclidean.right_closest_pair[0][0]
    //                   + " and Point "+ (int)euclidean.right_closest_pair[0][1]
    //                   + " with a distance of " + euclidean.right_closest_pair[0][2] + "\n");

    // System.out.println("\nThe final closest points are Point " + (int)euclidean.final_closest_pair[0][0]
    //                   + " and Point "+ (int)euclidean.final_closest_pair[0][1]
    //                   + " with a distance of " + euclidean.final_closest_pair[0][2]);
    // System.out.print("Total number of comparisons: ");
    // System.out.println(total_comparisons);
    // System.out.println();

    // debug statement
    // if (args[4].contains("true")) return;
  }
}
