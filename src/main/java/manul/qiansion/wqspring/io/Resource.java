package manul.qiansion.wqspring.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Auther: Anthony
 * @Date: 2019/6/17 14:43
 * @Description:Resource是spring内部资源定义的接口
 */
public interface Resource {
    InputStream getInputStream() throws IOException;
}
