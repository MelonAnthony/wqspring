package manul.qiansion.wqspring.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * @Auther: Anthony
 * @Date: 2019/6/17 14:47
 * @Description:具体的resource.
 */
public class UrlResource implements Resource {
    private final URL url;

    public UrlResource(URL url) {
        this.url = url;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        URLConnection urlConnection =url.openConnection();
        urlConnection.connect();
        return urlConnection.getInputStream();
    }
}
