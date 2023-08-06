import java.io.IOException;
import java.io.InputStream;
/*
1byte가 표현할 수 있는 값은 00000000 ~ 11111111 , 2^8개
read()메소드가 읽어들일 수 있는 경우의 수.
한 번에 1byte 씩 읽어들인다. 더이상 읽어들일것이 없을 때 까지 End Of File
EOF == -1
1   -> 00000000 00000000 00000000 00000001
1의 보수 11111111 11111111 11111111 11111110
2의 보수 11111111 11111111 11111111 11111111 : -1
 */
public class InputStreamExam01 {
    public static void main(String[] args) {
        InputStream in = null;
        try{
          int data =  in.read(); // eof 를 인지하기 위해
        }catch (IOException ex){
            System.out.println("io오류 \n"+ex);
        }finally {
            try{
                in.close();
            }catch (Exception ex2){
                System.out.println("io오류2 \n"+ex2);
            }
        }
    }
}
