class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode prev = head, curr = head.next;
        int idx = 1;
        int firstIdx = -1, prevIdx = -1;
        int minDist = Integer.MAX_VALUE, maxDist = -1;
        while (curr.next != null) {
            boolean isCritical = (curr.val > prev.val && curr.val > curr.next.val) || (curr.val < prev.val && curr.val < curr.next.val);
            if (isCritical) {
                if (firstIdx == -1) {
                    firstIdx = idx;
                } else {
                    minDist = Math.min(minDist, idx - prevIdx);
                }
                prevIdx = idx;
            }
            prev = curr;
            curr = curr.next;
            idx++;
        }

        if (firstIdx == -1 || firstIdx == prevIdx) return new int[]{-1, -1};
        maxDist = prevIdx - firstIdx;
        return new int[]{minDist, maxDist};
    }
}