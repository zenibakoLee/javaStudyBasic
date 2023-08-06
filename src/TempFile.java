import java.io.File;
import java.io.IOException;

/*
File.createTempFile() 메서드는 임시 파일을 생성할 때 기본적으로 시스템의 임시 디렉토리를 사용합니다.
시스템의 임시 디렉토리는 운영 체제에 따라 다를 수 있습니다.
macOS의 경우, /var/folders/ 디렉토리는 macOS의 임시 디렉토리입니다.
여기에는 시스템 및 사용자 임시 디렉토리가 포함되어 있습니다.
 */
public class TempFile {
    public static void main(String[] args) {
        TempFile example = new TempFile();
        String location = example.getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
        System.out.println("Class file location: " + location);
        try{
            File f = File.createTempFile("tmp_",".dat");
            System.out.println(f.getAbsolutePath());
            System.out.println("60초간 대기");
            try{
            Thread.sleep(10000);}
            catch (InterruptedException e) {
                System.out.println(e);
                }
            f.deleteOnExit(); // JVM 종료시 파일 삭제
            System.out.println("삭제완료");
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
