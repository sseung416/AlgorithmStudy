package codingtest;

import java.util.*;
import java.io.*;

// ATM: https://www.acmicpc.net/problem/11399
class Baekjoon_11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] people = new int[n];
        for (int i = 0; i < n; i++) {
            people[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        int temp = 0;
        int result = 0;
        Arrays.sort(people);
        for (int i = 0; i < n; i++) {
            temp += people[i];
            result += temp;
        }
        System.out.println(result);
    }
}