package dsa_aug_25.CapitalOne;

class MatrixGame1 {
    public static void main(String[] args) {
        int arr[] = MatrixGame1.fieldAndShape();
        System.out.println("Stopping row: " + arr[0]);
        System.out.println("Starting column: " + arr[1]);
    }

    public static int[] fieldAndShape(){
        int[][] board = {
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 0},
                {0, 0, 0, 1},
                {0, 1, 1, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 1, 1, 0}
        };

        int[][] shape = {
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        };

        int height = board.length;
        int width = board[0].length;

        // Try each possible starting column
        for(int col = 0; col <= width - 3; col++){
            int stopRow = collisionDetection(board, shape, 0, col);
            if(stopRow == -1) continue; // collision at top

            // Copy board to simulate placement
            int[][] newBoard = new int[height][width];
            for(int i=0;i<height;i++){
                System.arraycopy(board[i], 0, newBoard[i], 0, width);
            }

            // Place shape
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    if(shape[i][j] == 1){
                        newBoard[stopRow+i][col+j] = 1;
                    }
                }
            }

            // Check for full row
            for(int r=0;r<height;r++){
                boolean full = true;
                for(int c=0;c<width;c++){
                    if(newBoard[r][c] == 0){
                        full = false;
                        break;
                    }
                }
                if(full){
                    return new int[]{stopRow, col};
                }
            }
        }

        return new int[]{-1,-1};
    }

    public static int collisionDetection(int[][] board, int[][] shape,int i, int j){
        while(i < board.length - 2){ // ground will stop the fall
            for(int x=0;x<3;x++){
                for(int y=0;y<3;y++){
                    if(board[i+x][j+y]==1 && shape[x][y]==1){
                        return i-1;
                    }
                }
            }
            i++;
        }
        return i-1;
    }
}

