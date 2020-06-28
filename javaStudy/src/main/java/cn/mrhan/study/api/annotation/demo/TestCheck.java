package cn.mrhan.study.api.annotation.demo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * 简单的测试框架
 * 当主方法执行后，会自动自行被检测的所有方法（加了Check注解的方法），判断方法是否有异常，记录到文件中
 */
public class TestCheck {
    public static void main(String[] args) throws IOException {
        //1.创建计算器对象
        Calculator c = new Calculator();
        //2.获取字节码文件对象
        Class cls = c.getClass();

        //3.获取所有方法
        int number= 0;//出现异常的次数
        BufferedWriter bw = new BufferedWriter(new FileWriter("bug.txt"));
        Method[] methods = cls.getMethods();
        for(Method method:methods){
            //4.判断方法上是否有Check注解
            if(method.isAnnotationPresent(Check.class)){
                //5.有，执行
                try {
                    method.invoke(c);
                } catch (Exception e) {
                    e.printStackTrace();
                    //记录到文件中
                    number ++;
                    bw.write(method.getName()+"方法出现异常了");
                    bw.newLine();
                    bw.write("异常的原因："+e.getCause().getClass().getSimpleName());
                    bw.newLine();
                    bw.write(".................");
                    bw.newLine();
                }
            }
        }
        bw.write("本次一共出现"+number+"异常");
        bw.flush();
        bw.close();
        /**
         * 小结：
         *  1.以后大多数时候，我们会使用注解，而不是自定义注解
         *  2.注解给谁用户 编译器、解析程序
         *  3.注解不是程序的一部分  可以将注解理解为一个标签
         */

    }
}
