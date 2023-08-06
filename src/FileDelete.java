import java.io.File;

public class FileDelete {
    public static void main(String[] args) {
        if(args.length==0){
            System.out.println("사용법: java FileDelete 파일이름");
            System.exit(0);
        }

        File f = new File(args[0]);
        if(f.exists()){
            boolean deleteCompleted = f.delete();
            if(deleteCompleted)
                System.out.println("파일삭제완료");
            else
                System.out.println("파일삭제실패");
        }else{
            System.out.println("존재하지않는파일");
        }
    }
}
