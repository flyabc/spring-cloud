package com.microservice.config;

import java.io.*;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

public class MyTest {
    public static void main(String[] args) {
        /*String str = "1|2|3|4";
        String[] split = str.split("|");
        System.out.println(split.length);

        Integer i =127;
        Integer j = new Integer(127);
        int l = 127;
        System.out.println("i==l:"+(i==l));
        System.out.println("i==j:"+(i==j));
        System.out.println("l==j:"+(l==j));

        System.out.println();
        Integer x =10000;
        Integer y = new Integer(10000);
        int z  = 10000;
        System.out.println("x==z:"+(x==z));
        System.out.println("x==y:"+(x==y));
        System.out.println("z==y:"+(z==y));*/
        //priInt(10);
        //Narcissistic(1000);
        //System.out.println(StringCutByByte("qwe我的",5));

        /*String a = "我ABC汉DEF" ;
        int len = 7 ;
        String encoding = "UTF-8" ;

        System.out.println( getSubString(a, len,encoding) );
        a = "我ABC";
        len = 4 ;
        encoding = "gbk" ;
        System.out.println( getSubString(a, len,encoding) );*/
        //System.out.println(splitStr("LLLOK你好",6,Charset.forName("utf-8")));
        //fileOut();
        /*System.out.println(Math.round(7.5));
        System.out.println(Math.round(-7.5));
        System.out.println(4|3);*/


    }

    //斐波那锲数列
    public static void priInt(int num){
        int a= 1;
        int b =  1;
        int c = 0;
        for (int i = 1;i<num;i++){
            if(i==1){
                System.out.println(a);
            }else if (i==2){
                System.out.println(b);
            }else{
                c=a+b;
                a=b;
                b=c;
                System.out.println(c);
            }
        }
    }



    //水仙花数
    public static void Narcissistic(int num){

        int count =1;//水仙花数的个数
        for(int i = 153 ;i<=num;i++){
            int a = i/100;//百位数
            int b = (i%100)/10;//百位数
            int c = i%10;//个位数
            if((Math.pow(a,3)+Math.pow(b,3)+Math.pow(c,3))==i){
                System.out.println("第"+count+"个水仙花数:"+i);
                count++;
            }
        }
        System.out.println(count);

    }

    public static void fileOut(){
        String fileName = "D:"+File.separator+"out.txt";

        File file = new File(fileName);
        //如果文件目录不存在需要先创建文件目录
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        try {
            InputStreamReader fileReader = new FileReader(fileName);
            //BufferedReader buffer = new BufferedReader(fileReader);
            //FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileName = "D:"+File.separator+"out1.txt";
            file = new File(fileName);
            FileWriter fileWriter = new FileWriter(file);

            /*String str ="";
            while( (str=buffer.readLine()) != null){
            }*/
            char[] chars = new char[1024];
            long len ;
            while((len=fileReader.read(chars))!=-1){
                fileWriter.write(chars);
                fileWriter.flush();
            };
            fileWriter.close();
            fileReader.close();
            /*String str1 = "nihao";
            byte[] bytestemp = str1.getBytes();
            fileOutputStream.write(bytestemp);
            fileOutputStream.flush();
            fileOutputStream.close();*/
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static String StringCutByByte(String str, int index) {
        String temp = null;
        byte[] bytes = str.getBytes();

        byte[] bytetemp = new byte[index];
        for (int i = 0; i < index; i++) {
            bytetemp[i] = bytes[i];
            //System.out.println(bytes[i]);
        }
        if (index > 1) {
            if (bytes[index - 1] < 0 && bytes[index - 2] > 0) { //第三个参数表示要解码的字节数
                temp = new String(bytetemp,0,index-1);
            } else {
                temp = new String(bytetemp);
            }
        } else {
            if (bytes[index - 1] < 0) {
                temp = null;
            } else temp = new String(bytetemp, 0, 1);
        }
        return temp;
    }

    /**
     * 编写一个截取字符串的函数，输入为一个字符串和字节数，输出为按字节截取的字符串。
     *  但是要保证汉字不被截半个，
     *  如“我ABC”4，应该截为“我AB”，
     *  输入“我ABC汉DEF”，6，应该输出为“我ABC”而不是“我ABC+汉的半个”。
     * @author songwei
     *
     *我的处理方式：截取字符串的一个字符，加入StringBuffer中，并取其字节数，并入当前获取字符的总长度中，
     *如果总长度大于等于输入的长度，则返回StringBuffer的toString值。
     *getSubString方法传入encoding值。UTF-8中文占3个字节，GBK占2个。结果有所不同，所以还是传入较好。
     *没有通过判断charAt的值来判定是否为中文等特殊字符。
     *不知道我这种方式是否正确。【未经过详细测试】
     */

        /**
         *
         * @param str 传入字符串
         * @param len 截取字节数
         * @param encoding 编码方式
         * @return 返回截取后的字符串
         * @throws Exception
         */
        public static String getSubString(String str,int len,String encoding){
            StringBuffer sb = null;
            try {
                if(str == null || str.length()<1) return null ;
                if(len<1) return null ;
                sb = new StringBuffer();
                int all = 0 ;
                byte[] tmpB=null;
                for(int i=0;i<str.length();i++){
                    String tmp = str.substring(i,i+1);
                    tmpB= tmp.getBytes(encoding);
                    all +=tmpB.length ;
                    if(all<=len){
                        sb.append(tmp);
                    }else {
                        break ;

                    }
                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return sb.toString() ;
        }


        public static String splitStr(String str ,int index,Charset charset){
            StringBuffer sb = new  StringBuffer();

            if (str==null || str.length()<1) return null;
            if (index<1) return null;
            int len=str.length();
            if (index>str.getBytes(charset).length) return str;
            int all=0;

            byte[] bytes;
            for (int i=0;i<len;i++){
                String tem = str.substring(i,i+1);
                bytes = tem.getBytes(charset);
                int temLen = bytes.length;
                all +=temLen;
                if(all>index) break;
                if(all<=index) sb.append(tem);
            }
            return sb.toString();

        };


    //装元素的集合
    private  final LinkedList<Object> list = new LinkedList<>();
    //计算器
    private AtomicInteger count = new AtomicInteger(0);
    //上限和下限
    private final int min=0;
    private  int maxSize;

    public MyTest(int maxSize) {
        this.maxSize = maxSize;
    }

    public MyTest() {
        this(10);
    }
    //初始化对象用于加锁
    private final Object lock = new Object();

    public int getSize(){return count.get();}

    //添加一个对象,如果队列满了就阻塞
    public void put(Object obj){
        synchronized (lock){
            //容器大小刚好等于队列长度,就阻塞
            while(getSize()==maxSize){
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                list.add(obj);
                count.incrementAndGet();//加一
                lock.notify();

            }
        }

    }

    /**
     * 取出一个元素,如果没有进等待
     * @return
     */
    public Object take(){
        synchronized (lock){
            //如果容器大小刚好等于队列最小长度
            while(getSize()==min){
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //取出第一个元素
            Object obj = list.removeFirst();
            count.decrementAndGet();
            lock.notify();
            return obj;
        }
    }
}
