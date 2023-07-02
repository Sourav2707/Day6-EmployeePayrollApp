create database payroll_db;
create user 'payrolluser'@'%' identified by 'password';
grant all on payroll_db.* to 'payrolluser'@'%';