package cn.mrhan.study.demo.demos;

import java.io.UnsupportedEncodingException;

public class Demo13 {
    public static void main(String[] args) throws Exception {
/*      String str = Demo13.getANC("大家·好是·杰伦哈哈",30);
        System.out.println(str+";"+str.getBytes().length);*/
        String source = "大家·好我是·杰伦哈哈";
        char[] chars = source.toCharArray();
        StringBuffer bf = new StringBuffer();
        bf.append(source);
        for(int j=0;j<chars.length;j++){
            if(( "·".toCharArray()[0])==(chars[j])){
                bf.append(" ");
            }
        }
        bf.append("*");
        System.out.println(bf.toString());

        StringBuffer bf2 = new StringBuffer();
        bf2.append(source);
        int n  =source.indexOf("·");
        for(int i=0;i<n;i++){
            bf2.append(" ");
        }
        bf2.append("*");
    }

    public static String getANC(String source, int len)
            throws Exception
    {
        switch (getEncodeingType(source))
        {
            case 2:
                source = new String(source.getBytes("ISO-8859-1"), "GBK");
        }
        String rt = getAN(source, len);
        return rt;
    }

     public static int getEncodeingType(String source)
            throws Exception
    {
        String source_temp = new String(source.getBytes("ISO-8859-1"), "ISO-8859-1");
        if (source.equals(source_temp)) {
            return 2;
        }
        source_temp = new String(source.getBytes("GBK"), "GBK");
        return !source.equals(source_temp) ? 0 : 1;
    }


    public static String getAN(String source, int len) throws UnsupportedEncodingException {
        StringBuffer bf = new StringBuffer();
        if (source == null) {
            source = "";
        }
        int curLen = source.getBytes().length;
        int curLenC = source.length();
        if (curLen > len)
        {
            if (curLen != curLenC)
            {
                byte[] sourceByte = source.getBytes();
                 byte[] sourceByteNew = new byte[len];
                for (int i = 0; i < len; i++) {
                    sourceByteNew[i] = sourceByte[i];
                }
                bf.append(new String(sourceByteNew));
            }
            else
            {
                bf.append(source.substring(0, len));
            }
        }
        else if (curLen < len)
        {
            bf.append(source);
            for (int i = 0; i < len - curLen; i++) {
                bf.append(" ");
            }
        }
        else
        {
            bf.append(source);
        }
        char[] chars = source.toCharArray();
        for(int j=0;j<chars.length;j++){
            if("·".equals(chars[j])){
                bf.append("哈哈");
            }

        }
        return bf.toString();

    }


}
