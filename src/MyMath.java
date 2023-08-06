public class MyMath {

    private MyMath(){} // 생성자 사용 없이 static method 바로 호출해서 인스턴스 늘어나는 것 제한
    public static int abs(int x){
        if(x<0)
            return x * -1;
        else
            return x;
    }
}
