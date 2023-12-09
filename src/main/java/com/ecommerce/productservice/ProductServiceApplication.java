package com.ecommerce.productservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductServiceApplication implements CommandLineRunner {

//    private final MentorRepository mentorRepository;
//    private final StudentRepository studentRepository;
//    private final UserRepository userRepository;
//
//    public ProductServiceApplication(@Qualifier("stMentorRepository") MentorRepository mentorRepository,
//                                     @Qualifier("stStudentRepository") StudentRepository studentRepository,
//                                     @Qualifier("stUserRepository") UserRepository userRepository) {
//        this.mentorRepository = mentorRepository;
//        this.studentRepository = studentRepository;
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        Mentor mentor = new Mentor();
//        mentor.setName("John");
//        mentor.setEmailId("john@gmail.com");
//        mentor.setSalary(10000);
//        mentor.setAverageRating(4.5);
//
//        this.mentorRepository.save(mentor);
//
//        Student student = new Student();
//        student.setName("Smith");
//        student.setEmailId("smith@gmail.com");
//
//        this.studentRepository.save(student);
//
//        User user = new User();
//        user.setName("David");
//        user.setEmailId("david@gamil.com");
//
//        this.userRepository.save(user);
//
//    }

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
