-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jan 08, 2025 at 11:40 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `mvcproject_1`
--

-- --------------------------------------------------------

--
-- Table structure for table `creator_event`
--

CREATE TABLE `creator_event` (
  `creator_event_id` int(11) NOT NULL,
  `event_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `created_at` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `event`
--

CREATE TABLE `event` (
  `event_id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `is_private` tinyint(1) DEFAULT 0,
  `created_by` int(11) NOT NULL,
  `description` text DEFAULT NULL,
  `created_at` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `event`
--

INSERT INTO `event` (`event_id`, `name`, `is_private`, `created_by`, `description`, `created_at`) VALUES
(51, 'Tech Conference 2024', 0, 1, 'A large-scale conference bringing together tech professionals, industry leaders, and startups to discuss the latest trends in technology and innovation.', '2024-12-30 15:31:52'),
(52, 'AI Workshop: Exploring the Future', 1, 2, 'An exclusive hands-on workshop for data scientists and AI enthusiasts to explore cutting-edge AI techniques and frameworks. Limited to 30 participants.', '2024-12-30 15:31:52'),
(53, 'Codeathon 2024', 0, 3, 'A competitive coding event where developers of all skill levels come together to build innovative solutions within 48 hours. Open to public participation.', '2024-12-30 15:31:52'),
(54, 'Creative Design Summit', 1, 4, 'An exclusive event for top designers in the industry, offering workshops on the latest design trends, tools, and techniques.', '2024-12-30 15:31:52'),
(55, 'Blockchain Expo', 0, 5, 'A global event focused on blockchain technologies, cryptocurrencies, and decentralized applications. Keynote speakers from major blockchain companies.', '2024-12-30 15:31:52'),
(56, 'Data Science Bootcamp', 1, 6, 'A 6-week intensive bootcamp designed to train aspiring data scientists. Hands-on projects and mentorship from industry professionals.', '2024-12-30 15:31:52'),
(57, 'Startup Pitch Night', 0, 7, 'An open event for startups to pitch their innovative ideas to a panel of investors. The best pitch wins funding for their next stage of growth.', '2024-12-30 15:31:52'),
(58, 'Cybersecurity Symposium', 1, 8, 'A private event for cybersecurity professionals to discuss the latest threats, vulnerabilities, and defense strategies in the ever-evolving world of cyber threats.', '2024-12-30 15:31:52'),
(59, 'Digital Marketing Conference', 0, 9, 'A comprehensive conference focusing on the latest trends in digital marketing, including social media strategies, SEO, and influencer marketing.', '2024-12-30 15:31:52'),
(60, 'Startup Ecosystem Meet-up', 0, 10, 'A casual networking event for entrepreneurs, investors, and innovators to exchange ideas and build connections within the startup ecosystem.', '2024-12-30 15:31:52');

-- --------------------------------------------------------

--
-- Table structure for table `event_feedback`
--

CREATE TABLE `event_feedback` (
  `feedback_id` int(11) NOT NULL,
  `event_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `feedback` varchar(255) NOT NULL,
  `rating` int(1) DEFAULT NULL CHECK (`rating` between 1 and 5),
  `is_anonymous` tinyint(1) DEFAULT 0,
  `created_at` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `event_materials`
--

CREATE TABLE `event_materials` (
  `materials_id` int(11) NOT NULL,
  `event_id` int(11) NOT NULL,
  `description` text DEFAULT NULL,
  `file_path` varchar(255) DEFAULT NULL,
  `link` varchar(255) DEFAULT NULL,
  `file_type` varchar(50) DEFAULT NULL,
  `uploade_dat` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `event_schedule`
--

CREATE TABLE `event_schedule` (
  `schedule_id` int(11) NOT NULL,
  `event_id` int(11) NOT NULL,
  `learning_center_id` int(11) NOT NULL,
  `start_date` datetime NOT NULL,
  `end_date` datetime NOT NULL,
  `duration` int(11) NOT NULL,
  `max_tickets` int(11) NOT NULL,
  `ticket_price` decimal(10,2) NOT NULL,
  `created_at` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `event_subscription`
--

CREATE TABLE `event_subscription` (
  `subscription_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `event_id` int(11) NOT NULL,
  `started_at` datetime DEFAULT current_timestamp(),
  `active` tinyint(1) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `event_tag`
--

CREATE TABLE `event_tag` (
  `tag_id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `event_tag_mapping`
--

CREATE TABLE `event_tag_mapping` (
  `tag_mapping_id` int(11) NOT NULL,
  `event_id` int(11) NOT NULL,
  `tag_id` int(11) NOT NULL,
  `mapped_at` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `learning_center`
--

CREATE TABLE `learning_center` (
  `learning_center_id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `address` varchar(255) NOT NULL,
  `capacity` int(11) NOT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `webpage` varchar(255) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `established_date` date DEFAULT NULL,
  `created_at` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `learning_center`
--

INSERT INTO `learning_center` (`learning_center_id`, `name`, `address`, `capacity`, `phone`, `webpage`, `email`, `established_date`, `created_at`) VALUES
(1, 'Tech Academy', '123 Main St, Springfield', 150, '+1 555-1234', 'https://techacademy.com', 'contact@techacademy.com', '2010-05-20', '2024-12-30 13:47:36'),
(2, 'Code Academy', '456 Elm St, Rivertown', 200, '+1 555-5678', 'https://codeacademy.com', 'info@codeacademy.com', '2015-09-12', '2024-12-30 13:47:36'),
(3, 'Dev School', '789 Oak St, Greenfield', 100, '+1 555-9101', 'https://devschool.com', 'support@devschool.com', '2012-03-15', '2024-12-30 13:47:36'),
(4, 'Learn Hub', '101 Pine St, Lakeview', 120, '+1 555-1122', 'https://learnhub.com', 'hello@learnhub.com', '2018-01-10', '2024-12-30 13:47:36'),
(5, 'Innovate Learning', '202 Maple St, Hilltop', 180, '+1 555-3344', 'https://innovatelearning.com', 'contact@innovatelearning.com', '2016-07-08', '2024-12-30 13:47:36'),
(6, 'FutureTech Academy', '56 Innovation Blvd, Silicon Valley, CA', 250, '+1 408-555-0012', 'https://futuretechacademy.com', 'info@futuretechacademy.com', '2012-09-15', '2024-12-30 13:51:22'),
(7, 'The Coding Grove', '324 Greenway Ave, Forest Hills, NY', 150, '+1 718-555-0114', 'https://codinggrove.com', 'contact@codinggrove.com', '2014-05-22', '2024-12-30 13:51:22'),
(8, 'Global Learning Hub', '9000 World Plaza, Los Angeles, CA', 500, '+1 323-555-0978', 'https://globalhub.com', 'support@globalhub.com', '2005-11-30', '2024-12-30 13:51:22'),
(9, 'Tech Innovators Institute', '1123 Tech Rd, Boston, MA', 180, '+1 617-555-1235', 'https://techinnovators.com', 'info@techinnovators.com', '2017-01-10', '2024-12-30 13:51:22'),
(10, 'Skyline University', '777 Heights St, New York, NY', 1000, '+1 212-555-7632', 'https://skylineuniversity.com', 'admissions@skylineuniversity.com', '1990-04-05', '2024-12-30 13:51:22'),
(11, 'CodeLabs Academy', '2897 Developer Way, Chicago, IL', 80, '+1 312-555-8523', 'https://codelabsacademy.com', 'hello@codelabsacademy.com', '2018-08-14', '2024-12-30 13:51:22'),
(12, 'NextGen Learning Center', '459 University Dr, Austin, TX', 300, '+1 512-555-6704', 'https://nextgenlearning.com', 'enroll@nextgenlearning.com', '2010-12-01', '2024-12-30 13:51:22'),
(13, 'Brainwave Institute', '213 Mindset Ave, Denver, CO', 120, '+1 303-555-2347', 'https://brainwaveinstitute.com', 'info@brainwaveinstitute.com', '2016-07-22', '2024-12-30 13:51:22'),
(14, 'Creative Minds Academy', '5801 Art District St, Miami, FL', 250, '+1 305-555-4321', 'https://creativemindsacademy.com', 'contact@creativemindsacademy.com', '2019-03-18', '2024-12-30 13:51:22'),
(15, 'TechTrail Academy', '1023 Innovation Street, Seattle, WA', 200, '+1 206-555-3456', 'https://techtrailacademy.com', 'help@techtrailacademy.com', '2015-06-27', '2024-12-30 13:51:22');

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `role_id` int(11) NOT NULL,
  `role_name` enum('ROLE_USER','ROLE_ADMIN','ROLE_CREATOR') NOT NULL,
  `created_at` datetime DEFAULT current_timestamp(),
  `description` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`role_id`, `role_name`, `created_at`, `description`) VALUES
(1, 'ROLE_USER', '2024-11-25 08:00:00', 'Has full access to the system, can manage users, roles, and all data.'),
(2, 'ROLE_CREATOR', '2024-11-25 08:00:00', 'Can view public and create new events. Has access to events he created'),
(3, 'ROLE_ADMIN', '2024-11-25 08:00:00', 'Has access to standard features, can interact with events and data based on specific permissions.');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password_hash` varchar(255) NOT NULL,
  `phone_number` varchar(20) DEFAULT NULL,
  `company` varchar(100) DEFAULT NULL,
  `job_title` varchar(50) DEFAULT NULL,
  `role_id` int(11) NOT NULL,
  `created_at` datetime DEFAULT current_timestamp(),
  `is_active` tinyint(1) DEFAULT 1,
  `last_login` datetime DEFAULT NULL,
  `profile_picture` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `name`, `email`, `password_hash`, `phone_number`, `company`, `job_title`, `role_id`, `created_at`, `is_active`, `last_login`, `profile_picture`, `address`, `gender`, `date_of_birth`) VALUES
(1, 'Alice Johnson', 'alice.johnson@example.com', 'test', '123-456-7890', 'TechCorp', 'Software Engineer', 1, '2024-01-01 09:00:00', 1, '2024-12-26 00:00:00', 'bob.jpg', '123 Elm Street, Springfield, USA', 'Female', '1990-05-15'),
(2, 'Bob Smith', 'bob.smith@example.com', 'test', '987-654-3210', 'HealthCare Inc.', 'Data Analyst', 2, '2024-02-15 10:30:00', 1, '2024-12-20 11:45:00', 'bob.jpg', '456 Oak Street, Shelbyville, USA', 'Male', '1985-08-20'),
(3, 'tt', 'tt@a2works.biz', '$2a$10$TDIzZ576xj/Uv6JUvkV5euSEEuwiMrx1qG7XCfuCmet8AixgJwDFy', NULL, NULL, NULL, 1, '2024-12-28 00:00:00', 1, '2024-12-28 00:00:00', NULL, NULL, NULL, NULL),
(4, 'tttt', 'tttt@a2works.biz', '$2a$10$XMuZi.7s42hOyIMwV6UQYuWpqaPdOvb3XH.u6L7yhJvvuTyebkBLm', NULL, NULL, NULL, 1, '2024-12-28 00:00:00', 1, '2024-12-28 00:00:00', NULL, NULL, NULL, NULL),
(5, 'te', 'rt@a2works.biz', '$2a$10$IrdXb0AYcpS9H5LHX3kTaeLWj1E9HOyhViZZ8kVwvyKsTuOFcYKpa', NULL, NULL, NULL, 1, '2024-12-28 00:00:00', 1, '2024-12-28 00:00:00', NULL, NULL, NULL, NULL),
(6, '2222', 'test01@a2works.biz', '$2a$10$pXuuS6wfTF2rodpMtXtnW.E2Z/lIiZAhzmTCMCSvqTAoKImVkBE6.', NULL, NULL, NULL, 1, '2024-12-28 00:00:00', 1, '2024-12-28 00:00:00', NULL, NULL, NULL, NULL),
(7, 'Andrei Trusau', '2323@a2works.biz', '$2a$10$Z4dKm6KUqPCz9KKEX.ib5.sI4uQZBpwSJQFf/7y6OJM1DDz2xJV6C', NULL, NULL, NULL, 1, '2024-12-28 00:00:00', 1, '2024-12-28 00:00:00', NULL, NULL, NULL, NULL),
(8, '32532', '42@4', '$2a$10$EpXtND5TdKXpOV3DE2qhDeZ3LPQJwy/ncSvVpGKH4iLzi3by8jT8S', NULL, NULL, NULL, 1, '2024-12-28 00:00:00', 1, '2024-12-28 00:00:00', NULL, NULL, NULL, NULL),
(9, '5555', '5555@a2works.biz', '$2a$10$ARGk5cTg34DhS8jfP0zUNe/ScYe5Tpe8T0SeqJlpgnph7nZ2SuY0C', NULL, NULL, NULL, 1, '2024-12-28 00:00:00', 1, '2024-12-28 00:00:00', NULL, NULL, NULL, NULL),
(10, '123321', '123321@a2works.biz', '$2a$10$YJgHdHSA5M8UO6Wl9/GaXu6mKOfT9.L6u/K2iS32pnOrnYIECYxe6', NULL, NULL, NULL, 1, '2024-12-28 00:00:00', 1, '2024-12-28 00:00:00', NULL, NULL, NULL, NULL),
(11, '5555', '55555@mail.ru', '$2a$10$ABY4VMjrhVix0BfoNEpTzua.N04tOVTQIpq08S0mgvt0bGcH1CP7.', NULL, NULL, NULL, 1, '2024-12-28 00:00:00', 1, '2024-12-28 00:00:00', NULL, NULL, NULL, NULL),
(12, 'Andrei Trusau', 's222l@gmail.com', '$2a$10$YFcQphXiHYDUAVoddGJz/esFlF9z9qdJAuPUiDp7TrP02aiRvfEqu', NULL, NULL, NULL, 1, '2024-12-28 00:00:00', 1, '2024-12-28 00:00:00', NULL, NULL, NULL, NULL),
(13, 'test', 'test@testtt', '111111', '+4219508809', 'company', 'CEO', 1, '2024-12-28 00:00:00', 1, '2024-12-28 00:00:00', NULL, 'Srojarensa 10G', 'Female', NULL),
(14, 'aaa', 'test1@test1', '$2a$10$YOWYt3uxL5mGPgTGWdWzUO/k3hOe8qgtx9UH6uCyvxfINb/UHsm5S', NULL, NULL, NULL, 1, '2024-12-28 00:00:00', 1, '2024-12-28 00:00:00', NULL, NULL, NULL, NULL),
(15, 'maminka', 'mam@m', '$2a$10$5XgUqsiGTH9p5AaR2yCQzOaLm.8iWIlTrdPpJWSedTcVMsf3pv59u', NULL, NULL, NULL, 1, '2024-12-28 00:00:00', 1, '2024-12-28 00:00:00', NULL, NULL, NULL, NULL),
(16, 'Andrei Trusau', 'q@qqq', '$2a$10$/z20zkLu2t/Jq/7bZ2RaXOhtHu///fVfGahT/Co5/TXfnlLlXvfJu', '3253523', 'No company', 'lalka', 1, '2024-12-28 00:00:00', 1, '2024-12-28 00:00:00', NULL, 'bezdomnyj', 'Male', NULL),
(17, 'Andrei Trusau', 'qwqw@qwe', '$2a$10$1xVBL94YYPbZnjX2qECmZefG5LjeWNz2dlBQdoDPebN4Gdy5T3IDm', NULL, NULL, NULL, 1, '2024-12-28 00:00:00', 1, '2024-12-28 00:00:00', NULL, NULL, NULL, NULL),
(18, 'name', 'w@w', '$2a$10$iR8reldqQvb/XtIPFf5JU.pak8pu/esqHxYTF7OgtgMXhMXlGDB6m', '123-456-7890', 'TechCorp', 'Software Engineer', 3, '2024-01-01 09:00:00', 1, '2024-12-26 14:00:00', 'bob.jpg', '123 Elm Street, Springfield, USA', 'Female', '1990-05-15'),
(19, 'andy', 'e@eee', '$2a$10$fPutmr9mQ3oVXde6T35oPee9ZLvn/JXZ4ZMttEdYO93VMN6n0H172', NULL, NULL, NULL, 1, '2024-12-30 00:00:00', 1, '2024-12-30 00:00:00', NULL, NULL, NULL, NULL),
(20, 'admin_profile', 'e@e', '$2a$10$fPutmr9mQ3oVXde6T35oPee9ZLvn/JXZ4ZMttEdYO93VMN6n0H172', '123-456-7890', 'TechCorp', 'Software Engineer', 3, '2024-01-01 09:00:00', 1, '2024-12-26 14:00:00', 'bob.jpg', '123 Elm Street, Springfield, USA', 'Female', NULL),
(21, 'Andrei Trusau', 'testtest1@a2works.biz', '$2a$10$P9Uxm45itVTcILuRcW9jauPG77PzjJTsrOrO92ka1vbSyZ3qdUjyC', NULL, NULL, NULL, 1, '2024-12-30 00:00:00', 1, '2024-12-30 00:00:00', NULL, NULL, NULL, NULL),
(22, 'Andrei Trusau', 'test01t@a2works.biz', '$2a$10$cSkyI2JNiVjmpsvrCA7eGOJB6Z99MljoMTDX0M74jB4c4FNK7dc.S', NULL, NULL, NULL, 1, '2024-12-30 00:00:00', 1, '2024-12-30 00:00:00', NULL, NULL, NULL, NULL),
(23, 'Andrei Trusau', 'test01tT@a2works.biz', '$2a$10$DCipZ2Rwp7QAm7BwuU/5wu6eLNZPz5s5/F8RnhiJZ1Eo/4B8Ptvtu', NULL, NULL, NULL, 1, '2024-12-30 00:00:00', 1, '2024-12-30 00:00:00', NULL, NULL, NULL, NULL),
(24, 'Admin', 'admin@admin.com', '$2a$10$yz/HGxd//f0uq123K17zRuXytImYFe5M0d8Qf23DhHfRQrLsHyM9y', '', '', '', 3, '2024-12-30 00:00:00', 1, '2024-12-30 00:00:00', NULL, '', 'Male', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `user_history`
--

CREATE TABLE `user_history` (
  `history_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `event_id` int(11) NOT NULL,
  `created_at` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `creator_event`
--
ALTER TABLE `creator_event`
  ADD PRIMARY KEY (`creator_event_id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `event_id` (`event_id`);

--
-- Indexes for table `event`
--
ALTER TABLE `event`
  ADD PRIMARY KEY (`event_id`),
  ADD KEY `created_by` (`created_by`);

--
-- Indexes for table `event_feedback`
--
ALTER TABLE `event_feedback`
  ADD PRIMARY KEY (`feedback_id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `event_id` (`event_id`);

--
-- Indexes for table `event_materials`
--
ALTER TABLE `event_materials`
  ADD PRIMARY KEY (`materials_id`),
  ADD KEY `event_id` (`event_id`);

--
-- Indexes for table `event_schedule`
--
ALTER TABLE `event_schedule`
  ADD PRIMARY KEY (`schedule_id`),
  ADD KEY `event_id` (`event_id`),
  ADD KEY `learning_center_id` (`learning_center_id`);

--
-- Indexes for table `event_subscription`
--
ALTER TABLE `event_subscription`
  ADD PRIMARY KEY (`subscription_id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `event_id` (`event_id`);

--
-- Indexes for table `event_tag`
--
ALTER TABLE `event_tag`
  ADD PRIMARY KEY (`tag_id`);

--
-- Indexes for table `event_tag_mapping`
--
ALTER TABLE `event_tag_mapping`
  ADD PRIMARY KEY (`tag_mapping_id`),
  ADD KEY `event_id` (`event_id`),
  ADD KEY `tag_id` (`tag_id`);

--
-- Indexes for table `learning_center`
--
ALTER TABLE `learning_center`
  ADD PRIMARY KEY (`learning_center_id`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`role_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `email` (`email`),
  ADD KEY `role_id` (`role_id`);

--
-- Indexes for table `user_history`
--
ALTER TABLE `user_history`
  ADD PRIMARY KEY (`history_id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `event_id` (`event_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `creator_event`
--
ALTER TABLE `creator_event`
  MODIFY `creator_event_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `event`
--
ALTER TABLE `event`
  MODIFY `event_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=61;

--
-- AUTO_INCREMENT for table `event_feedback`
--
ALTER TABLE `event_feedback`
  MODIFY `feedback_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `event_materials`
--
ALTER TABLE `event_materials`
  MODIFY `materials_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `event_schedule`
--
ALTER TABLE `event_schedule`
  MODIFY `schedule_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `event_subscription`
--
ALTER TABLE `event_subscription`
  MODIFY `subscription_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `event_tag`
--
ALTER TABLE `event_tag`
  MODIFY `tag_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `event_tag_mapping`
--
ALTER TABLE `event_tag_mapping`
  MODIFY `tag_mapping_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `learning_center`
--
ALTER TABLE `learning_center`
  MODIFY `learning_center_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `role_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT for table `user_history`
--
ALTER TABLE `user_history`
  MODIFY `history_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `creator_event`
--
ALTER TABLE `creator_event`
  ADD CONSTRAINT `creator_event_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE,
  ADD CONSTRAINT `creator_event_ibfk_2` FOREIGN KEY (`event_id`) REFERENCES `event` (`event_id`) ON DELETE CASCADE;

--
-- Constraints for table `event`
--
ALTER TABLE `event`
  ADD CONSTRAINT `event_ibfk_1` FOREIGN KEY (`created_by`) REFERENCES `User` (`user_id`) ON DELETE CASCADE;

--
-- Constraints for table `event_feedback`
--
ALTER TABLE `event_feedback`
  ADD CONSTRAINT `event_feedback_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE,
  ADD CONSTRAINT `event_feedback_ibfk_2` FOREIGN KEY (`event_id`) REFERENCES `event` (`event_id`) ON DELETE CASCADE;

--
-- Constraints for table `event_materials`
--
ALTER TABLE `event_materials`
  ADD CONSTRAINT `event_materials_ibfk_1` FOREIGN KEY (`event_id`) REFERENCES `event` (`event_id`) ON DELETE CASCADE;

--
-- Constraints for table `event_schedule`
--
ALTER TABLE `event_schedule`
  ADD CONSTRAINT `event_schedule_ibfk_1` FOREIGN KEY (`event_id`) REFERENCES `event` (`event_id`) ON DELETE CASCADE,
  ADD CONSTRAINT `event_schedule_ibfk_2` FOREIGN KEY (`learning_center_id`) REFERENCES `learning_center` (`learning_center_id`) ON DELETE CASCADE;

--
-- Constraints for table `event_subscription`
--
ALTER TABLE `event_subscription`
  ADD CONSTRAINT `event_subscription_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE,
  ADD CONSTRAINT `event_subscription_ibfk_2` FOREIGN KEY (`event_id`) REFERENCES `event` (`event_id`) ON DELETE CASCADE;

--
-- Constraints for table `event_tag_mapping`
--
ALTER TABLE `event_tag_mapping`
  ADD CONSTRAINT `event_tag_mapping_ibfk_1` FOREIGN KEY (`event_id`) REFERENCES `event` (`event_id`) ON DELETE CASCADE,
  ADD CONSTRAINT `event_tag_mapping_ibfk_2` FOREIGN KEY (`tag_id`) REFERENCES `event_tag` (`tag_id`) ON DELETE CASCADE;

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `user_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`) ON DELETE CASCADE;

--
-- Constraints for table `user_history`
--
ALTER TABLE `user_history`
  ADD CONSTRAINT `user_history_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE,
  ADD CONSTRAINT `user_history_ibfk_2` FOREIGN KEY (`event_id`) REFERENCES `event` (`event_id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
