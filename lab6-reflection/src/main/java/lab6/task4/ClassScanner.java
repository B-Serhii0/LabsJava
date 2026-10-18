package lab6.task4;

import java.io.File;
import java.lang.annotation.Annotation;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/** Сканує пакет */
public class ClassScanner {

    public static List<Class<?>> findAnnotated(String packageName, Class<? extends Annotation> annotation)
            throws Exception {
        List<Class<?>> result = new ArrayList<>();
        String path = packageName.replace('.', '/');
        URL url = Thread.currentThread().getContextClassLoader().getResource(path);
        if (url == null) {
            throw new IllegalArgumentException("Пакет не знайдено: " + packageName);
        }
        File dir = new File(url.toURI());
        File[] files = dir.listFiles((d, name) -> name.endsWith(".class"));
        if (files == null) return result;

        for (File f : files) {
            String simpleName = f.getName().substring(0, f.getName().length() - ".class".length());
            Class<?> cls = Class.forName(packageName + "." + simpleName);
            if (cls.isAnnotationPresent(annotation)) {
                result.add(cls);
            }
        }
        return result;
    }
}
