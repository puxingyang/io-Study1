package lesson1;

import java.util.Scanner;

public class ScannerTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //给定一组测试用例10个，接收输入，每个用例是
        //假设，接受的输入为：
        //4
        //3 1 10 31
        while(sc.hasNextInt()) {//hasNextxxx()和nextxxx()读取到io数据直到满足条件，否则阻塞等待
            sc.nextInt();//读取到io数值直到满足条件，否则阻塞等待
            int num = sc.nextInt();
            for (int i = 0; i < num; i++) {
                int data = sc.nextInt(i);
                System.out.println(data);
            }
        }

        //4
        //3 1 10 31
        while(sc.hasNextLine()){
            String s = sc.nextLine();//4
            String next = sc.nextLine();//3 1 10 31
        }
    }
}
