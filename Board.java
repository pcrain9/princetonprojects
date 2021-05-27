import java.util.LinkedList;

/*implements an 8board puzzle, given a user-created set of numbers
thanks to https://github.com/keyvanakbary/princeton-algorithms/blob/master/week-4-8-puzzle/Board.java
for all of the guidance and inspiration!*/

public class Board{

    private static final int N = 3;
    private int[] board = new int[9];

    // create a board from an n-by-n array of tiles,
    // where tiles[row][col] = tile at (row, col)
    public Board(int[][] tiles){
        int k = 0;
        //populate the board
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                board[k++] = tiles[i][j];
           }
        }
    }
    //copy the current board to a 2d array
    public int[][] copy(int[] tmpboard){
        int k = 0;
        int[][] tmp = new int[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j< N; j++){
                tmp[i][j] = tmpboard[k++];
            }
        }
        return tmp;
    }
    // string representation of this board
    public String toString(){
        int k = 0;
        StringBuilder str = new StringBuilder();
        str.append(N + "\n");
        for (int i = 0; i < N; i++) {
            for(int j =0; j < N; j++){
            str.append(board[k]);
            k++;
            }
            str.append("\n");
        }
        return str.toString();
    }
    // board dimension n
    public int dimension(){
        return N;
    }
    // number of tiles out of place
    public int hamming(){
        int position = 1;
        int total = 0;

        for(int i = 0; i < 9; i++){
                if(board[i] != position){
                    total ++;
                    position ++;
                }
                else position ++;
            }       
        return total;
    }
    // sum of Manhattan distances between tiles and goal
    public int manhattan(){
        int row = 0;
        int col = 0;
        int total = 0;
        int tmp;
        int[] dim = new int[2];

        for(int i = 0; i < 9; i ++){
            if(board[i] == i + 1) continue;             
            //get the proper dimension
            dim = getcorrect(board[i]);
            //compare what is there to what should be there, subtract and multiply by -1 if <0
            tmp = dim[0] - row + dim[1] - col;
            if(tmp < 0) tmp = tmp * -1;
            total+=tmp;
            col++;
            //reset rows and cols for next round
            if(i == 2){
                row = 1;
                col = 0;
            }
            if(i == 5){
                row = 2;
                col = 0;
            }
        }
        return total;
    }
    //return where the number SHOULD be on the board
    public int[] getcorrect(int x){
        int[] tmp = new int[2];
        if(x == 0){
            tmp[0] = 2;
            tmp[1] = 2;
            return tmp;
        }
        if(x < 3) tmp[0] = 0;
        else if(x == 3 || x == 4 || x == 5) tmp[0] = 1;
        else tmp[0] = 2;

        if(x == 1 || x == 4 || x == 7) tmp[1] = 0;
        else if(x ==2 || x == 5 || x== 8) tmp[1] = 1;
        else tmp[1] = 2;
        return tmp;
    }

    // is this board the goal board?
    public boolean isGoal(){
        if(this.hamming() + this.manhattan() == 0) return true;
        else return false;
    }

    // does this board equal y?
    public boolean equals(Object y){
        return board.equals(y);
    }

    //all neighboring boards
    public Iterable<Board> neighbors(){
        //create a new linked list
        LinkedList<Board> other_boards = new LinkedList<Board>();
        int[] x = getdimension(0);
        
        //adjust rows
        if(x[0] == 0) other_boards.add(new Board(moveup(board)));
        else if(x[0] == 1){ other_boards.add(new Board(moveup(board)));
            other_boards.add(new Board(movedown(board)));}
        else other_boards.add(new Board(movedown(board)));

        //adjust columns
        if(x[1] == 0) other_boards.add(new Board(moveleft(board)));
        else if(x[1] == 1){
            other_boards.add(new Board(moveright(board)));
            other_boards.add(new Board(moveleft(board)));
        }
        else other_boards.add(new Board(moveright(board)));

        return other_boards;
    }

    //return a 2 element array that will give the location of the GIVEN space
    public int[] getdimension(int x){
        int[] k = new int[2];
        int[][] tmp = copy(board);
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(tmp[i][j] == x){
                    k[0] = i;
                    k[1] = j;
                    return k;
                }
            }
        } 
        throw new RuntimeException();
    }

    public int [][] movedown(int[] board){
        int tmp[][] = copy(board);
        int[] x = getdimension(0);
        tmp[x[0]][x[1]] = tmp[x[0] -1][x[1]];
        tmp[x[0] -1][x[1]] = 0;
        return tmp;
    }
    public int [][] moveup(int[] board){
        int tmp[][] = copy(board);
        int[] x = getdimension(0);
        tmp[x[0]][x[1]] = tmp[x[0] +1][x[1]];
        tmp[x[0] +1][x[1]] = 0;
        return tmp;
    }
    public int [][] moveleft(int[] board){
        int tmp[][] = copy(board);
        int[] x = getdimension(0);
        tmp[x[0]][x[1]] = tmp[x[0]][x[1] -1];
        tmp[x[0]][x[1] -1] = 0;
        return tmp;
    }
    public int [][] moveright(int[] board){
        int tmp[][] = copy(board);
        int[] x = getdimension(0);
        tmp[x[0]][x[1]] = tmp[x[0]][x[1] +1];
        tmp[x[0]][x[1] +1] = 0;
        return tmp;
    }
    // a board that is obtained by exchanging any pair of tiles
    public Board twin(){
        Board twinboard = new Board(copy(board));
        return twinboard;
        
    }
    // unit testing (not graded)
    public static void main(String[] args){
        
        int tiles[][] = {{5, 1, 2},{7, 4, 6},{8, 0, 3}};

        Board board = new Board(tiles);

        System.out.println("" + board.toString());

        Iterable <Board> list = new LinkedList<Board>();
        list = board.neighbors();

        for(Board element : list ){
            System.out.println(element.toString());
        }        
    }
}