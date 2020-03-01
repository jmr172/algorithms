/*
 * Created By:			  James Rogers
 * Created On:			  02/27/2020
 * Last Modified By:	James Rogers
 * Last Modified On:	02/27/2020
 * Purpose:			      Contains the tuple set of data for each state's input
 */


public class Command {

  int state_number;
  char to_write;
  int move;

  // Constructor for the class
  public Command(int state_number, char to_write, int move) {
    this.state_number = state_number;
    this.to_write = to_write;
    this.move = move;
  }
}
