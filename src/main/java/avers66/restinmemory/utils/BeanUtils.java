package avers66.restinmemory.utils;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import java.lang.reflect.Field;

/**
 * BeanUtils
 *
 * @Author Tretyakov Alexandr
 */


@UtilityClass
public class BeanUtils {

    @SneakyThrows
    public void copyNonNullProperties(Object source, Object destination) {
        Field[] fields = source.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            Object value = field.get(source);

            if (value != null) {
                field.set(destination, value);
            }
        }
    }
}
