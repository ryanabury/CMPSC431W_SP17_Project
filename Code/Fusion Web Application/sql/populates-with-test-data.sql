USE fusion;

INSERT INTO `users` (`reg_id`,`email`,`active`,`username`,`first_name`,`last_name`,`password`,`age`,`phone_num`,`gender`,`annual_salary`) VALUES ('0','ewr5183@psu.edu',0,'ewr5183','Ethan','Raymond','epassword',22,'5555555555','m',10000);
INSERT INTO `users` (`reg_id`,`email`,`active`,`username`,`first_name`,`last_name`,`password`,`age`,`phone_num`,`gender`,`annual_salary`) VALUES ('1','cod5198@psu.edu',0,'cod5198','Colin','Dematt','codpass',22,'5555555555','m',10000);
INSERT INTO `users` (`reg_id`,`email`,`active`,`username`,`first_name`,`last_name`,`password`,`age`,`phone_num`,`gender`,`annual_salary`) VALUES ('2','rab5802@psu.edu',0,'rab5802','Ryan','Bury','rburypass',22,'5555555555','m',10000);
INSERT INTO `users` (`reg_id`,`email`,`active`,`username`,`first_name`,`last_name`,`password`,`age`,`phone_num`,`gender`,`annual_salary`) VALUES ('3','jxd5473@psu.edu',0,'jxd5473','Jacob','Deshaies','jxdpass',22,'5555555555','m',10000);
INSERT INTO `users` (`reg_id`,`email`,`active`,`username`,`first_name`,`last_name`,`password`,`age`,`phone_num`,`gender`,`annual_salary`) VALUES ('4','cld5460@psu.edu',0,'cld5460','Connor','Dougherty','cldpass',22,'5555555555','m',10000);

INSERT INTO `suppliers` (`supplier_id`,`company_name`,`password`,`category`,`yearly_revenue`,`url_ext`,`banner_img`,`about_description`) VALUES (0,'Buy-N-Large','bnlpass','131',1000000,NULL,NULL,'We sell lots of stuff!');
INSERT INTO `suppliers` (`supplier_id`,`company_name`,`password`,`category`,`yearly_revenue`,`url_ext`,`banner_img`,`about_description`) VALUES (1,'Yoda\'s Discount Store','ydspass','270',500,NULL,NULL,'Good prices we have!');
INSERT INTO `suppliers` (`supplier_id`,`company_name`,`password`,`category`,`yearly_revenue`,`url_ext`,`banner_img`,`about_description`) VALUES (2,'Best Buy','bbpass','1',10000000,NULL,NULL,NULL);
