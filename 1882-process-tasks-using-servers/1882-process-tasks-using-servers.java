class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {

        int n = servers.length;
        int m = tasks.length;

        int[] ans = new int[m];

        PriorityQueue<int[]> free = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        PriorityQueue<long[]> busy = new PriorityQueue<>((a, b) -> {
            return Long.compare(a[0], b[0]);
        });

        for (int i = 0; i < n; i++) {
            free.offer(new int[]{servers[i], i});
        }

        long time = 0;

        for (int j = 0; j < m; j++) {

            time = Math.max(time, j);

            while (!busy.isEmpty() && busy.peek()[0] <= time) {
                long[] server = busy.poll();

                int index = (int) server[1];

                free.offer(new int[]{servers[index], index});
            }

            if (free.isEmpty()) {

                time = busy.peek()[0];

                while (!busy.isEmpty() && busy.peek()[0] <= time) {
                    long[] server = busy.poll();

                    int index = (int) server[1];

                    free.offer(new int[]{servers[index], index});
                }
            }

            int[] server = free.poll();

            int serverIndex = server[1];

            ans[j] = serverIndex;

            busy.offer(new long[]{
                time + tasks[j],
                serverIndex
            });
        }

        return ans;
    }
}