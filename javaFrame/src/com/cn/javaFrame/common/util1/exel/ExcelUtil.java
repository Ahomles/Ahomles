package com.cn.javaFrame.common.util1.exel;

import jxl.biff.HeaderFooter;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFFooter;
import org.apache.poi.hssf.usermodel.HSSFHeader;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelUtil {

	public static void main(String[] arg){
//			//创建一个新的excel
//		　　HSSFWorkbook wb = new HSSFWorkbook();
//		　　//创建sheet页
//		　　HSSFSheet sheet = wb.createSheet("KvOne");
//		　　//创建header页
//		　　HSSFHeader header = sheet.getHeader();
//		　　//设置标题居中
//		　　header.setCenter("标题");
//		　　//创建3行
//		　　HSSFRow[] row = new HSSFRow[3];
//		　　//设置第一行为Header
//		　　row[0] = sheet.createRow(0);
//		　　HSSFCell headerCell0 = row[0].createCell(10);
//		　　headerCell0.setCellValue(new HSSFRichTextString("标题"));
//		　　// 设置第二行为列名
//		　　row[1] = sheet.createRow(1);
//		　　HSSFCell[] headerCell1 = new HSSFCell[15];
//		　　for (int i = 0; i < 15; i++) {
//			　　headerCell1[i] = row[1].createCell(i);
//			　　headerCell1[i].setCellValue(new HSSFRichTextString("相应的列名"));
//		　　}
//		　　//第3行插入数据
//		　　row[2] = sheet.createRow(2);
//		　　HSSFCell[] headerCell12 = new HSSFCell[15];
//		　　for (int i = 0; i < 15; i++) {
//			　　headerCell12[i] = row[2].createCell(i);
//			　　headerCell12[i].setCellValue(new HSSFRichTextString("相应的数据值"));
//		　　}
//		　　//设置footer
//		　　sheet.setGridsPrinted(false);
//		　　HSSFFooter footer = sheet.getFooter();
//		　　footer.setRight("page   " + HeaderFooter.page() + "of" + HeaderFooter.numPages());
	}
}
