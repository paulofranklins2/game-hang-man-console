import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        char input = ' ';
        int missingLetter = 0;
        char[] guessingWord = {'_', '_', '_', '_', '_',};

        ArrayList<String> listOfWords = new ArrayList<>(Arrays.asList("Alarm", "Apple", "Arrow", "Basin", "Bench", "Bible", "Blade", "Blank", "Block", "Board", "Books", "Booth", "Bowls", "Bread", "Brush", "Chair", "Charm", "Check", "Chess", "Chime", "Chord", "Clock", "Clasp", "Clips", "Clock", "Coast", "Coins", "Comb", "Coral", "Crisp", "Cross", "Crown", "Curve", "Dance", "Darts", "Dates", "Decks", "Diode", "Discs", "Dishes", "Dolls", "Donut", "Drums", "Dress", "Drill", "Drink", "Drops", "Duster", "Easel", "Eggs", "Elbow", "Erase", "Error", "Fable", "Fairy", "Falls", "False", "Fence", "Ficus", "Field", "Film", "Flags", "Flask", "Fleet", "Flute", "Folds", "Force", "Frame", "Fruit", "Games", "Ghost", "Gifts", "Glass", "Gloves", "Gourd", "Grape", "Grill", "Grind", "Group", "Guest", "Guitar", "Habit", "Halos", "Hands", "Harps", "Heart", "Herbs", "Hoops", "Hotel", "House", "Icicle", "Inked", "Jolly", "Juice", "Kites", "Knife", "Knobs", "Lamps", "Lanes", "Latch"));
        int randomWord = new Random().nextInt(listOfWords.size());

        System.out.println("Answer: " + listOfWords.get(randomWord));
        String[] split = listOfWords.get(randomWord).split("");

        for (char c : guessingWord) {
            System.out.print(c + "");
            missingLetter++;
        }
        System.out.println();

        while (missingLetter > 0) {
            System.out.println("Missing Letters: " + missingLetter);
            try {
                do {
                    System.out.println("Enter Letter");
                    String inputStr = scanner.next();
                    if (inputStr.length() != 1) {
                        System.out.println("Invalid Input. Please enter a single letter.");
                        continue;
                    }
                    input = inputStr.charAt(0);
                } while (!Character.isLetter(input));
            } catch (Exception e) {
                System.out.println("Invalid Input");
            }
            for (int i = 0; i < split.length; i++) {
                if (split[i].equalsIgnoreCase(String.valueOf(input)) && guessingWord[i] == '_') {
                    guessingWord[i] = input;
                    missingLetter--;
                } else if (guessingWord[i] != '_') {
                    guessingWord[i] = guessingWord[i];
                } else {
                    guessingWord[i] = '_';
                }
            }
            for (char c : guessingWord) {
                System.out.print(c + "");
            }
            System.out.println();
        }
    }

}
