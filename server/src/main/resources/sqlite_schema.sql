--
-- Table structure for table `Address` generated from model 'Address'
--

CREATE TABLE IF NOT EXISTS `Address` (
  `id` INT DEFAULT NULL,
  `city` TEXT DEFAULT NULL,
  `housenumber` INT DEFAULT NULL,
  `street` TEXT DEFAULT NULL
);

--
-- Table structure for table `Meal` generated from model 'Meal'
--

CREATE TABLE IF NOT EXISTS `Meal` (
  `id` INT DEFAULT NULL,
  `restaurantID` INT DEFAULT NULL,
  `img` TEXT DEFAULT NULL,
  `name` TEXT DEFAULT NULL,
  `price` TEXT DEFAULT NULL
);

--
-- Table structure for table `Order` generated from model 'Order'
--

CREATE TABLE IF NOT EXISTS `Order` (
  `id` INT DEFAULT NULL,
  `mealID` INT DEFAULT NULL,
  `numItems` INT DEFAULT NULL
);

--
-- Table structure for table `Restaurant` generated from model 'Restaurant'
--

CREATE TABLE IF NOT EXISTS `Restaurant` (
  `id` INT DEFAULT NULL,
  `ownerID` INT DEFAULT NULL,
  `img` TEXT DEFAULT NULL,
  `meals` JSON DEFAULT NULL,
  `name` TEXT DEFAULT NULL
);

--
-- Table structure for table `User` generated from model 'User'
--

CREATE TABLE IF NOT EXISTS `User` (
  `addresses` JSON DEFAULT NULL,
  `email` TEXT DEFAULT NULL,
  `firstname` TEXT DEFAULT NULL,
  `id` INT DEFAULT NULL,
  `lastname` TEXT DEFAULT NULL,
  `password` TEXT DEFAULT NULL,
  `phone` TEXT DEFAULT NULL,
  `username` TEXT DEFAULT NULL,
  `isRestaurantOwner` TINYINT(1) DEFAULT NULL,
  `ownedRestaurants` JSON DEFAULT NULL
);
