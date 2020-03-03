/*
 * Created By:			  James Rogers
 * Created On:			  02/24/2020
 * Last Modified By:	James Rogers
 * Last Modified On:	02/24/2020
 * Purpose:			      Calculate euclidean distance between all points in array
 */

public class Euclidean {

  double[][] closest_pair;
  double[][] left_closest_pair;
  double[][] right_closest_pair;
  double[][] final_closest_pair;

  // Constructor for the class
  public Euclidean() {
    this.closest_pair = new double[1][3];
    this.left_closest_pair = new double [1][3];
    this.right_closest_pair = new double [1][3];
    this.final_closest_pair = new double [1][3];
    this.closest_pair[0][0] = -1;
    this.closest_pair[0][1] = -1;
    this.closest_pair[0][2] = -1;
    this.left_closest_pair[0][0] = -1;
    this.left_closest_pair[0][1] = -1;
    this.left_closest_pair[0][2] = -1;
    this.right_closest_pair[0][0] = -1;
    this.right_closest_pair[0][1] = -1;
    this.right_closest_pair[0][2] = -1;
    this.final_closest_pair[0][0] = -1;
    this.final_closest_pair[0][1] = -1;
    this.final_closest_pair[0][2] = -1;
  }

  // Calculate euclidean distance between every point
  public void calc_all(double[][] input, double[][] output, int input_size) {
    calc(input, output, input_size, this.closest_pair);
  }

  // Based off advice from QNI's collision avoidance software team
  // Assumes a list of points sorted by x
  public int calc_fast(double[][] input, double[][] output, int input_size) {
    // Keep track of every calculated distance incase the instructor wants to see it
    int midpoint = (int)((input[input_size-1][0] - input[0][0]) / 2);
    int index_of_midpoint = find(input, midpoint);

    int num_left_points = index_of_midpoint;
    int num_right_points = input_size - index_of_midpoint;

    double[][] left_points = new double[num_left_points][2];
    double[][] right_points = new double[num_right_points][2];

    int left_comparison_counter = (int)(0.5*(num_left_points*num_left_points-num_left_points));
    int right_comparison_counter = (int)(0.5*(num_right_points*num_right_points-num_right_points));

    double[][] left_output = new double[left_comparison_counter][3];
    double[][] right_output = new double[right_comparison_counter][3];

    for (int i = 0; i < num_left_points; i++) {
      left_points[i][0] = input[i][0];
      left_points[i][1] = input[i][1];
    }

    for (int i = num_left_points; i < num_left_points + num_right_points; i++) {
      right_points[i-num_left_points][0] = input[i][0];
      right_points[i-num_left_points][1] = input[i][1];
    }

    calc(left_points, left_output, left_points.length, this.left_closest_pair);
    calc(right_points, right_output, right_points.length, this.right_closest_pair);

    double shortest_distance = (this.left_closest_pair[0][2] < this.right_closest_pair[0][2]) ? this.left_closest_pair[0][2] : this.right_closest_pair[0][2];

    int min_x = find(input, midpoint-(int)shortest_distance) - 1;
    int max_x = find(input, midpoint+(int)shortest_distance);

    double[][] input_subarray = new double[max_x-min_x+1][2];
    for (int i = 0; i <= max_x-min_x; i++) {
      input_subarray[i][0] = input[min_x + i][0];
      input_subarray[i][1] = input[min_x + i][1];
    }

    int final_comparison_counter = (int)(0.5*(input_subarray.length*input_subarray.length-input_subarray.length));
    double[][] final_output = new double[final_comparison_counter][3];

    calc(input_subarray, final_output, input_subarray.length, this.final_closest_pair);

    shortest_distance = (this.final_closest_pair[0][2] < shortest_distance) ? this.final_closest_pair[0][2] : shortest_distance;

    if (this.left_closest_pair[0][2] == shortest_distance) {
      this.final_closest_pair = this.left_closest_pair;
    }
    else if (this.right_closest_pair[0][2] == shortest_distance) {
      this.final_closest_pair[0][0] = this.right_closest_pair[0][0] + index_of_midpoint;
      this.final_closest_pair[0][1] = this.right_closest_pair[0][1] + index_of_midpoint;
      this.final_closest_pair[0][2] = this.right_closest_pair[0][2];
    }
    else {
      this.final_closest_pair[0][0] = this.final_closest_pair[0][0] + min_x;
      this.final_closest_pair[0][1] = this.final_closest_pair[0][1] + min_x;
    }

    return(final_comparison_counter + left_comparison_counter + right_comparison_counter);

  }

  // Euclidean distance helper method
  public void calc(double[][] input, double[][] output, int input_size, double[][] pair) {
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
        if (pair[0][2] < 0) pair[0] = output[counter];
        else if (pair[0][2] > distance) pair[0] = output[counter];
        counter++;
      }
    }
  }

  // Find the index of first data point past the midpoint
  public int find(double[][] input, double midpoint) {
    for (int i = 0; i < input.length; i++) {
      if (input[i][0] > midpoint) return i;
    }
    return -1;
  }
}
