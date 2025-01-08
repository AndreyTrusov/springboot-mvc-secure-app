show tables;
use mvcproject;
select * from event;


CREATE TABLE Event_Tag_Mapping (
    TagMappingID INT AUTO_INCREMENT PRIMARY KEY,
    EventID INT(11) NOT NULL,
    TagID INT(11) NOT NULL,
    MappedAt DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (EventID) REFERENCES Event(EventID) ON DELETE CASCADE,
    FOREIGN KEY (TagID) REFERENCES Event_Tag(TagID) ON DELETE CASCADE
);

INSERT INTO mvcproject_1.event (name, is_private, created_by) VALUES
    ('Summer Beach Party', 0, 1),
    ('Corporate Team Building', 1, 2),
    ('Tech Conference 2024', 0, 3),
    ('Private Wedding Reception', 1, 4),
    ('City Marathon', 0, 5),
    ('Executive Board Meeting', 1, 6),
    ('Public Art Exhibition', 0, 7),
    ('Birthday Celebration', 1, 8),
    ('Community Cleanup Day', 0, 9);
    
    
Create database mvcproject_1;
USE mvcproject_1;

show tables;

CREATE TABLE event_tag (
    tag_id INT(11) NOT NULL AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    PRIMARY KEY (tag_id)
);

CREATE TABLE event_tag_mapping (
    tag_mapping_id INT AUTO_INCREMENT PRIMARY KEY,
    event_id INT(11) NOT NULL,
    tag_id INT(11) NOT NULL,
    mapped_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (event_id) REFERENCES event(event_id) ON DELETE CASCADE,
    FOREIGN KEY (tag_id) REFERENCES event_tag(tag_id) ON DELETE CASCADE
);


CREATE TABLE user_history (
    history_id INT(11) NOT NULL AUTO_INCREMENT,
    user_id INT(11) NOT NULL,
    event_id INT(11) NOT NULL,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (history_id),
    FOREIGN KEY (user_id) REFERENCES user(user_id) ON DELETE CASCADE,
    FOREIGN KEY (event_id) REFERENCES event(event_id) ON DELETE CASCADE
);

CREATE TABLE event_subscription (
    subscription_id INT(11) NOT NULL AUTO_INCREMENT,
    user_id INT(11) NOT NULL,
    event_id INT(11) NOT NULL,
    started_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    active BOOLEAN DEFAULT TRUE,
    PRIMARY KEY (subscription_id),
    FOREIGN KEY (user_id) REFERENCES user(user_id) ON DELETE CASCADE,
    FOREIGN KEY (event_id) REFERENCES event(event_id) ON DELETE CASCADE
);

CREATE TABLE event_feedback (
    feedback_id INT(11) NOT NULL AUTO_INCREMENT,
    event_id INT(11) NOT NULL,
    user_id INT(11) NOT NULL,
    feedback VARCHAR(255) NOT NULL,
    rating INT(1) CHECK (rating BETWEEN 1 AND 5),
    is_anonymous BOOLEAN DEFAULT FALSE,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (feedback_id),
	FOREIGN KEY (user_id) REFERENCES user(user_id) ON DELETE CASCADE,
    FOREIGN KEY (event_id) REFERENCES event(event_id) ON DELETE CASCADE
);

CREATE TABLE event_schedule (
    schedule_id INT(11) NOT NULL AUTO_INCREMENT,
    event_id INT(11) NOT NULL,
    learning_center_id INT(11) NOT NULL,
    start_date DATETIME NOT NULL,
    end_date DATETIME NOT NULL,
    duration INT(11) NOT NULL,
    max_tickets INT(11) NOT NULL,
    ticket_price DECIMAL(10, 2) NOT NULL, 
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (schedule_id),
    FOREIGN KEY (event_id) REFERENCES event(event_id) ON DELETE CASCADE,
    FOREIGN KEY (learning_center_id) REFERENCES learning_center(learning_center_id) ON DELETE CASCADE
);

CREATE TABLE event_materials (
    materials_id INT(11) NOT NULL AUTO_INCREMENT,
    event_id INT(11) NOT NULL,
    description TEXT,
    file_path VARCHAR(255),
    link VARCHAR(255),
    file_type VARCHAR(50),  -- Optional: To specify file type (PDF, PPT, etc.)
    uploade_dat DATETIME DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (materials_id),
    FOREIGN KEY (event_id) REFERENCES event(event_id) ON DELETE CASCADE
);

CREATE TABLE creator_event (
    creator_event_id INT(11) NOT NULL AUTO_INCREMENT,
    event_id INT(11) NOT NULL,
    user_id INT(11) NOT NULL,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (creator_event_id),
    FOREIGN KEY (user_id) REFERENCES user(user_id) ON DELETE CASCADE,
    FOREIGN KEY (event_id) REFERENCES event(event_id) ON DELETE CASCADE
);

CREATE TABLE learning_center (
    learning_center_id INT(11) NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    address VARCHAR(255) NOT NULL,
    capacity INT(11) NOT NULL,
    phone VARCHAR(20),
    webpage VARCHAR(255),
    email VARCHAR(100),
    established_date DATE,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (learning_center_id)
);

INSERT INTO learning_center (name, address, capacity, phone, webpage, email, established_date) 
VALUES
    ('Tech Academy', '123 Main St, Springfield', 150, '+1 555-1234', 'https://techacademy.com', 'contact@techacademy.com', '2010-05-20'),
    ('Code Academy', '456 Elm St, Rivertown', 200, '+1 555-5678', 'https://codeacademy.com', 'info@codeacademy.com', '2015-09-12'),
    ('Dev School', '789 Oak St, Greenfield', 100, '+1 555-9101', 'https://devschool.com', 'support@devschool.com', '2012-03-15'),
    ('Learn Hub', '101 Pine St, Lakeview', 120, '+1 555-1122', 'https://learnhub.com', 'hello@learnhub.com', '2018-01-10'),
    ('Innovate Learning', '202 Maple St, Hilltop', 180, '+1 555-3344', 'https://innovatelearning.com', 'contact@innovatelearning.com', '2016-07-08');

INSERT INTO learning_center (name, address, capacity, phone, webpage, email, established_date) 
VALUES
    ('FutureTech Academy', '56 Innovation Blvd, Silicon Valley, CA', 250, '+1 408-555-0012', 'https://futuretechacademy.com', 'info@futuretechacademy.com', '2012-09-15'),
    ('The Coding Grove', '324 Greenway Ave, Forest Hills, NY', 150, '+1 718-555-0114', 'https://codinggrove.com', 'contact@codinggrove.com', '2014-05-22'),
    ('Global Learning Hub', '9000 World Plaza, Los Angeles, CA', 500, '+1 323-555-0978', 'https://globalhub.com', 'support@globalhub.com', '2005-11-30'),
    ('Tech Innovators Institute', '1123 Tech Rd, Boston, MA', 180, '+1 617-555-1235', 'https://techinnovators.com', 'info@techinnovators.com', '2017-01-10'),
    ('Skyline University', '777 Heights St, New York, NY', 1000, '+1 212-555-7632', 'https://skylineuniversity.com', 'admissions@skylineuniversity.com', '1990-04-05'),
    ('CodeLabs Academy', '2897 Developer Way, Chicago, IL', 80, '+1 312-555-8523', 'https://codelabsacademy.com', 'hello@codelabsacademy.com', '2018-08-14'),
    ('NextGen Learning Center', '459 University Dr, Austin, TX', 300, '+1 512-555-6704', 'https://nextgenlearning.com', 'enroll@nextgenlearning.com', '2010-12-01'),
    ('Brainwave Institute', '213 Mindset Ave, Denver, CO', 120, '+1 303-555-2347', 'https://brainwaveinstitute.com', 'info@brainwaveinstitute.com', '2016-07-22'),
    ('Creative Minds Academy', '5801 Art District St, Miami, FL', 250, '+1 305-555-4321', 'https://creativemindsacademy.com', 'contact@creativemindsacademy.com', '2019-03-18'),
    ('TechTrail Academy', '1023 Innovation Street, Seattle, WA', 200, '+1 206-555-3456', 'https://techtrailacademy.com', 'help@techtrailacademy.com', '2015-06-27');


CREATE TABLE user (
    user_id INT(11) NOT NULL AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    password_hash VARCHAR(255) NOT NULL,
    phone_number VARCHAR(20),
    company VARCHAR(100),
    job_title VARCHAR(50),
    role_id INT(11) NOT NULL,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    is_active BOOLEAN DEFAULT TRUE,
    last_login DATETIME DEFAULT NULL,
    profile_picture VARCHAR(255),
    address VARCHAR(255),
    gender VARCHAR(10),
    date_of_birth DATE,
    PRIMARY KEY (user_id),
    FOREIGN KEY (role_id) REFERENCES role(role_id) ON DELETE CASCADE
);

CREATE TABLE event (
    event_id INT(11) NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    is_private BOOLEAN DEFAULT FALSE,
    created_by INT(11) NOT NULL,
    description TEXT,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (event_id),
    FOREIGN KEY (created_by) REFERENCES User(user_id) ON DELETE CASCADE
);
SET SQL_SAFE_UPDATES = 0;
DELETE FROM event;

INSERT INTO event (name, is_private, created_by, description) 
VALUES
    ('Tech Conference 2024', FALSE, 1, 'A large-scale conference bringing together tech professionals, industry leaders, and startups to discuss the latest trends in technology and innovation.'),
    ('AI Workshop: Exploring the Future', TRUE, 2, 'An exclusive hands-on workshop for data scientists and AI enthusiasts to explore cutting-edge AI techniques and frameworks. Limited to 30 participants.'),
    ('Codeathon 2024', FALSE, 3, 'A competitive coding event where developers of all skill levels come together to build innovative solutions within 48 hours. Open to public participation.'),
    ('Creative Design Summit', TRUE, 4, 'An exclusive event for top designers in the industry, offering workshops on the latest design trends, tools, and techniques.'),
    ('Blockchain Expo', FALSE, 5, 'A global event focused on blockchain technologies, cryptocurrencies, and decentralized applications. Keynote speakers from major blockchain companies.'),
    ('Data Science Bootcamp', TRUE, 6, 'A 6-week intensive bootcamp designed to train aspiring data scientists. Hands-on projects and mentorship from industry professionals.'),
    ('Startup Pitch Night', FALSE, 7, 'An open event for startups to pitch their innovative ideas to a panel of investors. The best pitch wins funding for their next stage of growth.'),
    ('Cybersecurity Symposium', TRUE, 8, 'A private event for cybersecurity professionals to discuss the latest threats, vulnerabilities, and defense strategies in the ever-evolving world of cyber threats.'),
    ('Digital Marketing Conference', FALSE, 9, 'A comprehensive conference focusing on the latest trends in digital marketing, including social media strategies, SEO, and influencer marketing.'),
    ('Startup Ecosystem Meet-up', FALSE, 10, 'A casual networking event for entrepreneurs, investors, and innovators to exchange ideas and build connections within the startup ecosystem.');


CREATE TABLE role (
    role_id INT(11) NOT NULL AUTO_INCREMENT,
    role_name ENUM('ROLE_USER', 'ROLE_ADMIN', 'ROLE_CREATOR') NOT NULL,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    description VARCHAR(255),
    PRIMARY KEY (role_id)
);

CREATE TABLE learning_center (
    learning_center_id INT(11) NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    address VARCHAR(255) NOT NULL,
    capacity INT(11) NOT NULL,
    phone VARCHAR(20),
    webpage VARCHAR(255),
    email VARCHAR(100),
    established_date DATE,
    createdAt DATETIME DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (learning_center_id)
);

INSERT INTO user (
    name, email, password_hash, phone_number, company, job_title, role_id, created_at, is_active, last_login, profile_picture, address, gender, date_of_birth
)
VALUES
('Alice Johnson', 'alice.johnson@example.com', 'test', '123-456-7890', 'TechCorp', 'Software Engineer', 1, '2024-01-01 09:00:00', TRUE, '2024-12-26 14:00:00', 'bob.jpg', '123 Elm Street, Springfield, USA', 'Female', '1990-05-15'),
('Bob Smith', 'bob.smith@example.com', 'test', '987-654-3210', 'HealthCare Inc.', 'Data Analyst', 2, '2024-02-15 10:30:00', TRUE, '2024-12-20 11:45:00', 'bob.jpg', '456 Oak Street, Shelbyville, USA', 'Male', '1985-08-20');

INSERT INTO user (
    name, email, password_hash, phone_number, company, job_title, role_id, created_at, is_active, last_login, profile_picture, address, gender, date_of_birth
)
VALUES
('name', 'e@e', '$2a$10$fPutmr9mQ3oVXde6T35oPee9ZLvn/JXZ4ZMttEdYO93VMN6n0H172', '123-456-7890', 'TechCorp', 'Software Engineer', 3, '2024-01-01 09:00:00', TRUE, '2024-12-26 14:00:00', 'bob.jpg', '123 Elm Street, Springfield, USA', 'Female', '1990-05-15');

select * from user;
select * from event;
select * from role;
select * from learning_center;

UPDATE user
SET role_id = 3
WHERE user_id = 24;

DROP TABLE role;

INSERT INTO event (name, is_private, description, created_by, created_at)
VALUES
('Conference', 0, 'Annual tech conference with industry leaders', 4, '2024-11-25 08:00:00'),
('Wedding Reception', 1, 'Private reception for family and friends', 5, '2024-12-10 17:00:00'),
('Product Launch', 0, 'Event for unveiling new product to the public', 6, '2024-12-05 14:00:00'),
('Christmas Party', 1, 'Holiday gathering with company employees', 7, '2024-12-24 19:00:00'),
('Workshop', 0, 'Educational workshop on data science tools', 8, '2024-11-30 10:00:00');



INSERT INTO role (role_id, role_name, created_at, description)
VALUES
(1, 'ROLE_USER', '2024-11-25 08:00:00', 'Has full access to the system, can manage users, roles, and all data.'),
(2, 'ROLE_CREATOR', '2024-11-25 08:00:00', 'Can view public and create new events. Has access to events he created'),
(3, 'ROLE_ADMIN', '2024-11-25 08:00:00', 'Has access to standard features, can interact with events and data based on specific permissions.');

select * from role;