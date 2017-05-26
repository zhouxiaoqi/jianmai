package cn.jianmai.fastdfs;

import org.csource.common.MyException;
import org.csource.fastdfs.*;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by zhouqi on 2017/3/27.
 */
public class FastdfsTest {

    @Test
    public void testUpload() throws Exception {
        ClientGlobal.init("/Users/zhouqi/Desktop/iead_java/jianmai/jianmai-web/src/main/resources/Client.conf");

        TrackerClient trackerClient = new TrackerClient();

        TrackerServer trackerServer = trackerClient.getConnection();

        StorageServer storageServer = null;

        StorageClient storageClient = new StorageClient(trackerServer, storageServer);

        String[] strings = storageClient.upload_file("/Users/zhouqi/Desktop/banner.png", "png", null);

        for (String s : strings) {
            System.out.println(s);
        }
    }


    @Test
    public void delete() throws Exception {
        ClientGlobal.init("/Users/zhouqi/Desktop/iead_java/jianmai/jianmai-web/src/main/resources/Client.conf");
        TrackerClient trackerClient = new TrackerClient();

        TrackerServer trackerServer = trackerClient.getConnection();

        StorageServer storageServer = null;

        StorageClient storageClient = new StorageClient(trackerServer, storageServer);
        int i = storageClient.delete_file("group1", "M00/00/00/CocSmFjjQ2KAYUHVAAAg2piw8pM23.jpeg");
        System.out.print(i);
    }
}
