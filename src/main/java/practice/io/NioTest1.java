package practice.io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;


public class NioTest1 {

    public static void main(String[] args){
        RandomAccessFile accessFile=null;


        try {
            accessFile=new RandomAccessFile(NioTest1.class.getClassLoader().getResource("test.txt").getPath(),"rw");
            FileChannel channel=accessFile.getChannel();
            ByteBuffer buffer= ByteBuffer.allocate(1024);
            int byteRead=channel.read(buffer);
            System.out.println(byteRead);
            while(byteRead!=-1){
                buffer.flip();
                while(buffer.hasRemaining()){
                    System.out.println((char)buffer.get());
                }
                buffer.compact();
                byteRead=channel.read(buffer);
                System.out.println(byteRead);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
