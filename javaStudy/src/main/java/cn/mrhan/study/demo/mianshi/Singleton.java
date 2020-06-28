package cn.mrhan.study.demo.mianshi;

/**
 * Singleton模式的主要作用是保证在java应用中，一个类只有一个实例存在
 * 一般Singleton模式通过长的形式为：定义一个类，它的构造函数为private
 * 有一个statuc的private变量，在类初始化的时候初始化，通过Public的
 * getInstance方法获取对它的引用
 */
public class Singleton {
    private static Singleton instance = null;
    public static Singleton getInstance(){
        if(instance==null){
            instance = new Singleton();
        }
        return instance;

    }

}
