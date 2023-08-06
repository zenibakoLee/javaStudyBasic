import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KeyboardIOExam {
    public static void main(String[] args) throws Exception{ // 예외처리 생략
        //키보드로부터 한 줄 씩 입력받고, 한 줄 식 화면에 출력
        //키보드 : System.in  InputStream type 주인공
        //화면에 출력 : System.out PrintStream type 주인공
        //char 단위 입출력은 Reader/Writer
        // 한 줄 읽기 : BufferedReader 클래스의 readLine()
        // 한 줄 쓰기: PrintStream, PrintWriter


            BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 장식이다. 주인공(추상클래스 Reader 구현 클래스)을 인풋으로 받아야한다.
            // 키보드 입력 byte 읽는 주인공을 인풋으로 넣어줘야함
            String line = null;
            while((line=br.readLine())!=null){
                System.out.println(line);
            }
            br.readLine();

    }
}
