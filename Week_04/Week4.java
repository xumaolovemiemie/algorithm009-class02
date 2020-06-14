import java.util.*;

/**
 * @author xumao
 */
public class Week4 {
    public static void main(String[] args) {

    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 22. 括号生成
     * <p>
     * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
     */
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        recursion22(list, 0, 0, n, "");
        return list;
    }

    private static void recursion22(List<String> list, int left, int right, int max, String str) {
        if (left == max && right == max) {
            list.add(str);
            return;
        }
        if (left < max) {
            recursion22(list, left + 1, right, max, str + "(");
        }
        if (right < left) {
            recursion22(list, left, right + 1, max, str + ")");
        }
    }

    /**
     * 69. x 的平方根
     * <p>
     * 实现 int sqrt(int x) 函数。
     * <p>
     * 计算并返回 x 的平方根，其中 x 是非负整数。
     * <p>
     * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
     */
    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        int high = x;
        int low = 0;
        int res = -1;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if ((long) middle * middle <= x) {
                res = middle;
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return res;
    }

    /**
     * 牛顿迭代法
     */
    public int mySqrt2(int x) {
        long i = x;
        while (i * i > x) {
            i = (i + x / i) / 2;
        }
        return (int) i;
    }

    /**
     * 102. 二叉树的层序遍历
     * <p>
     * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        recursion102(1, root, res);
        return res;
    }

    private void recursion102(int index, TreeNode root, List<List<Integer>> res) {
        if (res.size() < index) {
            res.add(new ArrayList<>());
        }
        res.get(index - 1).add(root.val);
        if (root.left != null) {
            recursion102(index + 1, root.left, res);
        }
        if (root.right != null) {
            recursion102(index + 1, root.right, res);
        }
    }

    /**
     * 122. 买卖股票的最佳时机 II
     * <p>
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     * <p>
     * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
     * <p>
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     * <p>
     * 提示：
     * <p>
     * 1 <= prices.length <= 3 * 10 ^ 4
     * <p>
     * 0 <= prices[i] <= 10 ^ 4
     */
    public int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                res += prices[i] - prices[i - 1];
            }
        }
        return res;
    }

    /**
     * 127. 单词接龙
     * <p>
     * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
     * <p>
     * 每次转换只能改变一个字母。
     * 转换过程中的中间单词必须是字典中的单词。
     * 说明:
     * <p>
     * 如果不存在这样的转换序列，返回 0。
     * 所有单词具有相同的长度。
     * 所有单词只由小写字母组成。
     * 字典中不存在重复的单词。
     * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // TODO: 2020/6/14
        return -1;
    }

    /**
     * 200. 岛屿数量
     * <p>
     * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
     * <p>
     * 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。
     * <p>
     * 此外，你可以假设该网格的四条边均被水包围。
     */
    public int numIslands(char[][] grid) {
        // TODO: 2020/6/14
        return -1;
    }

    /**
     * 322. 零钱兑换
     * <p>
     * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
     * 说明:
     * 你可以认为每种硬币的数量是无限的
     */
    public int coinChange(int[] coins, int amount) {
        // TODO: 2020/6/14
        return -1;
    }

    /**
     * 367. 有效的完全平方数
     * <p>
     * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
     * <p>
     * 说明：不要使用任何内置的库函数，如  sqrt。
     */
    public boolean isPerfectSquare(int num) {
        if (num <= 1) {
            return true;
        }
        int high = num, low = 0, res = -1;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if ((long) middle * middle <= num) {
                res = middle;
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return res * res == num;
    }

    /**
     * 牛顿迭代法
     */
    public boolean isPerfectSquare2(int num) {
        long i = num;
        while (i * i > num) {
            i = (i + num / i) / 2;
        }
        return i * i == num;
    }

    /**
     * 433. 最小基因变化
     * <p>
     * 一条基因序列由一个带有8个字符的字符串表示，其中每个字符都属于 "A", "C", "G", "T"中的任意一个。
     * <p>
     * 假设我们要调查一个基因序列的变化。一次基因变化意味着这个基因序列中的一个字符发生了变化。
     * <p>
     * 例如，基因序列由"AACCGGTT" 变化至 "AACCGGTA" 即发生了一次基因变化。
     * <p>
     * 与此同时，每一次基因变化的结果，都需要是一个合法的基因串，即该结果属于一个基因库。
     * <p>
     * 现在给定3个参数 — start, end, bank，分别代表起始基因序列，目标基因序列及基因库，请找出能够使起始基因序列变化为目标基因序列所需的最少变化次数。如果无法实现目标变化，请返回 -1。
     * <p>
     * 注意:
     * <p>
     * 起始基因序列默认是合法的，但是它并不一定会出现在基因库中。
     * 所有的目标基因序列必须是合法的。
     * 假定起始基因序列与目标基因序列是不一样的。
     */
    public int minMutation(String start, String end, String[] bank) {
        // TODO: 2020/6/14
        return -1;
    }

    /**
     * 455. 分发饼干
     * <p>
     * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。对每个孩子 i ，都有一个胃口值 gi ，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j ，都有一个尺寸 sj 。如果 sj >= gi ，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
     * <p>
     * 注意：
     * <p>
     * 你可以假设胃口值为正。
     * 一个小朋友最多只能拥有一块饼干。
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int childIndex = 0;
        int biscuitIndex = 0;
        while (childIndex < g.length && biscuitIndex < s.length) {
            if (g[childIndex] <= s[biscuitIndex]) {
                childIndex++;
            }
            biscuitIndex++;
        }
        return childIndex;
    }

    /**
     * 515. 在每个树行中找最大值
     * <p>
     * 您需要在二叉树的每一行中找到最大的值。
     */
    public List<Integer> largestValues(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        recursion515(1, root, res);
        return res;
    }

    private void recursion515(int index, TreeNode root, List<Integer> res) {
        if (res.size() < index) {
            res.add(root.val);
        } else if (res.get(index - 1) < root.val) {
            res.set(index - 1, root.val);
        }
        if (root.left != null) {
            recursion515(index + 1, root.left, res);
        }
        if (root.right != null) {
            recursion515(index + 1, root.right, res);
        }
    }

    /**
     * 860. 柠檬水找零
     * <p>
     * 在柠檬水摊上，每一杯柠檬水的售价为 5 美元。
     * <p>
     * 顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
     * <p>
     * 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
     * <p>
     * 注意，一开始你手头没有任何零钱。
     * <p>
     * 如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
     * <p>
     * 提示：
     * <p>
     * 0 <= bills.length <= 10000
     * bills[i] 不是 5 就是 10 或是 20
     */
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                if (five > 0) {
                    five--;
                    ten++;
                } else {
                    return false;
                }
            } else {
                if (five > 0 && ten > 0) {
                    five--;
                    ten--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 874. 模拟行走机器人
     * <p>
     * 机器人在一个无限大小的网格上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令：
     * <p>
     * 1. -2：向左转 90 度
     * 2. -1：向右转 90 度
     * 3. 1 <= x <= 9：向前移动 x 个单位长度
     * 4. 在网格上有一些格子被视为障碍物。
     * <p>
     * 第 i 个障碍物位于网格点  (obstacles[i][0], obstacles[i][1])
     * <p>
     * 机器人无法走到障碍物上，它将会停留在障碍物的前一个网格方块上，但仍然可以继续该路线的其余部分。
     * <p>
     * 返回从原点到机器人所有经过的路径点（坐标为整数）的最大欧式距离的平方。
     * <p>
     * 提示：
     * <p>
     * 1. 0 <= commands.length <= 10000
     * 2. 0 <= obstacles.length <= 10000
     * 3. -30000 <= obstacle[i][0] <= 30000
     * 4. -30000 <= obstacle[i][1] <= 30000
     * 5. 答案保证小于 2 ^ 31
     */
    public int robotSim(int[] commands, int[][] obstacles) {
        // TODO 题目没理解，有时间再看
        return -1;
    }
}
