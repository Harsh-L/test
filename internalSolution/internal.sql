-- phpMyAdmin SQL Dump
-- version 5.1.4deb1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Apr 10, 2023 at 11:27 AM
-- Server version: 8.0.32-0ubuntu0.22.10.2
-- PHP Version: 8.1.7-1ubuntu3.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `internal`
--

-- --------------------------------------------------------

--
-- Table structure for table `billdetail`
--

CREATE TABLE `billdetail` (
  `billdetailid` int NOT NULL,
  `billid` int NOT NULL,
  `productid` int NOT NULL,
  `qty` int NOT NULL,
  `total` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `billdetail`
--

INSERT INTO `billdetail` (`billdetailid`, `billid`, `productid`, `qty`, `total`) VALUES
(1, 1, 1, 2, 4950),
(2, 1, 6, 4, 4800),
(3, 1, 2, 2, 480),
(4, 2, 1, 1, 2475),
(5, 2, 7, 2, 8920);

-- --------------------------------------------------------

--
-- Table structure for table `billmaster`
--

CREATE TABLE `billmaster` (
  `billid` int NOT NULL,
  `custid` int NOT NULL,
  `grosstotal` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `billmaster`
--

INSERT INTO `billmaster` (`billid`, `custid`, `grosstotal`) VALUES
(1, 2, 10230),
(2, 2, 11395);

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `custid` int NOT NULL,
  `custname` varchar(200) NOT NULL,
  `phoneno` varchar(12) NOT NULL,
  `email` varchar(200) NOT NULL,
  `address` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`custid`, `custname`, `phoneno`, `email`, `address`) VALUES
(1, 'rohit', '9475954785', 'rohit45@hotmail.com', 'andheri west, mumbai.'),
(2, 'rishabh', '954795874', 'rishabh32@gmail.com', 'spiti velly, chamoli.');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `productid` int NOT NULL,
  `productname` varchar(100) NOT NULL,
  `rate` int NOT NULL,
  `stock` int NOT NULL,
  `discount` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`productid`, `productname`, `rate`, `stock`, `discount`) VALUES
(1, 'willow bat', 2500, 100, 25),
(2, 'season ball', 250, 100, 10),
(5, 'safe gaurd', 1800, 50, 25),
(6, 'pad', 1200, 100, 0),
(7, 'helmet', 4500, 20, 40);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `billdetail`
--
ALTER TABLE `billdetail`
  ADD PRIMARY KEY (`billdetailid`),
  ADD KEY `productid` (`productid`),
  ADD KEY `billid` (`billid`);

--
-- Indexes for table `billmaster`
--
ALTER TABLE `billmaster`
  ADD PRIMARY KEY (`billid`),
  ADD KEY `custid` (`custid`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`custid`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`productid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `billdetail`
--
ALTER TABLE `billdetail`
  MODIFY `billdetailid` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `billmaster`
--
ALTER TABLE `billmaster`
  MODIFY `billid` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `custid` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `productid` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `billdetail`
--
ALTER TABLE `billdetail`
  ADD CONSTRAINT `billdetail_ibfk_1` FOREIGN KEY (`productid`) REFERENCES `product` (`productid`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `billdetail_ibfk_2` FOREIGN KEY (`billid`) REFERENCES `billmaster` (`billid`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `billmaster`
--
ALTER TABLE `billmaster`
  ADD CONSTRAINT `billmaster_ibfk_1` FOREIGN KEY (`custid`) REFERENCES `customer` (`custid`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
