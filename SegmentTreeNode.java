public class SegmentTreeNode {
    private int val;
    private int start;
    private int end;
    private SegmentTreeNode left;
    private SegmentTreeNode right;

    // constructor
    public SegmentTreeNode(int val, int start, int end, SegmentTreeNode left, SegmentTreeNode right) {
        this.val = val;
        this.start = start;
        this.end = end;
        this.left = left;
        this.right = right;
    }

    // constructor
    public SegmentTreeNode(int val, int start, int end) {
        this(val, start, end, null, null);
    }

    /**
     * Build a segment tree from the given array.
     *
     * @param arr the given array
     */
    public static SegmentTreeNode createSegmentTree(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        return createSegmentTreeHelper(arr, 0, arr.length - 1);
    }

    /**
     * Helper method to build a segment tree from the given array.
     *
     * @param arr the given array
     * @param low the lower boundary
     * @param high the higher boundary
     */
    private static SegmentTreeNode createSegmentTreeHelper(int[] arr, int low, int high) {
        if (low == high) {
            return new SegmentTreeNode(arr[low], low, high);
        }
        int mid = low + (high - low) / 2;
        // build left and right child
        SegmentTreeNode left = createSegmentTreeHelper(arr, low, mid);
        SegmentTreeNode right = createSegmentTreeHelper(arr, mid + 1, high);
        return new SegmentTreeNode(left.val + right.val, low, high, left, right);
    }

    /**
     * Updates the element at index i with the given value.
     *
     * @param i the index
     * @param val the value
     */
    public void update(int i, int val) {
        if (i > this.end || i < this.start) {
            return;
        }
        if (i == this.start && i == this.end) {
            this.val = val;
            return;
        }
        int mid = start + (end - start) / 2;
        if (i <= mid) {
            this.left.update(i, val);
        }
        else {
            this.right.update(i, val);
        }
        this.val = this.left.val + this.right.val;
    }

    /**
     * Calculates the sum of a segment.
     *
     * @param i the lower boundary
     * @param j the higher boundary
     */
    public int sum(int i, int j) {
        if (i > this.end || i < this.start || j > this.end || j < this.start) {
            return 0;
        }
        if (i == this.start && j == this.end) {
            return this.val;
        }
        int mid = start + (end - start) / 2;
        if (j <= mid) {
            return this.left.sum(i, j);
        }
        else if (i > mid) {
            return this.right.sum(i, j);
        }
        return this.left.sum(i, mid) + this.right.sum(mid + 1, j);
    }
}
