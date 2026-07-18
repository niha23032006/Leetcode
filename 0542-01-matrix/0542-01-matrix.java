class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        Queue<int[]> queue = new LinkedList<>();

        // Initialize queue with all 0's
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                } else {
                    mat[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();

            for (int[] d : dirs) {
                int nr = cell[0] + d[0];
                int nc = cell[1] + d[1];

                if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                    if (mat[nr][nc] > mat[cell[0]][cell[1]] + 1) {
                        mat[nr][nc] = mat[cell[0]][cell[1]] + 1;
                        queue.offer(new int[]{nr, nc});
                    }
                }
            }
        }

        return mat;
    }
}