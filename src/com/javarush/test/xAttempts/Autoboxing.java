package Attempts;

/**
 * Created by Аркадий on 07.03.2016.
 */
public class Autoboxing {
        static void methodBoxVar(Integer in) {
            System.out.println("Integer");
        }
        static void methodBoxVar(int... i) {
            System.out.println("ints");
        }
        public static void main(String[] args) {
            int intVal1 = 25;
            methodBoxVar(intVal1);
        }
}
