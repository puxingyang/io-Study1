package lesson2;

import org.junit.Test;
import sun.plugin2.main.client.DisconnectedExecutionContext;

import java.io.*;

public class FileIOTest {

    @Test
    public void t1() throws IOException {
        InputStream fis = null;
        try {
            //第一种方式:使用FileInputStream+绝对路径。第二种：使用ClassLoarder+相对路径（推荐）
//            fis = new FileInputStream("C:\\Users\\puxingyang\\IdeaProjects\\javaweb\\io-study\\Data\\随便.txt");
            fis = this.getClass().getClassLoader().getResourceAsStream("随便.txt");
            //abcdefg读取操作，从当前位置偏移多少位（read，new String中的第二个参数），读取多长（第三个参数）
            byte[] bytes = new byte[1024];
            int len;
            while((len = fis.read(bytes)) != -1){
                String s = new String(bytes,0,len);
                System.out.println(s);
            }
        } finally {
            if(fis != null){
                fis.close();
            }
        }
    }

    @Test
    public void t2() throws IOException{
        FileReader reader = new FileReader("C:\\Users\\puxingyang\\IdeaProjects\\javaweb\\io-study\\Data\\随便.txt");
        char[] chars = new char[1024];
        int len;
        while ((len = reader.read(chars)) != -1) {
            String s = new String(chars, 0, len);
            System.out.println(s);
        }
    }

    @Test
    public void t3() throws IOException{
        FileInputStream fis = new FileInputStream("C:\\Users\\puxingyang\\IdeaProjects\\javaweb\\io-study\\Data\\随便.txt");
        InputStreamReader isr = new InputStreamReader(fis,"GBK");
        BufferedReader br = new BufferedReader(isr);
        String line;
        while((line = br.readLine()) != null){
            System.out.println(line);
        }
    }

    @Test
    public void t4() throws IOException {
        FileInputStream fis = new FileInputStream("C:\\Users\\puxingyang\\IdeaProjects\\javaweb\\io-study\\Data\\随便.txt");
        BufferedInputStream bis = new BufferedInputStream(fis);
        byte[] bytes = new byte[1024];
        int len;
        while ((len = bis.read(bytes)) != -1){
            String s = new String(bytes, 0, len);
            System.out.println(s);
        }
    }

    @Test
    public void t5() throws IOException {
        //覆盖的形式
        FileOutputStream fos = new FileOutputStream("C:\\Users\\puxingyang\\IdeaProjects\\javaweb\\io-study\\Data\\随便.txt");
        //追加到文件末尾
//      FileOutputStream fos = new FileOutputStream("C:\\Users\\puxingyang\\IdeaProjects\\javaweb\\io-study\\Data\\随便.txt",true);
        PrintWriter pw = new PrintWriter(fos, true);//自动刷新缓冲区
        pw.println("追加1");
        pw.println("追加2");
        pw.println("追加3");
//        pw.flush();//手动刷新缓冲区
    }

    @Test
    public void t6() throws IOException {
        //覆盖的形式
        FileOutputStream fos = new FileOutputStream("C:\\Users\\puxingyang\\IdeaProjects\\javaweb\\io-study\\Data\\随便.txt");
        //追加到文件末尾
//      FileOutputStream fos = new FileOutputStream("C:\\Users\\puxingyang\\IdeaProjects\\javaweb\\io-study\\Data\\随便.txt",true);
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        BufferedWriter bw = new BufferedWriter(osw);
        bw.write("追加1");
        bw.newLine();
        bw.write("追加2");
        bw.newLine();
        bw.write("追加3");
        bw.newLine();
    }
}
