package cn.mrhan.study.api.reflect;

import cn.mrhan.study.entity.Person;

import java.lang.reflect.Constructor;

/**
 * 反射的构造方法
 */
public class Demo03 {

    public static void main(String[] args) throws Exception {
        //获取构造方法
        Class personClass = Person.class;
        Constructor constructor = personClass.getConstructor(String.class,int.class);
        System.out.println(constructor);
        //创建对象
        Object person = constructor.newInstance("张三",22);
        System.out.println(person);
        //如果使用空参数构造方法创建对象操作可以简化 可以使用Class对象的newInstance方法
        Object o = personClass.newInstance();
        System.out.println(o);
    }
}
