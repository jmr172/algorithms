/*
 * Created By:			  James Rogers
 * Created On:			  02/24/2020
 * Last Modified By:	James Rogers
 * Last Modified On:	02/24/2020
 * Purpose:			      Calculate euclidean distance between all points in array
 */

public class Euclidean {

  double[][] closest_pair;

  // Constructor for the class
  public Euclidean() {
    this.closest_pair = new double[1][3];
    this.closest_pair[0][0] = -1;
    this.closest_pair[0][1] = -1;
    this.closest_pair[0][2] = -1;
  }

  // Calculate euclidean distance between every point
  public void calc(double[][] input, double[][] output, int input_size) {
    int counter = 0;
    for (int i = 0; i < input_size; i++) {
      for (int j = i + 1; j < input_size; j++) {
        double x_diff = input[i][0] - input[j][0];
        double y_diff = input[i][1] - input[j][1];
        double distance = Math.sqrt((x_diff * x_diff) + (y_diff * y_diff));
        // I'm rounding distance to 3 decimal places for aesthetic reasons
        // Please let me know if this isn't acceptable
        distance = Math.floor(distance * 1000) / 1000;
        output[counter][0] = i;
        output[counter][1] = j;
        output[counter][2] = distance;
        if (this.closest_pair[0][2] < 0) this.closest_pair[0] = output[counter];
        else if (this.closest_pair[0][2] > distance) this.closest_pair[0] = output[counter];
        counter++;
      }
    }
  }

  // Find the smallest entry in the array
  public int find(double[][] input, int input_size) {
    int index = 0;
    for (int i = 0; i < input_size; i++) {
      if (input[index][2] > input[i][2]) index = i;
    }
    return index;
  }
}
