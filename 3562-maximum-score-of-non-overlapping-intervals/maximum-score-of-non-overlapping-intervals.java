import java.util.*;

class Solution {
    static class Interval {
        int l, r, w, id;
        Interval(int l, int r, int w, int id) {
            this.l = l;
            this.r = r;
            this.w = w;
            this.id = id;
        }
    }

    static class State {
        long score;
        List<Integer> indices;

        State(long score, List<Integer> indices) {
            this.score = score;
            this.indices = indices;
        }

        static State max(State a, State b) {
            if (a == null) return b;
            if (b == null) return a;
            if (a.score > b.score) return a;
            if (b.score > a.score) return b;
            
            int len = Math.min(a.indices.size(), b.indices.size());
            for (int i = 0; i < len; i++) {
                int cmp = Integer.compare(a.indices.get(i), b.indices.get(i));
                if (cmp != 0) return cmp < 0 ? a : b;
            }
            return a.indices.size() <= b.indices.size() ? a : b;
        }
    }

    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();
        Interval[] arr = new Interval[n];
        for (int i = 0; i < n; i++) {
            List<Integer> in = intervals.get(i);
            arr[i] = new Interval(in.get(0), in.get(1), in.get(2), i);
        }

        // Sort by start time, then end time, then original ID for stability
        Arrays.sort(arr, (a, b) -> {
            if (a.l != b.l) return Integer.compare(a.l, b.l);
            if (a.r != b.r) return Integer.compare(a.r, b.r);
            return Integer.compare(a.id, b.id);
        });

        // For each interval i, find the first interval j (where j > i) such that arr[j].l > arr[i].r
        int[] nextIdx = new int[n];
        // Precompute minimum right-boundary suffix or binary search over start times:
        // Since arr is sorted by start time, we can binary search for the first element with l > arr[i].r
        for (int i = 0; i < n; i++) {
            int low = i + 1, high = n - 1, ans = n;
            while (low <= high) {
                int mid = (low + high) >>> 1;
                if (arr[mid].l > arr[i].r) {
                    ans = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            nextIdx[i] = ans;
        }

        State[][] dp = new State[n + 1][5];
        for (int k = 0; k <= 4; k++) {
            dp[n][k] = new State(0, new ArrayList<>());
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int k = 0; k <= 4; k++) {
                State best = dp[i + 1][k]; // Skip

                if (k > 0) {
                    State nextState = dp[nextIdx[i]][k - 1];
                    List<Integer> newIndices = new ArrayList<>();
                    newIndices.add(arr[i].id);
                    newIndices.addAll(nextState.indices);
                    Collections.sort(newIndices);

                    State takeState = new State(nextState.score + arr[i].w, newIndices);
                    best = State.max(best, takeState);
                }
                dp[i][k] = best;
            }
        }

        List<Integer> ansList = dp[0][4].indices;
        int[] res = new int[ansList.size()];
        for (int i = 0; i < ansList.size(); i++) {
            res[i] = ansList.get(i);
        }
        return res;
    }
}