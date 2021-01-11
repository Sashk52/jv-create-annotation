package core.basesyntax.lib;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.UserDao;
import core.basesyntax.exceptions.AnnotationException;
import core.basesyntax.factory.Factory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {
    public static Object getInstance(Class clazz) throws IllegalAccessException,
            InvocationTargetException, InstantiationException, NoSuchMethodException {
        Constructor constructor = clazz.getDeclaredConstructor();
        Object instance = constructor.newInstance();
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.isAnnotationPresent(Inject.class)) {
                field.setAccessible(true);
                Object objectdao = new Object();
                if (field.getType() == BetDao.class) {
                    objectdao = Factory.getBetDao();
                } else if (field.getType() == UserDao.class) {
                    objectdao = Factory.getUserDao();
                }
                if (objectdao.getClass().isAnnotationPresent(Dao.class)) {
                    field.set(instance, objectdao);
                } else {
                    throw new AnnotationException("Class " + field.getType()
                            + " doesn't have annotation @Dao");
                }
            }

        }
        return instance;
    }
}
