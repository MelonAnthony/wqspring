package manul.qiansion.wqspring.io;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.*;

/**
 * @Auther: Anthony
 * @Date: 2019/6/17 16:58
 * @Description:
 */
public class ResourceLoaderTest {

    @Test
    public void test() throws IOException {
        ResourceLoader resourceLoader = new ResourceLoader();
        Resource resource=resourceLoader.getResource("wqspring.xml");
        InputStream is = resource.getInputStream();
        Assert.assertNotNull(is);
    }
}