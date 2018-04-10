import java.util.Arrays;

/**
 * Created by GregHuang on 2018/4/10.
 */
public class DiceRotations {
    public static void main(String[] args) {
        int[] A1 = {1, 2, 3};
        int[] A2 = {1, 1, 6};
        int[] A3 = {1, 6, 2, 3};

        int ans = solution(A1);
        System.out.println(ans);

        ans = solution(A2);
        System.out.println(ans);

        ans = solution(A3);
        System.out.println(ans);
    }

    public static int solution(int[] A) {
        // Select target pips
        int[] count = new int[]{0,0,0,0,0,0};
        int max = 0;
        int maxid = -1;

        for(int i: A) {
            int idx_pips = i - 1;
            int idx_opposite = 7 - idx_pips;

            count[idx_pips] = count[idx_pips] + 1;
            count[idx_opposite] = count[idx_opposite] -1;

            if (maxid != -1) max = count[maxid-1];

            if (max < count[idx_pips]) {
                maxid = i;
            }
        }

        // Cal # of rotation
        int rotate = 0;
        for (int i: A) {
            if (i == maxid) continue;
            else if (i == (7-maxid)) rotate = rotate + 2;
            else rotate++;
        }
        return rotate;
    }
}
