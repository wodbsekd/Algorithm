// 2105 : 디저트카페

import java.util.Scanner;

public class Solution {
 
    static int[] dx = { -1, 1, 1, -1 }; // 시게방향으로 진행
    static int[] dy = { 1, 1, -1, -1 };
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
 
        for (int tc = 1; tc <= t; tc++) {
 
            int n = sc.nextInt();
            int[][] map = new int[n][n];
 
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    map[i][j] = sc.nextInt();
                }
            }
 
            int ans = -1;
 
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < n; y++) {
                    for (int L1 = 1; L1 < n; L1++) {
                        for (int L2 = 1; L2 < n; L2++) {
 
                            if (2 * (L1 + L2) <= ans) {
                                continue;
                            }
 
                            int[] len = { L1, L2, L1, L2 };
                            boolean isPossible = true;
                            boolean[] dessert = new boolean[101];
                             
                            dessert[map[x][y]] = true;
 
                            int nx = x;
                            int ny = y;
                            int init_x = x;
                            int init_y = y;

                            for (int d = 0; d < 4; d++) {
                                for (int k = 0; k < len[d]; k++) {
                                    nx += dx[d];
                                    ny += dy[d];
                 
 
                                    if (nx <0 || nx > n-1 || ny < 0 || ny > n-1) {
                                        isPossible = false;
                                        break;
                                    }
 
                                    if (dessert[map[nx][ny]] && (nx != init_x || ny != init_y)) {
                                        isPossible = false;
                                        break;
                                    }

                                    dessert[map[nx][ny]] = true;
 
                                }
                                if (!isPossible)
                                    break;
                            }
 
                            if (isPossible) {
                                int result = 2 * (L1 + L2);
                                if (result > ans)
                                    ans = result;
                            }
                             
                        }
                    }
                }
            } // x for문 종료
 
            System.out.println("#" + tc + " " + ans);
 
        } // tc for문 종료
    }
}
