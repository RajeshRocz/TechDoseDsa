package dsa_aug_25.CapitalOne;

import java.util.Arrays;

public class MatrixGame2 {
    public static void main(String[] args){
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
        int[] arr=filedShape(board, shape);
        System.out.println("Stopping row: " + arr[0]);
        System.out.println("Starting column: " + arr[1]);
    }

    /*
    private static int[] filedShape(int[][] board, int[][] shape){
        int bh=board.length;
        int bw=board[0].length;
        int sh=shape.length;
        int sw=shape[0].length;

        for(int col=0;col<=bw-sw;col++){
            int stopRow=collisionDetection(board,shape,col);
            if(stopRow==-1){
                continue;
            }

            int[][] newBoard=new int[bh][bw];
            for(int i=0;i<bh;i++){
                System.arraycopy(board[i],0,newBoard[i],0,bw);
            }

            for(int i=0;i<sh;i++){
                for(int j=0;j<sw;j++){
                    if(shape[i][j]==1){
                        newBoard[stopRow+i][col+j]=1;
                    }
                }
            }

            for(int i=0;i<bh;i++){
                boolean isFull=true;
                for(int j=0;j<bw;j++){
                    if(newBoard[i][j]==0){
                        isFull=false;
                        break;
                    }
                }
                if(isFull){
                    return new int[]{stopRow, col};
                }
            }

        }
        return new int[]{-1,-1};

    }

    private static int collisionDetection(int[][] board, int[][] shape, int col){
        int m=shape.length;
        int n=shape[0].length;
        int row=0;
        while(row<=board.length-m) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[row + i][col + j] == 1 && shape[i][j] == 1) {
                        return row-1;
                    }
                }
            }
            row++;
        }
        return row-1;
    }*/

    private static int[] filedShape(int[][] board, int[][] shape){
        int height=board.length;
        int width=board[0].length;
        for(int col=0;col<width;col++){
            int stopRow=findCollision(board,shape,col);
            if(stopRow==-1){
                continue;
            }

            int[][] newBoard=new int[height][width];
            for(int i=0;i<height;i++){
                System.arraycopy(board[i],0,newBoard[i],0,width);
            }

            for(int i=0;i< shape.length;i++){
                for(int j=0;j<shape[0].length;j++){
                    if(shape[i][j]==1){
                        newBoard[stopRow+i][col+j]=1;
                    }
                }
            }


            for(int i=0;i<height;i++){
                boolean isFull=true;
                for(int j=0;j<width;j++){
                    if(newBoard[i][j]==0){
                        isFull=false;
                        break;
                    }
                }
                if(isFull){
                    return new int[]{stopRow,col};
                }
            }
        }
        return new int[]{-1,-1};
    }

    private static int findCollision(int[][] board,int[][] shape, int col){
        int row=0;
        while(row<board.length-3){
            for(int i=0;i<shape.length;i++){
                for(int j=0;j<shape[0].length;j++){
                    if(shape[i][j]==1 && board[row+i][col+j]==1){
                        return row-1;
                    }
                }
            }
            row++;
        }
        return row-1;
    }
}
