## DP 思维要点

1. 化繁为简，分解出子问题 （分治）
2. 定义好状态空间
3. 推导出 DP 方程

## DP 问题的几种解法思路

1. 递归（自顶向下）
2. 递归 + 备忘录（自顶向下）
3. 迭代 + 备忘录（自底向上）
4. 迭代 + 2 个变量（自底向上）

## 以 198 题打家劫舍为例子

### 1. 递归（自顶向下）

面对第 N 间房子，只有两个选项： 偷， 不偷。 需要通过比大小来选择偷还不是不偷。
推导出 DP 方程（过程略过）。

> rob(i) = Math.max( rob(i - 2) + currentHouseValue, rob(i - 1) )

```java
public int rob(int[] nums) {
    return rob(nums, nums.length - 1);
}
private int rob(int[] nums, int i) {
    if (i < 0) {
        return 0;
    }
    return Math.max(rob(nums, i - 2) + nums[i], rob(nums, i - 1));
}
```

### 2. 递归 + 备忘录（自顶向下）

递归的方式性能太差，中间有太多重复的计算。可以用备忘录模式把计算的值缓存起来。

```java
int[] memo;
public int rob(int[] nums) {
    memo = new int[nums.length + 1];
    Arrays.fill(memo, -1);
    return rob(nums, nums.length - 1);
}

private int rob(int[] nums, int i) {
    if (i < 0) {
        return 0;
    }
    if (memo[i] >= 0) {
        return memo[i];
    }
    int result = Math.max(rob(nums, i - 2) + nums[i], rob(nums, i - 1));
    memo[i] = result;
    return result;
}
```

### 3. 迭代 + 备忘录（自底向上）

从底下往上递推，可以把递归转成迭代的写法。

```java
public int rob(int[] nums) {
    if (nums.length == 0) return 0;
    int[] memo = new int[nums.length + 1];
    memo[0] = 0;
    memo[1] = nums[0];
    for (int i = 1; i < nums.length; i++) {
        int val = nums[i];
        memo[i+1] = Math.max(memo[i], memo[i-1] + val);
    }
    return memo[nums.length];
}
```

### 4. 迭代 + 2 个变量（自底向上）

通过上面的优化，我们可以看到主要只使用了 memo[i] 和 memo[i-1]， 所以可以考虑用 2 个变量来替代。

```java
public int rob(int[] nums) {
    if (nums.length == 0) return 0;
    int prev1 = 0;
    int prev2 = 0;
    for (int num : nums) {
        int tmp = prev1;
        prev1 = Math.max(prev2 + num, prev1);
        prev2 = tmp;
    }
    return prev1;
}
```

## 小结

动态规划的问题，难点在于如何把问题分解成最优子问题。找到了最优子问题，定义好 DP 方程，按照模版来套基本就差不多了。 另外，自底向上的迭代法是最优方案。
