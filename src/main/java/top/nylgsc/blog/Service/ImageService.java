package top.nylgsc.blog.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.nylgsc.blog.Dao.ImageDao;
import top.nylgsc.blog.entity.Image;

@Service
@Transactional
public class ImageService {

    @Autowired
    private ImageDao imageDao;

    public Image getImage(){
        return imageDao.getImage();
    }

    public void insertImage(String base64){
        imageDao.insertImage(base64);
    }


}
