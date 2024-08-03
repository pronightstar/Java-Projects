import java.util.*;
public class Assignment2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int guess, max, min, answer, attempts, rrMin, rrMax;
        String gamemodeChoice;
        char Replay;

        do {
            System.out.println("Welcome to the guessing game. Select which gamemode you want to play.[2,3,4,4+]");
            gamemodeChoice = sc.nextLine();

            if (gamemodeChoice.equals("2")) {
                answer = (int) (100 * Math.random()) + 1;
                guess = 0;
                while (!(guess == answer)) {
                    System.out.println("Guess a random number from 1 to 100");
                    guess = sc.nextInt();
                    if (guess > answer && guess < 101) {
                        System.out.println("Incorrect, too high.");
                    } else if (guess < answer && guess > 0) {
                        System.out.println("Incorrect, too low.");
                    } else if (guess < 0 || guess > 100) {
                        System.out.println("Invalid input");
                    }
                    if (guess == answer) {
                        System.out.println("Congrats kid you won");
                    }
                }

            } else if (gamemodeChoice.equals("3")) {
                System.out.println("Enter a minimum value.");
                min = sc.nextInt();
                System.out.println("Enter a maximum value.");
                max = sc.nextInt();
                answer = (int) ((max - min) * Math.random()) + min;
                guess = 0;
                while (!(guess == answer)) {
                    System.out.println("Guess a random number between your max and minimum values.");
                    guess = sc.nextInt();
                    if (guess > answer && guess <= max) {
                        System.out.println("Incorrect. Too high.");
                    } else if (guess < answer && guess >= min) {
                        System.out.println("Incorrect. Too low.");
                    } else if (guess < max || guess > min) {
                        System.out.println("Invalid input.");
                    }
                }
                if (guess == answer) {
                    System.out.println("Correct kid");
                }

            } else if (gamemodeChoice.equals("4")) {
                System.out.println("Enter a minimum value.");
                min = sc.nextInt();
                System.out.println("Enter a maximum value.");
                max = sc.nextInt();
                answer = (int) ((max - min) * Math.random()) + min;
                guess = 0;
                attempts = 10;
                while (guess != answer && attempts > 0) {
                    System.out.println("Guess the number. You have " + attempts + " tries");
                    guess = sc.nextInt();
                    if (guess > answer && guess <= max) {
                        System.out.println("Incorrect. Too high.");
                    } else if (guess < answer && guess >= min) {
                        System.out.println("Incorrect. Too low.");
                    } else if (guess > max || guess < min) {
                        System.out.println("Invalid Input.");
                    } else if (guess == answer) {
                        System.out.println("Correct kid");
                        break;
                    }
                    attempts--;
                    if (attempts == 0) {
                        System.out.println("Ohhh I win kid you lose idiot");
                    }
                }
            } else if (gamemodeChoice.equals("4+")) {
                int wins = 0;
                int losses = 0;
                System.out.println("How many games do you want the computer to play?");
                int rounds = sc.nextInt();
                if (rounds <= 5) {
                    for (int i = 1; i <= rounds; i++) {
                        System.out.println("Choose the minimum value.");
                        min = sc.nextInt();
                        System.out.println("Choose the maximum value.");
                        max = sc.nextInt();
                        rrMax = max;
                        rrMin = min;
                        answer = (int) ((max - min) * Math.random()) + min;
                        guess = 0;
                        attempts = 10;
                        while (guess != answer && attempts > 0) {
                            System.out.println("Guess the number. You have " + attempts + " tries");
                            guess = rrMin + (rrMax - rrMin) / 2;
                            if (guess > answer && guess <= max) {
                                System.out.println("Incorrect. Too high. Guessed " + guess);
                                rrMax = guess - 1;
                            } else if (guess < answer && guess >= min) {
                                System.out.println("Incorrect. Too low. Guessed " + guess);
                                rrMin = guess + 1;
                            } else if (guess > max || guess < min) {
                                System.out.println("Invalid Input.");
                            } else if (guess == answer) {
                                System.out.println("Correct computer");
                                break;
                            }
                            attempts--;
                            if (attempts == 0) {
                                System.out.println("Ohhh I win kid you lose idiot");
                            }
                        }
                    }
                } else if (rounds > 5){
                    for (int i = 1; i <= rounds; i++) {
                        System.out.println("Choose the minimum value.");
                        min = sc.nextInt();
                        System.out.println("Choose the maximum value.");
                        max = sc.nextInt();
                        rrMax = max;
                        rrMin = min;
                        answer = (int) ((max - min) * Math.random()) + min;
                        guess = 0;
                        attempts = 10;
                        while (guess != answer && attempts > 0) {
                            guess = rrMin + (rrMax - rrMin) / 2;
                            if (guess > answer && guess <= max) {
                                rrMax = guess - 1;
                            } else if (guess < answer && guess >= min) {
                                rrMin = guess + 1;
                            } else if (guess == answer) {
                                wins++;
                                break;
                            }
                            attempts--;
                            if (attempts == 0) {
                                losses++;
                            }
                        }
                    }
                    System.out.println("Wins: " + wins + "\nLosses: " + losses);
                }
            } else {
                System.out.println("Invalid input.");
            }
            System.out.println("Want to play again? [Type 'Y' to return to menu]");
            Replay = sc.next().charAt(0);
            sc.nextLine();
        } while (Replay == 'Y');
    }
}