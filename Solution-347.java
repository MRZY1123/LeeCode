package leetcode347;
import java.util.*;
/**
 * @author Taochunwei
 * @date 2019/7/11 - 15:41
 */
public class Solution {

    public List<Integer> topKFrequent(int[] nums, int k) {
        TreeMap<Integer,Integer> map= new TreeMap<>();
        for(int num:nums)
            if(map.containsKey(num))
                map.put(num,map.get(num)+1);
            else
                map.put(num,1);

        PriorityQueue<Integer> pq= new PriorityQueue<>(
                (a,b) ->map.get(a)-map.get(b)
        );
        for(int key:map.keySet())
            if(pq.size()<k)
                pq.add(key);
            else if(map.get(key)>map.get(pq.peek())){
                pq.remove();
                pq.add(key);
            }

        LinkedList<Integer> res= new LinkedList<>();
        while(!pq.isEmpty()){
            res.add(pq.remove());
        }
        return res;
    }
}


