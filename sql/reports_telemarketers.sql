CREATE TABLE reports_telemarketers(
    	report_id varchar(20),
    	first_name varchar(20),
    	last_name varchar(20),
    	phone int(9),
    	age int,
    	gender varchar(1),
    	annual_income DECIMAL,
    	register_id varchar(20),
    	PRIMARY KEY(report_id),
    	FOREIGN KEY(register_id) REFERENCES reg_user(register_id)
)