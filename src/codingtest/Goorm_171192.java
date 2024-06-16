package codingtest;

import java.io.*;
import java.util.*;

// 절약: https://level.goorm.io/exam/171192/절약/quiz/1
// 구현
public class Goorm_171192 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        final Account account = new Account();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String tag = st.nextToken();
            int money = Integer.parseInt(st.nextToken());

            account.write(tag, money);
            if (!account.isSaveSuccess()) {
                System.out.print("fail");
                return;
            }
        }

        System.out.print("success");
    }
}

class Account {
    private long sum = 0;
    private boolean isSuccess = true;

    void write(String tag, int money) {
        if (tag.equals("in")) {
            sum += (long) money;
        } else if (tag.equals("out")) {
            sum -= (long) money;
        }

        isSuccess = sum >= 0;
    }

    boolean isSaveSuccess() {
        return isSuccess;
    }
}