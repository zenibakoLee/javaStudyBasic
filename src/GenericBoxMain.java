public class GenericBoxMain {
    public static void main(String[] args) {
        GenericBox<String> genericBox = new GenericBox<>();
        genericBox.setT("kim");
        String str = genericBox.getT();
        System.out.println(str.toUpperCase());

        GenericBox<Integer> intBox = new GenericBox<>();
        intBox.setT(3);
        System.out.println(intBox.getT());
    }
}
