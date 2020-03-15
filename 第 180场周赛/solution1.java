package LeetCode_solution.competition2;

import java.util.ArrayList;
import java.util.List;

public class solution1 {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int[] row=new int[matrix.length];
        int[] column=new int[matrix[0].length];
        List<Integer> res=new ArrayList();
        for(int i=0;i<matrix.length;i++){
            int max=0;
            for(int j=0;j<matrix[0].length;j++){
                max=Math.max(max,matrix[i][j]);
            }
            row[i]=max;
        }
        for(int j=0;j<matrix[0].length;j++){
            int min=0;
            for(int i=0;i<matrix.length;i++){
                min=Math.min(min,matrix[i][j]);
            }
            column[j]=min;
        }
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==row[i] && row[i]==column[j]){
                    res.add(column[j]);
                }
            }

        }
        return res;

    }
}
