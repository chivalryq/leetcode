public class test {
    base.innerClass innerClass=new base.innerClass();
    Object object=new Object();
}

class base {
    final void finalmethod() {

    }

    static class innerClass {
        static {
            System.out.println("good");
        }

        public static void main(String[] args) {

        }
    }
}
