package com.bugsmanage.util.common;

import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;
import com.bugsmanage.pojo.Bug;

/**
* @Description:
* @author 作者 :lixingyan
* @version 创建时间：2017年3月29日 上午9:01:51
*/
public class ViewExcel extends AbstractExcelView{

	@Override
	public void buildExcelDocument(Map<String, Object> obj,  
            HSSFWorkbook workbook, HttpServletRequest request, HttpServletResponse response)  
            throws Exception {  
        String filename = "buglist.xls";//设置下载时客户端Excel的名称       
       // filename = StringUtils.encodeFilename(filename, request);//处理中文文件名    
        response.setContentType("application/vnd.ms-excel");       
        response.setHeader("Content-disposition", "attachment;filename=" + filename);       
        OutputStream ouputStream = response.getOutputStream();       
        workbook.write(ouputStream);       
        ouputStream.flush();       
        ouputStream.close();   
    }  
}
