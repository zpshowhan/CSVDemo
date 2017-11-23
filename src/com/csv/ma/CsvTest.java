package com.csv.ma;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

/** 
* @ClassName: CsvTest 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @version 1.0 2017年5月22日 下午2:04:04 
*/
public class CsvTest {

	public static void main(String[] args) throws IOException {
		//生成CsvReader对象，以，为分隔符，GBK编码方式
        CsvReader r = new CsvReader("D://test.csv", ',',Charset.forName("GBK"));
        //读取表头
        r.readHeaders();
        String[] headers = r.getHeaders();
        for (int i = 0; i < headers.length; i++) {
			
        	System.out.println(headers[i]);
		}
        //逐条读取记录，直至读完
        while (r.readRecord()) {
            //读取一条记录
            System.out.println(r.getRawRecord());
            //按列名读取这条记录的值
            System.out.println(r.get(0));
            System.out.println(r.get("性别"));
        }
        r.close();
        System.out.println('p'+1);
        //===========
        /*File file=new File("F://info.csv");
        CsvWriter wr =new CsvWriter("F://info.csv",',',Charset.forName("GBK"));
        String[] headers = {"编号","姓名","年龄"};
        String[] content = {"12365","张山","34"};
        String[] content2 = {"12365","张山","34"};
        wr.writeRecord(headers);
        wr.writeRecord(content);
        wr.writeRecord(content2);
        wr.close();*/
	}
}
