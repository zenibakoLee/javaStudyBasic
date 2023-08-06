public class ObjectBoxMain {
    // 어떤 타입이던 담을 수 있는 box
    public static void main(String[] args){
        ObjectBox box = new ObjectBox();
        box.set("kim");
        String str = (String)box.get();
        System.out.println(str.toUpperCase());

        box.set(5);
        Integer i = (Integer)box.get();
        System.out.println(i.intValue());
        // 그러나 꺼낼대마다 형변환을 해야하는 상황
    }
}
