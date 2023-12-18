import java.util.Arrays;
import java.util.Scanner;

/**
 * @author xierui2022140771
 * @description Java简单语法、数据类型以及键盘输入输出
 */

public class WorkOne {
    public static void main(String[] args) {
        WorkOne work = new WorkOne();
        work.test1();
        work.test2();
        work.test3();
        work.test4();
        work.test5();
    }
    public void test1() {   // 类型转化
        System.out.println("--------类型转化--------");
        int three=3;
        char one='1';
        int intFour=(three+one);    // char 可以自动转 int，反之不能，故 int+char—>int
        char charFour=(char)(three+one);
        System.out.println(intFour);
        System.out.println((char)intFour);
        System.out.println(charFour);
        System.out.println((int)charFour);
    }
    public void test2() { // 数组
        System.out.println("--------数组--------");
        // 一维数组以及拷贝
        int intArray[] = {1,2,3};
        int copyArray[] = new int[4];
        System.arraycopy(intArray,0,copyArray,1,intArray.length);
        System.out.println(Arrays.toString(copyArray));

        // 二维数组
        int a[][] = new int[2][];
        a[0] = new int[2];
        a[1] = new int[3];
        for(int i=0; i<a.length; i++) {
            System.out.println(Arrays.toString(a[i]));
        }
    }
    public void test3() {   // 格式化输出
        System.out.println("--------格式化输出--------");
        int a=1, b=2;
        System.out.printf("%d, %d\n",a , b);
    }
    public void test4() {   // 获取键盘输入
        System.out.println("--------获取键盘输入--------");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入String");
        String inputLine = scanner.nextLine();
        System.out.println(inputLine);
        System.out.println("请输入Int");
        int inputInt = scanner.nextInt();
        System.out.println(inputInt);
    }
    public void test5() {   // 带标号的break
        System.out.println("--------带标号的break--------");
        int i=4;
        outer:while (i>0) {
            for(int j=0; j<10;j++) {
                System.out.printf("i:%d, j:%d\n",i , j);
                if (i<j) {break outer;}
            }
        }
    }
}
