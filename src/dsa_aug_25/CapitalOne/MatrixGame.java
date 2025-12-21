package dsa_aug_25.CapitalOne;

public class MatrixGame {

    public static void main(String[] args) {
        int arr[] = fieldAndShape();
        System.out.println(arr[0]); // stopping index
        System.out.println(arr[1]);

    }

    public static int[] fieldAndShape(){
        int[][] board = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 1},
                {0, 0, 0, 1},
                {0, 1, 1, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 1, 1, 0}
        };

        int[][] shape = new int[][] {
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        };

        int rowSum[] = new int[board.length];

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                rowSum[i]+=board[i][j];
            }
        }

        for(int j=0;j<board[0].length-2;j++){
            // i will always be 0 as we have to start from top

            int a = collisionDetection(board,shape, 0, j);
            if(a==-1){
                // means the collision is at the dropping place itself
                continue;
            }
            else{
                // checking for rowSum
                for(int x=0;x<3;x++){
                    int increase = 0;
                    for(int y=0;y<3;y++){
                        increase+= shape[x][y];
                    }
                    if(rowSum[a+x]+ increase==board[0].length){
                        return new int[]{a,j};
                    }
                } // O(9)
            }
        }

        return new int[]{-1,-1};

    }

    public static int collisionDetection(int[][] board, int[][] shape,int i, int j){
        // drop simulation and collision detection
        while(i<board.length-2){ // ground will stop the fall

            for(int x=0;x<3;x++){
                for(int y=0;y<3;y++){
                    if(board[i+x][j+y]==1 && shape[x][y]==1){
                        return i-1;
                    }
                }
            }
            i++;
        }
        // if collision happened on i, it would have stopped on i-1, otherwise board.length-3
        return i-1;
    }
}

// board.length = n, board[0].length =m
// each valid starting index i,j : 9* (n-2) + 9 (for row sum check)
// Total valid start indexes  = m-2
// TC: ~~  9*n*m


