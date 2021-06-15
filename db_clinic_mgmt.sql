-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 15, 2021 at 05:14 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_clinic_mgmt`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_admin`
--

CREATE TABLE `tbl_admin` (
  `AccountID` varchar(45) DEFAULT NULL,
  `Name` varchar(45) DEFAULT NULL,
  `Username` varchar(45) DEFAULT NULL,
  `Password` varchar(45) DEFAULT NULL,
  `Address` varchar(45) DEFAULT NULL,
  `ContactNo` varchar(45) DEFAULT NULL,
  `Type` varchar(45) DEFAULT NULL,
  `Status` varchar(45) DEFAULT NULL,
  `Q1` varchar(200) DEFAULT NULL,
  `A1` varchar(200) DEFAULT NULL,
  `Q2` varchar(200) DEFAULT NULL,
  `A2` varchar(200) DEFAULT NULL,
  `Q3` varchar(200) DEFAULT NULL,
  `A3` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_admin`
--

INSERT INTO `tbl_admin` (`AccountID`, `Name`, `Username`, `Password`, `Address`, `ContactNo`, `Type`, `Status`, `Q1`, `A1`, `Q2`, `A2`, `Q3`, `A3`) VALUES
('ID0422202173425', 'administrator', 'admin', 'admin', 'gensan', '09123012022', 'Admin', 'Active', 'What is your first girlfriend\'s/boyfriend\'s name?', 'admin', 'Who is your favorite historical person?', 'admin', 'What\'s the name of the hosipital in which you were born?', 'admin'),
('ID04222021105336', 'admin1', 'admin1', 'admin1', 'Poland', '345678909876543', 'Admin', 'Active', 'What is your favorite movie?', 'esd', 'What\'s the name of a college you applied to but didn\'t attend?', 'sdsd', 'What is the name of your favorite childhood cuddly toy?', 'dsdsds'),
('ID05032021105257', 'Juan Tamad', 'admin01', 'admin01', 'gensan', '4567890-87658', 'Admin', 'Active', 'What is your favorite foor?', 'admin01', 'What is your childhood nickname?', 'admin01', 'What\'s the nickname of your oldest child?', 'admin01');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_appointment`
--

CREATE TABLE `tbl_appointment` (
  `ClientID` varchar(45) DEFAULT NULL,
  `Member` varchar(45) DEFAULT NULL,
  `Fullname` varchar(45) DEFAULT NULL,
  `Date` varchar(45) DEFAULT NULL,
  `Time` varchar(45) DEFAULT NULL,
  `Message` varchar(200) DEFAULT NULL,
  `Status` varchar(45) DEFAULT NULL,
  `Contact` varchar(45) DEFAULT NULL,
  `Datereserved` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_appointment`
--

INSERT INTO `tbl_appointment` (`ClientID`, `Member`, `Fullname`, `Date`, `Time`, `Message`, `Status`, `Contact`, `Datereserved`) VALUES
('EID0606202193812', 'Member', 'Last Last Last', 'Jun-14-2021', '10:00 AM', 'Dear client\n\nYour schedule has been set on Jun-14-2021 and time 10:00 AM\nPlease come early!\n\nThank you\n\nSystem Generated do not reply\nDole clinic', 'Scheduled', '09992221111', 'Jun-14-2021'),
('EID0614202184331', 'Non-Member', 'ajasd; ajasd; ajasd;', 'Jun-13-2021', '8:00 AM', 'Dear client\n\nYour schedule has been set on Jun-13-2021 and time 8:00 AM\nPlease come early!\n\nThank you\n\nSystem Generated do not reply\nDole clinic', 'Scheduled', '1241531', 'Jun-14-2021'),
('EID0614202190212', 'Non-Member', 'juan juan juan', 'Jun-13-2021', '8:00 AM', 'Dear client\n\nYour schedule has been set on Jun-13-2021 and time 8:00 AM\nPlease come early!\n\nThank you\n\nSystem Generated do not reply\nDole clinic', 'Rescheduled', '1241151', 'Jun-14-2021');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_appointment_removed`
--

CREATE TABLE `tbl_appointment_removed` (
  `ClientID` varchar(45) DEFAULT NULL,
  `Member` varchar(45) DEFAULT NULL,
  `Fullname` varchar(45) DEFAULT NULL,
  `Date` varchar(45) DEFAULT NULL,
  `Time` varchar(45) DEFAULT NULL,
  `Message` varchar(150) DEFAULT NULL,
  `Status` varchar(45) DEFAULT NULL,
  `Contact` varchar(45) DEFAULT NULL,
  `Datereserved` varchar(45) DEFAULT NULL,
  `ActStat` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_appointment_removed`
--

INSERT INTO `tbl_appointment_removed` (`ClientID`, `Member`, `Fullname`, `Date`, `Time`, `Message`, `Status`, `Contact`, `Datereserved`, `ActStat`) VALUES
('', '', '', 'Member', 'Tamad Tamad Tamad', 'Dear client\n\nYour schedule has been set on Member and time Tamad Tamad Tamad\nPlease come early!\n\nThank you\n\nSystem Generated do not reply\nDole clinic', 'Scheduled', 'Account Security', 'Tamad Tamad Tamad', NULL),
('', '', '', 'Member', 'Tamad Tamad Tamad', 'Dear client\n\nYour schedule has been set on Member and time Tamad Tamad Tamad\nPlease come early!\n\nThank you\n\nSystem Generated do not reply\nDole clinic', 'Scheduled', 'Account Security', 'Tamad Tamad Tamad', NULL),
('', '', '', 'Member', 'Tamad Tamad Tamad', 'Dear client\n\nYour schedule has been set on Member and time Tamad Tamad Tamad\nPlease come early!\n\nThank you\n\nSystem Generated do not reply\nDole clinic', 'Scheduled', 'Account Security', 'Tamad Tamad Tamad', NULL),
('EID0606202193812', 'Member', 'Last Last Last', 'May-12-2021', '07:00 AM', 'Dear client\n\nYour schedule has been set on May-12-2021 and time 07:00 AM\nPlease come early!\n\nThank you\n\nSystem Generated do not reply\nDole clinic', 'Scheduled', NULL, '10:02 PM', 'Removed'),
('EID0529202141448', 'Member', 'test test test', '05 11, 21', 'Time', 'Dear client\n\nYour schedule has been set on 05 11, 21 and time 8:00 AM\nPlease come early!\n\nThank you\n\nSystem Generated do not reply\nDole clinic', 'Rescheduled', NULL, '8:00 AM', 'Served'),
('EID0606202193313', 'Member', 'Tamad Tamad Tamad', 'May-12-2021', 'Time', 'Dear client\n\nYour schedule has been set on May-12-2021 and time 07:00 AM\nPlease come early!\n\nThank you\n\nSystem Generated do not reply\nDole clinic', 'Scheduled', NULL, '07:00 AM', 'Removed'),
('EID0606202193313', 'Member', 'Tamad Tamad Tamad', 'May-12-2021', 'Time', 'Dear client\n\nYour schedule has been set on May-12-2021 and time 07:00 AM\nPlease come early!\n\nThank you\n\nSystem Generated do not reply\nDole clinic', 'Scheduled', NULL, '07:00 AM', 'Removed'),
('EID0606202193313', 'Member', 'Tamad Tamad Tamad', '05 11, 21', '8:00 AM', 'Dear client\n\nYour schedule has been set on 05 11, 21 and time 8:00 AM\nPlease come early!\n\nThank you\n\nSystem Generated do not reply\nDole clinic', 'Scheduled', '09922484422', '8:00 AM', 'Removed'),
('EID0606202193313', 'Member', 'Tamad Tamad Tamad', '05 11, 21', 'Time', 'Dear client\n\nYour schedule has been set on 05 11, 21 and time 8:00 AM\nPlease come early!\n\nThank you\n\nSystem Generated do not reply\nDole clinic', 'Rescheduled', NULL, '8:00 AM', 'Removed'),
('EID0606202193313', 'Member', 'Tamad Tamad Tamad', 'May-12-2021', 'Time', 'Dear client\n\nYour schedule has been set on May-12-2021 and time 07:00 AM\nPlease come early!\n\nThank you\n\nSystem Generated do not reply\nDole clinic', 'Rescheduled', NULL, '07:00 AM', 'Removed'),
('EID0606202193313', 'Member', 'Tamad Tamad Tamad', 'Jun-13-2021', 'Time', 'Dear client\n\nYour schedule has been set on Jun-13-2021 and time 8:00 AM\nPlease come early!\n\nThank you\n\nSystem Generated do not reply\nDole clinic', 'Rescheduled', NULL, '8:00 AM', 'Removed'),
('EID0606202193313', 'Member', 'Tamad Tamad Tamad', 'Jun-13-2021', 'Time', 'Dear client\n\nYour schedule has been set on Jun-13-2021 and time 8:00 AM\nPlease come early!\n\nThank you\n\nSystem Generated do not reply\nDole clinic', 'Rescheduled', NULL, '8:00 AM', 'Removed'),
('EID0606202193812', 'Member', 'Last Last Last', '05 11, 21', 'Time', 'Dear client\n\nYour schedule has been set on 05 11, 21 and time 8:00 AM\nPlease come early!\n\nThank you\n\nSystem Generated do not reply\nDole clinic', 'Rescheduled', NULL, '8:00 AM', 'Removed'),
('EID0606202193812', 'Member', 'Last Last Last', '05 11, 21', 'Time', 'Dear client\n\nYour schedule has been set on 05 11, 21 and time 8:00 AM\nPlease come early!\n\nThank you\n\nSystem Generated do not reply\nDole clinic', 'Rescheduled', NULL, '8:00 AM', 'Removed'),
('EID0529202141448', 'Member', 'test test test', 'May-12-2021', 'Time', 'Dear client\n\nYour schedule has been set on May-12-2021 and time 07:00 AM\nPlease come early!\n\nThank you\n\nSystem Generated do not reply\nDole clinic', 'Rescheduled', NULL, '07:00 AM', 'Served'),
('EID0529202141448', 'Member', 'test test test', '05 11, 21', '8:00 AM', 'Dear client\n\nYour schedule has been set on 05 11, 21 and time 8:00 AM\nPlease come early!\n\nThank you\n\nSystem Generated do not reply\nDole clinic', 'Rescheduled', NULL, '8:00 AM', 'Served'),
('EID0529202141448', 'Member', 'test test test', 'May-12-2021', '07:00 AM', 'Dear client\n\nYour schedule has been set on May-12-2021 and time 07:00 AM\nPlease come early!\n\nThank you\n\nSystem Generated do not reply\nDole clinic', 'Rescheduled', NULL, '07:00 AM', 'Served'),
('EID0606202193313', 'Member', 'Tamad Tamad Tamad', 'Jun-13-2021', '8:00 AM', 'Dear client\n\nYour schedule has been set on Jun-13-2021 and time 8:00 AM\nPlease come early!\n\nThank you\n\nSystem Generated do not reply\nDole clinic', 'Rescheduled', NULL, '8:00 AM', 'Removed'),
('EID0606202193313', 'Member', 'Tamad Tamad Tamad', 'Jun-13-2021', '8:00 AM', 'Dear client\n\nYour schedule has been set on Jun-13-2021 and time 8:00 AM\nPlease come early!\n\nThank you\n\nSystem Generated do not reply\nDole clinic', 'Rescheduled', NULL, '8:00 AM', 'Removed'),
('EID0606202193812', 'Member', 'Last Last Last', 'May-12-2021', '07:00 AM', 'Dear client\n\nYour schedule has been set on May-12-2021 and time 07:00 AM\nPlease come early!\n\nThank you\n\nSystem Generated do not reply\nDole clinic', 'Rescheduled', NULL, '07:00 AM', 'Removed'),
('EID0606202193313', 'Member', 'Tamad Tamad Tamad', 'May-12-2021', '07:00 AM', 'Dear client\n\nYour schedule has been set on May-12-2021 and time 07:00 AM\nPlease come early!\n\nThank you\n\nSystem Generated do not reply\nDole clinic', 'Scheduled', NULL, '07:00 AM', 'Removed'),
('EID0606202193313', 'Member', 'Tamad Tamad Tamad', 'May-12-2021', '07:00 AM', 'Dear client\n\nYour schedule has been set on May-12-2021 and time 07:00 AM\nPlease come early!\n\nThank you\n\nSystem Generated do not reply\nDole clinic', 'Scheduled', '09922484422', 'Jun-13-2021', 'Removed'),
('EID0606202193313', 'Member', 'Tamad Tamad Tamad', 'Jun-14-2021', '10:00 AM', 'Dear client\n\nYour schedule has been set on Jun-14-2021 and time 10:00 AM\nPlease come early!\n\nThank you\n\nSystem Generated do not reply\nDole clinic', 'Scheduled', '09922484422', 'Jun-13-2021', 'Removed'),
('EID0606202193812', 'Member', 'Last Last Last', 'Jun-13-2021', '8:00 AM', 'Dear client\n\nYour schedule has been set on Jun-13-2021 and time 8:00 AM\nPlease come early!\n\nThank you\n\nSystem Generated do not reply\nDole clinic', 'Rescheduled', NULL, '8:00 AM', 'Removed'),
('EID0529202141448', 'Member', 'test test test', 'Jun-13-2021', '8:00 AM', 'Dear client\n\nYour schedule has been set on Jun-13-2021 and time 8:00 AM\nPlease come early!\n\nThank you\n\nSystem Generated do not reply\nDole clinic', 'Rescheduled', NULL, '8:00 AM', 'Served'),
('EID0606202193313', 'Member', 'Tamad Tamad Tamad', '05 11, 21', '8:00 AM', 'Dear client\n\nYour schedule has been set on 05 11, 21 and time 8:00 AM\nPlease come early!\n\nThank you\n\nSystem Generated do not reply\nDole clinic', 'Scheduled', '09922484422', 'Jun-14-2021', 'Removed'),
('EID0606202193812', 'Member', 'Last Last Last', 'Jun-13-2021', '8:00 AM', 'Dear client\n\nYour schedule has been set on Jun-13-2021 and time 8:00 AM\nPlease come early!\n\nThank you\n\nSystem Generated do not reply\nDole clinic', 'Scheduled', '09992221111', 'Jun-14-2021', 'Removed'),
('EID0606202193812', 'Member', 'Last Last Last', 'Jun-14-2021', '10:00 AM', 'Dear client\n\nYour schedule has been set on Jun-14-2021 and time 10:00 AM\nPlease come early!\n\nThank you\n\nSystem Generated do not reply\nDole clinic', 'Scheduled', '09992221111', 'Jun-14-2021', 'Removed'),
('EID0606202193313', 'Member', 'Tamad Tamad Tamad', 'May-12-2021', '07:00 AM', 'Dear client\n\nYour schedule has been set on May-12-2021 and time 07:00 AM\nPlease come early!\n\nThank you\n\nSystem Generated do not reply\nDole clinic', 'Scheduled', '09922484422', 'Jun-14-2021', 'Removed'),
('EID0606202193313', 'Member', 'Tamad Tamad Tamad', 'May-12-2021', '07:00 AM', 'Dear client\n\nYour schedule has been set on May-12-2021 and time 07:00 AM\nPlease come early!\n\nThank you\n\nSystem Generated do not reply\nDole clinic', 'Scheduled', '09922484422', 'Jun-14-2021', 'Removed'),
('EID0529202141448', 'Member', 'test test test', 'Jun-14-2021', '10:00 AM', 'Dear client\n\nYour schedule has been set on Jun-14-2021 and time 10:00 AM\nPlease come early!\n\nThank you\n\nSystem Generated do not reply\nDole clinic', 'Scheduled', '', 'Jun-14-2021', 'Served'),
('EID0614202190212', 'Non-Member', 'juan juan juan', 'Jun-14-2021', '10:00 AM', 'Dear client\n\nYour schedule has been set on Jun-14-2021 and time 10:00 AM\nPlease come early!\n\nThank you\n\nSystem Generated do not reply\nDole clinic', 'Rescheduled', '1241151', 'Jun-14-2021', 'Removed'),
('EID0606202193313', 'Member', 'M Tamad Tamad', 'Jun-15-2021', '9:00 AM', 'Dear client\n\nYour schedule has been set on Jun-15-2021 and time 9:00 AM\nPlease come early!\n\nThank you\n\nSystem Generated do not reply\nDole clinic', 'Scheduled', '09922484422', 'Jun-15-2021', 'Removed');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_availabilty`
--

CREATE TABLE `tbl_availabilty` (
  `AID` varchar(45) DEFAULT NULL,
  `Date` varchar(45) DEFAULT NULL,
  `Time` varchar(45) DEFAULT NULL,
  `Remarks` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_availabilty`
--

INSERT INTO `tbl_availabilty` (`AID`, `Date`, `Time`, `Remarks`) VALUES
('AID05032021100118', 'May-12-2021', '07:00 AM', 'No remarks'),
('AID0613202175533', 'Jun-13-2021', '8:00 AM', 'Non'),
('AID0613202175845', 'Jun-14-2021', '10:00 AM', 'No Ramarks'),
('AID06152021122109', 'Jun-15-2021', '9:00 AM', '');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_clientinfo`
--

CREATE TABLE `tbl_clientinfo` (
  `ClientID` varchar(45) DEFAULT NULL,
  `Member` varchar(45) DEFAULT NULL,
  `LName` varchar(45) DEFAULT NULL,
  `MName` varchar(45) DEFAULT NULL,
  `Fname` varchar(45) DEFAULT NULL,
  `Number_Street` varchar(45) DEFAULT NULL,
  `City` varchar(45) DEFAULT NULL,
  `State` varchar(45) DEFAULT NULL,
  `Zipcode` varchar(45) DEFAULT NULL,
  `Email` varchar(45) DEFAULT NULL,
  `Gender` varchar(45) DEFAULT NULL,
  `Marital_State` varchar(45) DEFAULT NULL,
  `Home` varchar(45) DEFAULT NULL,
  `Work` varchar(45) DEFAULT NULL,
  `Cell` varchar(45) DEFAULT NULL,
  `Spouse_Home` varchar(45) DEFAULT NULL,
  `Spouse_Work` varchar(45) DEFAULT NULL,
  `Spouse_Cell` varchar(45) DEFAULT NULL,
  `EC_Name` varchar(45) DEFAULT NULL,
  `EC_Contact` varchar(45) DEFAULT NULL,
  `Refer` varchar(45) DEFAULT NULL,
  `Physician` varchar(45) DEFAULT NULL,
  `If_yes` varchar(45) DEFAULT NULL,
  `Conditions` varchar(300) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_clientinfo`
--

INSERT INTO `tbl_clientinfo` (`ClientID`, `Member`, `LName`, `MName`, `Fname`, `Number_Street`, `City`, `State`, `Zipcode`, `Email`, `Gender`, `Marital_State`, `Home`, `Work`, `Cell`, `Spouse_Home`, `Spouse_Work`, `Spouse_Cell`, `EC_Name`, `EC_Contact`, `Refer`, `Physician`, `If_yes`, `Conditions`) VALUES
('EID0529202141448', 'Member', 'test', 'setse', 'test', 'asdsad', '', '', '', '', 'Yes', 'Single', '', '', '', '', '', '', '', '', '', 'Yes', '', ''),
('EID0606202193313', 'Member', 'Tamad', 'M', 'Tamad', 'brgy mapayapa street', 'General Santos', '', '', '', 'Yes', 'Single', '09922484422', '09922484422', '09922484422', '09922484422', '09922484422', '09922484422', '', '', '', 'Yes', '', ''),
('EID0606202193812', 'Member', 'Last', 'Mid', 'Last', 'Street', 'City123', '', '', '', 'Yes', 'Single', '09992221111', '09992221111', '09992221111', '09992221111', '09992221111', '09992221111', '', '', '', 'Yes', '', ''),
('EID0614202184331', 'Non-Member', 'ajasd;', 'askda', 'ajasd;', '', '', '', '', '', 'Yes', 'Single', '', '', '1241531', '', '', '', '', '', '', 'Yes', '', ''),
('EID0614202190212', 'Non-Member', 'juan', '', 'juan', 'street', '', '', '', '', 'Yes', 'Single', '', '', '1241151', '', '', '', '', '', '', 'Yes', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_cost`
--

CREATE TABLE `tbl_cost` (
  `Test` varchar(45) DEFAULT NULL,
  `Cost` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_cost`
--

INSERT INTO `tbl_cost` (`Test`, `Cost`) VALUES
('HIV', '200.00'),
('TB', '400.00'),
('Heart', '800.00'),
('Blood', '300.00'),
('Malaria', '600.00'),
('Liver', '2500.00'),
('VLDR', '300.00'),
('TPHA', '800.00');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_login_history`
--

CREATE TABLE `tbl_login_history` (
  `AccountID` varchar(45) DEFAULT NULL,
  `Name` varchar(45) DEFAULT NULL,
  `Username` varchar(45) DEFAULT NULL,
  `Type` varchar(45) DEFAULT NULL,
  `DateLogin` varchar(45) DEFAULT NULL,
  `TimeLogin` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_login_history`
--

INSERT INTO `tbl_login_history` (`AccountID`, `Name`, `Username`, `Type`, `DateLogin`, `TimeLogin`) VALUES
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Apr-22-2021', '7:51 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Apr-22-2021', '10:36 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Apr-25-2021', '7:56 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Apr-25-2021', '8:05 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Apr-26-2021', '8:07 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Apr-27-2021', '7:11 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Apr-27-2021', '7:51 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Apr-27-2021', '7:56 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Apr-27-2021', '9:27 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Apr-27-2021', '9:32 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Apr-27-2021', '9:50 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Apr-27-2021', '10:02 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Apr-27-2021', '10:05 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Apr-27-2021', '10:16 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Apr-27-2021', '10:21 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Apr-27-2021', '10:23 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Apr-27-2021', '10:28 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Apr-27-2021', '10:30 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Apr-27-2021', '10:32 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Apr-27-2021', '10:34 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Apr-27-2021', '10:36 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Apr-27-2021', '10:40 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Apr-27-2021', '10:40 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Apr-27-2021', '10:42 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Apr-27-2021', '10:52 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Apr-27-2021', '10:59 PM'),
('ID0422202173425', 'administrator', 'ADMIN', 'Admin', 'Apr-27-2021', '11:04 PM'),
('ID0422202173425', 'administrator', 'ADMIN', 'Admin', 'Apr-27-2021', '11:40 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Apr-29-2021', '6:44 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Apr-29-2021', '6:49 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Apr-29-2021', '8:52 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Apr-29-2021', '8:56 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Apr-29-2021', '8:58 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Apr-29-2021', '9:07 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Apr-29-2021', '9:09 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Apr-29-2021', '9:37 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Apr-29-2021', '9:38 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Apr-29-2021', '9:45 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Apr-29-2021', '10:00 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Apr-29-2021', '10:11 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Apr-29-2021', '10:19 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Apr-29-2021', '10:22 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Apr-29-2021', '10:41 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Apr-29-2021', '10:50 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'May-01-2021', '10:30 AM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'May-01-2021', '10:53 AM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'May-01-2021', '7:57 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'May-01-2021', '8:11 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'May-01-2021', '11:01 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'May-02-2021', '8:20 AM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'May-02-2021', '8:24 AM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'May-02-2021', '8:26 AM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'May-02-2021', '8:30 AM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'May-02-2021', '8:49 AM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'May-02-2021', '8:52 AM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'May-02-2021', '7:19 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'May-03-2021', '9:55 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'May-03-2021', '9:59 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'May-03-2021', '10:00 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'May-03-2021', '10:31 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'May-03-2021', '10:39 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'May-03-2021', '10:45 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'May-03-2021', '10:52 PM'),
('ID05032021105257', 'Juan Tamad', 'admin01', 'Admin', 'May-03-2021', '10:54 PM'),
('ID05032021105257', 'Juan Tamad', 'admin01', 'Admin', 'May-04-2021', '12:04 AM'),
('ID05032021105257', 'Juan Tamad', 'admin01', 'Admin', 'May-04-2021', '12:07 AM'),
('ID05032021105257', 'Juan Tamad', 'admin01', 'Admin', 'May-04-2021', '8:44 PM'),
('ID05032021105257', 'Juan Tamad', 'admin01', 'Admin', 'May-04-2021', '8:52 PM'),
('ID05032021105257', 'Juan Tamad', 'admin01', 'Admin', 'May-04-2021', '8:57 PM'),
('ID05032021105257', 'Juan Tamad', 'admin01', 'Admin', 'May-04-2021', '8:59 PM'),
('ID05032021105257', 'Juan Tamad', 'admin01', 'Admin', 'May-04-2021', '9:07 PM'),
('ID05032021105257', 'Juan Tamad', 'admin01', 'Admin', 'May-04-2021', '9:11 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'May-06-2021', '6:59 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'May-06-2021', '8:09 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'May-11-2021', '8:19 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'May-11-2021', '8:25 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'May-11-2021', '8:27 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'May-11-2021', '8:36 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'May-16-2021', '8:43 AM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'May-16-2021', '9:38 AM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'May-16-2021', '9:57 AM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'May-16-2021', '10:13 AM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'May-16-2021', '10:27 AM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'May-16-2021', '11:02 AM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'May-16-2021', '11:38 AM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'May-16-2021', '1:52 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'May-16-2021', '1:55 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'May-16-2021', '2:40 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'May-16-2021', '2:51 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'May-29-2021', '9:22 AM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'May-29-2021', '9:27 AM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'May-29-2021', '1:34 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'May-29-2021', '1:57 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'May-29-2021', '1:59 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'May-29-2021', '2:12 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'May-29-2021', '2:15 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'May-29-2021', '2:25 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'May-29-2021', '3:52 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'May-29-2021', '4:09 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'May-29-2021', '4:12 PM'),
('ID0422202173425', 'administrator', 'ADMIN', 'Admin', 'May-29-2021', '4:45 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'May-29-2021', '4:56 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'May-30-2021', '7:58 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'May-30-2021', '8:21 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'May-30-2021', '8:26 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'May-30-2021', '9:51 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-05-2021', '11:07 AM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-05-2021', '11:27 AM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-05-2021', '1:38 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-05-2021', '1:44 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-05-2021', '1:45 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-05-2021', '1:50 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-05-2021', '2:17 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-05-2021', '3:00 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-05-2021', '3:05 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-05-2021', '3:10 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-05-2021', '6:10 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-05-2021', '6:37 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-05-2021', '7:55 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-05-2021', '8:11 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-05-2021', '8:17 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-05-2021', '8:19 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-05-2021', '8:25 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-05-2021', '8:28 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-05-2021', '8:30 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-05-2021', '8:33 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-05-2021', '8:34 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-05-2021', '9:35 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-05-2021', '9:52 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-05-2021', '10:25 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-05-2021', '10:26 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-05-2021', '10:38 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-05-2021', '10:49 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-06-2021', '8:22 AM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-06-2021', '8:24 AM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-06-2021', '8:26 AM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-06-2021', '8:48 AM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-06-2021', '2:51 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-06-2021', '3:00 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-06-2021', '3:25 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-06-2021', '3:36 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-06-2021', '4:07 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-06-2021', '4:16 PM'),
('ID0422202173425', 'administrator', 'ADMIN', 'Admin', 'Jun-06-2021', '4:17 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-06-2021', '4:21 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-06-2021', '4:23 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-06-2021', '4:25 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-06-2021', '4:26 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-06-2021', '4:36 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-06-2021', '4:45 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-06-2021', '5:34 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-06-2021', '6:04 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-06-2021', '6:21 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-06-2021', '6:26 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-06-2021', '6:28 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-06-2021', '6:30 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-06-2021', '6:30 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-06-2021', '6:32 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-06-2021', '6:33 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-06-2021', '6:36 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-06-2021', '7:19 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-06-2021', '8:01 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-06-2021', '8:09 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-06-2021', '8:11 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-06-2021', '8:29 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-06-2021', '8:33 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-06-2021', '8:40 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-06-2021', '9:21 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-06-2021', '9:21 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-06-2021', '9:31 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-06-2021', '9:32 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-06-2021', '9:38 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-06-2021', '9:40 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-06-2021', '9:51 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-06-2021', '9:53 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-06-2021', '9:57 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-06-2021', '10:01 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-12-2021', '8:54 AM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-12-2021', '9:47 AM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-12-2021', '10:17 AM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-12-2021', '10:19 AM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-12-2021', '10:24 AM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-12-2021', '10:28 AM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-12-2021', '10:30 AM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-12-2021', '10:32 AM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-12-2021', '11:21 AM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-12-2021', '12:01 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-12-2021', '12:06 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-12-2021', '12:25 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-12-2021', '4:23 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-12-2021', '4:50 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-12-2021', '5:07 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-12-2021', '5:10 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-12-2021', '5:13 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-12-2021', '5:52 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-12-2021', '6:00 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-12-2021', '6:03 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-12-2021', '6:16 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-12-2021', '6:22 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-12-2021', '6:25 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-12-2021', '6:28 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-12-2021', '6:29 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-12-2021', '6:32 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-12-2021', '6:33 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-12-2021', '6:35 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-12-2021', '6:52 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-12-2021', '6:59 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-12-2021', '7:02 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-12-2021', '7:10 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-12-2021', '7:26 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-12-2021', '7:27 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-12-2021', '7:53 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-12-2021', '8:01 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-12-2021', '9:24 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-12-2021', '9:25 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-12-2021', '9:25 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-12-2021', '9:27 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-12-2021', '9:29 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-12-2021', '10:11 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-12-2021', '10:12 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-12-2021', '10:15 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-12-2021', '10:21 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-12-2021', '10:51 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-12-2021', '11:16 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-12-2021', '11:28 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-12-2021', '11:44 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-13-2021', '12:08 AM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-13-2021', '12:11 AM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-13-2021', '12:26 AM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-13-2021', '12:32 AM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-13-2021', '12:35 AM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-13-2021', '12:36 AM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-13-2021', '12:43 AM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-13-2021', '12:55 AM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-13-2021', '7:22 am'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-13-2021', '7:32 AM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-13-2021', '7:34 AM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-13-2021', '7:45 AM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-13-2021', '7:51 am'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-13-2021', '7:55 AM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-13-2021', '7:57 AM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-13-2021', '8:06 AM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-13-2021', '8:13 AM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-13-2021', '8:18 AM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-13-2021', '8:19 AM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-13-2021', '8:22 AM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-13-2021', '8:27 AM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-13-2021', '8:32 AM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-13-2021', '8:33 AM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-13-2021', '8:34 AM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-13-2021', '8:39 AM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-13-2021', '8:41 AM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-13-2021', '9:02 AM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-13-2021', '9:04 AM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-13-2021', '9:25 AM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-13-2021', '10:01 AM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-13-2021', '10:26 AM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-13-2021', '10:33 AM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-13-2021', '10:38 AM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-13-2021', '11:02 AM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-13-2021', '11:12 AM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-13-2021', '11:17 AM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-13-2021', '11:22 AM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-13-2021', '11:28 AM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-13-2021', '11:34 AM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-13-2021', '11:36 AM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-13-2021', '11:37 AM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-13-2021', '11:40 AM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-13-2021', '11:43 AM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-13-2021', '11:47 AM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-13-2021', '11:54 AM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-13-2021', '12:26 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-13-2021', '12:30 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-13-2021', '12:33 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-13-2021', '12:39 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-13-2021', '12:42 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-13-2021', '12:49 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-13-2021', '1:14 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-13-2021', '1:21 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-13-2021', '1:22 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-13-2021', '1:43 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-13-2021', '1:51 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-13-2021', '2:04 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-13-2021', '2:08 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-13-2021', '2:11 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-13-2021', '2:15 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-13-2021', '2:18 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-13-2021', '2:24 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-13-2021', '3:16 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-13-2021', '3:20 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-13-2021', '3:28 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-13-2021', '3:30 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-13-2021', '3:36 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-13-2021', '3:51 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-13-2021', '3:55 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-13-2021', '3:59 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-13-2021', '4:07 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-13-2021', '4:19 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-13-2021', '4:22 pm'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-13-2021', '4:24 pm'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-13-2021', '4:33 pm'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-13-2021', '4:54 pm'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-13-2021', '4:57 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-13-2021', '5:34 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-13-2021', '5:36 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-13-2021', '5:37 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-13-2021', '5:49 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-13-2021', '5:51 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-13-2021', '6:00 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-13-2021', '6:04 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-13-2021', '6:38 pm'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-13-2021', '6:59 pm'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-13-2021', '7:51 pm'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-13-2021', '7:53 pm'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-13-2021', '8:07 pm'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-13-2021', '8:15 pm'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-13-2021', '8:38 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-13-2021', '8:43 pm'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-13-2021', '8:44 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-13-2021', '8:53 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-13-2021', '8:58 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-13-2021', '9:00 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-13-2021', '9:11 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-14-2021', '7:52 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-14-2021', '7:57 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-14-2021', '8:16 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-14-2021', '8:20 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-14-2021', '8:24 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-14-2021', '8:24 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-14-2021', '8:32 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-14-2021', '8:35 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-14-2021', '9:07 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-14-2021', '9:26 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-14-2021', '9:33 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-14-2021', '9:41 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-14-2021', '10:02 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-14-2021', '10:07 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-14-2021', '10:10 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-14-2021', '10:24 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-14-2021', '10:36 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-14-2021', '10:45 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-14-2021', '10:52 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-14-2021', '10:54 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-14-2021', '11:03 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-14-2021', '11:06 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-14-2021', '11:19 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-14-2021', '11:21 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-14-2021', '11:54 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-14-2021', '11:56 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-14-2021', '11:59 PM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-15-2021', '12:03 AM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-15-2021', '12:08 AM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-15-2021', '12:11 AM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-15-2021', '12:12 AM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-15-2021', '12:19 AM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-15-2021', '12:25 AM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-15-2021', '12:31 AM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-15-2021', '12:35 AM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-15-2021', '12:37 AM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-15-2021', '12:38 AM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-15-2021', '12:39 AM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-15-2021', '12:45 AM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-15-2021', '12:56 AM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-15-2021', '1:23 AM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-15-2021', '1:42 AM'),
('ID0615202114300', 'user', 'user', 'User', 'Jun-15-2021', '1:45 AM'),
('ID0615202114300', 'user', 'user', 'User', 'Jun-15-2021', '1:51 AM'),
('ID0422202173425', 'administrator', 'admin', 'Admin', 'Jun-15-2021', '2:05 AM');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_smsacct`
--

CREATE TABLE `tbl_smsacct` (
  `ID` varchar(45) NOT NULL,
  `Name` varchar(45) NOT NULL,
  `Username` varchar(45) DEFAULT NULL,
  `Password` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_smsacct`
--

INSERT INTO `tbl_smsacct` (`ID`, `Name`, `Username`, `Password`) VALUES
('ID06122021104913', 'SF', 'SD', 'SD'),
('ID06122021112907', 'ASD', 'asd', 'asd'),
('ID06132021121859', 'My account', 'customer002', 'Passw0rd123'),
('ID0613202175742', 'Jaun', 'user101', 'pass123');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_user`
--

CREATE TABLE `tbl_user` (
  `AccountID` varchar(45) DEFAULT NULL,
  `Name` varchar(45) DEFAULT NULL,
  `Username` varchar(45) DEFAULT NULL,
  `Password` varchar(45) DEFAULT NULL,
  `Address` varchar(45) DEFAULT NULL,
  `ContactNo` varchar(45) DEFAULT NULL,
  `Type` varchar(45) DEFAULT NULL,
  `Status` varchar(45) DEFAULT NULL,
  `Q1` varchar(200) DEFAULT NULL,
  `A1` varchar(200) DEFAULT NULL,
  `Q2` varchar(200) DEFAULT NULL,
  `A2` varchar(200) NOT NULL,
  `Q3` varchar(200) NOT NULL,
  `A3` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_user`
--

INSERT INTO `tbl_user` (`AccountID`, `Name`, `Username`, `Password`, `Address`, `ContactNo`, `Type`, `Status`, `Q1`, `A1`, `Q2`, `A2`, `Q3`, `A3`) VALUES
('ID0615202114300', 'user', 'user', 'user', 'user', 'useruser', 'User', 'Active', 'What is your pet\'s name?', 'user', 'What is the name of your first teacher?', 'user', 'What was the name of your first school?', 'user');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_appointment`
--
ALTER TABLE `tbl_appointment`
  ADD UNIQUE KEY `ClientID` (`ClientID`);

--
-- Indexes for table `tbl_smsacct`
--
ALTER TABLE `tbl_smsacct`
  ADD PRIMARY KEY (`ID`,`Name`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
