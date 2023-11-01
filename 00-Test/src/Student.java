public class Student {
    private String name;
    private int age;
    public static int a;
    {
        System.out.println("构造代码块");
    }
    public Student(String name,int age){
        super();
        this.name = name;
        this.age = age;
    }

    public void study(){

        System.out.println("开始学习！" + name);
    }
}
