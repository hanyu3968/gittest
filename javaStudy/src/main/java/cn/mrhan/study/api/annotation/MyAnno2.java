package cn.mrhan.study.api.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 *  *  元注解 用于描述注解的注解
 *  *      @Target:描述注解能够作用的位置
 *              EleemntType取值：
 *              TYPE：可以作用于雷伤
 *              MEHTOD:可以作用于方法上
 *              FIELD:可以作用于成员变量上
 *  *      @Retention:描述注解被保留的阶段
 *  *      @Documented：描述注解是否被抽取到api文档中
 *  *      @Interited：描述注解是否被子类继承
 */
@Target(value={ElementType.TYPE,ElementType.METHOD})//标识该myanno2注解只能作用于类上
public @interface MyAnno2 {



}
