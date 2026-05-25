class Solution {
    public int[] asteroidCollision(int[] arr) {
        ArrayList<Integer> s = new ArrayList<>();
        for (int a : arr) {
            if (a > 0) {
                s.add(a);
            } else {
                boolean destroyed = false;
                while (s.size() > 0 && s.get(s.size() - 1) > 0) {
                    int top = s.get(s.size() - 1);
                    if (Math.abs(a) > top) {
                        s.remove(s.size() - 1);
                    } else if (Math.abs(a) == top) {
                        s.remove(s.size() - 1);
                        destroyed = true;
                        break;
                    } else {
                        destroyed = true;
                        break;
                    }
                }
                if (!destroyed) {
                    s.add(a);
                }
            }
        }
        int[] res = new int[s.size()];
        for (int i = 0; i < s.size(); i++) {
            res[i] = s.get(i);
        }
        return res;
    }
}