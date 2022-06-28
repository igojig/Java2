package inner_classes;


class Cat{
    String name;
    class Passport{
        static int i;
        String name;
        int age;

        public Passport(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

    void foo(){

    }
}


public class Main {
    public static void main(String[] args) {
        Cat cat=new Cat();

        new Cat().new Passport("1",2);

        System.out.println(-5./0);

    }
}
