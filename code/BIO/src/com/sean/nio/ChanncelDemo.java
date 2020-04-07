package com.sean.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.file.Files;

/**
 * @author sean
 * @date 2020/4/1  17:01
 */
public class ChanncelDemo {
    private static Charset charset = Charset.forName("UTF-8");
    private static CharsetDecoder decoder = charset.newDecoder();

    public static String readFile(String fileName) {
        StringBuilder msg = new StringBuilder();
        try (FileInputStream fileInputStream = new FileInputStream(fileName)) {
            FileChannel channel = fileInputStream.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(512);
            int read = channel.read(byteBuffer);
            while (read != -1) {
                byteBuffer.flip();
                msg.append(decoder.decode(byteBuffer));
                byteBuffer.clear();
                read = channel.read(byteBuffer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return msg.toString();
    }

    public static void writeFile(String fileName, String... msg) {
        try (FileOutputStream outputStream = new FileOutputStream(fileName)) {
            FileChannel channel = outputStream.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            for (String s : msg) {
                buffer.put(s.getBytes());
            }
            buffer.flip();
            channel.write(buffer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
