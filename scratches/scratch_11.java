class Scratch {
    public static void main(String[] args) {
        int[][] matrix = new int[6][6];
        matrix[0][0]=1; matrix[0][1]=1; matrix[0][2]=1; matrix[0][3]=0; matrix[0][4]=0; matrix[0][5]=0;
        matrix[1][0]=0; matrix[1][1]=1; matrix[1][2]=0; matrix[1][3]=0; matrix[1][4]=0; matrix[1][5]=0;
        matrix[2][0]=1; matrix[2][1]=1; matrix[2][2]=1; matrix[2][3]=0; matrix[2][4]=0; matrix[2][5]=0;
        matrix[3][0]=0; matrix[3][1]=0; matrix[3][2]=2; matrix[3][3]=4; matrix[3][4]=4; matrix[3][5]=0;
        matrix[4][0]=0; matrix[4][1]=0; matrix[4][2]=0; matrix[4][3]=2; matrix[4][4]=0; matrix[4][5]=0;
        matrix[5][0]=0; matrix[5][1]=0; matrix[5][2]=1; matrix[5][3]=2; matrix[5][4]=4; matrix[5][5]=0;

        System.out.println(hourglassSum(matrix));
    }

    static int hourglassSum(int[][] arr) {

        int max = -10;

        for (int i = 0; i+2 < arr.length;i++) {
            for (int j = 0; j+2 < arr[i].length;j++) {
                max = Math.max(max,
                        arr[i][j]+arr[i][j+1]+arr[i][j+2]+arr[i+1][j+1]+arr[i+2][j]+arr[i+2][j+1]+arr[i+2][j+2]);
            }
        }

        return max;
    }
}