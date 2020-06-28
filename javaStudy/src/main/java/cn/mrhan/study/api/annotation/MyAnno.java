package cn.mrhan.study.api.annotation;

/**
 * 自定义注解
 * 注解本质上就是一个接口，该接口默认继承Annoaction接口
 * 属性：接口中可以定义的成员方法 抽象方法
 *      属性的返回值类型 基础数据类型、字符串、枚举、注解 以上类型的数组
 *      定义了属性，在使用的时候需要给属性赋值
 *      如果定义属性时，使用default时候可以不给属性赋值
 *      如果只有后一个属性需要赋值，并且属性的名称是value，则value可以忽略
 *

 */
public @interface MyAnno {
     int age();

     String name();
}
