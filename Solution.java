class Solution {
    public int countLargestGroup(int n) {
        int sz = 37;
        ArrayList<Integer>[] adj = new ArrayList[sz];
        for (int i = 0; i < sz; i++) {
            adj[i] = new ArrayList<>();   
        }
        int max = 0;
        while (n > 0) {
            int group = sumDigits(n);
            adj[group].add(n);
            max = Math.max(max, adj[group].size());
            n--;
        }
        int count = 0;
        for (int g = 1; g < sz; g++) {
            if (adj[g].size() == max) {
                count++;
            }
        }
        return count;
    }
    
    int sumDigits(int x) {
        int sum = 0;
        while (x > 0) {
            sum += (x % 10);
            x /= 10;
        }
        return sum;
    }
}
