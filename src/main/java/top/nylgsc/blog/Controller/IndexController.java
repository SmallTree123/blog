package top.nylgsc.blog.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.BASE64Encoder;
import top.nylgsc.blog.Service.ImageService;
import top.nylgsc.blog.entity.Image;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

@Controller
@RequestMapping(value = "/blog")
public class IndexController {

    @Autowired
    private ImageService imageService;

    @RequestMapping(value = "/index")
    public String index(HttpServletRequest request){
//        加载所有图片
        Image image = imageService.getImage();
        String photo = image.getPhoto();
        System.out.println(photo);
        File file = new File(photo+"banner01.jpg");
        FileInputStream is = null;
        byte[] data=null;
        try {
            is = new FileInputStream(file);
             data= new byte[is.available()];
            is.read(data);
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        BASE64Encoder encoder = new BASE64Encoder();
        String base64Img =  encoder.encode(data);
        request.getSession().setAttribute("banner01",base64Img);
        return "index";
    }
    @RequestMapping(value = "/about")
    public String about(){
        return "about";
    }
    @RequestMapping(value = "/list")
    public String list(){
        return "list";
    }
    @RequestMapping(value = "/life")
    public String life(){
        return "life";
    }
    @RequestMapping(value = "/time")
    public String time(){
        return "time";
    }
    @RequestMapping(value = "/gbook")
    public String gbook(){
        return "gbook";
    }

    @RequestMapping(value = "/articleDetail")
    public String articleDetail(){
        return "articleDetail";
    }
}
