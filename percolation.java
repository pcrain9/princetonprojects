public class Percolation{
    //count current open sites
    int open_sites = 0; 
    //does site peroclate?
    boolean percolates = false;
    //create id# for each site
    int id;
    //what is the size of the number of objects pointing to root?
    int sz = 0;
    //is the site open?
    boolean is_open = false;
    //is the site full?
    boolean is_full = false;

    public Percolation(int n){
        //create grid, setting all values to false
        Percolation[][] grid = new Percolation[n][n];
        
        //fill grid with ID values
        int counter = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                grid[i][j].id = counter;
                counter ++;                
            }
        }       
    }

     // opens the site (row, col) if it is not open already
     public void open(int row, int col){
            //check to see if given value is open (true). If blocked, switch to open
            if(!grid[row][col].is_open){
                grid[row][col].is_open = true;
            }
            //create root class
            private int root(){
                while(n != grid[row][col].id){

                n = grid[row][col].id;
                }
                
                return n;
            }
            //special case: row,col is part of top row
            if(row == 0){
                exit();
            }
            //insert logic to connect open sites together
            else if(grid[row+1][col].is_open = true){
                //attempt to find root
                while(grid[row+1][col].id != )
            } 

            }
         }

     // is the site (row, col) open?
    public boolean isOpen(int row, int col){
        if(grid[row][col].is_open = true){
            return true;
            open_sites++;
        }
        else{
            return false;
        }
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col){
        //chase pointers to root (row 0). if possible, return true

    }

    // returns the number of open sites
    public int numberOfOpenSites(){
        return open_sites;
    }
    // does the system percolate?
    public boolean percolates(){
        return percolates;        
    }

    // test client (optional)
    public static void main(String[] args)
}