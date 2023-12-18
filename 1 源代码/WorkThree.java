/**
 * @author xierui2022140771
 * @description 继承与派生练习，
 *              改编自北邮本科《面向对象C++课程设计》课后题：
 *              （1） 声明一个基类Shape（形状），其中包含一个方法来计算面积；
 *              （2） 从Shape 派生两个类：矩形类和圆形类；
 *              （3） 分别实现派生类构造函数和其他方法；
 *              （4） 创建派生类的对象，观察函数调用次序；
 *              （5） 对不同对象计算面积。
 */

public class WorkThree {
    public static void main(String[] args) {
        System.out.println("------------------");
        Rectangle rectangle = new Rectangle(4, 3);
        rectangle.showInfo();
        System.out.printf("面积是：%.2f\n", rectangle.calculateArea());

        System.out.println("------------------");
        Circle circle = new Circle(3.5);
        circle.showInfo();
        System.out.printf("面积是：%.2f\n", circle.calculateArea());
    }
}

abstract class Shape {
    Shape() {
        System.out.println("调用了Shape的无参数构造函数");
    }
    abstract double calculateArea();
}

class Rectangle extends Shape {
    private double length;//长
    private double width;//宽

    Rectangle(double length, double width) {
        System.out.println("调用了Rectangle的有参数构造函数");
        this.length = length;
        this.width = width;
    }

    @Override
    double calculateArea() {
        return this.length * this.width;
    }

    void showInfo() {
        System.out.printf("这是长%.2f，宽%.2f的矩形\n", this.length, this.width);
    }
}

class Circle extends Shape {
    private double radius;//半径

    Circle(double radius) {
        System.out.println("调用了Circle的有参数构造函数");
        this.radius = radius;
    }

    @Override
    double calculateArea() {
        return 3.14 * this.radius * this.radius;
    }

    void showInfo() {
        System.out.printf("这是半径%.2f的圆形\n", this.radius);
    }
}