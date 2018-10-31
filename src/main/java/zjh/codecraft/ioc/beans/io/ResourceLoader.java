package zjh.codecraft.ioc.beans.io;

import java.net.URL;

/**
 * @author zhengjianhui on 10/29/18
 */
public class ResourceLoader {

    public Resource getResource(String location) {
        URL resourse = this.getClass().getClassLoader().getResource(location);
        return new UrlResource(resourse);
    }
}
