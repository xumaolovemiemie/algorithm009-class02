import org.w3c.dom.Node;

import javax.swing.tree.TreeNode;
import java.util.*;

public class Week2 {
    public static void main(String[] args) {

    }

    /**
     * 1. 两数之和
     * <p>
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * <p>
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && map.get(nums[i]) != i) {
                return new int[]{map.get(nums[i]), i};
            }
            map.put(target - nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * 面试题40. 最小的k个数
     * <p>
     * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
     * https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
     * <p>
     * 思路一：通过排序
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int[] res = new int[k];
        System.arraycopy(arr, 0, res, 0, k);
        return res;
    }

    /**
     * 面试题40. 最小的k个数
     * <p>
     * 思路二：通过顶堆实现
     */
    public int[] getLeastNumbers2(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int num : arr) {
            if (queue.size() < k) {
                queue.offer(num);
            } else if (num < queue.peek()) {
                queue.poll();
                queue.offer(num);
            }
        }
        int[] res = new int[k];
        int index = 0;
        for (int value : queue) {
            res[index++] = value;
        }
        return res;
    }

    /**
     * 49. 字母异位词分组
     * <p>
     * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }

    /**
     * 面试题49. 丑数
     * <p>
     * 我们把只包含因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
     * https://leetcode-cn.com/problems/chou-shu-lcof/
     */
    public int nthUglyNumber(int n) {
        // TODO: 2020/5/31
        return -1;
    }

    /**
     * 94. 二叉树的中序遍历
     * <p>
     * 给定一个二叉树，返回它的中序 遍历。
     * * Definition for a binary tree node.
     * * public class TreeNode {
     * *     int val;
     * *     TreeNode left;
     * *     TreeNode right;
     * *     TreeNode(int x) { val = x; }
     * * }
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        // TODO: 2020/5/31
        return null;
    }

    /**
     * 144. 二叉树的前序遍历
     * <p>
     * 给定一个二叉树，返回它的 前序 遍历。
     * * Definition for a binary tree node.
     * * public class TreeNode {
     * *     int val;
     * *     TreeNode left;
     * *     TreeNode right;
     * *     TreeNode(int x) { val = x; }
     * * }
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        // TODO: 2020/5/31
        return null;
    }

    /**
     * 242. 有效的字母异位词
     * <p>
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     */
    public boolean isAnagram(String s, String t) {
        char[] charsS = s.toCharArray();
        Arrays.sort(charsS);
        String newS = new String(charsS);
        char[] charsT = t.toCharArray();
        Arrays.sort(charsT);
        String newT = new String(charsT);
        return newS.equals(newT);
    }

    /**
     * 347. 前 K 个高频元素
     * <p>
     * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
     */
    public int[] topKFrequent(int[] nums, int k) {
        // TODO: 2020/5/31
        return null;
    }

    /**
     * 429. N叉树的层序遍历
     * <p>
     * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
     * * Definition for a Node.
     * * class Node {
     * *     public int val;
     * *     public List<Node> children;
     * *
     * *     public Node() {}
     * *
     * *     public Node(int _val) {
     * *         val = _val;
     * *     }
     * *
     * *     public Node(int _val, List<Node> _children) {
     * *         val = _val;
     * *         children = _children;
     * *     }
     * * };
     */
    public List<List<Integer>> levelOrder(Node root) {
        // TODO: 2020/5/31
        return null;
    }

    /**
     * 589. N叉树的前序遍历
     * <p>
     * 给定一个 N 叉树，返回其节点值的前序遍历。
     * * Definition for a Node.
     * * class Node {
     * *     public int val;
     * *     public List<Node> children;
     * *
     * *     public Node() {}
     * *
     * *     public Node(int _val) {
     * *         val = _val;
     * *     }
     * *
     * *     public Node(int _val, List<Node> _children) {
     * *         val = _val;
     * *         children = _children;
     * *     }
     * * };
     */
    public List<Integer> preorder(Node root) {
        // TODO: 2020/5/31
        return null;
    }

    /**
     * 590. N叉树的后序遍历
     * <p>
     * 给定一个 N 叉树，返回其节点值的后序遍历。
     * * Definition for a Node.
     * * class Node {
     * *     public int val;
     * *     public List<Node> children;
     * *
     * *     public Node() {}
     * *
     * *     public Node(int _val) {
     * *         val = _val;
     * *     }
     * *
     * *     public Node(int _val, List<Node> _children) {
     * *         val = _val;
     * *         children = _children;
     * *     }
     * * }
     */
    public List<Integer> postorder(Node root) {
        // TODO: 2020/5/31
        return null;
    }

}
