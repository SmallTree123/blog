package top.nylgsc.blog;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sun.misc.BASE64Encoder;
import top.nylgsc.blog.Service.ImageService;
import top.nylgsc.blog.entity.Image;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogApplicationTests {

    @Autowired
    private ImageService imageService;
    @Test
    public void contextLoads() throws IOException {
        Image image = imageService.getImage();
        System.out.print(image.toString());
    }

    @Test
    public void test1() throws IOException {
        File file = new File("D:\\1.jpg");
        FileInputStream is = new FileInputStream(file);
        byte[] data = new byte[is.available()];
        is.read(data);
        is.close();
        BASE64Encoder encoder = new BASE64Encoder();
        String base64Img =  encoder.encode(data);
        imageService.insertImage(base64Img);
        System.out.println(base64Img);
    }



}
