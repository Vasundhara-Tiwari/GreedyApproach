package dp;

import java.lang.*;
import java.util.*;

public class ActivitySelection {
    static class Pair {
        int first;
        int second;
        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    static void SelectActivities(int s[], int f[]) {
        ArrayList<Pair> ans = new ArrayList<>();
        PriorityQueue<Pair> p = new PriorityQueue<>((p1, p2) -> p1.first - p2.first);
        for (int i = 0; i < s.length; i++) {
            p.add(new Pair(f[i], s[i]));
        }
        Pair it = p.poll();
        int start = it.second;
        int end = it.first;
        ans.add(new Pair(start, end));
        while (!p.isEmpty()) {
            Pair itr = p.poll();
            if (itr.second >= end) {
                start = itr.second;
                end = itr.first;
                ans.add(new Pair(start, end));
            }
        }
        System.out.println("Following Activities should be selected. \n");
        for (Pair itr : ans) {
            System.out.println("Activity started at: " + itr.first + " and ends at  " + itr.second);
        }
    }
    public static void main(String[] args) {
        int s[] = { 1, 2, 3, 4, 7, 8, 9, 9, 11, 12 };
        int f[] = { 3, 5, 4, 7, 10, 9, 11, 13, 12, 14 };
        SelectActivities(s, f);
    }
}
