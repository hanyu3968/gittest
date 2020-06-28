package cn.mrhan.study.api.reflect;
import cn.mrhan.study.api.annotation.Pro;
import java.lang.reflect.Method;

/**
 * 写一个框架，可以帮我们创建任意对象
 */
@Pro(className="cn.mrhan.study.entity.Person",methodName = "eat")
public class RefeactDemo {
    public static void main(String[] args) throws Exception {
        //1.解析注解
        //1.1获取该类的字节码文件对象
        Class<RefeactDemo> caseDemoClass = RefeactDemo.class;
        //1.2获取上边的注解对象
        Pro pro = caseDemoClass.getAnnotation(Pro.class);//其实就是在内存中生成了一个该注解的子类实现对象
        //1.3调用注解对象中定义的抽象方法，获取返回值
        String className = pro.className();
        String methodName = pro.methodName();
        System.out.println(className+","+methodName);
        //3.加载改类进内存
        Class cls = Class.forName(className);
        //4.创建对象
        Object obj = cls.newInstance();
        //5.获取方法对象
        Method method = cls.getMethod(methodName);
        //6.执行方法
        method.invoke(obj);
    }
}
