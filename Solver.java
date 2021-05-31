import java.util.LinkedList;
import java.util.Arrays;

public class Solver {

    int moves = 0;
    Board [] storedBoards = new Board [100];

    // find a solution to the initial board (using the A* algorithm)
    public Solver(Board initial){
        if(initial ==null) throw new IllegalArgumentException();
        

        Board current = initial;
        Iterable <Board> list = new LinkedList<Board>();
        while(!current.isGoal()){        
            list = current.neighbors();
        
            //check all neighbors
            for(Board element : list){
                 if(element.hamming() <= current.hamming()){
                    current = element;
                }
            }
            //add to solution array
            storedBoards[moves++] = current;            
        }
    
    }

    // min number of moves to solve initial board; -1 if unsolvable
    public int moves(){
        //if board is unsolvable, return -1
        return moves;
    }

    // sequence of boards in a shortest solution; null if unsolvable
    public Iterable<Board> solution(){

        Iterable<Board> list = Arrays.asList(storedBoards);

        return list;       
    }
    
    // test client (see below) 
    public static void main(String[] args){
        //initialize board
        int tiles[][] = {{5, 1, 2},{7, 4, 6},{8, 0, 3}};
        //check for solvability. Credit: https://www.geeksforgeeks.org/check-instance-8-puzzle-solvable/
        int invCount = 0;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j< 3; j++){
                if (tiles[j][i] > 0 && tiles[j][i] > tiles[i][j]) invCount++;  
            }
        }     
         if(invCount % 2 != 0){
            System.out.println("Unsolvable puzzle.");
            System.exit(1);
        }

        //begin solve
        Board board = new Board(tiles);
        Solver solver = new Solver(board);        
        Iterable<Board> list = solver.solution();

        System.out.println("Number of moves needed to solve puzzle: " + solver.moves() + "\n");
        for(Board element : list){
            if(element == null) System.exit(0);
            System.out.println("" + element.toString());
        }
    }
}



