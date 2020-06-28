package cn.mrhan.study.demo.demos;

public class Demo09 {
    public static void main(String[] args) {
        String str = "11|12|13|14|15|16|";
        String[] strs = str.split("\\|");
        String begin = strs[0];
        String end = strs[strs.length-1];
        System.out.println("begin:"+begin+",end:"+end);
    }
}
