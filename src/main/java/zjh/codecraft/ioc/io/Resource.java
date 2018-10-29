package zjh.codecraft.ioc.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * 资源抽象接口
 * @author zhengjianhui on 10/29/18
 */
public interface Resource {

    InputStream getInputStream() throws IOException;
}
