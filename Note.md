##oldIO
用线程来对应一次 请求的做法 ，浪费的点在于
```apple js
bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream())); 
tempStr= bufferedReader.readLine()

```
也就是说client 的socket 产生的流 在read方法进行阻塞，





###NEW IO
 
IO处理客户端请求的最小单位是线程
而NIO使用了比线程还小一级的单位：通道（Channel）