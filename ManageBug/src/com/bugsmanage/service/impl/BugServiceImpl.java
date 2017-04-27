package com.bugsmanage.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bugsmanage.dao.BugDao;
import com.bugsmanage.pojo.Bug;
import com.bugsmanage.service.BugService;
import com.bugsmanage.util.tag.PageModel;

/**
 * @Description:
 * @author 作者 :lixingyan
 * @version 创建时间：2017年3月20日 下午3:56:41
 */
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
@Service("bugService")
public class BugServiceImpl implements BugService {

	@Autowired
	private BugDao bugDao;

	// 分页查询
	@Transactional(readOnly = true)
	@Override
	public List<Bug> findBug(Bug bug, PageModel pageModel) {
		/** 当前需要分页的总数据条数 */
		Map<String, Object> params = new HashMap<>();
		params.put("bug", bug);

		int recordCount = bugDao.count(params);
		pageModel.setRecordCount(recordCount);

		if (recordCount > 0) {
			/*开始分页查询数据：查询第几页的数据 */
			params.put("pageModel", pageModel);
		}
		List<Bug> bugs = bugDao.selectByPage(params);
		return bugs;
	}

	// 根据bug_id查询
	@Transactional(readOnly = true)
	@Override
	public Bug selectBugById(Integer bug_id) {

		return this.bugDao.selectBugsById(bug_id);
	}

	// 添加bug
	@Override
	public void addBug(Bug bug) {
		this.bugDao.addBug(bug);

	}

	// 删除bug
	@Override
	public void deleteBug(Integer bug_id) {
		this.bugDao.deletebug(bug_id);

	}

	// 修改bug
	@Override
	public void modifyBug(Bug bug) {
		this.bugDao.update(bug);

	}

	//添加后马上显示
	@Transactional(readOnly = true)
	@Override
	public Bug selectBugByAdd(Bug bug) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<>();
		params.put("bug", bug);		
		return this.bugDao.selectBugByAdd(params);
	}

	@Transactional(readOnly = true)
	@Override
	public Integer countbug(Bug bug) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<>();
		params.put("bug", bug);
		return this.bugDao.count(params);
	}

//	//根据pro_id进行查询
//	@Transactional(readOnly = true)
//	@Override
//	public List<Bug> selectBugByPro(Integer pro_id) {
//		// TODO Auto-generated method stub
//		return this.bugDao.selectBugByPro(pro_id);
//	}
//
//	//根据pro_id 进行统计
//	@Transactional(readOnly = true)
//	@Override
//	public Integer countByP(Integer pro_id) {
//		
//		return this.bugDao.countByPro(pro_id);
//	}

	@Transactional(readOnly = true)
	@Override
	public List<Bug> selectBug(Bug bug) {
		Map<String, Object> params = new HashMap<>();
		params.put("bug", bug);
		return this.bugDao.selectByPage(params);		
	}
	
	@Override
	public HSSFWorkbook SetToExcel(Bug bug1) {
		 HSSFWorkbook workbook = new HSSFWorkbook(); 			
	 
 //    List<Bug> bugs=this.selectBugByPro(pro_id);
     
		 List<Bug> bugs=this.selectBug(bug1);
		 
		 
	 HSSFSheet sheet = workbook.createSheet("buglist");   
     HSSFRow row= sheet.createRow((short)0);  
     HSSFCell cell = null;  
     DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
     int nColumn=12; 
     
  cell = row.createCell((0));
     cell.setCellType(HSSFCell.CELL_TYPE_STRING);
     cell.setCellValue("序号"); 
    
  cell = row.createCell((1));
     cell.setCellType(HSSFCell.CELL_TYPE_STRING);
     cell.setCellValue("标题"); 
     
  cell = row.createCell((2));
     cell.setCellType(HSSFCell.CELL_TYPE_STRING);
     cell.setCellValue("缺陷级别"); 
     
  cell = row.createCell((3));
     cell.setCellType(HSSFCell.CELL_TYPE_STRING);
     cell.setCellValue("缺陷状态"); 
     
  cell = row.createCell((4));
     cell.setCellType(HSSFCell.CELL_TYPE_STRING);
     cell.setCellValue("报告人"); 
     
  cell = row.createCell((5));
     cell.setCellType(HSSFCell.CELL_TYPE_STRING);
     cell.setCellValue("所属项目"); 
     
  cell = row.createCell((6));
     cell.setCellType(HSSFCell.CELL_TYPE_STRING);
     cell.setCellValue("复现人"); 
     
  cell = row.createCell((7));
     cell.setCellType(HSSFCell.CELL_TYPE_STRING);
     cell.setCellValue("评论"); 
     
  cell = row.createCell((8));
     cell.setCellType(HSSFCell.CELL_TYPE_STRING);
     cell.setCellValue("复现结果"); 
     
  cell = row.createCell((9));
     cell.setCellType(HSSFCell.CELL_TYPE_STRING);
     cell.setCellValue("测试环境"); 
     
  cell = row.createCell((10));
     cell.setCellType(HSSFCell.CELL_TYPE_STRING);
     cell.setCellValue("步骤描述"); 
     
  cell = row.createCell((11));
     cell.setCellType(HSSFCell.CELL_TYPE_STRING);
     cell.setCellValue("提交时间"); 
     
     
     
     int iRow=1;  
     //写入各条记录，每条记录对应Excel中的一行  	        
     
     for (Bug bug : bugs)
	       {
    	 row = sheet.createRow((short) iRow++);
    	 
     	 cell = row.createCell(0);
     	 cell.setCellType(HSSFCell.CELL_TYPE_STRING);
     	 cell.setCellValue(bug.getBug_id().toString());
     	 
     	 cell = row.createCell(1);
     	 cell.setCellType(HSSFCell.CELL_TYPE_STRING);
     	 cell.setCellValue(bug.getSummary().toString());
     	 
     	 cell = row.createCell(2);
     	 cell.setCellType(HSSFCell.CELL_TYPE_STRING);
     	 if(bug.getBugseverity() != null && bug.getBugseverity().getBugseverity_id() != null
					&& bug.getBugseverity().getBugseverity_id() != 0){
     		cell.setCellValue(bug.getBugseverity().getSeverity().toString());
     	 }
     	 else{
     		cell.setCellValue("无");
     	 }
     	 
     	 
     	 cell = row.createCell(3);
     	 cell.setCellType(HSSFCell.CELL_TYPE_STRING);
     	 if(bug.getBug_status()==1){
     	 cell.setCellValue("New");}
     	 else   if(bug.getBug_status()==2){
	         cell.setCellValue("Open");}
     	 else   if(bug.getBug_status()==3){
		         cell.setCellValue("Assigned");}
     	 else   if(bug.getBug_status()==4){
	             cell.setCellValue("Handled");}
     	 else   if(bug.getBug_status()==5){
		         cell.setCellValue("Closed");}
     	 else   if(bug.getBug_status()==6){
		         cell.setCellValue("Reopen");}
     	 
     	 
     	 cell = row.createCell(4);
     	 cell.setCellType(HSSFCell.CELL_TYPE_STRING);
     	if (bug.getReporter() != null && bug.getReporter().getUser_id() != null
				&& bug.getReporter().getUser_id() != 0){
     		cell.setCellValue(bug.getReporter().getUsername().toString());
     	}else{
     	 cell.setCellValue("无");
        }
     	
     	
     	 cell = row.createCell(5);
     	 cell.setCellType(HSSFCell.CELL_TYPE_STRING);
     	if (bug.getProject() != null && bug.getProject().getPro_id() != null
				&& bug.getProject().getPro_id() != 0){
     		cell.setCellValue(bug.getProject().getPro_name().toString());
     	}else{
     	 cell.setCellValue("无");
     	}
     	
     	
     	 cell = row.createCell(6);
     	 cell.setCellType(HSSFCell.CELL_TYPE_STRING);
     	if (bug.getHandler() != null && bug.getHandler().getUser_id() != null
				&& bug.getHandler().getUser_id() != 0){
     		cell.setCellValue(bug.getHandler().getUsername().toString());
     	}else{
     		cell.setCellValue("无");
     	}
     	 
     	 
     	 cell = row.createCell(7);
     	 cell.setCellType(HSSFCell.CELL_TYPE_STRING);
     	 cell.setCellValue(bug.getBug_comment()== null ? "无 ":bug.getBug_comment().toString());
     	 
     	 
     	 cell = row.createCell(8);
     	 cell.setCellType(HSSFCell.CELL_TYPE_STRING);
     	 if(bug.getBug_result()== null){
     		cell.setCellValue("无");
     	 }
     	 else if(bug.getBug_result()==1){
     		 cell.setCellValue("Fixed");
     	 }else  if(bug.getBug_result()==2){
     		 cell.setCellValue("Rejected");
     	 }
     	 else  if(bug.getBug_result()==3){
     		 cell.setCellValue("Postponed");
     	 }
     	 else  if(bug.getBug_result()==4){
     		 cell.setCellValue("Duplicate");
     	 }
     	
     	 
     	 cell = row.createCell(9);
     	 cell.setCellType(HSSFCell.CELL_TYPE_STRING);
     	 cell.setCellValue(bug.getBug_os().toString());
     	 
     	 
     	 cell = row.createCell(10);
     	 cell.setCellType(HSSFCell.CELL_TYPE_STRING);
     	 cell.setCellValue(bug.getBug_description().toString());
     	 
     	 
     	 cell = row.createCell(11);
     	 cell.setCellType(HSSFCell.CELL_TYPE_STRING);
     	 cell.setCellValue(df.format(bug.getSubmite_time()).toString());
       
	       }		        
     
//		 }
//		 }
     return workbook;
	}


}
