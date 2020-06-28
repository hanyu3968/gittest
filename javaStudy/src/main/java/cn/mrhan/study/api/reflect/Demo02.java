package cn.mrhan.study.api.reflect;

import cn.mrhan.study.entity.Person;

import java.lang.reflect.Field;

/**
 * Class对象功能
 * 1.获取成员变量
 * 2.获取构造方法
 * 3.获取成员方法
 * 4.获取类名
 */
public class Demo02 {



    public static void main(String[] args) throws Exception {
        //1.获取Peroson的Class对象
        Class c = Person.class;
        Field[] fields = c.getFields();//获取public 修饰的成员变量
        for(Field field:fields){
            System.out.println(field);
        }

        System.out.println("==============");

        Field a = c.getField("address");
        Person p = new Person();
        Object value = a.get(p);
        System.out.println(value);


        //设置a的值
        a.set(p,"安徽合肥");
        System.out.println(p);

        System.out.println("=============");
        //获取所有的成员变量
        Field[] declaredFields = c.getDeclaredFields();
        for(Field declaredField:declaredFields){
            System.out.println(declaredField);
        }
        //Field.getDeclardField(String name)
        Field d = c.getDeclaredField("address");
        //忽略访问权限修饰符的安全检查
        d.setAccessible(true);//暴力反射
        Object value2 = d.get(p);
        System.out.println(value2);

    }


}
