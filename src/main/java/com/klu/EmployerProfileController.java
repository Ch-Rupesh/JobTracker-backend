package com.klu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/employer-profile")
@CrossOrigin(origins = "*") // Specify your frontend origin for better security
public class EmployerProfileController {

    private static final Logger logger = LoggerFactory.getLogger(EmployerProfileController.class);

    @Autowired
    private EmployerProfileRepository employerProfileRepository;

    @PostMapping("/submit")
    public ResponseEntity<?> submitProfile(@RequestBody EmployerProfile employerProfile) {
        try {
            // Save the employer profile
            employerProfileRepository.save(employerProfile);
            logger.info("Employer profile submitted successfully for email: {}", employerProfile.getEmail());
            return ResponseEntity.ok(new ResponseMessage("Success", "Employer profile submitted successfully!"));
        } catch (Exception e) {
            logger.error("Error submitting employer profile: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseMessage("Error", "Failed to submit employer profile: " + e.getMessage()));
        }
    }

    // ResponseMessage class to structure the response
    public static class ResponseMessage {
        private String status;
        private String message;

        public ResponseMessage(String status, String message) {
            this.status = status;
            this.message = message;
        }

        public String getStatus() {
            return status;
        }

        public String getMessage() {
            return message;
        }
    }
}