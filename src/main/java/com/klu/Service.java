package com.klu;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

@org.springframework.stereotype.Service
public class Service {

	@Autowired
	SignUpRepo up;	
	
	@Autowired
	LoginRepo in;
	
	@Autowired
	User_Personal_Details_Repo personalRepo;
	
	@Autowired
	User_Qualification_Details_Repo qualificationRepo; 
	
	@Autowired
	ResumeRepo resume;
	
	public String insertData(SignUp signup) {		
		up.save(signup);
		return "Sign Up Successfully";
	}
	
	public String insertLogin(LogIn login) {
		in.save(login);
		return "Login Successfully";
	}
	
	public String insertPersonalData(User_Personal_Details personal) {
		personalRepo.save(personal);
        return "Personal data stored successfully";
	}
	
	public List<User_Personal_Details> getAllUsers() {
        return personalRepo.findAll();
    }
	
	public String insertQualificationData(User_Qualification_Details qualification) {
		qualificationRepo.save(qualification);
		return "Qualification data stored successfully";
	}
	
	public String uploadPDF(String email, MultipartFile file) throws IOException {
        Resume res=new Resume();
        res.setEmail(email);
        res.setFile_name(file.getOriginalFilename());
        res.setType(file.getContentType());
        res.setData(file.getBytes());
        
        resume.save(res);
        return "PDF uploaded successfully!";
    }
	
	

}
