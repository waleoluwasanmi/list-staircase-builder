import java.util.*;
import java.io.*;

/**
 * This piece of code should read in an unsorted list and build a staircase representation out
 * of it with each row increasing  count as we build the stair case. Prints out the staircase at the end.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        SortedMap<Integer, String> sMap = new TreeMap<>();

        //File inFile = new File("C:\\Users\\waleo\\Documents\\3love.txt");
        File inFile = new File(args[0]);
        BufferedReader reader = new BufferedReader(new FileReader(inFile));
        String st = null;
        int numItems = 0;

        //store values in a sorted way
        while ((st = reader.readLine()) != null)
        {
            if (!st.isEmpty()) {
                StringTokenizer tokenizer = new StringTokenizer(st);
                int index = Integer.parseInt(tokenizer.nextToken());

                String mainText = tokenizer.nextToken();
                // Put entry in sorted map
                sMap.put(index, mainText);
                numItems++;
            }
        }

        reader.close();

        //skip through map with increasing index read
        List<String> decodedString = new ArrayList<>();
        int skipLength = 1;
        int numProcessed = 0;

        while (numProcessed < numItems){
            int indexToPocess = numProcessed + (skipLength);

            if (indexToPocess > numItems) break;
            decodedString.add(sMap.get(indexToPocess));;
            numProcessed =  indexToPocess;
            skipLength++;
        }

        for (String word: decodedString){
            System.out.println(word);
        }
    }
}