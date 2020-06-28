package cn.mrhan.study.demo.mianshi;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Test01 {

    public Test01(String type){
        System.out.println("构造方法1");
    }
    private String id ;
    private String name;

    public Test01() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {

        this.name = name;
    }

    @Override
    public String toString() {
        return "Test01{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Class c1 = Class.forName("cn.mrhan.study.demo.mianshi.Test01");

        Constructor[] cConstructors = c1.getConstructors();
        for (Constructor constructor:cConstructors) {
            System.out.println(constructor);
        }
        Class c2 = Test01.class;
        Method[] methods = c2.getMethods();
        for(Method method:methods){
            System.out.println(method);
        }

    }
}
