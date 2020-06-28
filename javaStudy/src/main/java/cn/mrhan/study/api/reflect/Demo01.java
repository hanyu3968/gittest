package cn.mrhan.study.api.reflect;

import cn.mrhan.study.entity.Person;

/**
 * 反射：框架设计的灵魂
 * 将类的各个组成部分封装为其他对象，这就是反射机制
 */
public class Demo01 {
    /**
     * java代码在计算机中经历的三个阶段：
     * Source-源代码阶段：java文件----java编译---在硬盘中生成字节码文件Person.class
     * Class-类对象阶段：类加载器 ：成员变量 Field  构造方法 Constructor   成员方法 Methods
     * ----创建对象----Runtime-运行时阶段
     * 反射的好处：
     * 1.可以在程序运行过程中，操作这些对象
     * 2.可以解耦，提高程序的可扩展性
     *
     * 获取Class类对象的方式：
     * 1.Class.forName("全类名") :将字节码文件加载进内存，返回Class对象
     * 多用于配置文件，将类名定义与配置文件中 读取文件 加载类
     * 2.类名.class ；通过类名的属性class获取
     * 多用于参数的传递
     * 3.对象.getClass()
     * 多用于对象的获取字节码的方式
     */
    public static void main(String[] args) throws ClassNotFoundException {
        //Class.forName("全类名")
        Class cls1 = Class.forName("cn.mrhan.study.entity.Person");
        System.out.println(cls1);

        //类名.class
        Class cls2 = Person.class;
        System.out.println(cls2);

        //对象.getClass()
        Person p = new Person();
        Class cls3 = p.getClass();
        System.out.println(cls3);
        System.out.println(cls1==cls2);
        System.out.println(cls3==cls2);
        //结论 同一个字节码文件中在一次程序运行过程中，只会被加载一次，class类对象都是同一个



    }
}
