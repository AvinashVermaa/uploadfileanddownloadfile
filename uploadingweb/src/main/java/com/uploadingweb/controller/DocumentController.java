package com.uploadingweb.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import com.uploadingweb.entity.Document;
import com.uploadingweb.repository.DocumentRepo;

@Controller
public class DocumentController {

	@Autowired
	private DocumentRepo documentRepo;
	
	@RequestMapping("displayUpload")
	public String displayUpload(ModelMap model) {
		List<Document> lists = documentRepo.findAll();
		model.addAttribute("lists", lists);
		return "upload";
	}
	
	@RequestMapping(value = "upload",method=RequestMethod.POST)
	public String upload(@RequestParam("id") int id,@RequestParam("document") MultipartFile file,ModelMap model) throws Exception{
		Document document = new Document();
		document.setId(id);
		document.setName(file.getOriginalFilename());
		document.setData(file.getBytes());
		
		Document savedDocument = documentRepo.save(document);
		
		List<Document> lists = documentRepo.findAll();
		model.addAttribute("lists", lists);
		
		return "upload";
	}
	
	@RequestMapping("download")
	public StreamingResponseBody download(@RequestParam("id") int id,HttpServletResponse response) {
		Document document = documentRepo.findById(id).get();
		byte[] data = document.getData();
		
		//Set headers for downloading the file
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		headers.setContentDispositionFormData("attachment", "download.jpg");
		
		response.setHeader(HttpHeaders.CONTENT_DISPOSITION, headers.getFirst(HttpHeaders.CONTENT_DISPOSITION));
		
		return outputStream->{
			outputStream.write(data);
			outputStream.flush();
			outputStream.close();
		};
	}
}
