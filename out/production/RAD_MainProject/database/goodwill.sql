-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: localhost:80
-- Generation Time: Jul 09, 2021 at 09:28 PM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 7.3.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `goodwill`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `userName` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `userName`, `password`) VALUES
(1, 'afraj', '123'),
(2, 'amas', '123');

-- --------------------------------------------------------

--
-- Table structure for table `sem_reg`
--

CREATE TABLE `sem_reg` (
  `id` int(11) NOT NULL,
  `userName` varchar(45) NOT NULL,
  `iName` varchar(45) NOT NULL,
  `degree` varchar(45) NOT NULL,
  `faculty` varchar(45) NOT NULL,
  `year` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `sem_reg`
--

INSERT INTO `sem_reg` (`id`, `userName`, `iName`, `degree`, `faculty`, `year`) VALUES
(1, 'afraj', 'M.A.M Afraj', 'Computer Science', 'Faculty of Computer Science', '2nd Year'),
(2, 'afraj', '', 'Computer Science', 'Faculty of Computer Science', '2nd Year'),
(3, 'amas', 'M.J.A Amas', 'Computer Science', 'Faculty of Computer Science', '2nd Year'),
(4, 'siyaj', 'M.S.S Ahamed', 'Management', 'Faculty of Computer Science', '1st Year');

-- --------------------------------------------------------

--
-- Table structure for table `students`
--

CREATE TABLE `students` (
  `id` int(11) NOT NULL,
  `userName` varchar(45) NOT NULL,
  `password` varchar(200) NOT NULL,
  `email` varchar(200) NOT NULL,
  `fname` varchar(45) DEFAULT NULL,
  `nameInitial` varchar(45) DEFAULT NULL,
  `stream` varchar(45) DEFAULT NULL,
  `degree` varchar(45) DEFAULT NULL,
  `c_no` varchar(45) DEFAULT NULL,
  `zscore` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `students`
--

INSERT INTO `students` (`id`, `userName`, `password`, `email`, `fname`, `nameInitial`, `stream`, `degree`, `c_no`, `zscore`, `city`) VALUES
(18, 'amas', '123', 'Amas@gmail.com', 'Ahamed Amas', 'M.J.A Amas', 'Commerce', 'BIIT', '123232', '1.2', 'Ottamavadi'),
(23, 'afraj', '123', 'aj@gmail.com', 'Mohamed Afraj', 'M.A.M Afraj', 'Commerce', 'Computer Science', '12345644', '1.25', 'Warakapola'),
(24, 'siyaj', '123', 'sj@gmail.com', 'Siyaj Ahamed', 'M.S.SAhamed', 'Commerce', 'Management', '1234332', '1.7', 'Kuliyapitiya');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `sem_reg`
--
ALTER TABLE `sem_reg`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `students`
--
ALTER TABLE `students`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `sem_reg`
--
ALTER TABLE `sem_reg`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `students`
--
ALTER TABLE `students`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
