package com.klu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class NotificationService {
    
    @Autowired
    private NotificationRepository notificationRepo;

    @Autowired
    private User_Personal_Details_Repo userRepo;

    public List<Notification> getNotificationsByEmail(String email) {
        return notificationRepo.findByUserEmail(email);
    }
    
    public List<Notification> getAllNotifications() {
        return notificationRepo.findAll();
    }

    public Notification saveNotification(Notification notification) {
        notification.setCreatedAt(LocalDateTime.now());
        notification.setReadStatus(false);
        return notificationRepo.save(notification);
    }

    public Optional<Notification> markAsRead(Long id) {
        Optional<Notification> optional = notificationRepo.findById(id);
        optional.ifPresent(notification -> {
            notification.setReadStatus(true);
            notificationRepo.save(notification);
        });
        return optional;
    }

    public void deleteNotification(Long id) {
        notificationRepo.deleteById(id);
    }

    public void markAllAsRead() {
        List<Notification> list = notificationRepo.findAll();
        for (Notification n : list) {
            n.setReadStatus(true);
        }
        notificationRepo.saveAll(list);
    }

    public void createJobMatchNotification(Job job) {
        // Get users who match the job criteria
        List<User_Personal_Details> users = userRepo.findAll();

        for (User_Personal_Details user : users) {
            // Calculate match score based on skills
            double matchScore = calculateMatchScore(user.getSkills(), job.getSkills_required());

            // Create notification if match score is above threshold
            if (matchScore > 0.5) {
                Notification notification = new Notification();
                notification.setUserEmail(user.getEmail()); // assuming user has email attribute
                notification.setJobId(job.getId().toString());
                notification.setTitle("New Job Match!");
                notification.setMessage("A new job matching your skills has been posted: " + job.getJob_name() + " at " + job.getCompany_name());
                notification.setMatchScore(matchScore);

                // Save notification
                saveNotification(notification);
            }
        }
    }

    private double calculateMatchScore(List<String> userSkills, String jobSkills) {
        if (userSkills == null || jobSkills == null) return 0.0;

        String[] requiredSkills = jobSkills.toLowerCase().split(",");
        int matches = 0;

        for (String skill : requiredSkills) {
            if (userSkills.stream().anyMatch(s -> s.toLowerCase().contains(skill.trim()))) {
                matches++;
            }
        }

        return (double) matches / requiredSkills.length;
    }
}
