package codingtest.boj.gold3;

import java.io.*;
import java.util.*;

// 홍익 투어리스트: https://www.acmicpc.net/problem/23326
// 트리
public class Baekjoon_23326 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        TreeSet<Integer> set = new TreeSet<>(); // 구역 정보

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 구역 개수
        int q = Integer.parseInt(st.nextToken()); // 쿼리 개수
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(st.nextToken());
            if (value == 1) set.add(i);
        }

        int cur = 0; // 도현이의 현재 위치 (pos 1)
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int query = Integer.parseInt(st.nextToken());
            if (query == 1) { // 명소 지정하거나 해제
                int block = Integer.parseInt(st.nextToken()) - 1;
                if (set.contains(block)) {
                    set.remove(block); // 이미 명소라면 해제
                } else {
                    set.add(block); // 명소가 아니라면 지정
                }
            } else if (query == 2) { // 시계 방향으로 이동
                int move = Integer.parseInt(st.nextToken());
                cur = (cur + move) % n;
            } else { // 명소에 도달하기 위해 몇 칸을 움직여야 하는지
                if (set.isEmpty()) {
                    // 명소가 없다면 -1 출력
                    sb.append(-1);
                } else {
                    // 명소가 있을 때, 현재 위치한 값과 같거나 큰 값에 위치한 명소들을 조회함
                    SortedSet<Integer> s = set.tailSet(cur);
                    if (s.isEmpty()) {
                        // 현재 위치 값보다 같거나 큰 명소 값이 없으면, 가장 첫 번째 명소 조회해서 계산
                        // ex) n=5, cur=4, tree=[1,3] -> 5+1-4=2
                        sb.append(n + set.first() - cur);
                    } else {
                        // 있으면, 그 명소 값에 현재 위치 값 계산
                        // ex) n=5, cur=3, tree=[1,4] -> 4-3=1
                        sb.append(s.first() - cur);
                    }
                }
                sb.append('\n');
            }
        }
        br.close();
        System.out.print(sb);
    }
}