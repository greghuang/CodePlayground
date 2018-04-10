package Codility;

import java.util.LinkedList;

/**
 * Created by GregHuang on 2018/4/10.
 */
public class CreativeAccounting {

    public static void main(String[] args) {

        System.out.println(solution(123456));
        System.out.println(solution(130));

    }

    public static int solution(int A) {
        LinkedList<Integer> list = new LinkedList<Integer>();

        while (A >= 10) {
            int r = A % 10;
            list.offerFirst(r);
            A = A / 10;
        }
        list.offerFirst(A);

        int ans = 0;

        while(!list.isEmpty()) {
            Integer first = list.pollFirst();
            Integer second = list.pollLast();

            if (first != null) {
                ans = ans * 10 + first;
            }

            if (second != null) {
                ans = ans * 10 + second;
            }
        }

        return ans;
    }
}
