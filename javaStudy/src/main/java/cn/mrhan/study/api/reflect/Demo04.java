package cn.mrhan.study.api.reflect;

import cn.mrhan.study.entity.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * 反射的成员方法
 */
public class Demo04 {

    public static void main(String[] args) throws Exception {
        //获取成员方法
        Class personClass = Person.class;
        //获取指定的方法
        Method method = personClass.getMethod("eat");
        Person p = new Person();
        //执行方法
        method.invoke(p);
        //获取所有public修饰的方法
        Method[] methods = personClass.getMethods();
        for (Method meth:methods){
            System.out.println(meth);
            //method.setAccessible(true);//暴力反射 获取私有成员方法
            String name = meth.getName();
            System.out.println(name);
        }


        //获取类名
        String className = personClass.getName();
        System.out.println(className);

    }
}
