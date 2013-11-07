CREATE TABLE IF NOT EXISTS `Account` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `userid` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `userid` (`userid`)
);

INSERT INTO `Account` (`id`, `userid`,`password`, `email`) VALUES
(1, 'june', 'aaa123', 'june@hotmail.com'),
(2, 'kenny', 'aaa123', 'kenny@hotmail.com');

CREATE TABLE IF NOT EXISTS `user` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
);

INSERT INTO `user` (`id`, `password`, `username`, `email`) VALUES
(1, '21232f297a57a5a743894a0e4a801fc3', 'john', 'kenn@hotmail.com'),
(2, 'ee11cbb19052e40b07aac0ca060c23ee', 'jane', 'jeff@hotmail.com'),
(3, 'xdhhjkd', 'mike', 'mike@hotmail.com'),
(4, 'zvksdfm', 'alice', 'alice@hotmail.com'),
(5, 'xmnogpd', 'nancy', 'nacny@hotmail.com'),
(6, 'mvbnko', 'jeff', 'kekn@hotmail.com'),
(7, 'mnhtiep', 'betty', 'betty@hotmail.com'),
(8, 'trrtyur', 'johnny', 'johny@hotmail.com');

CREATE TABLE IF NOT EXISTS `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role` int(11) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
);

INSERT INTO `role` (`id`, `role`, `user_id`) VALUES
(1, 1, 1),
(2, 2, 2),
(3, 1, 3),
(4, 1, 4),
(5, 2, 5),
(6, 1, 6),
(7, 2, 7),
(8, 1, 8);
