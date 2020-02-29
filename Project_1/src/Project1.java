/**
 * Created By:			  James Rogers
 * Created On:			  02/24/2020
 * Last Modified By:	James Rogers
 * Last Modified On:	02/24/2020
 * Purpose:
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.Math;

public class Project1 {

  public static BufferedReader buffered_reader;
  public static BufferedWriter buffered_writer;
  // input array = [x_coor, y_coor]
  public static double[][] input_array;
  // comparison array = [point_1, point_2, distance]
  public static double[][] comparison_array;

  /**
  * @param args[]:  [path/to/table] [encode/decode] [path/to/input] [path/to/output]
  */
  public static void main(String[] args) {

    // Show the project banner
    Banner banner = new Banner();
    banner.show();

    if (args.length != 2) {
      System.out.println("Usage: java Project1 [path/to/input] [path/to/output]");
      System.exit(1);
    }

    // Open the input file for the frequency table
    try {
      buffered_reader = new BufferedReader(new FileReader(args[0]));
      buffered_writer = new BufferedWriter(new FileWriter(args[1]));
    } catch (IOException e) {
      System.err.println("Failed to open file: " + e.getMessage());
      return;
    }

    // String to be used when reading lines from the files
    String in;

    // Read from input table file and construct two dimensional array of input
    int counter = 0;
    int num_points = 0;
    int num_comparisons = 0;
    try {
      // Count the number of data points
      while (buffered_reader.readLine() != null) {
        num_points++;
      }

      // Reset file pointer back to head
      buffered_reader.close();
      buffered_reader = new BufferedReader(new FileReader(args[0]));

      // Create array to hold file input
      input_array = new double[num_points][2];

      // Create array to hold every comparison and their results
      num_comparisons = (int)(Double.valueOf(num_points + 1) * (Double.valueOf(num_points) / 2) - Double.valueOf(num_points));
      System.out.println("Number of comparisons: " + num_comparisons + "\n");
      comparison_array = new double[num_comparisons][3];

      // Read all the data points from file to array
      while ((in = buffered_reader.readLine()) != null) {
        String[] handler = in.split(",");
        double value = Double.parseDouble(handler[0]);
        input_array[counter][0] = Double.parseDouble(handler[0]);
        input_array[counter][1] = Double.parseDouble(handler[1]);
        System.out.println("Point " + counter + ": " + (int)input_array[counter][0] + ", " + (int)input_array[counter][1]);
        counter++;
      }
      System.out.println();
    } catch (IOException e) {
      System.err.println("Failed to read from file: " + e.getMessage());
      return;
    }

    // Create a eculidean object
    Euclidean euclidean = new Euclidean();

    // Brute force calculate the distance between every point
    euclidean.calc(input_array, comparison_array, num_points);
    for (int i = 0; i < num_comparisons; i++) System.out.println("Point " + (int)comparison_array[i][0] + " -> Point " + (int)comparison_array[i][1] + ": " + comparison_array[i][2]);

    // Find the two closest points
    int index_of_closest_points = euclidean.find(comparison_array, num_comparisons);
    System.out.println("\nThe two closest points are Point " + (int)comparison_array[index_of_closest_points][0]
                      + " and Point "+ (int)comparison_array[index_of_closest_points][1]
                      + " with a distance of " + comparison_array[index_of_closest_points][2]);

  }

}