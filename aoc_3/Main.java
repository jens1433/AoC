import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class Main {

    // Day 3 part 2
    public static void main(String[] args) throws IOException {

        String records = Files.readString(Path.of("C:\\Users\\jensg\\Downloads\\input.txt"));
        List<String> recordList = Arrays.stream(records.split("\n")).toList();
        List<String> oxygenRating = recordList;
        int place = 0;
        while(oxygenRating.size() > 1) {
            int fPlace = place;
            List<String> fOxygenRating = oxygenRating;
            oxygenRating = oxygenRating.stream().filter(record -> record.substring(fPlace, fPlace + 1).equals(findCommonBit(fOxygenRating, fPlace, false))).toList();
            place++;
        }
        List<String> scrubberRating = recordList;
        place = 0;
        while(scrubberRating.size() > 1) {
            int fPlace = place;
            List<String> fScrubberRating = scrubberRating;
            scrubberRating = scrubberRating.stream().filter(record -> record.substring(fPlace, fPlace + 1).equals(findCommonBit(fScrubberRating, fPlace, true))).toList();
            place++;
        }
        int i_oxygenRating = Integer.parseInt(oxygenRating.get(0), 2);
        int i_scrubberRating = Integer.parseInt(scrubberRating.get(0), 2);
        System.out.println(i_oxygenRating * i_scrubberRating);
    }

    public static String findCommonBit(List<String> records, int place, boolean fewer) {
        int zero, one = zero = 0;
        for (String record : records){
            if(record.substring(place, place + 1).equals("1")) {
                one++;
            } else {
                zero++;
            }
        }
        return fewer ? (zero > one ? "1" : "0")  : (zero > one ? "0" : "1");
    }
}
