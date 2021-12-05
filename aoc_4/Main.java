import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {

        List<Board> boards = new ArrayList<Board>();

        String input = Files.readString(Path.of("C:\\Users\\jensg\\Downloads\\input.txt"));
        List<String> a_Input = new ArrayList<String>(Arrays.stream(input.split("\n")).toList());
        List<Integer> numbers = Arrays.stream(a_Input.get(0).split(",")).map(Integer::parseInt).toList();
        a_Input.remove(a_Input.get(0));
        a_Input.removeAll(Arrays.asList("", null));

        for (int i = 0; i < a_Input.size(); i++) {
            int n_board = (int)(i / 5);
            if(boards.size() == n_board) {
                boards.add(new Board());
            }
            String row = a_Input.get(i).trim().replaceAll(" +", " ");
            boards.get(n_board).setRow(i % 5, Arrays.stream(row.split(" ")).mapToInt(s -> Integer.parseInt(s)).toArray());
        }

        Board fastestBoard = null;
        Board slowestBoard = null;
        int fastestBoardTurns = Integer.MAX_VALUE;
        int slowestBoardTurns = 0;

        for (Board b : boards) {
            int curNumIndex = -1;
            while(!b.isFinished()) {
                curNumIndex++;
                b.markValue(numbers.get(curNumIndex));
            }
            if (curNumIndex < fastestBoardTurns){
                fastestBoard = b;
                fastestBoardTurns = curNumIndex;
            }
            if(curNumIndex > slowestBoardTurns) {
                slowestBoard = b;
                slowestBoardTurns = curNumIndex;
            }
        }

        if(fastestBoard != null) {
            System.out.println("Part 1: " + fastestBoard.getUnmarkedSum() * numbers.get(fastestBoardTurns));
        }
        if(slowestBoard != null) {
            System.out.println("Part 2: " + slowestBoard.getUnmarkedSum() * numbers.get(slowestBoardTurns));
        }
    }
}

