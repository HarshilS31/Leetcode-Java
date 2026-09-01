class Solution {
    private static final int[] DX = {-1, 1, 0, 0};
    private static final int[] DY = {0, 0, -1, 1};

    private static class State {
        int x, y, mask, energy, steps;
        State(int x, int y, int mask, int energy, int steps) {
            this.x = x;
            this.y = y;
            this.mask = mask;
            this.energy = energy;
            this.steps = steps;
        }
    }
    public int minMoves(String[] classroom, int maxEnergy) {
        int m = classroom.length;
        int n = classroom[0].length();
        int sx = 0, sy = 0;
        List<int[]> litters = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = classroom[i].charAt(j);
                if (c == 'S') {
                    sx = i;
                    sy = j;
                } else if (c == 'L') {
                    litters.add(new int[]{i, j});
                }
            }
        }
        int totalLitters = litters.size();
        Map<Long, Integer> litterMap = new HashMap<>();
        for (int i = 0; i < totalLitters; i++) {
            litterMap.put(((long) litters.get(i)[0] << 32) | litters.get(i)[1], i);
        }
        int fullMask = (1 << totalLitters) - 1;
        int[][][] bestEnergy = new int[m][n][1 << totalLitters];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(bestEnergy[i][j], -1);
            }
        }
        Queue<State> queue = new LinkedList<>();
        queue.offer(new State(sx, sy, 0, maxEnergy, 0));
        bestEnergy[sx][sy][0] = maxEnergy;
        while (!queue.isEmpty()) {
            State curr = queue.poll();
            if (curr.mask == fullMask) {
                return curr.steps;
            }
            for (int i = 0; i < 4; i++) {
                int nx = curr.x + DX[i];
                int ny = curr.y + DY[i];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                char cell = classroom[nx].charAt(ny);
                if (cell == 'X') continue;
                int nextEnergy = curr.energy - 1;
                if (nextEnergy < 0) continue; 
                
                if (cell == 'R') {
                    nextEnergy = maxEnergy;
                }
                
                int nextMask = curr.mask;
                long key = ((long) nx << 32) | ny;
                if (cell == 'L' && litterMap.containsKey(key)) {
                    int idx = litterMap.get(key);
                    nextMask |= (1 << idx);
                }
                
                if (nextEnergy > bestEnergy[nx][ny][nextMask]) {
                    bestEnergy[nx][ny][nextMask] = nextEnergy;
                    queue.offer(new State(nx, ny, nextMask, nextEnergy, curr.steps + 1));
                }
            }
        }
        
        return -1;
    }
}