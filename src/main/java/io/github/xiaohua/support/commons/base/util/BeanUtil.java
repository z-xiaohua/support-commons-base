package io.github.xiaohua.support.commons.base.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.beans.BeanCopier;

/**
 * 功能：使用spring Cglib的BeanCopier实现，性能高
 *
 * @author zhongxiaohua
 */
@Slf4j
public class BeanUtil {

    /**
     * 拷贝对象属性<br>
     * （1）如果属性名相同，但类型不同，不会拷贝该属性，也不会报错；<br>
     * （2）source的属性必须要有getter和setter<br>
     * @param target 拷贝到目标对象
     * @param source 源对象
     */
    public static void copyProperties(Object source, Object target) {
        if (null == source || null == target) {
            return;
        }
        BeanCopier copier = BeanCopier.create(source.getClass(), target.getClass(), false);
        copier.copy(source, target, null);
    }

    /**
     * 把 source 转换成指定对象 T，T必须有一个不带参数的构造函数
     * @param source 源数据，不能为null
     * @param clazz  目标数据的class，不能为null
     * @throws RuntimeException 如果无法实例化 clazz、复制属性错误，抛出异常
     */
    public static <T> T from(Object source, Class<T> clazz) {
        if (null == source) {
            return null;
        }
        try {
            T target = clazz.newInstance();
            copyProperties(source, target);
            return target;
        } catch (Exception e) {
            throw new RuntimeException("copyProperties ERROR, obj: " + source.getClass() + " clz: " + clazz, e);
        }
    }

    /**
     * 把 source 列表转换成指定对象 T 的列表，T必须有一个不带参数的构造函数
     *
     * @param list  要转换的列表，不能为空
     * @param clazz 目标数据的class，不能为null
     * @throws RuntimeException 如果无法实例化 clazz、复制属性错误，抛出异常
     */
    public static <T> List<T> fromList(Collection<? extends Object> list, Class<T> clazz) {
        List<T> result = new ArrayList<T>();
        if (null != list) {
            for (Object source : list) {
                result.add(from(source, clazz));
            }
        }
        return result;
    }
}
