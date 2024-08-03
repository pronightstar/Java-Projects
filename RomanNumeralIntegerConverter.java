import java.util.*;
public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter a roman numeral from 1 - 3999");
    String roman = sc.nextLine();
    if (converter(roman) < 4000 && converter(roman) > 0) {
    System.out.println(converter(roman));
    } else {
      System.out.println("Invalid input");
    }
  }
public static int converter(String roman) {
  int sum = 0;
  for (int i = 0; i < roman.length(); i++) {
    char currentChar = roman.charAt(i);
    int currentValue = romanToNum(currentChar);
    if (i < roman.length() - 1) {
      char nextChar = roman.charAt(i + 1);
      int nextValue = romanToNum(nextChar);
      if (currentValue < nextValue) {
        sum += (nextValue - currentValue);
        i++;
      } else {
        sum += currentValue;
      }
    } else {
      sum += currentValue;
        }
  }
  return sum;
}
public static int romanToNum(char roman) {
  switch (roman) {
    case 'I':
      return 1;
    case 'V':
      return 5;
    case 'X':
      return 10;
    case 'L':
      return 50;
    case 'C':
      return 100;
    case 'D':
      return 500;
    case 'M':
      return 1000;
    default:
      return 0;
  }
}
}
