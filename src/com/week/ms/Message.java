package com.week.ms;

import java.io.*;
import java.util.*;

public class Message {

    public static void main(String[] args) {
        String kFile = "data.txt";
        ArrayList array=solution(kFile);
        for(int i=0;i<array.size();i++){
            Map map = (Map) array.get(i);
            System.out.println(map);
            if(i>=9){
                break;
            }
        }
    }

    public static ArrayList solution(String kFile) {

        Comparator c = new Comparator<Map>() {
            @Override
            public int compare(Map m1, Map m2) {
                // TODO Auto-generated method stub
                int cnt1 = (int) m1.get("cnt");
                int cnt2 = (int) m2.get("cnt");
                if(cnt1 >= cnt2){
                    return -1;
                }else{
                    return 1;
                }
            }
        };

        HashMap count=new HashMap();

        ArrayList array =new ArrayList();

        FileInputStream inputStream = null;
        Scanner sc = null;
        try {
            inputStream=new FileInputStream(kFile);
            sc = new Scanner(inputStream,"UTF-8");
            //我们将使用Java.util.Scanner类扫描文件的内容，一行一行连续地读取，允许对每一行进行处理，而不保持对它的引用。总之没有把它们存放在内存中：
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                if(line!=null){
                    if(count.containsKey(line)){
                        int cnt = (int) count.get(line);
                        cnt++;
                        count.put(line,cnt);
                        for(int i=0;i<array.size();i++){//更新Array
                            Map map = (Map) array.get(i);
                            if(map.get("msg").equals(line)){
                                map.put("cnt",cnt);
                            }
                        }
                    }else{
                        count.put(line,1);
                        Map map=new HashMap();
                        map.put("msg",line);
                        map.put("cnt",1);
                        array.add(map);

                    }
                    Collections.sort(array,c);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (sc != null) {
                sc.close();
            }
        }
        return array;
    }
}