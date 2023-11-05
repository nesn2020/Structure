package TeachingSoftware;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import Demo1.demo1;
import Demo2.*;
import Demo3.*;
import Demo4.*;
public class disPlayMain {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("欢迎来到体系结构风格演示-实现KWIC，请选择你想要使用的体系结构风格");
        displayMainMenu();
    }

    public static void openFile(String filePath){
        // 创建File对象
        File fileToOpen = new File(filePath);
        // 检查文件是否存在
        if (fileToOpen.exists()) {
            try {
                // 使用Desktop类来打开文件
                Desktop.getDesktop().open(fileToOpen);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("文件不存在或路径不正确");
        }
    }

    public static void displayMainMenu() throws IOException, InterruptedException {
        System.out.println();
        System.out.println("1. 主程序-子程序");
        System.out.println("2. 面向对象");
        System.out.println("3. 事件系统");
        System.out.println("4. 管道-过滤");
        System.out.println("5. 退出");


        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                displayOptionOne();
                break;
            case 2:
                displayOptionTwo();
                break;
            case 3:
                displayOptionThree();
                break;
            case 4:
                displayOptionFour();
                break;
            case 5:
                System.out.println("谢谢使用，再见！");
                System.exit(0);
                break;
            default:
                System.out.println("无效的选项，请重新选择。");
                displayMainMenu();
                break;
        }
    }

    public static void displayOptionOne() throws IOException, InterruptedException {
        System.out.println("主程序-子程序体系结构：");
        System.out.println("1. 返回主菜单");
        System.out.println("2. 实现KWIC");
        System.out.println("3. 退出");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                displayMainMenu();
                break;
            case 2:
                System.out.println("主程序-子程序运行结果：");
                demo1 kwic = new demo1();
                kwic.input("D:\\input.txt");
                kwic.shift();
                kwic.alphabetizer();
                kwic.output("D:\\output.txt");

                openFile("D:\\体系结构图\\主程序-子程序.png");  //打开结构图

                Thread.sleep(2000);
                System.out.println();
                System.out.println();
                displayMainMenu();
                break;
            case 3:
                System.out.println("谢谢使用，再见！");
                System.exit(0);
            default:
                System.out.println("无效的选项，请重新选择。");
                displayOptionOne();
                break;
        }
    }

    public static void displayOptionTwo() throws IOException, InterruptedException {
        System.out.println("面向对象体系结构：");
        System.out.println("1. 返回主菜单");
        System.out.println("2. 实现KWIC");
        System.out.println("3. 退出");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                displayMainMenu();
                break;
            case 2:
                System.out.println("面向对象运行结果：");

                Demo2.Input input = new Demo2.Input();
                input.input("D:\\input.txt");
                Demo2.Shift shift = new Demo2.Shift(input.getLineTxt());
                shift.shift();
                Demo2.Alphabetizer alphabetizer = new Demo2.Alphabetizer(shift.getKwicList());
                alphabetizer.sort();
                Demo2.Output output = new Demo2.Output(alphabetizer.getKwicList());
                output.output("D:\\output.txt");
                openFile("D:\\体系结构图\\面向对象.png");
                Thread.sleep(2000);
                System.out.println();
                System.out.println();
                displayMainMenu();
                break;
            case 3:
                System.out.println("谢谢使用，再见！");
                System.exit(0);
            default:
                System.out.println("无效的选项，请重新选择。");
                displayOptionTwo();
                break;
        }
    }

    public static void displayOptionThree() throws IOException, InterruptedException {
        System.out.println("事件系统：");
        System.out.println("1. 返回主菜单");
        System.out.println("2. 实现KWIC");
        System.out.println("3. 退出");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                displayMainMenu();
                break;
            case 2:
                System.out.println("事件系统运行结果：");

                //创建主题
                KWICSubject kwicSubject = new KWICSubject();
                //创建观察者
                Demo3.Input input = new Demo3.Input("D:\\input.txt");
                Demo3.Shift shift = new Demo3.Shift(input.getLineTxt());
                Demo3.Alphabetizer alphabetizer = new Demo3.Alphabetizer(shift.getKwicList());
                Demo3.Output output = new Demo3.Output(alphabetizer.getKwicList(), "D:\\output.txt");

                // 将观察者加入主题
                kwicSubject.addObserver(input);
                kwicSubject.addObserver(shift);
                kwicSubject.addObserver(alphabetizer);
                kwicSubject.addObserver(output);
                // 逐步调用各个观察者
                kwicSubject.startKWIC();
                openFile("D:\\体系结构图\\事件系统.png");
                Thread.sleep(2000);
                System.out.println();
                System.out.println();
                displayMainMenu();
                break;
            case 3:
                System.out.println("谢谢使用，再见！");
                System.exit(0);
            default:
                System.out.println("无效的选项，请重新选择。");
                displayOptionOne();
                break;
        }
    }

    public static void displayOptionFour() throws IOException, InterruptedException {
        System.out.println("管道-过滤：");
        System.out.println("1. 返回主菜单");
        System.out.println("2. 实现KWIC");
        System.out.println("3. 退出");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                displayMainMenu();
                break;
            case 2:
                System.out.println("管道-过滤运行结果：");

                File inFile = new File("D:\\input.txt");
                File outFile = new File("D:\\output.txt");
                Pipe pipe1 = new Pipe();
                Pipe pipe2 = new Pipe();
                Pipe pipe3 = new Pipe();
                Demo4.Input input = new Demo4.Input(inFile, pipe1);
                Demo4.Shift shift = new Demo4.Shift(pipe1, pipe2);
                Demo4.Alphabetizer alphabetizer  = new Demo4.Alphabetizer(pipe2, pipe3);
                Demo4.Output output = new Demo4.Output(outFile,pipe3);
                input.transform();
                shift.transform();
                alphabetizer.transform();
                output.transform();
                openFile("D:\\体系结构图\\管道-过滤.png");
                Thread.sleep(2000);
                System.out.println();
                System.out.println();
                displayMainMenu();
                break;
            case 3:
                System.out.println("谢谢使用，再见！");
                System.exit(0);
            default:
                System.out.println("无效的选项，请重新选择。");
                displayOptionOne();
                break;
        }
    }
}
