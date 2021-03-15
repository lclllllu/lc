class Solution {
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        
        List<List<Integer>> result = new ArrayList<>();
        
        for(int[] in : intervals) {
            
            if(in[0] < toBeRemoved[0]) {
                result.add(List.of(in[0], Math.min(toBeRemoved[0], in[1])));
            }
            
            if(toBeRemoved[1] < in[1]) {
                result.add(List.of(Math.max(toBeRemoved[1], in[0]), in[1]));
            }
        }
        return result;
    }
}
