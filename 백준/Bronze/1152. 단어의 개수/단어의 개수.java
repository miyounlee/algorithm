import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        int str;
        int pre_chr = 32;   // sp
        int count = 0;
        /**
         * 현재문자가 공백이면서, 이전문자가 공백이 아닌경우 카운트
         * 현재문자가 개행이면서, 이전문자가 공백이 아닌경우 카운트
         */
        while (true) {
            str = System.in.read(); // 1byte 읽어옴

            if (str == 32) {    // sp
                if (pre_chr != 32) {
                    count++;
                }
            }
            if (str == 10) {    // 개행
                if (pre_chr != 32) {
                    count++;
                }
                break;
            }
            pre_chr = str;
        }

        System.out.println(count);
    }
}
