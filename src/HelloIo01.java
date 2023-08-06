import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class HelloIo01 {
    public static void main(String[] args) throws IOException {
        OutputStream out = new FileOutputStream("/tmp/helloIo01.dat");
        out.write(1); // 00000000 00000000 00000001
        out.write(255);
        out.write(0);
        out.write(1);
        out.close();
    }
}
