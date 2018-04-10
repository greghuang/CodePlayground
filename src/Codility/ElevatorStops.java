package Codility;

import java.util.*;

/**
 * Created by GregHuang on 21/11/2017.
 */
public class ElevatorStops {
    public static void main(String[] args) {
        int[] A1 = {60, 80, 40};
        int[] B1 = {2, 3, 5};

        int[] A2 = {40, 40, 100, 80 ,20};
        int[] B2 = {3, 3, 2, 2, 3};


        ElevatorStops es = new ElevatorStops();
        int result = es.solution(A1, B1, 5, 2, 200);
        System.out.println(result);

        result = es.solution(A2, B2, 3, 5, 200);
        System.out.println(result);
    }

    /*
     M: number of floor
     X: maximum people
     Y: weight limit
     A: A list of weight for passenger
     B: A list of target floor for passenger

     The question to ask
     1. How to determine how many floor to stop? I use Set in my code
     2. The complexity of your code
     */
    public int solution(int[] A, int[] B, int M, int X, int Y) {
        int totalStop = 0;

        if (A.length != B.length) return -1;

        Set<Integer> floorSet = new HashSet<Integer>();
        int target = 0;
        boolean lastOne = false;

        while (!lastOne) {
            int curPassenger = 0;
            int curWeight = 0, nxtWeight = A[target];

            floorSet.clear();

            while((curPassenger + 1 <= X) && (curWeight + nxtWeight <= Y) && !lastOne) {
                curWeight += nxtWeight;
                curPassenger++;
                floorSet.add(B[target]);

                target++;
                if (target < A.length) nxtWeight = A[target];
                else lastOne = true;
            }

            // cal # of floor to stop
            totalStop += floorSet.size() + 1;
        }

        return totalStop;
    }
}
