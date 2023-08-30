package exam_J1_1;

import java.util.ArrayList;
import java.util.List;

public class aufgebe4 {
    public static void main(String[] args) {
        int[] num = {
                -8, 0, 13, 0, -8, 23, -22, 18, -6, -1,
                -21, -1, 2, 20, -24, 21, 25, -16, -10, -2,
                -20, 15, -15, 0, -16, -19, 13, 24, -3, 7,
                21, -15, 21, -11, 4, -17, 3, 11, 22, 12,
                11, 12, 6, -4, -21, -20, -24, -3, -25, -13,
                17, 19, 19, 20, 22, 9, -10, 12, 16, -1,
                21, -24, 12, 19, -7, 15, 5, -22, 23, 12,
                6, 2, -14, 12, 17, -13, 3, -4, -16, 8,
                16, 6, -23, 0, 3, -16, -6, -14, 8, 25,
                -22, 2, 7, 8, -6, 20, 3, -5, -19, -15};
        List<Integer> positiveNums = new ArrayList<>();
        for (int i = 0; i < num.length; i++) {
            if (num[i] >= 0){
                positiveNums.add(num[i]);
            } else if (num[i] < 0){
                int l = -num[i];
                positiveNums.add(l);
            }
        }
        System.out.println(positiveNums);
    }
}

