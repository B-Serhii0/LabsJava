package lab6.task4;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

public class Task4Main {
    public static void main(String[] args) throws Exception {
        //сканування пакета
        List<Class<?>> found = ClassScanner.findAnnotated("lab6.task4.components", Component.class);
        System.out.println("Знайдено @Component класів: " + found.size() + "\n");

        for (Class<?> cls : found) {
            Component meta = cls.getAnnotation(Component.class);
            System.out.println("== " + cls.getSimpleName() + " (name=" + meta.name() + ", v" + meta.version() + ")");

            //створення екземпляра
            Constructor<?> ctor = cls.getDeclaredConstructor();
            Object instance = ctor.newInstance();

            //встановлення значення поля
            Field field = cls.getDeclaredFields()[0];
            field.setAccessible(true);
            field.set(instance, demoValueFor(field.getType()));

            //виклик методу дії
            Method execute = cls.getMethod("execute");
            execute.invoke(instance);

            //підсумковий стан
            System.out.println("   " + instance + "\n");
        }
    }

    private static Object demoValueFor(Class<?> type) {
        if (type == boolean.class) return true;
        if (type == int.class) return 42;
        if (type == String.class) return "demo";
        throw new IllegalArgumentException("Непідтримуваний тип: " + type);
    }
}
