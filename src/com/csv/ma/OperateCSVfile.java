package com.csv.ma;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/** 
* @ClassName: OperateCSVfile 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @version 1.0 2017年5月22日 下午2:18:35 
*/
public class OperateCSVfile {

	 public static void main(String[] args){
	        String [] str = {"省","市","区","街","路","里","幢","村","室","园","苑","巷","号"};
	        File inFile = new File("C://batch_user_sample.csv"); // 读取的CSV文件
	        File outFile = new File("C://out.csv");//写出的CSV文件
	        String inString = "";
	        String tmpString = "";
	        try {
	            BufferedReader reader = new BufferedReader(new FileReader(inFile));
	            BufferedWriter writer = new BufferedWriter(new FileWriter(outFile));
	            while((inString = reader.readLine())!= null){
	                char [] c = inString.toCharArray();
	                String [] value = new String[c.length];
	                String result = "";
	                for(int i = 0;i < c.length;i++){
	                    value[i] = String.valueOf(c[i]);
	                    for(int j = 0;j < str.length;j++){
	                        if(value[i].equals(str[j])){
	                            String tmp = value[i];
	                            value[i] = "," + tmp + ",";
	                        }
	                    }
	                    result += value[i];
	                }
	               writer.write(inString);
	               writer.newLine();
	            }
	            reader.close();
	            writer.close();
	        } catch (FileNotFoundException ex) {
	            System.out.println("没找到文件！");
	        } catch (IOException ex) {
	            System.out.println("读写文件出错！");
	        }
	    }
}
