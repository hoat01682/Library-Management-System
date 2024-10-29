-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               8.0.39 - MySQL Community Server - GPL
-- Server OS:                    Win64
-- HeidiSQL Version:             12.8.0.6908
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for library_management
CREATE DATABASE IF NOT EXISTS `library_management` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `library_management`;

-- Dumping structure for table library_management.account
CREATE TABLE IF NOT EXISTS `account` (
  `account_id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(255) NOT NULL,
  `permission_id` int NOT NULL,
  `status` enum('Đang hoạt động','Ngừng hoạt động') NOT NULL,
  `staff_id` int DEFAULT NULL,
  PRIMARY KEY (`account_id`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  KEY `fk_permission_idx` (`permission_id`),
  KEY `fk_account_staff_id` (`staff_id`),
  CONSTRAINT `fk_account_staff_id` FOREIGN KEY (`staff_id`) REFERENCES `staff` (`staff_id`),
  CONSTRAINT `fk_permission_id` FOREIGN KEY (`permission_id`) REFERENCES `permission` (`permission_id`),
  CONSTRAINT `fk_staff_staff_id` FOREIGN KEY (`account_id`) REFERENCES `staff` (`staff_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table library_management.account: ~3 rows (approximately)
INSERT INTO `account` (`account_id`, `username`, `password`, `permission_id`, `status`, `staff_id`) VALUES
	(1, 'admin', '12345', 1, 'Đang hoạt động', 1),
	(2, 'staff1', '12345', 2, 'Đang hoạt động', 1),
	(3, 'staff2', '12345', 3, 'Ngừng hoạt động', 2);

-- Dumping structure for table library_management.book
CREATE TABLE IF NOT EXISTS `book` (
  `book_id` varchar(255) NOT NULL,
  `title` varchar(255) NOT NULL,
  `author` varchar(255) NOT NULL,
  `publisher_id` int NOT NULL,
  `year_publish` int NOT NULL,
  `category_id` int NOT NULL,
  `quantity` int NOT NULL,
  PRIMARY KEY (`book_id`),
  KEY `fk_publisher_publisher_id_idx` (`publisher_id`),
  KEY `fk_category_category_id_idx` (`category_id`),
  CONSTRAINT `fk_category_category_id` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`),
  CONSTRAINT `fk_publisher_publisher_id` FOREIGN KEY (`publisher_id`) REFERENCES `publisher` (`publisher_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table library_management.book: ~0 rows (approximately)

-- Dumping structure for table library_management.bookitem
CREATE TABLE IF NOT EXISTS `bookitem` (
  `isbn` varchar(20) NOT NULL,
  `book_id` varchar(255) DEFAULT NULL,
  `purchaseticket_id` varchar(20) NOT NULL,
  `bookshelf_id` int DEFAULT NULL,
  `status` enum('Có sẵn','Đang mượn','Hư hỏng','Mất') NOT NULL,
  `add_date` date NOT NULL,
  PRIMARY KEY (`isbn`),
  KEY `fk_bookshelf_id_idx` (`bookshelf_id`),
  KEY `fk_purchaseticket_bookitem_id_idx` (`purchaseticket_id`),
  KEY `fk_book_id_idx` (`book_id`),
  CONSTRAINT `fk_bookitem_book_id` FOREIGN KEY (`book_id`) REFERENCES `book` (`book_id`),
  CONSTRAINT `fk_bookshelf_id` FOREIGN KEY (`bookshelf_id`) REFERENCES `bookshelf` (`bookshelf_id`),
  CONSTRAINT `fk_purchaseticket_bookitem_id` FOREIGN KEY (`purchaseticket_id`) REFERENCES `purchaseticket` (`purchase_ticket_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table library_management.bookitem: ~0 rows (approximately)

-- Dumping structure for table library_management.bookshelf
CREATE TABLE IF NOT EXISTS `bookshelf` (
  `bookshelf_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `capacity` int NOT NULL,
  PRIMARY KEY (`bookshelf_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table library_management.bookshelf: ~0 rows (approximately)

-- Dumping structure for table library_management.borrowticket
CREATE TABLE IF NOT EXISTS `borrowticket` (
  `borrow_ticket_id` varchar(20) NOT NULL,
  `staff_id` int NOT NULL,
  `member_id` int NOT NULL,
  `borrow_date` date NOT NULL,
  `due_date` date NOT NULL,
  `status` enum('Chưa trả','Đã trả') NOT NULL,
  PRIMARY KEY (`borrow_ticket_id`),
  KEY `staff_id_idx` (`staff_id`),
  KEY `member_id_idx` (`member_id`),
  CONSTRAINT `fk_member` FOREIGN KEY (`member_id`) REFERENCES `member` (`member_id`),
  CONSTRAINT `fk_staff` FOREIGN KEY (`staff_id`) REFERENCES `staff` (`staff_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table library_management.borrowticket: ~0 rows (approximately)

-- Dumping structure for table library_management.borrowticket_details
CREATE TABLE IF NOT EXISTS `borrowticket_details` (
  `borrow_ticket_details_id` int NOT NULL AUTO_INCREMENT,
  `borrow_ticket_id` varchar(20) NOT NULL,
  `isbn` varchar(20) NOT NULL,
  PRIMARY KEY (`borrow_ticket_details_id`),
  KEY `fk_borrowticket_id_idx` (`borrow_ticket_id`),
  KEY `fk_borrowticket_bookitem_id_idx` (`isbn`),
  CONSTRAINT `fk_borrowticket` FOREIGN KEY (`borrow_ticket_id`) REFERENCES `borrowticket` (`borrow_ticket_id`),
  CONSTRAINT `fk_borrowticket_bookitem_id` FOREIGN KEY (`isbn`) REFERENCES `bookitem` (`isbn`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table library_management.borrowticket_details: ~0 rows (approximately)

-- Dumping structure for table library_management.category
CREATE TABLE IF NOT EXISTS `category` (
  `category_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table library_management.category: ~0 rows (approximately)

-- Dumping structure for table library_management.function
CREATE TABLE IF NOT EXISTS `function` (
  `function_id` varchar(45) NOT NULL,
  `function_name` varchar(255) NOT NULL,
  PRIMARY KEY (`function_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table library_management.function: ~10 rows (approximately)
INSERT INTO `function` (`function_id`, `function_name`) VALUES
	('1', 'Quản lý sách'),
	('10', 'Thống kê'),
	('2', 'Quản lý mượn sách'),
	('3', 'Quản lý trả sách'),
	('4', 'Quản lý nhập sách'),
	('5', 'Quản lý nhân viên'),
	('6', 'Quản lý thành viên'),
	('7', 'Quản lý tài khoản'),
	('8', 'Quản lý vi phạm'),
	('9', 'Quản lý phân quyền');

-- Dumping structure for table library_management.member
CREATE TABLE IF NOT EXISTS `member` (
  `member_id` int NOT NULL AUTO_INCREMENT,
  `full_name` varchar(255) NOT NULL,
  `phone` varchar(10) NOT NULL,
  `address` varchar(255) NOT NULL,
  `membership_date` date NOT NULL,
  `status` enum('Đang hoạt động','Ngừng hoạt động') NOT NULL,
  `violationCount` int NOT NULL,
  PRIMARY KEY (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table library_management.member: ~0 rows (approximately)

-- Dumping structure for table library_management.penalty
CREATE TABLE IF NOT EXISTS `penalty` (
  `penalty_id` int NOT NULL AUTO_INCREMENT,
  `penalty_name` varchar(45) NOT NULL,
  `amount` decimal(10,2) NOT NULL,
  PRIMARY KEY (`penalty_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table library_management.penalty: ~0 rows (approximately)

-- Dumping structure for table library_management.penaltyticket
CREATE TABLE IF NOT EXISTS `penaltyticket` (
  `penalty_ticket_id` varchar(20) NOT NULL,
  `member_id` int NOT NULL,
  `staff_id` int NOT NULL,
  `penalty_id` int NOT NULL,
  `penalty_date` date NOT NULL,
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`penalty_ticket_id`),
  KEY `fk_mem_id_idx` (`member_id`),
  KEY `fk_staff_id_idx` (`staff_id`),
  KEY `fk_penalty_idx` (`penalty_id`),
  CONSTRAINT `fk_mem_id` FOREIGN KEY (`member_id`) REFERENCES `member` (`member_id`),
  CONSTRAINT `fk_penalty` FOREIGN KEY (`penalty_id`) REFERENCES `penalty` (`penalty_id`),
  CONSTRAINT `fk_staff_penticket` FOREIGN KEY (`staff_id`) REFERENCES `staff` (`staff_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table library_management.penaltyticket: ~0 rows (approximately)

-- Dumping structure for table library_management.permission
CREATE TABLE IF NOT EXISTS `permission` (
  `permission_id` int NOT NULL AUTO_INCREMENT,
  `permission_name` varchar(50) NOT NULL,
  PRIMARY KEY (`permission_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table library_management.permission: ~3 rows (approximately)
INSERT INTO `permission` (`permission_id`, `permission_name`) VALUES
	(1, 'Admin'),
	(2, 'Nhân viên thủ thư'),
	(3, 'Nhân viên nhập hàng');

-- Dumping structure for table library_management.permission_details
CREATE TABLE IF NOT EXISTS `permission_details` (
  `permission_id` int NOT NULL,
  `function_id` varchar(45) NOT NULL,
  `action` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`permission_id`,`function_id`),
  KEY `fk_function_idx` (`function_id`),
  CONSTRAINT `fk_function` FOREIGN KEY (`function_id`) REFERENCES `function` (`function_id`),
  CONSTRAINT `fk_permission` FOREIGN KEY (`permission_id`) REFERENCES `permission` (`permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table library_management.permission_details: ~0 rows (approximately)

-- Dumping structure for table library_management.publisher
CREATE TABLE IF NOT EXISTS `publisher` (
  `publisher_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `phone` varchar(10) NOT NULL,
  PRIMARY KEY (`publisher_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table library_management.publisher: ~0 rows (approximately)

-- Dumping structure for table library_management.purchaseticket
CREATE TABLE IF NOT EXISTS `purchaseticket` (
  `purchase_ticket_id` varchar(20) NOT NULL,
  `supplier_id` int NOT NULL,
  `staff_id` int NOT NULL,
  `purchase_date` date NOT NULL,
  `status` enum('Hoàn thành','Hủy') NOT NULL,
  PRIMARY KEY (`purchase_ticket_id`),
  KEY `fk_supplier_supplier_id_idx` (`supplier_id`),
  KEY `fk_staff_id_pt_id_idx` (`staff_id`),
  CONSTRAINT `fk_staff_id_pt_id` FOREIGN KEY (`staff_id`) REFERENCES `staff` (`staff_id`),
  CONSTRAINT `fk_supplier_supplier_id` FOREIGN KEY (`supplier_id`) REFERENCES `supplier` (`supplier_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table library_management.purchaseticket: ~0 rows (approximately)

-- Dumping structure for table library_management.purchaseticket_details
CREATE TABLE IF NOT EXISTS `purchaseticket_details` (
  `purchase_ticket_details_id` int NOT NULL AUTO_INCREMENT,
  `purchase_ticket_id` varchar(20) NOT NULL,
  `isbn` varchar(20) NOT NULL,
  `quantity` int NOT NULL,
  PRIMARY KEY (`purchase_ticket_details_id`),
  KEY `fk_purchaseticket_idx` (`purchase_ticket_id`),
  KEY `fk_isbn_bookitem_idx` (`isbn`),
  CONSTRAINT `fk_isbn_bookitem` FOREIGN KEY (`isbn`) REFERENCES `bookitem` (`isbn`),
  CONSTRAINT `fk_purchaseticket` FOREIGN KEY (`purchase_ticket_id`) REFERENCES `purchaseticket` (`purchase_ticket_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table library_management.purchaseticket_details: ~0 rows (approximately)

-- Dumping structure for table library_management.returnticket
CREATE TABLE IF NOT EXISTS `returnticket` (
  `return_ticket_id` varchar(20) NOT NULL,
  `borrow_ticket_id` varchar(20) NOT NULL,
  `staff_id` int NOT NULL,
  `return_date` date NOT NULL,
  `status` enum('Hoàn thành','Hủy') NOT NULL,
  PRIMARY KEY (`return_ticket_id`),
  KEY `staff_id_idx` (`staff_id`),
  KEY `fk_borrow_ticket_id_idx` (`borrow_ticket_id`),
  CONSTRAINT `fk_borrowticket_id` FOREIGN KEY (`borrow_ticket_id`) REFERENCES `borrowticket` (`borrow_ticket_id`),
  CONSTRAINT `fk_staff_id` FOREIGN KEY (`staff_id`) REFERENCES `staff` (`staff_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table library_management.returnticket: ~0 rows (approximately)

-- Dumping structure for table library_management.returnticket_details
CREATE TABLE IF NOT EXISTS `returnticket_details` (
  `return_ticket_details_id` int NOT NULL AUTO_INCREMENT,
  `return_ticket_id` varchar(20) NOT NULL,
  `isbn` varchar(20) NOT NULL,
  PRIMARY KEY (`return_ticket_details_id`),
  KEY `fk_return_idx` (`return_ticket_id`),
  KEY `fk_returnticket_bookitem_id_idx` (`isbn`),
  CONSTRAINT `fk_return` FOREIGN KEY (`return_ticket_id`) REFERENCES `returnticket` (`return_ticket_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table library_management.returnticket_details: ~0 rows (approximately)

-- Dumping structure for table library_management.staff
CREATE TABLE IF NOT EXISTS `staff` (
  `staff_id` int NOT NULL AUTO_INCREMENT,
  `full_name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `phone` varchar(10) NOT NULL,
  `address` varchar(255) NOT NULL,
  `hire_date` date NOT NULL,
  `status` enum('Đang làm việc','Đã nghỉ việc') NOT NULL,
  PRIMARY KEY (`staff_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table library_management.staff: ~3 rows (approximately)
INSERT INTO `staff` (`staff_id`, `full_name`, `email`, `phone`, `address`, `hire_date`, `status`) VALUES
	(1, 'Nguyễn Văn A', 'a.nguyen@example.com', '0123456789', 'Hà Nội', '2023-01-01', 'Đang làm việc'),
	(2, 'Trần Thị B', 'b.tran@example.com', '0987654321', 'Hồ Chí Minh', '2023-01-15', 'Đang làm việc'),
	(3, 'Lê Văn C', 'c.le@example.com', '0112233445', 'Đà Nẵng', '2023-02-01', 'Đã nghỉ việc');

-- Dumping structure for table library_management.supplier
CREATE TABLE IF NOT EXISTS `supplier` (
  `supplier_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `phone` varchar(10) NOT NULL,
  PRIMARY KEY (`supplier_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table library_management.supplier: ~0 rows (approximately)

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
