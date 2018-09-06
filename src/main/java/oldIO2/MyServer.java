package oldIO2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author wks
 * Create_date:2018/8/19
 * Desc:
 */
public class MyServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket=new ServerSocket(8080);

        while(true){
            Socket client=serverSocket.accept( );
            new Thread(()->{
                try {
                    BufferedReader bufferedReader = null;       //创建字符缓存输入流
                    bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));        //获取客户端的输入流
                    StringBuilder sb=new StringBuilder();
                    String tempStr;
                    while ( (tempStr= bufferedReader.readLine() )!=null ){
                        sb.append(tempStr);
                    }
                    System.out.printf(sb.toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
