import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * @author xierui2022140771
 * @description Java文件IO与异常处理练习
 */

public class WorkFour {
    public static void main(String[] args) {
        WorkFour work = new WorkFour();
        work.createFile();
        work.readFile();
        work.writeFile();
    }

    void createFile() {
        System.out.println("-----文件创建-----");
        File file = new File("newFile.txt");

        try {
            boolean result = file.createNewFile();
            if (result) {
                System.out.println("成功创建文件");
            }
            else {
                System.out.println("文件已存在");
            }
        }
        catch(Exception e) {
            e.getStackTrace();
        }
    }

    void readFile() {
        System.out.println("-----文件读取-----");
        try {
            FileReader input = new FileReader("input.txt");
            System.out.println("文件中有以下内容：");
            int content;
            while ((content = input.read()) != -1) {
                System.out.print((char) content);
            }
            System.out.println();
            input.close();
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }

    void writeFile() {
        System.out.println("-----文件写入(覆盖)-----");
        String data = "This is the data in the output file";
        try {
            FileWriter output = new FileWriter("output.txt");

            output.write(data);
            System.out.println("Data is written to the file.");

            output.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
