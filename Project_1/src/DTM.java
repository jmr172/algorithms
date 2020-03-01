/*
 * Created By:			  James Rogers
 * Created On:			  02/27/2020
 * Last Modified By:	James Rogers
 * Last Modified On:	02/27/2020
 * Purpose:			      Performs the deterministic Turing machine functions
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DTM {

  List<Map<Character,Command>> plain_dictionaries;
  List<Map<Character,Command>> addition_dictionaries;
  List<Map<Character,Command>> subtraction_dictionaries;
  List<Map<Character,Command>> multiplication_dictionaries;
  int plain_state;
  int addition_state;
  int subtraction_state;
  int multiplication_state;

  // Constructor for the class
  public DTM() {
    this.plain_dictionaries = new ArrayList<Map<Character,Command>>();
    this.addition_dictionaries = new ArrayList<Map<Character,Command>>();
    this.subtraction_dictionaries = new ArrayList<Map<Character,Command>>();
    this.multiplication_dictionaries = new ArrayList<Map<Character,Command>>();
    this.plain_state = 0;
    this.addition_state = 0;
    this.subtraction_state = 0;
    this.multiplication_state = 0;
  }

  public void states() {
    // Create 3 commands for every state (0,1,b)
    // Assign them to a dictionary
    // Add dictionary to array
    // -1 is no state, -2 is yes state
    Command command_0;
    Command command_1;
    Command command_b;
    Map<Character,Command> state;

    // Plain DTM for part 2.1
    // 0
    state = new HashMap<Character,Command>();
    state.put('0', new Command(0,'0',1));
    state.put('1', new Command(0,'1',1));
    state.put('b', new Command(1,'b',-1));
    this.plain_dictionaries.add(state);
    // 1
    state = new HashMap<Character,Command>();
    state.put('0', new Command(2,'b',-1));
    state.put('1', new Command(3,'b',-1));
    state.put('b', new Command(-1,'b',-1));
    this.plain_dictionaries.add(state);
    // 2
    state = new HashMap<Character,Command>();
    state.put('0', new Command(-2,'b',-1));
    state.put('1', new Command(-1,'b',-1));
    state.put('b', new Command(-1,'b',-1));
    this.plain_dictionaries.add(state);
    // 3
    state = new HashMap<Character,Command>();
    state.put('0', new Command(-1,'b',-1));
    state.put('1', new Command(-1,'b',-1));
    state.put('b', new Command(-1,'b',-1));
    this.plain_dictionaries.add(state);

    // Addition DTM for Part 2.2
    // 0
    state = new HashMap<Character,Command>();
    state.put('1', new Command(1,'b',1));
    state.put('b', new Command(0,'b',1));
    state.put('x', new Command(5,'x',1));
    this.addition_dictionaries.add(state);
    // 1
    state = new HashMap<Character,Command>();
    state.put('1', new Command(1,'1',1));
    state.put('b', new Command(-1,'b',0));
    state.put('x', new Command(2,'x',1));
    this.addition_dictionaries.add(state);
    // 2
    state = new HashMap<Character,Command>();
    state.put('1', new Command(2,'1',1));
    state.put('b', new Command(3,'1',-1));
    state.put('x', new Command(-1,'x',0));
    this.addition_dictionaries.add(state);
    // 3
    state = new HashMap<Character,Command>();
    state.put('1', new Command(3,'1',-1));
    state.put('b', new Command(-1,'b',0));
    state.put('x', new Command(4,'x',-1));
    this.addition_dictionaries.add(state);
    // 4
    state = new HashMap<Character,Command>();
    state.put('1', new Command(4,'1',-1));
    state.put('b', new Command(0,'b',1));
    state.put('x', new Command(-1,'x',0));
    this.addition_dictionaries.add(state);
    // 5
    state = new HashMap<Character,Command>();
    state.put('1', new Command(-2,'1',0));
    state.put('b', new Command(-1,'b',0));
    state.put('x', new Command(-1,'x',0));
    this.addition_dictionaries.add(state);

    // Subtraction DTM for Part 2.2
    // 0
    state = new HashMap<Character,Command>();
    state.put('1', new Command(1,'b',1));
    state.put('b', new Command(0,'b',1));
    state.put('x', new Command(7,'x',1));
    this.subtraction_dictionaries.add(state);
    // 1
    state = new HashMap<Character,Command>();
    state.put('1', new Command(1,'1',1));
    state.put('b', new Command(-1,'b',0));
    state.put('x', new Command(2,'x',1));
    this.subtraction_dictionaries.add(state);
    // 2
    state = new HashMap<Character,Command>();
    state.put('1', new Command(2,'1',1));
    state.put('b', new Command(3,'b',-1));
    state.put('x', new Command(-1,'x',0));
    this.subtraction_dictionaries.add(state);
    // 3
    state = new HashMap<Character,Command>();
    state.put('1', new Command(4,'b',-1));
    state.put('b', new Command(-1,'b',0));
    state.put('x', new Command(6,'x',-1));
    this.subtraction_dictionaries.add(state);
    // 4
    state = new HashMap<Character,Command>();
    state.put('1', new Command(4,'1',-1));
    state.put('b', new Command(-1,'b',0));
    state.put('x', new Command(5,'x',-1));
    this.subtraction_dictionaries.add(state);
    // 5
    state = new HashMap<Character,Command>();
    state.put('1', new Command(5,'1',-1));
    state.put('b', new Command(0,'b',1));
    state.put('x', new Command(-1,'x',0));
    this.subtraction_dictionaries.add(state);
    // 6
    state = new HashMap<Character,Command>();
    state.put('1', new Command(6,'1',-1));
    state.put('b', new Command(-2,'1',0));
    state.put('x', new Command(-1,'x',0));
    this.subtraction_dictionaries.add(state);
    // 7
    state = new HashMap<Character,Command>();
    state.put('1', new Command(-2,'1',0));
    state.put('b', new Command(-1,'b',0));
    state.put('x', new Command(-1,'x',0));
    this.subtraction_dictionaries.add(state);

    // Multiplication DTM for Part 2.2
    // 0
    state = new HashMap<Character,Command>();
    state.put('1', new Command(1,'b',1));
    state.put('b', new Command(0,'b',1));
    state.put('x', new Command(9,'x',1));
    state.put('j', new Command(-1,'j',0));
    this.multiplication_dictionaries.add(state);
    // 1
    state = new HashMap<Character,Command>();
    state.put('1', new Command(2,'b',1));
    state.put('b', new Command(1,'b',1));
    state.put('x', new Command(-2,'x',0));
    state.put('j', new Command(-1,'j',0));
    this.multiplication_dictionaries.add(state);
    // 2
    state = new HashMap<Character,Command>();
    state.put('1', new Command(2,'1',1));
    state.put('b', new Command(-1,'b',0));
    state.put('x', new Command(3,'x',1));
    state.put('j', new Command(-1,'j',0));
    this.multiplication_dictionaries.add(state);
    // 3
    state = new HashMap<Character,Command>();
    state.put('1', new Command(4,'j',1));
    state.put('b', new Command(-1,'b',0));
    state.put('x', new Command(-1,'x',0));
    state.put('j', new Command(-1,'j',0));
    this.multiplication_dictionaries.add(state);
    // 4
    state = new HashMap<Character,Command>();
    state.put('1', new Command(4,'1',1));
    state.put('b', new Command(5,'1',-1));
    state.put('x', new Command(-1,'x',0));
    state.put('j', new Command(-1,'j',0));
    this.multiplication_dictionaries.add(state);
    // 5
    state = new HashMap<Character,Command>();
    state.put('1', new Command(6,'1',-1));
    state.put('b', new Command(-1,'b',0));
    state.put('x', new Command(-1,'x',0));
    state.put('j', new Command(7,'1',-1));
    this.multiplication_dictionaries.add(state);
    // 6
    state = new HashMap<Character,Command>();
    state.put('1', new Command(6,'1',-1));
    state.put('b', new Command(-2,'1',0));
    state.put('x', new Command(-1,'x',0));
    state.put('j', new Command(3,'j',1));
    this.multiplication_dictionaries.add(state);
    // 7
    state = new HashMap<Character,Command>();
    state.put('1', new Command(-1,'1',0));
    state.put('b', new Command(-1,'b',0));
    state.put('x', new Command(8,'x',-1));
    state.put('j', new Command(7,'1',-1));
    this.multiplication_dictionaries.add(state);
    // 8
    state = new HashMap<Character,Command>();
    state.put('1', new Command(8,'1',-1));
    state.put('b', new Command(1,'b',1));
    state.put('x', new Command(-1,'x',0));
    state.put('j', new Command(-1,'j',0));
    this.multiplication_dictionaries.add(state);
    // 9
    state = new HashMap<Character,Command>();
    state.put('1', new Command(9,'b',1));
    state.put('b', new Command(-2,'b',0));
    state.put('x', new Command(-1,'x',0));
    state.put('j', new Command(-1,'j',0));
    this.multiplication_dictionaries.add(state);

  }

  public String run(String data, BufferedWriter output) {
    char[] plain_input = data.toCharArray();
    char[] plain_copy = new char[plain_input.length];
    List<char[]> plain_history = new ArrayList<char[]>();
    if (plain_input.length < 30) {
      System.out.println("Running provided DTM...");
      System.out.println(plain_input);
    }
    else {
      plain_copy = new char[plain_input.length];
      for (int i = 0; i < plain_copy.length; i++) {
        plain_copy[i] = plain_input[i];
      }
      plain_history.add(plain_copy);
    }
    int plain_head_position = 0;
    char plain_read_value;
    Command plain_command;
    while (this.plain_state >= 0) {
      plain_read_value = plain_input[plain_head_position];
      plain_command = this.plain_dictionaries.get(this.plain_state).get(plain_read_value);
      this.plain_state = plain_command.state_number;
      plain_input[plain_head_position] = plain_command.to_write;
      plain_head_position += plain_command.move;
      if (plain_input.length < 30) {
        System.out.println(plain_input);
      }
      else {
        plain_copy = new char[plain_input.length];
        for (int i = 0; i < plain_copy.length; i++) {
          plain_copy[i] = plain_input[i];
        }
        plain_history.add(plain_copy);
      }
    }
    if (plain_input.length >= 30) {
      for (char[] val : plain_history) {
        try {
          output.write(String.valueOf(val) + "\n");
        } catch(IOException e) {
          System.err.println("Failed to write to file: " + e.getMessage());
        }
      }
    }
    return String.valueOf(plain_input);
  }

  public String addition(String data, BufferedWriter output) {
    String addition_padding = "";
    for (int i = 0; i < data.length(); i++) {
      addition_padding += "b";
    }
    addition_padding = data + addition_padding;
    char[] addition_input = addition_padding.toCharArray();
    char[] addition_copy = new char[addition_input.length];
    List<char[]> addition_history = new ArrayList<char[]>();
    if (addition_input.length < 30) {
      System.out.println("Running unary addition DTM...");
      System.out.println(addition_input);
    }
    else {
      addition_copy = new char[addition_input.length];
      for (int i = 0; i < addition_copy.length; i++) {
        addition_copy[i] = addition_input[i];
      }
      addition_history.add(addition_copy);
    }
    int addition_head_position = 0;
    char addition_read_value;
    Command addition_command;
    while (this.addition_state >= 0) {
      addition_read_value = addition_input[addition_head_position];
      addition_command = this.addition_dictionaries.get(this.addition_state).get(addition_read_value);
      this.addition_state = addition_command.state_number;
      addition_input[addition_head_position] = addition_command.to_write;
      addition_head_position += addition_command.move;
      if (addition_input.length < 30) {
        // System.out.print("State: " + this.addition_state + ", ");
        System.out.println(addition_input);
      }
      else {
        addition_copy = new char[addition_input.length];
        for (int i = 0; i < addition_copy.length; i++) {
          addition_copy[i] = addition_input[i];
        }
        addition_history.add(addition_copy);
      }
    }
    if (addition_input.length >= 30) {
      for (char[] val : addition_history) {
        try {
          output.write(String.valueOf(val) + "\n");
        } catch(IOException e) {
          System.err.println("Failed to write to file: " + e.getMessage());
        }
      }
    }
    return String.valueOf(addition_input);
  }

  public String subtraction(String data, BufferedWriter output) {
    char[] subtraction_input = data.toCharArray();
    char[] subtraction_copy = new char[subtraction_input.length];
    List<char[]> subtraction_history = new ArrayList<char[]>();
    if (subtraction_input.length < 30) {
      System.out.println("Running unary subtraction DTM...");
      System.out.println(subtraction_input);
    }
    else {
      subtraction_copy = new char[subtraction_input.length];
      for (int i = 0; i < subtraction_copy.length; i++) {
        subtraction_copy[i] = subtraction_input[i];
      }
      subtraction_history.add(subtraction_copy);
    }
    int subtraction_head_position = 0;
    char subtraction_read_value;
    Command subtraction_command;
    while (this.subtraction_state >= 0) {
      subtraction_read_value = subtraction_input[subtraction_head_position];
      subtraction_command = this.subtraction_dictionaries.get(this.subtraction_state).get(subtraction_read_value);
      this.subtraction_state = subtraction_command.state_number;
      subtraction_input[subtraction_head_position] = subtraction_command.to_write;
      subtraction_head_position += subtraction_command.move;
      if (subtraction_input.length < 30) {
        // System.out.print("State: " + this.subtraction_state + ", ");
        System.out.println(subtraction_input);
      }
      else {
        subtraction_copy = new char[subtraction_input.length];
        for (int i = 0; i < subtraction_copy.length; i++) {
          subtraction_copy[i] = subtraction_input[i];
        }
        subtraction_history.add(subtraction_copy);
      }
    }
    if (subtraction_input.length >= 30) {
      for (char[] val : subtraction_history) {
        try {
          output.write(String.valueOf(val) + "\n");
        } catch(IOException e) {
          System.err.println("Failed to write to file: " + e.getMessage());
        }
      }
    }
    return String.valueOf(subtraction_input);
  }

  public String multiplication(String data, BufferedWriter output) {
    String multiplication_padding = "";
    for (int i = 0; i < data.length()*data.length(); i++) {
      multiplication_padding += "b";
    }
    multiplication_padding = data + multiplication_padding;
    char[] multiplication_input = multiplication_padding.toCharArray();
    char[] multiplication_copy = new char[multiplication_input.length];
    List<char[]> multiplication_history = new ArrayList<char[]>();
    if (data.length() < 30) {
      System.out.println("Running unary multiplication DTM...");
      System.out.println(multiplication_input);
    }
    else {
      multiplication_copy = new char[multiplication_input.length];
      for (int i = 0; i < multiplication_copy.length; i++) {
        multiplication_copy[i] = multiplication_input[i];
      }
      multiplication_history.add(multiplication_copy);
    }
    int multiplication_head_position = 0;
    char multiplication_read_value;
    Command multiplication_command;
    while (this.multiplication_state >= 0) {
      multiplication_read_value = multiplication_input[multiplication_head_position];
      multiplication_command = this.multiplication_dictionaries.get(this.multiplication_state).get(multiplication_read_value);
      this.multiplication_state = multiplication_command.state_number;
      multiplication_input[multiplication_head_position] = multiplication_command.to_write;
      multiplication_head_position += multiplication_command.move;
      if (data.length() < 30) {
        System.out.print("State: " + this.multiplication_state + ", ");
        System.out.println(multiplication_input);
      }
      else {
        multiplication_copy = new char[multiplication_input.length];
        for (int i = 0; i < multiplication_copy.length; i++) {
          multiplication_copy[i] = multiplication_input[i];
        }
        multiplication_history.add(multiplication_copy);
      }
    }
    if (data.length() >= 30) {
      for (char[] val : multiplication_history) {
        try {
          output.write(String.valueOf(val) + "\n");
        } catch(IOException e) {
          System.err.println("Failed to write to file: " + e.getMessage());
        }
      }
    }
    return String.valueOf(multiplication_input);
  }
}
