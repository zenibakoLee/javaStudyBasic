public class Exeption01 {
    public static void main(String[] args) {
        ExceptionObj1 exobj = new ExceptionObj1();
        try{
            int value = exobj.divide(10,0);
            System.out.println("result: "+value);
        }catch (ArithmeticException ex){
            System.out.println("나누기 불가함");
        }

    }
}

