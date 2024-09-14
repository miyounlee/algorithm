import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] gradeArr = {"A+", "A0", "B+", "B0", "C+", "C0", "D+", "D0", "F"};
        double[] scoreArr = {4.5, 4.0, 3.5, 3.0, 2.5, 2.0, 1.5, 1.0, 0.0};
        double scoreSum = 0;
        double markSum = 0;

        for (int i = 0; i < 20; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            st.nextToken();
            double mark = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();

            for (int j = 0; j < gradeArr.length; j++) {
                if (grade.equals("P")) {
                    break;
                } else if (grade.equals(gradeArr[j])) {
                    scoreSum += (mark * scoreArr[j]);
                    markSum += mark;
                }
            }
        }

        System.out.printf("%.6f", scoreSum / markSum);
    }
}