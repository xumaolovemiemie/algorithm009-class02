import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Week3 {
    public static void main(String[] args) {

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 17. 电话号码的字母组合
     * <p>
     * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
     * <p>
     * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
     * <p>
     * 图片见img1
     * <p>
     * 说明:
     * 你可以任意选择答案输出的顺序。
     */
    public static List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        List<String> res = new ArrayList<>();
//        recur17(0, digits, "", res, map);
        backtrack17("", digits, map, res);
        return res;
    }

    public static void backtrack17(String combination, String nextDigits, Map<Character, String> phone, List<String> res) {
        if (nextDigits.length() == 0) {
            res.add(combination);
        } else {
            Character digit = nextDigits.charAt(0);
            String letters = phone.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                char letter = phone.get(digit).charAt(i);
                backtrack17(combination + letter, nextDigits.substring(1), phone, res);
            }
        }
    }

    // Java
    public static void recursion17(int level, String digits, String str, List<String> list, HashMap<Character, String> map) {
        // terminator
        if (level == digits.length()) {
            // process result
            list.add(str);
            return;
        }
        // process current logic
        String letters = map.get(digits.charAt(level));
        for (int i = 0; i < letters.length(); i++) {
            // drill down
            recursion17(level + 1, digits, str + letters.charAt(i), list, map);
        }
        // restore current status
    }

    /**
     * 22. 括号生成
     * <p>
     * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
     */
    public static List<String> generateParenthesis(int n) {
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
     * 46. 全排列
     * <p>
     * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int[] visited = new int[nums.length];
        recursion46(list, nums, new ArrayList<Integer>(), visited);
        return list;
    }

    private static void recursion46(List<List<Integer>> list,int[] nums,ArrayList<Integer> tmp, int[] visited) {
        if (left == max && right == max) {
            list.add(str);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            recursion46(list, left, right + 1, max, str + ")");
        }
    }
//
//    /**
//     * 47. 全排列 II
//     *
//     * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
//     */
//    public List<List<Integer>> permuteUnique(int[] nums) {
//
//    }
//
//    /**
//     * 50. Pow(x, n)
//     *
//     * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
//     */
//    public double myPow(double x, int n) {
//
//    }
//
//    /**
//     * 51. N皇后
//     *
//     * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
//     *
//     * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
//     *
//     * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
//     */
//    public List<List<String>> solveNQueens(int n) {
//
//    }
//
//    /**
//     * 70. 爬楼梯
//     * <p>
//     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
//     * <p>
//     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
//     * <p>
//     * 注意：给定 n 是一个正整数。
//     */
//    public static int climbStairs(int n) {
//        if (n <= 2) {
//            return n;
//        }
//        int num = 0;
//        int num1 = 2;
//        int num2 = 1;
//        for (int i = 3; i <= n; i++) {
//            num = num1 + num2;
//            num2 = num1;
//            num1 = num;
//        }
//        return num;
//    }
//
//    /**
//     * 77. 组合
//     * <p>
//     * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
//     */
//    public List<List<Integer>> combine(int n, int k) {
//
//    }
//
//    /**
//     * 78. 子集
//     *
//     * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
//     *
//     * 说明：解集不能包含重复的子集。
//     */
//    public List<List<Integer>> subsets(int[] nums) {
//
//    }
//
//    /**
//     * 98. 验证二叉搜索树
//     * <p>
//     * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
//     * <p>
//     * 假设一个二叉搜索树具有如下特征：
//     * <p>
//     * 节点的左子树只包含小于当前节点的数。
//     * 节点的右子树只包含大于当前节点的数。
//     * 所有左子树和右子树自身必须也是二叉搜索树。
//     */
//    public boolean isValidBST(TreeNode root) {
//
//    }
//
//    /**
//     * 102. 二叉树的层序遍历
//     *
//     * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
//     */
//    public List<List<Integer>> levelOrder(TreeNode root) {
//
//    }
//
//    /**
//     * 104. 二叉树的最大深度
//     * <p>
//     * 给定一个二叉树，找出其最大深度。
//     * <p>
//     * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
//     * <p>
//     * 说明: 叶子节点是指没有子节点的节点。
//     */
//    public int maxDepth(TreeNode root) {
//
//    }
//
//    /**
//     * 105. 从前序与中序遍历序列构造二叉树
//     * <p>
//     * 根据一棵树的前序遍历与中序遍历构造二叉树。
//     * <p>
//     * 注意:你可以假设树中没有重复的元素。
//     */
//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//
//    }
//
//    /**
//     * 111. 二叉树的最小深度
//     * <p>
//     * 给定一个二叉树，找出其最小深度。
//     * <p>
//     * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
//     * <p>
//     * 说明: 叶子节点是指没有子节点的节点。
//     */
//    public int minDepth(TreeNode root) {
//
//    }
//
//    /**
//     * 169. 多数元素
//     *
//     * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
//     *
//     * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
//     */
//    public int majorityElement(int[] nums) {
//
//    }
//
//    /**
//     * 226. 翻转二叉树
//     * <p>
//     * 翻转一棵二叉树。
//     */
//    public TreeNode invertTree(TreeNode root) {
//
//    }
//
//    /**
//     * 236. 二叉树的最近公共祖先
//     * <p>
//     * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
//     * <p>
//     * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
//     */
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//
//    }
//
//    /**
//     * 297. 二叉树的序列化与反序列化
//     * <p>
//     * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
//     * <p>
//     * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
//     */
//    public class Codec {
//
//        // Encodes a tree to a single string.
//        public String serialize(TreeNode root) {
//
//        }
//
//        // Decodes your encoded data to tree.
//        public TreeNode deserialize(String data) {
//
//        }
//    }

}
