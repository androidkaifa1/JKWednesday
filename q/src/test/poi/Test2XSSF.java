package poi;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileOutputStream;

/**
 * Created by root on 2017/6/1.
 */
public class Test2XSSF {
    @Test
    public void testprint() throws Exception{
        String xlsFile = "d:/outproduct/clroleprice.xlsx";

        //STEP 1:打开excel文件
        Workbook wb = new XSSFWorkbook();									//创建excel文件
        //Workbook wb = new XSSFWorkbook(new FileInputStream(xlsFile));		//打开已存在的excel文件

        //STEP 2:打开当前工作簿
        Sheet sheet = wb.createSheet("我的第一个工作簿");		//建立新的sheet对象
        //Sheet sheet = wb.getSheetAt(0);						//选择第一个工作簿
        //wb.setSheetName(0, "我的第一个工作簿");					//设置工作簿的名称

        Row nRow = null;
        Cell nCell   = null;

        //STEP 3:创建行对象
        nRow = sheet.createRow((short)1);						//第2行

        for (int j = 0; j < 100000; j++) {
            nRow = sheet.createRow(j);
            for (int i = 0; i < 20; i++) {
                //STEP 4:指定列 创建单元格对象
                nCell = nRow.createCell((short)(i));					//第3列

                //STEP 5:指定列 创建单元格对象
                nCell.setCellValue("盐城");
            }
        }




        //STEP 6:设置样式
        nCell.setCellStyle(leftStyle(wb));

        //STEP 7:关闭保存excel文件
        FileOutputStream fOut = new FileOutputStream(xlsFile);
        wb.write(fOut);
        fOut.flush();
        fOut.close();

    }

    //设置单元格样式
    private CellStyle leftStyle(Workbook wb){
        CellStyle curStyle = wb.createCellStyle();
        Font curFont = wb.createFont();								//设置字体
        //curFont.setFontName("Times New Roman");						//设置英文字体
        curFont.setFontName("微软雅黑");								//设置英文字体
        curFont.setCharSet(Font.DEFAULT_CHARSET);					//设置中文字体，那必须还要再对单元格进行编码设置
        curFont.setFontHeightInPoints((short)10);						//字体大小
        curStyle.setFont(curFont);

        curStyle.setBorderTop(CellStyle.BORDER_THICK);				//粗实线
        curStyle.setBorderBottom(CellStyle.BORDER_THIN);			//实线
        curStyle.setBorderLeft(CellStyle.BORDER_MEDIUM);			//比较粗实线
        curStyle.setBorderRight(CellStyle.BORDER_THIN);				//实线

        curStyle.setWrapText(true);  									//换行
        curStyle.setAlignment(CellStyle.ALIGN_RIGHT);				//横向具右对齐
        curStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);	//单元格垂直居中

        return curStyle;
    }
}
