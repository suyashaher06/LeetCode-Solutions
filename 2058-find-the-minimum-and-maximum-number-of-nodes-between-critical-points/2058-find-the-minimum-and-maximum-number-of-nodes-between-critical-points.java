/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int firstIdx = -1;
        int prevIdx = -1;
        int minDist = Integer.MAX_VALUE;
        
        ListNode prevNode = head;
        ListNode currNode = head.next;
        int idx = 1;
        
        while (currNode.next != null) {
            int val = currNode.val;
            boolean isMaxima = val > prevNode.val && val > currNode.next.val;
            boolean isMinima = val < prevNode.val && val < currNode.next.val;
            
            if (isMaxima || isMinima) {
                if (firstIdx == -1) {
                    firstIdx = idx;
                } else {
                    minDist = Math.min(minDist, idx - prevIdx);
                }
                prevIdx = idx;
            }
            
            prevNode = currNode;
            currNode = currNode.next;
            idx++;
        }
        
        if (firstIdx == -1 || prevIdx == firstIdx) {
            return new int[]{-1, -1};
        }
        
        int maxDist = prevIdx - firstIdx;
        return new int[]{minDist, maxDist};
    }
}