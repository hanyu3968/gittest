package cn.mrhan.study.api.annotation;
@MyAnno(age =1,name="张三")
public class AnnoDemo1 {


    @Override
    public String toString(){
        return super.toString();
    }

      @MyAnno2
    public  void show(){

    }

}
