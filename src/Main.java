import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        wordSpliter(openFile());
    }

    public static Scanner openFile(){
        Scanner scanner;
        while (true){
            System.out.print("Input path: ");
            Scanner in = new Scanner(System.in);
            String path = in.nextLine();
            try {
                scanner = new Scanner(new File(path));
                break;
            }
            catch (FileNotFoundException ex){
                System.out.println("File not found, try again");
            }
        }
        return scanner;
    }

    public static void wordSpliter(Scanner scanner){
        TreeMap<String, Integer> statistics = new TreeMap<>();
        HashMap<String, Integer> maxValue = new HashMap<>();
        int max = 1;
        while (scanner.hasNext()){
            String word = scanner.useDelimiter("(\\s+)|(\\.+)|(,+)|(!+)|(\\?+)|(\\(+)|(\\)+)|(;+)").next();
            if (word.equals("")) continue;
            if (statistics.containsKey(word)) {
                statistics.put(word, statistics.get(word) + 1);
                if (statistics.get(word) > max) {
                    maxValue.clear();
                    max = statistics.get(word);
                    maxValue.put(word, max);
                }
                if (statistics.get(word) == max) maxValue.put(word, max);
            }
            else statistics.put(word, 1);
        }
        System.out.println("Contains: " + statistics);
        System.out.println("Max value: " + maxValue);
    }
}
