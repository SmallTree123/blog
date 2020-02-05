package top.nylgsc.blog.Dao;


import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.nylgsc.blog.entity.Image;

@Repository
public interface ImageDao {
    public Image getImage();

    public void insertImage(@Param("image") String base64);
}
