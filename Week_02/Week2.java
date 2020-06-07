import java.util.*;

public class Week2 {
    public static void main(String[] args) {
        System.out.println("...." + nthUglyNumber(10));
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
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
     * 1. 两数之和
     * <p>
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * <p>
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
     */
    public static int[] twoSum(int[] nums, int target) {
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
     * <p>
     * https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
     * <p>
     * 思路一：通过排序
     */
    public static int[] getLeastNumbers(int[] arr, int k) {
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
    public static int[] getLeastNumbers2(int[] arr, int k) {
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
    public static int nthUglyNumber(int n) {
        int[] nums = new int[n];
        nums[0] = 1;
        int i2 = 0, i3 = 0, i5 = 0;
        int temp = 1;
        for (int i = 1; i < n; i++) {
            temp = Math.min(Math.min(nums[i2] * 2, nums[i3] * 3), nums[i5] * 5);
            nums[i] = temp;
            if (temp == nums[i2] * 2) {
                i2++;
            }
            if (temp == nums[i3] * 3) {
                i3++;
            }
            if (temp == nums[i5] * 5) {
                i5++;
            }
        }
        return nums[n - 1];
    }

    /**
     * 94. 二叉树的中序遍历
     * <p>
     * 给定一个二叉树，返回它的中序 遍历。
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        addElement94(list, root);
        return list;
    }

    private static void addElement94(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            addElement94(list, root.left);
        }
        list.add(root.val);
        if (root.right != null) {
            addElement94(list, root.right);
        }
    }

    /**
     * 144. 二叉树的前序遍历
     * <p>
     * 给定一个二叉树，返回它的 前序 遍历。
     */
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        addElement144(list, root);
        return list;
    }

    private static void addElement144(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        if (root.left != null) {
            addElement144(list, root.left);
        }
        if (root.right != null) {
            addElement144(list, root.right);
        }
    }

    /**
     * 242. 有效的字母异位词
     * <p>
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     */
    public static boolean isAnagram(String s, String t) {
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
     * <p>
     * 提示：
     * <p>
     * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
     * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
     * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
     * 你可以按任意顺序返回答案。
     */
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(map::get));
        for (Integer key : map.keySet()) {
            if (queue.size() < k) {
                queue.add(key);
            } else if (map.get(key) > map.get(queue.peek())) {
                queue.remove();
                queue.add(key);
            }
        }
        int[] res = new int[k];
        int count = 0;
        while (!queue.isEmpty()) {
            res[count++] = queue.remove();

        }
        return res;
    }

    /**
     * 429. N叉树的层序遍历
     * <p>
     * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
     * <p>
     * 说明:
     * <p>
     * 树的深度不会超过 1000。
     * 树的节点总数不会超过 5000。
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root != null) {
            addElement429(list, root, 0);
        }
        return list;
    }

    private void addElement429(List<List<Integer>> list, Node root, int level) {
        if (list.size() <= level) {
            list.add(new ArrayList<>());
        }
        list.get(level).add(root.val);
        for (Node child : root.children) {
            addElement429(list, child, level + 1);
        }
    }

    /**
     * 589. N叉树的前序遍历
     * <p>
     * 给定一个 N 叉树，返回其节点值的前序遍历。
     */
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        addElement589(list, root);
        return list;
    }

    private void addElement589(List<Integer> list, Node root) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        List<Node> children = root.children;
        if (children == null || children.size() == 0) {
            return;
        }
        for (Node child : children) {
            addElement589(list, child);
        }
    }

    /**
     * 590. N叉树的后序遍历
     * <p>
     * 给定一个 N 叉树，返回其节点值的后序遍历。
     */
    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        addElement590(list, root);
        return list;
    }

    private void addElement590(List<Integer> list, Node root) {
        if (root == null) {
            return;
        }
        List<Node> children = root.children;
        if (children != null && children.size() > 0) {
            for (Node child : children) {
                addElement590(list, child);
            }
        }
        list.add(root.val);
    }

}
