class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {

        int n = servers.length;
        int m = tasks.length;

        int[] ans = new int[m];

        // Available servers: sorted by weight, then index
        PriorityQueue<int[]> free = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        // Busy servers: sorted by finish time
        PriorityQueue<long[]> busy = new PriorityQueue<>((a, b) -> {
            return Long.compare(a[0], b[0]);
        });

        // Initially, all servers are free
        for (int i = 0; i < n; i++) {
            free.offer(new int[]{servers[i], i});
        }

        long time = 0;

        for (int j = 0; j < m; j++) {

            // Current time should never move backwards
            time = Math.max(time, j);

            // Release all servers that have finished
            while (!busy.isEmpty() && busy.peek()[0] <= time) {
                long[] server = busy.poll();

                int index = (int) server[1];

                free.offer(new int[]{servers[index], index});
            }

            // If no server is free, advance time
            if (free.isEmpty()) {

                time = busy.peek()[0];

                // Release all servers available at this time
                while (!busy.isEmpty() && busy.peek()[0] <= time) {
                    long[] server = busy.poll();

                    int index = (int) server[1];

                    free.offer(new int[]{servers[index], index});
                }
            }

            // Select the best available server
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