import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println(solutionB(1, 8, 3, 2));
        System.out.println(solutionB(9, 8, 7, 6));
    }

    static Date curTime = null;
    static Date lastTime = null;
    static String answer = "";
    public static String solutionB(int A, int B, int C, int D) {
        curTime = null;
        lastTime = null;
        answer = "";

        int[] array = {A, B, C, D};
        sort(null, array);
        if (lastTime == null)
            return "Invalid time";
        else
            return answer;
    }

    private static void sort(List<Integer> list, int[] a) {
        if(list == null)
            list = new ArrayList<Integer>();

        if (a.length == 1) {
            list.add(a[0]);

            int hour = Integer.parseInt(String.format("%d%d",list.get(0),list.get(1)));
            int minute = Integer.parseInt(String.format("%d%d", list.get(2), list.get(3)));

            if (hour <= 0 || hour > 23) return;
            if (minute <= 0 || minute > 59) return;

            String timeStr = String.format("%d:%d", hour, minute);
            //System.out.println(timeStr);

            SimpleDateFormat parser = new SimpleDateFormat("HH:mm", Locale.ENGLISH);
            parser.setTimeZone(TimeZone.getTimeZone("UTC"));
            System.out.println("Time zone:" + parser.getTimeZone().toString());

            try {
                curTime = parser.parse(timeStr);

                if (lastTime == null || curTime.after(lastTime)) {
                    lastTime = curTime;
                    answer = timeStr;
                }
            } catch (ParseException e) {
                System.out.println("Time format is not valid:" + curTime);
            }
        }

        for (int i = 0; i < a.length; i++) {
            //list.add(a[i]);
            List newList = new ArrayList<Integer>(list);
            newList.add(a[i]);
            sort(newList, copy(a, i));
        }
    }

    private static int[] copy(int[] a,int index){
        int[] b = new int[a.length-1];
        System.arraycopy(a, 0, b, 0, index);
        System.arraycopy(a, index + 1, b, index, a.length - index - 1);
        return b;
    }
}
