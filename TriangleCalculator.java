import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a, b, c = 1;
        do {
            System.out.println("Provide three side lengths - 0 0 0 to terminate.");
            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();
            System.out.println(a + " " + b + " " + c + " " + triangleType(a, b, c) + " " + angleType(a, b, c) + angleFinder(a, b, c));
        } while (!(a == 0 && b == 0 && c == 0));
    }
            public static String triangleType ( int side1, int side2, int side3){
              if (side1 == 0 && side2 == 0 && side3 == 0) {
                    return "Program terminated by user.";
                } else if (!isRealTriangle(side1, side2, side3)) {
                return "Triangle is not possible.";
                } else if (side1 == side2 && side2 == side3) {
                    return "Triangle Possible: Equilateral";
                } else if ((side1 == side2) || (side2 == side3 || (side1 == side3))) {
                    return "Triangle Possible: Isosceles";
                } else {
                    return "Triangle Possible: Scalene";
                }
            }
            public static String angleType (int side1, int side2, int side3) {
                if ((side1 <= 0 || side2 <= 0 || side3 <= 0) || (!(isRealTriangle(side1, side2, side3)))) {
                    return " ";
                } else if (isRightTriangle(side1, side2, side3)) {
                    return "& Right";
                } else if (isObtuseTriangle(side1, side2, side3)){
                  return "& Obtuse";
                } else {
                  return "& Acute";
                }
            }
  public static boolean isRightTriangle(int side1, int side2, int side3) {
      return side1 * side1 == side2 * side2 + side3 * side3 ||
             side2 * side2 == side1 * side1 + side3 * side3 ||
             side3 * side3 == side1 * side1 + side2 * side2;
  }
  public static boolean isObtuseTriangle(int side1, int side2, int side3) {
      int biggestSide = Math.max(side1, Math.max(side2, side3));
      int otherSides = 0;
      if (biggestSide == side1) {
          otherSides = side2 * side2 + side3 * side3;
      } else if (biggestSide == side2) {
          otherSides = side1 * side1 + side3 * side3;
      } else {
          otherSides = side1 * side1 + side2 * side2;
      }
      return otherSides < biggestSide * biggestSide;
  }
  public static boolean isRealTriangle(int side1, int side2, int side3) {
      return side1 + side2 > side3 && side2 + side3 > side1 && side1 + side3 > side2;
  }
  public static String angleFinder(int a, int b, int c) {
      Double angleA, angleB, angleC;
    if  ((a <= 0 || b <= 0 || c <= 0) || (!(isRealTriangle(a, b, c)))) {
          return " ";
      } else {
      angleA = Math.acos((b * b + c * c - a * a) / (2.0 * b * c));
      angleB = Math.acos((a * a + c * c - b * b) / (2.0 * a * c));
      angleC = Math.acos((a * a + b * b - c * c) / (2.0 * a * b));
      angleA = (double)Math.round(Math.toDegrees(angleA) * 100) / 100;
      angleB = (double)Math.round(Math.toDegrees(angleB) * 100) / 100;
      angleC = (double)Math.round(Math.toDegrees(angleC) * 100) / 100;
      return ", the angles are: ∠" + angleA + "° ∠" + angleB + "° ∠" + angleC + "° respectively.";
    }
  }
    }
