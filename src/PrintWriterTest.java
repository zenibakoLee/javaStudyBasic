import java.io.*;

public class PrintWriterTest {
    public static void main(String[] args) throws IOException {
        String targetPath = "/tmp/printWriterTest.txt";
        PrintWriter out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(targetPath)));
        out.println("1st line");
        out.println("2nd line");
        out.println("3rd line");
        out.close();
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(targetPath)));
        String line = null;
        while((line = in.readLine())!=null){
            System.out.println(line);
        }
        in.close();
    }
}
