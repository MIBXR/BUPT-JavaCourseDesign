/**
 * @author xierui2022140771
 * @description Java面向对象特征相关尝试，
 *              本科学过c++，所以重点体验在c++没有的super关键字
 */

public class WorkTwo extends SuperWorkTwo {
    int x;
    WorkTwo() {
        super(5);   // 父类没有缺省的构造器，则子类需要明确使用super(args)写明调用父类的何种构造方式
        x = 8;
        System.out.printf("WorkTwo: x=%d\n", x);
    }
    @Override
    void doWorkTwo() {
        super.doWorkTwo();
        System.out.println("WorkTwo.doWorkTwo()");

        System.out.println("-----子类重新定义的父类同名成员变量-----");
        System.out.printf("super.x=%d\n", super.x); // 使用super访问子类父类同名成员变量
        System.out.printf("this.x=%d\n", this.x);

        System.out.println("-----子类没有重新定义的父类成员变量-----");
        System.out.printf("super.y=%d\n", super.y); // 使用super访问子类没有重新定义的父类成员变量
        System.out.printf("this.y=%d\n", this.y);
        System.out.println("修改this.y=999");
        this.y = 999;
        System.out.printf("super.y=%d\n", super.y); // 使用super访问子类没有重新定义的父类成员变量
        System.out.printf("this.y=%d\n", this.y);
    }
    public static void main(String[] args) {
        WorkTwo work = new WorkTwo();
        work.doWorkTwo();
    }
}

class SuperWorkTwo{
    int x, y;
    SuperWorkTwo(int x) {
        this.x = x;
        this.y = 6;
        System.out.printf("SuperWorkTwo: x=%d\n", x);
    }
    void doWorkTwo() {
        System.out.println("SuperWorkTwo.doWorkTwo()");
    }
}