import java.util.*;

public class Solution {

    public static void main(String[] args) {

    }

    /**
     * 1. 两数之和
     * <p>
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * <p>
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            }
            map.put(target - nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }


    /**
     * 11. 盛最多水的容器
     * <p>
     * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     * <p>
     * 说明：你不能倾斜容器，且 n 的值至少为 2。
     */
    public static int maxArea(int[] height) {
        int max = 0;
        for (int i = 0, j = height.length - 1; i < j; ) {
            int minHeight = height[i] < height[j] ? height[i++] : height[j--];
            max = Math.max(max, (j - i) * minHeight);
        }
        return max;
    }

    /**
     * 15. 三数之和
     * <p>
     * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
     * <p>
     * 注意：答案中不可以包含重复的三元组。
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums.length < 3) {
            return lists;
        }
        Arrays.sort(nums);
        int l, r;
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            l = i + 1;
            r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    lists.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    l++;
                    r--;
                } else if (sum > 0) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return lists;
    }

    /**
     * 20. 有效的括号
     * <p>
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     * <p>
     * 有效字符串需满足：
     * <p>
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 注意空字符串可被认为是有效字符串。
     */
    public static boolean isValid(String s) {
        Map<Character, Character> map = new TreeMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char aChar : chars) {
            if (map.containsKey(aChar)) {
                if (stack.size() == 0 || !map.get(aChar).equals(stack.pop())) {
                    return false;
                }
            } else {
                stack.push(aChar);
            }
        }
        return stack.size() == 0;
    }

    /**
     * 26. 删除排序数组中的重复项
     * <p>
     * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
     * <p>
     * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     * <p>
     * 说明:
     * <p>
     * 为什么返回数值是整数，但输出的答案是数组呢?
     * <p>
     * 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
     */
    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[index]) {
                nums[++index] = nums[i];
            }
        }
        return index + 1;
    }

    /**
     * 42. 接雨水
     * <p>
     * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     */
    public static int trap(int[] height) {
        int area = 0;
        int leftMax = 0, rightMax = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            if (height[left] <= height[right]) {
                if (height[left] < leftMax) {
                    area += leftMax - height[left++];
                } else {
                    leftMax = height[left++];
                }
            } else {
                if (height[right] < rightMax) {
                    area += rightMax - height[right--];
                } else {
                    rightMax = height[right--];
                }
            }
        }
        return area;
    }

    /**
     * 66. 加一
     * <p>
     * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
     * <p>
     * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
     * <p>
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     */
    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i] += 1;
                return digits;
            } else {
                digits[i] = 0;
            }
        }
        int[] ints = new int[digits.length + 1];
        ints[0] = 1;
        return ints;
    }

    /**
     * 70. 爬楼梯
     * <p>
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     * <p>
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     * <p>
     * 注意：给定 n 是一个正整数。
     */
    public static int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int num = 0;
        int num1 = 2;
        int num2 = 1;
        for (int i = 3; i <= n; i++) {
            num = num1 + num2;
            num2 = num1;
            num1 = num;
        }
        return num;
    }

    /**
     * 84. 柱状图中最大的矩形
     * <p>
     * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
     * <p>
     * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
     */
    public int largestRectangleArea(int[] heights) {
        // TODO: 2020/5/23 待实现
        return -1;
    }

    /**
     * 155. 最小栈
     * <p>
     * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
     * <p>
     * push(x) —— 将元素 x 推入栈中。
     * pop() —— 删除栈顶的元素。
     * top() —— 获取栈顶元素。
     * getMin() —— 检索栈中的最小元素。
     */
    public static class MinStack {
        // TODO: 2020/5/23 待实现

        public MinStack() {

        }

        public void push(int x) {

        }

        public void pop() {

        }

        public int top() {
            // TODO: 2020/5/23 待实现
            return -1;
        }

        public int getMin() {
            // TODO: 2020/5/23 待实现
            return -1;
        }
    }

    /**
     * 189. 旋转数组
     * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
     * <p>
     * 说明:
     * <p>
     * 1.尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
     * 2.要求使用空间复杂度为 O(1) 的 原地 算法。
     */
    public static void rotate(int[] nums, int k) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        k = k % nums.length;
        int current = nums[nums.length - k];
        for (int i = 0; i < k * nums.length; i = i + k) {
            int z = nums[i % k];
            nums[i % k] = current;
            current = z;
        }
    }

    /**
     * 239. 滑动窗口最大值
     * <p>
     * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
     * <p>
     * 返回滑动窗口中的最大值。
     * <p>
     * 进阶：
     * <p>
     * 你能在线性时间复杂度内解决此题吗？
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        // TODO: 2020/5/23 待实现
        return null;
    }

    /**
     * 283. 移动零
     * <p>
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * <p>
     * 说明:
     * <p>
     * 1.必须在原数组上操作，不能拷贝额外的数组。
     * 2.尽量减少操作次数。
     */
    public static void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                j++;
            }
        }
        for (int i = j; i < nums.length; ++i) {
            nums[i] = 0;
        }
    }

    /**
     * 509. 斐波拉契数
     * <p>
     * 斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
     * <p>
     * F(0) = 0,   F(1) = 1
     * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
     * 给定 N，计算 F(N)。
     */
    public static int fib(int N) {
        if (N == 0) return 0;
        if (N == 1) return 1;
        int n1 = 1;
        int n2 = 0;
        int temp = n1 + n2;
        for (int i = 2; i <= N; i++) {
            temp = n2 + n1;
            n2 = n1;
            n1 = temp;
        }
        return temp;
    }

    /**
     * 641. 设计循环双端队列
     * <p>
     * 设计实现双端队列。
     * 你的实现需要支持以下操作：
     * <p>
     * MyCircularDeque(k)：构造函数,双端队列的大小为k。
     * insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true。
     * insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true。
     * deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true。
     * deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true。
     * getFront()：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。
     * getRear()：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1。
     * isEmpty()：检查双端队列是否为空。
     * isFull()：检查双端队列是否满了。
     * <p>
     * 提示：
     * <p>
     * 所有值的范围为 [1, 1000]
     * 操作次数的范围为 [1, 1000]
     * 请不要使用内置的双端队列库。
     */
    public static class MyCircularDeque {
        // TODO: 2020/5/23 待实现

        /**
         * Initialize your data structure here. Set the size of the deque to be k.
         */
        public MyCircularDeque(int k) {

        }

        /**
         * Adds an item at the front of Deque. Return true if the operation is successful.
         */
        public boolean insertFront(int value) {
            // TODO: 2020/5/23 待实现
            return false;
        }

        /**
         * Adds an item at the rear of Deque. Return true if the operation is successful.
         */
        public boolean insertLast(int value) {
            // TODO: 2020/5/23 待实现
            return false;
        }

        /**
         * Deletes an item from the front of Deque. Return true if the operation is successful.
         */
        public boolean deleteFront() {
            // TODO: 2020/5/23 待实现
            return false;
        }

        /**
         * Deletes an item from the rear of Deque. Return true if the operation is successful.
         */
        public boolean deleteLast() {
            // TODO: 2020/5/23 待实现
            return false;
        }

        /**
         * Get the front item from the deque.
         */
        public int getFront() {
            // TODO: 2020/5/23 待实现
            return -1;
        }

        /**
         * Get the last item from the deque.
         */
        public int getRear() {
            // TODO: 2020/5/23 待实现
            return -1;
        }

        /**
         * Checks whether the circular deque is empty or not.
         */
        public boolean isEmpty() {
            // TODO: 2020/5/23 待实现
            return false;
        }

        /**
         * Checks whether the circular deque is full or not.
         */
        public boolean isFull() {
            // TODO: 2020/5/23 待实现
            return false;
        }
    }
}
