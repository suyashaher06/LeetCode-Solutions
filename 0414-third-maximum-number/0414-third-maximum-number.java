class Solution {
    public int thirdMax(int[] nums) {
        
        Long first = null;
        Long second = null;
        Long third = null;

        for (int num : nums) {
            
            if (Long.valueOf(num).equals(first) ||
                Long.valueOf(num).equals(second) ||
                Long.valueOf(num).equals(third)) {
                continue;
            }

            if (first == null || num > first) {
                third = second;
                second = first;
                first = (long) num;
            }
            else if (second == null || num > second) {
                third = second;
                second = (long) num;
            }
            else if (third == null || num > third) {
                third = (long) num;
            }
        }

        return third != null ? third.intValue() : first.intValue();
    }
}