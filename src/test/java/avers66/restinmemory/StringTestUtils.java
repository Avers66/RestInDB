package avers66.restinmemory;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.FileCopyUtils;

import javax.imageio.IIOException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;

/**
 * StringTestUtils
 *
 * @Author Tretyakov Alexandr
 */

public class StringTestUtils {

    public static String readStringFromResource(String stringPath) {
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        //ToDo resourceLoader
        Resource resource = resourceLoader.getResource(MessageFormat.format("classpath:{0}", stringPath ));
        try(Reader rd = new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8)) {
            return FileCopyUtils.copyToString(rd);
        }catch (IOException ex) {
           throw new  RuntimeException(ex);
        }
    }
}
