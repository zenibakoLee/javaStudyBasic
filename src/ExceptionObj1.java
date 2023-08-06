public class ExceptionObj1{
    /**
     *
     * @param i
     * @param j
     * @return i를 j로 나눈 결과를 반환한다.
     * @throws ArithmeticException
     */
    public int divide(int i,int j) throws ArithmeticException{
        int value=0;
//        try{
        value = i/j;
//        }catch(ArithmeticException ex){
//            System.out.println(ex.toString());
//        }
        return value;
    }
}
