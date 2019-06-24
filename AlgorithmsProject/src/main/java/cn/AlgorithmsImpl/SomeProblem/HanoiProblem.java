package cn.AlgorithmsImpl.SomeProblem;

/**
 * 汉诺塔问题：加入了新的限制：无法将一个圆盘直接从左放至右。
 */
public class HanoiProblem {
    public static void main(String[] args) {
        System.out.println(countSteps(10, "left", "mid", "right"));
    }

    private static int countSteps(int num, String left, String mid, String right) {
        if (num < 1) return 0;
        return process(num, left, mid, right, left, right);
    }

    private static int process(int num, String left, String mid, String right, String from, String to) {
        if (num == 1) {
            if (from.equals(mid) || to.equals(mid)) {
                System.out.println("Move 1 form " + from + " to " + to);
                return 1;
            } else {
                System.out.println("Move 1 from " + from + " to mid");
                System.out.println("Move 1 form mid to " + to);
                return 2;
            }
        }
        if (from.equals(mid) || to.equals(mid)) {
            String another = (from.equals(left) || to.equals(left)) ? right : left;
            int part1 = process(num - 1, left, mid, right, from, another);
            int part2 = 1;
            System.out.println("Move " + num + " from " + from + " to " + to);
            int part3 = process(num - 1, left, mid, right, another, to);
            return part1 + part2 + part3;
        } else {
            int part1 = process(num - 1, left, mid, right, from, to);
            int part2 = 1;
            System.out.println("Move " + num + " form " + from + " to " + mid);
            int part3 = process(num - 1, left, mid, right, to, from);
            int part4 = 1;
            System.out.println("Move " + num + " form " + mid + " to " + to);
            int part5 = process(num - 1, left, mid, right, from, to);
            return part1 + part2 + part3 + part4 + part5;
        }
    }
}
