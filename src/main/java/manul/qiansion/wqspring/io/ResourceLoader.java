package manul.qiansion.wqspring.io;

import java.net.URL;

/**
 * @Auther: Anthony
 * @Date: 2019/6/17 14:45
 * @Description:spring的资源加载器，用来获取资源
 */
public class ResourceLoader {
    public Resource getResource(String location){
        URL resource = this.getClass().getClassLoader().getResource(location);
        return new UrlResource(resource);
    }
}
