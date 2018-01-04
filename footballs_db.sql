-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 04, 2018 at 07:25 PM
-- Server version: 10.1.29-MariaDB
-- PHP Version: 7.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `footballs_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `authorities`
--

DROP TABLE IF EXISTS `authorities`;
CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `authorities`
--

INSERT INTO `authorities` (`username`, `authority`) VALUES
('pavel', 'ROLE_ADMIN'),
('pavel', 'ROLE_PREMIUM'),
('pavel', 'ROLE_USER');

-- --------------------------------------------------------

--
-- Table structure for table `player`
--

DROP TABLE IF EXISTS `player`;
CREATE TABLE `player` (
  `id` int(11) NOT NULL,
  `forename` varchar(30) NOT NULL DEFAULT '',
  `surname` varchar(50) NOT NULL,
  `salary` int(12) NOT NULL,
  `age` int(3) NOT NULL,
  `offense` int(2) NOT NULL,
  `defense` int(2) NOT NULL,
  `inTeam` int(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `player`
--

INSERT INTO `player` (`id`, `forename`, `surname`, `salary`, `age`, `offense`, `defense`, `inTeam`) VALUES
(1, 'pedro', 'sanches', 12, 22, 2, 3, 0),
(2, 'dsfsdf', 'sdf', 2, 2, 2, 2, 0),
(3, '\"Susan\"', '\"Jones\"', 210998, 47, 93, 28, 0),
(4, 'Barbara', 'Jones', 28772, 24, 5, 84, 0),
(5, 'John', 'Rodriguez', 112028, 28, 1, 57, 0),
(6, 'Daniel', 'Rodriguez', 412100, 26, 59, 28, 0),
(7, 'Charles', 'Lee', 867715, 39, 29, 20, 0),
(8, 'Elizabeth', 'Brown', 719754, 52, 62, 43, 0),
(9, 'John', 'Miller', 17817, 15, 50, 25, 0),
(10, 'Joseph', 'Miller', 81171, 54, 41, 7, 0),
(11, 'Thomas', 'Moore', 125712, 52, 27, 65, 0),
(12, 'Robert', 'Taylor', 224240, 56, 81, 44, 0),
(13, 'Mary', 'Thompson', 381990, 18, 28, 62, 0),
(14, 'Mark', 'Smith', 654413, 38, 61, 50, 0),
(15, 'Mary', 'Thompson', 37080, 41, 80, 56, 0),
(16, 'John', 'Miller', 263487, 36, 67, 36, 0),
(17, 'Richard', 'White', 541425, 15, 92, 36, 0),
(18, 'Patricia', 'Thompson', 175234, 36, 73, 14, 0),
(19, 'Richard', 'White', 670720, 46, 8, 38, 0),
(20, 'Barbara', 'Johnson', 136692, 40, 84, 4, 0),
(21, 'David', 'Williams', 951739, 28, 5, 7, 0),
(22, 'Michael', 'Wilson', 106378, 44, 89, 46, 0),
(23, 'Daniel', 'Davis', 947386, 42, 66, 23, 0),
(24, 'Linda', 'Moore', 57076, 54, 61, 25, 0),
(25, 'John', 'Davis', 746089, 53, 81, 94, 0),
(26, 'Mark', 'Davis', 433050, 30, 56, 36, 0),
(27, 'John', 'Lee', 611106, 28, 66, 25, 0),
(28, 'Michael', 'Moore', 559966, 34, 32, 96, 0),
(29, 'Elizabeth', 'Miller', 517751, 32, 21, 33, 0),
(30, 'Michael', 'Thomas', 544990, 16, 6, 19, 0),
(31, 'John', 'White', 813432, 44, 53, 86, 0),
(32, 'Joseph', 'Martin', 112739, 35, 79, 7, 0),
(33, 'Barbara', 'Thompson', 11734, 29, 44, 93, 0),
(34, 'Richard', 'Davis', 9511, 18, 71, 26, 0),
(35, 'David', 'Jones', 671202, 51, 66, 75, 0),
(36, 'Elizabeth', 'Martin', 387452, 16, 71, 70, 0),
(37, 'Robert', 'Anderson', 947492, 42, 56, 21, 0),
(38, 'Michael', 'Lee', 946093, 26, 52, 68, 0),
(39, 'James', 'Johnson', 160828, 45, 10, 38, 0),
(40, 'Thomas', 'Lee', 716013, 49, 54, 66, 0),
(41, 'Patricia', 'Thompson', 228219, 35, 82, 88, 0),
(42, 'William', 'Smith', 528393, 49, 32, 84, 0),
(43, 'Maria', 'Johnson', 774675, 41, 49, 61, 0),
(44, 'William', 'Thompson', 915801, 23, 83, 49, 0),
(45, 'Mary', 'Lee', 337238, 18, 86, 64, 0),
(46, 'Maria', 'Rodriguez', 642222, 32, 10, 46, 0),
(47, 'Charles', 'White', 257571, 45, 9, 88, 0),
(48, 'Jennifer', 'Anderson', 121158, 53, 39, 94, 0),
(49, 'Elizabeth', 'Smith', 430156, 41, 51, 60, 0),
(50, 'Richard', 'Johnson', 328491, 23, 30, 88, 0),
(51, 'Susan', 'Jackson', 223062, 31, 15, 59, 0),
(52, 'Linda', 'Johnson', 574733, 21, 76, 33, 0),
(53, 'Jennifer', 'Thompson', 909270, 22, 91, 9, 0),
(54, 'Thomas', 'Wilson', 379590, 17, 11, 12, 0),
(55, 'Daniel', 'Moore', 957213, 19, 25, 81, 0),
(56, 'William', 'Thomas', 531553, 37, 87, 10, 0),
(57, 'William', 'Wilson', 777967, 57, 97, 61, 0),
(58, 'Susan', 'Williams', 881150, 21, 91, 96, 0),
(59, 'William', 'Garcia', 257706, 28, 86, 72, 0),
(60, 'Jennifer', 'Jackson', 596584, 15, 72, 26, 0),
(61, 'Charles', 'Thompson', 369223, 18, 43, 42, 0),
(62, 'Barbara', 'Lee', 936461, 32, 68, 1, 0),
(63, 'Maria', 'Miller', 362260, 55, 66, 64, 0),
(64, 'Elizabeth', 'Garcia', 216083, 47, 16, 4, 0),
(65, 'Patricia', 'Moore', 277574, 51, 97, 36, 0),
(66, 'Thomas', 'Miller', 291345, 29, 57, 61, 0),
(67, 'David', 'Davis', 218991, 27, 61, 16, 0),
(68, 'Michael', 'Jones', 810625, 48, 27, 37, 0),
(69, 'William', 'Thomas', 930794, 52, 13, 5, 0),
(70, 'Patricia', 'Thompson', 608376, 15, 81, 17, 0),
(71, 'Joseph', 'Williams', 908620, 19, 47, 53, 0),
(72, 'Elizabeth', 'Davis', 481402, 58, 92, 67, 0),
(73, 'John', 'Wilson', 741475, 56, 21, 67, 0),
(74, 'Richard', 'Smith', 420558, 57, 86, 90, 0),
(75, 'Linda', 'Thompson', 245084, 19, 23, 84, 0),
(76, 'Maria', 'Williams', 220343, 23, 31, 64, 0),
(77, 'Charles', 'Thomas', 256789, 22, 1, 60, 0),
(78, 'Michael', 'Anderson', 838029, 45, 21, 64, 0),
(79, 'Susan', 'Brown', 719914, 59, 61, 43, 0),
(80, 'Elizabeth', 'Williams', 757786, 58, 30, 74, 0),
(81, 'Thomas', 'Williams', 780335, 47, 49, 71, 0),
(82, 'Mary', 'Miller', 94508, 47, 8, 83, 0),
(83, 'Elizabeth', 'Moore', 402770, 39, 75, 34, 0),
(84, 'Michael', 'Taylor', 862434, 19, 73, 36, 0),
(85, 'Mark', 'Thomas', 326236, 42, 45, 92, 0),
(86, 'Linda', 'Lee', 636582, 24, 69, 70, 0),
(87, 'Robert', 'Thompson', 369764, 45, 78, 56, 0),
(88, 'Maria', 'Rodriguez', 223529, 29, 60, 7, 0),
(89, 'William', 'Thompson', 220533, 33, 72, 51, 0),
(90, 'Mark', 'Jones', 651919, 49, 56, 51, 0),
(91, 'Mark', 'Jackson', 520645, 34, 35, 52, 0),
(92, 'Mark', 'Thomas', 175470, 52, 48, 63, 0),
(93, 'Joseph', 'Smith', 853541, 17, 59, 12, 0),
(94, 'Patricia', 'Williams', 890988, 24, 25, 17, 0),
(95, 'John', 'White', 879381, 21, 1, 93, 0),
(96, 'Michael', 'White', 254399, 36, 8, 68, 0),
(97, 'William', 'Smith', 981417, 48, 55, 65, 0),
(98, 'Joseph', 'Smith', 490558, 24, 64, 84, 0),
(99, 'David', 'Davis', 911120, 26, 41, 29, 0),
(100, 'John', 'Thompson', 972385, 44, 80, 19, 0),
(101, 'John', 'Wilson', 267724, 25, 39, 37, 0),
(102, 'Mark', 'Davis', 47384, 19, 59, 46, 0),
(103, 'Thomas', 'Martin', 755945, 26, 39, 52, 0),
(104, 'Patricia', 'Thomas', 460207, 27, 36, 49, 0),
(105, 'Patricia', 'Thomas', 273998, 47, 97, 49, 0),
(106, 'Jennifer', 'Martin', 479593, 43, 80, 14, 0),
(107, 'David', 'Lee', 889593, 46, 35, 58, 0),
(108, 'Mary', 'Brown', 660961, 19, 27, 74, 0),
(109, 'Linda', 'Johnson', 355640, 34, 49, 12, 0),
(110, 'Jennifer', 'Anderson', 692560, 23, 3, 97, 0),
(111, 'Maria', 'Williams', 675914, 21, 34, 47, 0),
(112, 'Daniel', 'Martin', 769325, 21, 10, 32, 0),
(113, 'Mark', 'Anderson', 381449, 40, 82, 20, 0),
(114, 'William', 'Jackson', 161129, 33, 30, 2, 0),
(115, 'Jennifer', 'Martinez', 536961, 30, 38, 45, 0),
(116, 'Michael', 'Brown', 456814, 25, 23, 3, 0),
(117, 'Michael', 'Garcia', 92585, 25, 47, 54, 0),
(118, 'Barbara', 'Johnson', 94336, 26, 24, 25, 0),
(119, 'Richard', 'Martin', 643614, 54, 86, 3, 0),
(120, 'Richard', 'Thomas', 132421, 19, 43, 62, 0),
(121, 'Linda', 'Johnson', 149265, 21, 2, 2, 0),
(122, 'Barbara', 'Jackson', 861906, 30, 87, 74, 0),
(123, 'Maria', 'Brown', 440134, 21, 80, 96, 0),
(124, 'William', 'Taylor', 859788, 42, 16, 33, 0),
(125, 'Jennifer', 'Thompson', 591252, 32, 16, 6, 0),
(126, 'Elizabeth', 'Smith', 683103, 27, 31, 75, 0),
(127, 'Elizabeth', 'Smith', 505573, 22, 40, 25, 0),
(128, 'Maria', 'Davis', 137261, 18, 41, 95, 0),
(129, 'Mark', 'Thomas', 254575, 21, 59, 74, 0),
(130, 'Jennifer', 'Thompson', 383634, 50, 71, 37, 0),
(131, 'William', 'Davis', 590382, 24, 14, 28, 0),
(132, 'Jennifer', 'Rodriguez', 407098, 34, 71, 60, 0),
(133, 'Jennifer', 'Smith', 17464, 56, 67, 43, 0),
(134, 'Jennifer', 'Thomas', 627557, 15, 11, 7, 0),
(135, 'David', 'Brown', 648256, 59, 26, 80, 0),
(136, 'James', 'Jackson', 522024, 53, 95, 83, 0),
(137, 'James', 'Thompson', 861852, 44, 93, 16, 0),
(138, 'Charles', 'Martin', 981741, 21, 71, 96, 0),
(139, 'William', 'Wilson', 396364, 53, 5, 96, 0),
(140, 'James', 'Taylor', 856191, 55, 40, 70, 0),
(141, 'Thomas', 'Smith', 816064, 44, 61, 10, 0),
(142, 'Charles', 'Jackson', 615928, 17, 72, 80, 0),
(143, 'Charles', 'Brown', 143977, 45, 72, 66, 0),
(144, 'Daniel', 'Thompson', 876638, 26, 5, 29, 0),
(145, 'William', 'Smith', 112731, 52, 87, 66, 0),
(146, 'Charles', 'Taylor', 944049, 41, 33, 29, 0),
(147, 'Mary', 'Thomas', 506442, 41, 19, 94, 0),
(148, 'Daniel', 'Miller', 843104, 58, 33, 80, 0),
(149, 'Joseph', 'Taylor', 120185, 58, 89, 37, 0),
(150, 'Susan', 'Williams', 489195, 41, 29, 78, 0),
(151, 'Elizabeth', 'White', 502462, 36, 77, 77, 0),
(152, 'Barbara', 'Anderson', 529521, 20, 98, 74, 0),
(153, 'Joseph', 'Garcia', 442652, 46, 64, 25, 0),
(154, 'Jennifer', 'Thomas', 855273, 48, 6, 57, 0),
(155, 'Maria', 'Moore', 642511, 55, 24, 82, 0),
(156, 'Thomas', 'Brown', 900520, 20, 64, 56, 0),
(157, 'David', 'White', 849263, 34, 16, 57, 0),
(158, 'Linda', 'Thomas', 562999, 15, 15, 95, 0),
(159, 'Charles', 'Garcia', 498792, 39, 13, 54, 0),
(160, 'Patricia', 'Taylor', 143930, 42, 3, 64, 0),
(161, 'Linda', 'Lee', 190762, 45, 7, 5, 0),
(162, 'Susan', 'Martinez', 924048, 27, 58, 3, 0),
(163, 'Susan', 'Smith', 172102, 33, 19, 60, 0),
(164, 'Susan', 'Brown', 894156, 31, 12, 58, 0),
(165, 'Mark', 'Wilson', 920875, 21, 81, 74, 0),
(166, 'Mary', 'Martin', 461321, 21, 69, 31, 0),
(167, 'Charles', 'Lee', 8499, 35, 57, 61, 0),
(168, 'William', 'Jones', 712371, 45, 92, 40, 0),
(169, 'Michael', 'Miller', 356956, 56, 36, 8, 0),
(170, 'Daniel', 'Martin', 603524, 57, 18, 60, 0),
(171, 'Mary', 'Davis', 560030, 35, 56, 18, 0),
(172, 'Robert', 'Martinez', 332140, 40, 32, 82, 0),
(173, 'Michael', 'Jones', 109650, 44, 50, 22, 0),
(174, 'Charles', 'Thompson', 951720, 40, 29, 16, 0),
(175, 'William', 'Jones', 947203, 58, 4, 27, 0),
(176, 'Susan', 'Taylor', 980032, 53, 42, 24, 0),
(177, 'William', 'Moore', 956998, 55, 21, 68, 0),
(178, 'Thomas', 'Martin', 514634, 29, 66, 47, 0),
(179, 'Jennifer', 'Miller', 570018, 36, 79, 62, 0),
(180, 'Thomas', 'Jones', 131116, 32, 33, 19, 0),
(181, 'Michael', 'Garcia', 338200, 30, 85, 74, 0),
(182, 'Mark', 'White', 28502, 40, 9, 54, 0),
(183, 'Jennifer', 'Anderson', 656758, 19, 58, 8, 0),
(184, 'Mark', 'Davis', 436180, 57, 15, 95, 0),
(185, 'Robert', 'Brown', 96155, 47, 77, 47, 0),
(186, 'Susan', 'Martin', 938848, 47, 86, 86, 0),
(187, 'Maria', 'Smith', 119686, 52, 97, 16, 0),
(188, 'David', 'Rodriguez', 599200, 20, 46, 81, 0),
(189, 'John', 'Rodriguez', 962203, 45, 9, 16, 0),
(190, 'David', 'Martin', 722516, 42, 35, 46, 0),
(191, 'William', 'Johnson', 971858, 31, 39, 64, 0),
(192, 'John', 'Miller', 82555, 28, 86, 94, 0),
(193, 'Elizabeth', 'Moore', 111115, 43, 59, 15, 0),
(194, 'Joseph', 'Martin', 511775, 52, 11, 49, 0),
(195, 'Susan', 'Miller', 679329, 31, 58, 20, 0),
(196, 'Mary', 'Smith', 421743, 23, 30, 47, 0),
(197, 'Maria', 'Johnson', 28619, 19, 79, 59, 0),
(198, 'John', 'Martin', 696714, 15, 29, 79, 0),
(199, 'Richard', 'Smith', 36587, 37, 33, 10, 0),
(200, 'Thomas', 'Thompson', 86955, 59, 7, 39, 0),
(201, 'Jennifer', 'Martin', 614522, 26, 60, 76, 0),
(202, 'Daniel', 'Thompson', 349759, 54, 9, 23, 0),
(203, 'Daniel', 'Jackson', 724531, 25, 55, 92, 0),
(204, 'Elizabeth', 'Miller', 131497, 39, 7, 62, 0),
(205, 'Linda', 'Thomas', 64155, 21, 30, 89, 0),
(206, 'Charles', 'Lee', 77115, 52, 86, 35, 0),
(207, 'Robert', 'Martinez', 460522, 50, 68, 19, 0),
(208, 'Susan', 'White', 782511, 38, 31, 39, 0),
(209, 'Daniel', 'Jones', 484713, 43, 25, 90, 0),
(210, 'Joseph', 'Davis', 207594, 20, 45, 20, 0),
(211, 'James', 'Williams', 712176, 38, 33, 51, 0),
(212, 'Barbara', 'Anderson', 930948, 57, 92, 9, 0),
(213, 'Thomas', 'Jones', 111189, 55, 43, 77, 0),
(214, 'Linda', 'Brown', 801666, 20, 16, 13, 0),
(215, 'Daniel', 'Anderson', 582020, 25, 19, 92, 0),
(216, 'Mary', 'Brown', 748406, 28, 33, 63, 0),
(217, 'Richard', 'Davis', 911083, 31, 77, 16, 0),
(218, 'Susan', 'Lee', 271453, 37, 52, 95, 0),
(219, 'Elizabeth', 'Garcia', 559744, 39, 19, 57, 0),
(220, 'Barbara', 'Brown', 382197, 32, 60, 34, 0),
(221, 'Mark', 'Rodriguez', 61871, 37, 92, 32, 0),
(222, 'Patricia', 'Jackson', 592458, 30, 10, 57, 0),
(223, 'Linda', 'Thomas', 595075, 15, 30, 66, 0),
(224, 'Barbara', 'Miller', 37544, 24, 35, 5, 0),
(225, 'Maria', 'Smith', 400624, 51, 55, 76, 0),
(226, 'Richard', 'Jones', 375325, 44, 48, 91, 0),
(227, 'Linda', 'Smith', 677122, 24, 1, 7, 0),
(228, 'Joseph', 'White', 911527, 42, 30, 24, 0),
(229, 'Patricia', 'Miller', 556529, 50, 46, 96, 0),
(230, 'Linda', 'Smith', 887887, 27, 89, 15, 0),
(231, 'Barbara', 'Rodriguez', 904610, 30, 57, 20, 0),
(232, 'Joseph', 'Davis', 751112, 27, 85, 17, 0),
(233, 'Linda', 'White', 595135, 56, 72, 52, 0),
(234, 'Maria', 'Martin', 629216, 51, 84, 92, 0),
(235, 'Maria', 'Brown', 369730, 52, 42, 22, 0),
(236, 'Barbara', 'White', 980277, 45, 89, 4, 0),
(237, 'James', 'Martinez', 171299, 28, 18, 34, 0),
(238, 'Charles', 'Brown', 29394, 27, 74, 5, 0),
(239, 'Michael', 'Smith', 282667, 31, 3, 45, 0),
(240, 'Charles', 'Moore', 24716, 58, 50, 18, 0),
(241, 'William', 'Lee', 902651, 31, 70, 10, 0),
(242, 'Robert', 'Jones', 493723, 52, 16, 96, 0),
(243, 'Richard', 'Martin', 714193, 43, 36, 9, 0),
(244, 'William', 'Martinez', 139125, 30, 15, 65, 0),
(245, 'Charles', 'Davis', 546896, 33, 17, 34, 0),
(246, 'Richard', 'Brown', 653276, 52, 18, 3, 0),
(247, 'Jennifer', 'Johnson', 163883, 46, 97, 13, 0),
(248, 'Elizabeth', 'Jones', 384763, 31, 61, 30, 0),
(249, 'Charles', 'Jones', 56973, 17, 79, 94, 0),
(250, 'Mark', 'Brown', 325739, 40, 18, 70, 0),
(251, 'Charles', 'Rodriguez', 22560, 27, 36, 91, 0),
(252, 'Michael', 'Jackson', 100282, 37, 20, 90, 0),
(253, 'Mary', 'Rodriguez', 322545, 51, 76, 54, 0),
(254, 'Barbara', 'Williams', 106240, 22, 5, 42, 0),
(255, 'Michael', 'Jackson', 97138, 45, 88, 34, 0),
(256, 'Joseph', 'Thompson', 739250, 41, 25, 14, 0),
(257, 'Mark', 'Thompson', 171615, 59, 85, 42, 0),
(258, 'Susan', 'Martinez', 232914, 41, 20, 51, 0),
(259, 'Charles', 'Davis', 515822, 24, 48, 67, 0),
(260, 'Linda', 'Thomas', 513138, 47, 14, 92, 0),
(261, 'Thomas', 'White', 498143, 30, 51, 16, 0),
(262, 'James', 'Thomas', 970129, 28, 81, 16, 0),
(263, 'Maria', 'Martinez', 515779, 18, 22, 10, 0),
(264, 'Michael', 'Brown', 297220, 49, 41, 60, 0),
(265, 'Linda', 'Thomas', 789681, 30, 80, 90, 0),
(266, 'David', 'Moore', 532394, 56, 69, 20, 0),
(267, 'John', 'Williams', 550449, 29, 49, 64, 0),
(268, 'Elizabeth', 'Thomas', 796412, 19, 30, 64, 0),
(269, 'Robert', 'Brown', 26910, 50, 19, 63, 0),
(270, 'Charles', 'White', 931990, 46, 70, 30, 0),
(271, 'Patricia', 'Rodriguez', 819470, 28, 15, 1, 0),
(272, 'Mark', 'Anderson', 536432, 41, 28, 36, 0),
(273, 'Maria', 'Davis', 102564, 54, 94, 55, 0),
(274, 'Michael', 'Wilson', 398888, 54, 87, 64, 0),
(275, 'Elizabeth', 'Jackson', 13828, 55, 4, 9, 0),
(276, 'Barbara', 'Jackson', 962019, 25, 21, 60, 0),
(277, 'Susan', 'Martinez', 380715, 26, 80, 95, 0),
(278, 'David', 'Garcia', 943404, 23, 71, 86, 0),
(279, 'William', 'White', 110778, 56, 21, 86, 0),
(280, 'Joseph', 'Garcia', 431252, 43, 79, 67, 1),
(281, 'Susan', 'Smith', 750084, 30, 30, 69, 1),
(282, 'Daniel', 'Martinez', 689550, 47, 26, 48, 1),
(283, 'Mary', 'Garcia', 268203, 53, 56, 75, 1),
(284, 'Thomas', 'Thompson', 331086, 31, 72, 48, 1),
(285, 'Daniel', 'Anderson', 309336, 55, 49, 8, 1),
(286, 'John', 'Jones', 855060, 33, 28, 31, 1),
(287, 'Richard', 'Rodriguez', 189390, 18, 87, 83, 1),
(288, 'William', 'Martinez', 442178, 54, 27, 98, 1),
(289, 'Susan', 'Davis', 569989, 43, 8, 65, 1),
(290, 'Daniel', 'Brown', 458002, 29, 61, 34, 1),
(291, 'Joseph', 'Thomas', 146883, 40, 90, 21, 1),
(292, 'Elizabeth', 'Johnson', 801557, 20, 43, 44, 1),
(293, 'Jennifer', 'Anderson', 776157, 26, 48, 84, 1),
(294, 'James', 'Wilson', 478340, 55, 38, 63, 1),
(295, 'Robert', 'Martinez', 938718, 40, 95, 10, 1),
(296, 'William', 'Garcia', 325338, 32, 18, 57, 1),
(297, 'Elizabeth', 'Rodriguez', 962022, 41, 21, 58, 1),
(298, 'Jennifer', 'Williams', 619481, 38, 26, 19, 1),
(299, 'Daniel', 'Anderson', 621124, 37, 52, 27, 1),
(300, 'Mark', 'Thomas', 768529, 59, 4, 42, 1),
(301, 'Maria', 'Martin', 281124, 26, 82, 76, 1),
(302, 'Jennifer', 'Jackson', 365498, 34, 73, 57, 1),
(303, 'Mark', 'Thompson', 692697, 27, 54, 98, 1);

-- --------------------------------------------------------

--
-- Table structure for table `schedule`
--

DROP TABLE IF EXISTS `schedule`;
CREATE TABLE `schedule` (
  `game_id` int(11) NOT NULL,
  `game_date` datetime DEFAULT NULL,
  `host_team` varchar(100) DEFAULT NULL,
  `away_team` varchar(100) DEFAULT NULL,
  `game_result` int(11) DEFAULT NULL,
  `game_winner` varchar(100) DEFAULT NULL,
  `game_loser` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `teams`
--

DROP TABLE IF EXISTS `teams`;
CREATE TABLE `teams` (
  `name` varchar(50) NOT NULL,
  `wins` int(10) NOT NULL,
  `losses` int(10) NOT NULL,
  `owner` varchar(50) NOT NULL,
  `player1ID` int(11) NOT NULL,
  `player2ID` int(11) NOT NULL,
  `player3ID` int(11) NOT NULL,
  `player4ID` int(11) NOT NULL,
  `player5ID` int(11) NOT NULL,
  `player6ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `teams`
--

INSERT INTO `teams` (`name`, `wins`, `losses`, `owner`, `player1ID`, `player2ID`, `player3ID`, `player4ID`, `player5ID`, `player6ID`) VALUES
('asdasd123', 0, 0, 'pavel123', 274, 275, 276, 277, 278, 279),
('MarekTeam', 0, 0, 'pavel123123', 292, 293, 294, 295, 296, 297),
('pavelTeam', 0, 0, 'pavel', 298, 299, 300, 301, 302, 303),
('teamName123', 0, 0, 'pavel44', 256, 257, 258, 259, 260, 261),
('teamName1234', 0, 0, 'pavel1231234', 286, 287, 288, 289, 290, 291);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(70) NOT NULL,
  `email` varchar(70) DEFAULT NULL,
  `enabled` tinyint(1) NOT NULL,
  `budget` int(30) NOT NULL DEFAULT '0',
  `teamName` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`username`, `password`, `email`, `enabled`, `budget`, `teamName`) VALUES
('pavel', '$2a$10$bhES1XCla.N/G2WOEi7CYe213Koz3YKI08DXHcP6kZE/ES/lUvILq', 'asdasd@asdas.com', 1, 1000000, 'pavelTeam');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `authorities`
--
ALTER TABLE `authorities`
  ADD UNIQUE KEY `ix_auth_username` (`username`,`authority`);

--
-- Indexes for table `player`
--
ALTER TABLE `player`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `schedule`
--
ALTER TABLE `schedule`
  ADD PRIMARY KEY (`game_id`);

--
-- Indexes for table `teams`
--
ALTER TABLE `teams`
  ADD PRIMARY KEY (`name`),
  ADD KEY `Owner` (`owner`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `player`
--
ALTER TABLE `player`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=304;

--
-- AUTO_INCREMENT for table `schedule`
--
ALTER TABLE `schedule`
  MODIFY `game_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `authorities`
--
ALTER TABLE `authorities`
  ADD CONSTRAINT `fk_authorities_users` FOREIGN KEY (`username`) REFERENCES `users` (`username`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
