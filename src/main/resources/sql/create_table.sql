USE kansyoku_kiroku;

CREATE TABLE user(
	user_id int(11) PRIMARY KEY AUTO_INCREMENT,
	user_name VARCHAR(32) NOT NULL,
	email VARCHAR(255) NOT NULL,
	password VARCHAR(16) NOT NULL
);

CREATE TABLE menu(
	user_id int(11) NOT NULL,
	menu_id int(11) PRIMARY KEY AUTO_INCREMENT,
	menu_name VARCHAR(100) NOT NULL,
	price int(11) NOT NULL,
	kcal int(5) NOT NULL,
	shop VARCHAR(100),
	memo VARCHAR(100),
	created_date date NOT NULL
);