/**
 * Created By:			  James Rogers
 * Created On:			  04/17/2020
 * Last Modified By:	James Rogers
 * Last Modified On:	04/17/2020
 * Purpose:
 */

import java.util.*;

public class Untangler {

  public int x_index = 0;
  public int y_index = 0;
  public int s_index = 0;
  public boolean first_time = true;

  public String x1 = "";
  public String y1 = "";

  // Empty constructor
  public Untangler() {}

  public boolean untangle(String a, String b, String q) {
    char[] x = a.toCharArray();
    char[] y = b.toCharArray();
    char[] s = q.toCharArray();

    x_index = 0;
    y_index = 0;
    s_index = 0;
    first_time = true;

    x1 = "";
    y1 = "";

    // System.out.println("Check if x leads...");
    //check if x leads
    for (char c : s) {
      s_index++;
      // Step 1
      if (first_time == true) {
        if (x[x_index] == c) {
          first_time = false;
          // Step 2
          x1 += c;
          x_index++;
        }
        continue;
      }

      // Step 3
      if (c == x[x_index % x.length]) {
        x1 += c;
        x_index++;
        continue;
      }
      if (c == y[y_index % y.length]) {
        y1 += c;
        y_index++;
        continue;
      }
      break;
    }

    // Step 4
    // System.out.println("s_index: " + s_index);
    // System.out.println("s.length: " + s.length);
    if (s_index == s.length) {
      return true;
    }

    x_index = 0;
    y_index = 0;
    s_index = 0;
    first_time = true;

    x1 = "";
    y1 = "";

    // System.out.println("Check if y leads...");
    //check if y leads
    for (char c : s) {
      s_index++;
      // Step 1
      if (first_time == true) {
        if (y[y_index] == c) {
          first_time = false;
          // Step 2
          y1 += c;
          y_index++;
        }
        continue;
      }

      // Step 3
      if (c == y[y_index % y.length]) {
        y1 += c;
        y_index++;
        continue;
      }
      if (c == x[x_index % x.length]) {
        x1 += c;
        x_index++;
        continue;
      }
      break;
    }

    // Step 4
    // System.out.println("s_index: " + s_index);
    // System.out.println("s.length: " + s.length);
    if (s_index == s.length) {
      return true;
    }

    return false;

  }

}
