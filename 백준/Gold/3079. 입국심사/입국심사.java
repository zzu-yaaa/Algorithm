import java.io.*;
import java.util.*;

public class Main{
    static ArrayList<Long> time = new ArrayList<>();
    static long N;
    static long M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputArr = br.readLine().split(" ");
        N = Long.parseLong(inputArr[0]); // 심사대 개수 (long 타입)
        M = Long.parseLong(inputArr[1]); // 심사 받아야 할 사람 수 (long 타입)
        
        for (int i = 0; i < N; i++) {
            time.add(Long.parseLong(br.readLine()));
        }
        Collections.sort(time);

        long low = 1;
        long high = time.get((int) N - 1) * M; // 가장 긴 심사 시간 * M 으로 초기화
        long answer = high;

        while (low <= high) {
            long mid = low + (high - low) / 2; // 정확한 중간 값 계산 방법 (오버플로우 방지)
            long cnt = countPeopleProcessed(mid);

            if (cnt >= M) {
                answer = mid;
                high = mid - 1; // 최소 시간을 찾기 위해 범위를 왼쪽으로 이동
            } else {
                low = mid + 1; // 처리된 사람 수가 부족하면 범위를 오른쪽으로 이동
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
    }

    private static long countPeopleProcessed(long mid) {
        long cnt = 0;

        for (Long t : time) {
            cnt += mid / t; // 각 심사대에서 mid 시간 동안 처리할 수 있는 사람 수 누적
            if (cnt >= M) {
                break; // M 이상의 처리량이 확보되면 더 이상 계산할 필요 없음
            }
        }

        return cnt;
    }
}