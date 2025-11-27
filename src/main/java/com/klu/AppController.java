package com.klu;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class AppController {
	
	@Autowired
	Service s;

	@PostMapping("/SignUp")
	public String insertSignUp(@RequestBody SignUp signup) {
		return s.insertData(signup);
	}

	@PostMapping("/LogIn")
	public String insertLogin(@RequestBody LogIn login) {
		return s.insertLogin(login);
	}

	@PostMapping("/User_Personal_Details")
    public String createUser(@RequestBody User_Personal_Details personal) {
        return s.insertPersonalData(personal);
    }

    @GetMapping("User_Personal_Details")
    public List<User_Personal_Details> getAllUsers() {
        return s.getAllUsers();
    }
   
    @PostMapping("/User_Qualification_Details")
    public String createQualification(@RequestBody User_Qualification_Details qualification) throws IOException {
        return s.insertQualificationData(qualification);
    }
   
    @PostMapping("/Resume")
    public String upload(@RequestParam("email") String email, @RequestParam("file") MultipartFile file) throws IOException {
        return s.uploadPDF(email, file);
    }

    @GetMapping("/Resume/{email}")
    public ResponseEntity<byte[]> downloadResume(@PathVariable String email) {
    
        Optional<Resume> optionalResume = s.resume.findById(email);
        
        if (optionalResume.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        
        Resume resume = optionalResume.get();
       
        return ResponseEntity.ok()
                .header(org.springframework.http.HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resume.getFile_name() + "\"")
                .contentType(org.springframework.http.MediaType.APPLICATION_PDF)
                .body(resume.getData());
    }    
}
