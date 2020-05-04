/**
 * Created By:			  James Rogers
 * Created On:			  04/17/2020
 * Last Modified By:	James Rogers
 * Last Modified On:	04/17/2020
 * Purpose:
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.Math;
import java.util.*;

public class Project3 {

  public static BufferedReader buffered_reader;
  public static String x;
  public static String y;
  public static String s;

  /**
  * @param args[]:  [path/to/input]
  */
  public static void main(String[] args) {

    // Show the project banner
    Banner banner = new Banner();
    banner.show();

    if (args.length != 3) {
      System.out.println(args.length);
      System.out.println("Usage: java Project3 [x] [y] [path/to/input]");
      System.exit(1);
    }

    // Open the input and output files
    try {
      x = args[0];
      y = args[1];
      buffered_reader = new BufferedReader(new FileReader(args[2]));
    } catch (IOException e) {
      System.err.println("Failed to open file: " + e.getMessage());
      return;
    }

    String in = "";
    s = "";
    try {
      while ((in = buffered_reader.readLine()) != null) {
          s += in;
      }
    } catch (IOException e) {
      System.err.println("Failed to read from file: " + e.getMessage());
      return;
    }

    System.out.println("x = " + x);
    System.out.println("y = " + y);
    System.out.println("s = " + s);

    Untangler untangler = new Untangler();
    boolean success = untangler.untangle(x,y,s);

    if (success) {
      System.out.println("\nTRUE: The signal " + s + " is an interweaving of the signals " + x + " and " + y);
      System.out.println("x\': " + untangler.x1);
      System.out.println("y\': " + untangler.y1);
    }
    else {
      System.out.println("\nFALSE: The signal " + s + " is not an interweaving of the signals " + x + " and " + y);
    }

    try {
      buffered_reader.close();
    } catch (IOException e) {
      System.err.println("Failed to close file: " + e.getMessage());
      return;
    }
  }
}
