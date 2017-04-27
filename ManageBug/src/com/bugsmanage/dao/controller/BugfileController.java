package com.bugsmanage.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.bugsmanage.pojo.Bug;
import com.bugsmanage.pojo.Bugfile;
import com.bugsmanage.service.BugService;
import com.bugsmanage.service.BugfileService;

/**
* @Description:
* @author 作者 :lixingyan
* @version 创建时间：2017年3月28日 上午9:07:11
*/
@Controller
public class BugfileController {	
	@Autowired
	@Qualifier("bugfileService")
	private BugfileService bugfileService;
	
	@Autowired
	@Qualifier("bugService")
	private BugService bugService;
	
	@RequestMapping(value="/bug/addBugFile")
	 public ModelAndView addBugFile(
			 Integer bug_id,
			 MultipartFile file,		  
			 ModelAndView mv,
			 @ModelAttribute Bug bug
			)throws Exception{
		
			// 上传文件名
			String originalFilename = file.getOriginalFilename();
			
			if(file!=null&&originalFilename!=null&&originalFilename.length()>0){  
	              
		        //存储图片的物理路径  
		        String pic_path="D:\\pic\\";  
		          
		        //新的图片名称  
		        String filename=UUID.randomUUID()+originalFilename.substring(originalFilename.lastIndexOf("."));  
		              
		        File newFile=new File(pic_path+filename);  		              
		        //将内存中的数据写入磁盘  
		        file.transferTo(newFile);  
		              
		        //将新的图片名称写到itemsCustom中  
		        Bugfile bugfile=new Bugfile();
		        bugfile.setFilename(filename);  
		        
		        bugfile.setBug_id(bug_id);
		        bugfileService.addBugfile(bugfile);
		        
		    }  					
			// 插入数据库
			Bug realbug=new Bug();
			realbug=bugService.selectBugById(bug_id);
			
			List<Bugfile> bugfiles=bugfileService.selectBugfileByBugId(bug_id);
			// 设置Model数据
						
			mv.addObject("bug", realbug);
			mv.addObject("bugfiles", bugfiles);
			mv.setViewName("bug/AdddetailBug");
		
		// 返回
		return mv;
	}
}
