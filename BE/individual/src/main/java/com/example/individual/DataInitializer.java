package com.example.individual;

import com.example.individual.model.Offer;
import com.example.individual.model.User;
import com.example.individual.repository.OfferRepository;
import com.example.individual.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Arrays;

/**
 * Component class responsible for initializing data in the application's database.
 */
@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private OfferRepository offerRepository;

    @Override
    public void run(String... args) throws Exception {

        if (userRepository.count() == 0) {



            List<User> users = Arrays.asList(
                    new User("user1", "user1email@mailhog.com", passwordEncoder.encode("1"), "Sabrina", "Dorn", "2004", "F", 1, 0.0),
                    new User("user2", "user2email@mailhog.com", passwordEncoder.encode("2"), "John", "Smith", "1990", "M", 5, 0.0),
                    new User("user3", "user3email@mailhog.com", passwordEncoder.encode("3"), "Michael", "Johnson", "1985", "M", 6, 0.0),
                    new User("user4", "user4email@mailhog.com", passwordEncoder.encode("4"), "Emma", "Brown", "1999", "F", 2, 0.0),
                    new User("user5", "user5@mailhog.com", passwordEncoder.encode("5"), "William", "Jones", "1976", "M", 7, 0.0),
                    new User("user6", "user6@mailhog.com", passwordEncoder.encode("6"), "Olivia", "Davis", "1992", "F", 3, 0.0),
                    new User("user7", "user7@mailhog.com", passwordEncoder.encode("7"), "James", "Miller", "2001", "M", 8, 0.0),
                    new User("user8", "user8@mailhog.com", passwordEncoder.encode("8"), "Ava", "Wilson", "1988", "F", 4, 0.0),
                    new User("user9", "user9@mailhog.com", passwordEncoder.encode("9"), "Benjamin", "Moore", "1979", "M", 11, 0.0),
                    new User("user10", "user10@mailhog.com", passwordEncoder.encode("10"), "Sophia", "Anderson", "1996", "F", 10, 0.0),
                    new User("user11", "user11@mailhog.com", passwordEncoder.encode("11"), "Ethan", "Taylor", "2008", "M", 12, 0.0),
                    new User("user12", "user12@mailhog.com", passwordEncoder.encode("12"), "Lily", "Clark", "1994", "F", 9, 0.0)
            );



            userRepository.saveAll(users);
        }


        if (offerRepository.count() == 0) {

            List<Offer> offers = Arrays.asList(
                    new Offer("Math Tutor", "Experienced math tutor. Improve your skills today!", "user2", "Mathematics", 30.0, "New York", parseDate("2023-09-09 10:00:00")),
                    new Offer("Physics Pro", "Master physics with an expert tutor. Contact now!", "user3", "Physics", 35.0, "Los Angeles", parseDate("2023-09-10 14:30:00")),
                    new Offer("Science Tutor", "Science tutor offering comprehensive help in various subjects.", "user4", "Science", 25.0, "Chicago / Online", parseDate("2023-09-11 16:15:00")),
                    new Offer("History Guide", "History lessons for all ages. Let's explore the past together.", "user5", "History", 30.0, "San Francisco", parseDate("2023-09-12 11:45:00")),
                    new Offer("Biology Expert", "Biology made easy. Learn with a passionate tutor.", "user6", "Biology", 30.0, "Boston", parseDate("2023-09-13 09:30:00")),
                    new Offer("Chemistry Master", "Chemistry tutor with a focus on understanding complex concepts.", "user7", "Chemistry", 35.0, "Houston", parseDate("2023-09-14 13:00:00")),
                    new Offer("Geography Explorer", "Explore the world with a geography tutor. Fun and educational!", "user8", "Geography", 25.0, "Philadelphia", parseDate("2023-09-15 15:20:00")),
                    new Offer("Music Maestro", "Music lessons for beginners and advanced students. Unlock your musical talent.", "user9", "Music", 40.0, "Phoenix", parseDate("2023-09-16 12:10:00")),
                    new Offer("IT Tutor", "IT specialist offering coding and technology tutoring. Get tech-savvy!", "user10", "IT", 40.0, "San Diego", parseDate("2023-09-17 17:00:00")),
                    new Offer("Language Pro", "Language tutor for English, Spanish, and more. Enhance your communication skills.", "user11", "Language", 30.0, "Online", parseDate("2023-09-18 10:30:00")),
                    new Offer("Lit Enthusiast", "Literature lover? Dive into the world of books with a literature tutor.", "user12", "Literature", 30.0, "Miami", parseDate("2023-09-19 14:45:00")),
                    new Offer("Versatile Tutor", "Custom tutoring for your unique needs. Contact me for personalized lessons.", "user1", "Other", 35.0, "Seattle", parseDate("2023-09-20 16:05:00")),
                    new Offer("Math Magic", "Mathematics made fun and easy. Let's conquer math together!", "user2", "Mathematics", 30.0, "Online", parseDate("2023-09-21 11:20:00")),
                    new Offer("Physics Wizard", "Physics tutor with a passion for teaching. Boost your grades!", "user3", "Physics", 35.0, "Atlanta", parseDate("2023-09-22 09:00:00")),
                    new Offer("Science Explorer", "Science tutor offering hands-on experiments and exciting learning.", "user4", "Science", 25.0, "Detroit", parseDate("2023-09-23 14:15:00")),
                    new Offer("History Buff", "Explore the past with a history tutor. Engaging lessons guaranteed.", "user5", "History", 30.0, "Austin", parseDate("2023-09-24 13:30:00")),
                    new Offer("Bio Guru", "Biology tutor with real-world examples. Get ready for success!", "user6", "Biology", 30.0, "Portland", parseDate("2023-09-25 10:45:00")),
                    new Offer("Chemistry Solver", "Chemistry tutor specializing in problem-solving. Ace your exams!", "user7", "Chemistry", 35.0, "San Jose", parseDate("2023-09-26 16:40:00")),
                    new Offer("Geo Adventurer", "Geography tutor bringing the world to your doorstep. Join the journey!", "user8", "Geography", 25.0, "Las Vegas", parseDate("2023-09-27 12:55:00"))
            );


            offerRepository.saveAll(offers);
        }
    }
    /**
     * Parses a date string in the "yyyy-MM-dd HH:mm:ss" format into a Date object.
     *
     * @param dateStr The date string to be parsed.
     * @return A Date object representing the parsed date and time.
     * @throws ParseException If the date string cannot be parsed.
     */
    private Date parseDate(String dateStr) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.parse(dateStr);
    }

}
