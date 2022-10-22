import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test {
    public String py1() throws IOException, InterruptedException {
        String line=null;
        try {
            String[] args1 = new String[] { "python", "D:\\web项目\\疫情地图\\src\\cha.py"};
            Process proc = Runtime.getRuntime().exec(args1);// 执行py文件
            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream(),"gb2312"));
            line = in.readLine();
//            System.out.println("1"+line);
            in.close();
            proc.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return line;

    }

    public static void main(String[] args) throws IOException, InterruptedException {
        test test = new test();
        String lk=test.py1();
        System.out.println(lk);

    }
}
