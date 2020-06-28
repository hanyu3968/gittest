package cn.mrhan.study.demo.demos;

public class Demo04 {
    public static void main(String[] args) {
        StringBuffer jydStr =new StringBuffer();
        jydStr.append("1").append("").append("222");
        System.out.println(jydStr);

        String str = "1";
        String str2 = str.substring(0,str.length()-1);
        System.out.println(str2);

        String str1 = jydStr.toString();
        System.out.println(str1);
    }
}
