CREATE DATABASE IRON_GATE;
USE IRON_GATE;

CREATE TABLE USERS(
	UserNameU VARCHAR(15) primary key,
	Major VARCHAR(20) not null,
	UPassword VARCHAR(15) not null ,
	Email VARCHAR(25) unique not null,
	NickName VARCHAR(25) not null,
	UserType VARCHAR(25) not null check ( UserType in ( 'User', 'Admin', 'Expert') ) default 'User',
    year_experience int null
    
);
# Admins
insert into USERS values('Naa887', 'CS', 'Nn111234', '2210003771@iau.edu.sa', 'Norah', 'Admin',null);
insert into USERS values('Masuma25', 'CS', 'MasumaMoh55', '2210003617@iau.edu.sa', 'Masuma', 'Admin',null);
insert into USERS values('Shahad22', 'CS', 'Sshh1112', '2200005154@iau.edu.sa', 'Shahad', 'Admin',null);
insert into USERS values('Nada66', 'CS', 'Nada63Dawod', '22100053638@iau.edu.sa', 'Nada', 'Admin',null);
insert into USERS values('Reem33', 'CS', 'ReemSari33', '2210003546@iau.edu.sa', 'Reem', 'Admin',null);
insert into USERS values('Munera55', 'CS', 'MunerAJalal30', '2210003530@iau.edu.sa', 'Muneera', 'Admin',null);

# Regular Users
insert into USERS values('NorahAly76', 'CS', 'Norah3738', 'NorahAlalyani@gmail.com', 'Norah Alalyani', 'User',null);
insert into USERS values('Lama88', 'CS', 'Lama##', 'Lama@gmail.com', 'Lama Alqahtani', 'User',null);
insert into USERS values('Manar78', 'CS', 'Manar93337', 'Manar@gmail.com', 'Manar Alkhabbaz', 'User',null);
insert into USERS values('NorahAlmut3', 'CS', 'NorahMut23', 'NorahAlmutairi@gmail.com', 'Norah Almutairi', 'User',null);
insert into USERS values('ManarMuh23', 'CS', 'manar373', 'Manar10@gmail.com', 'Manar ALbazboz', 'User',null);
insert into USERS values('Maryam8', 'CS', 'MaryamK89', 'Maryam@gmail.com', 'Maryam Kamel', 'User',null);
insert into USERS values('Shaikha90', 'CS', '@Shaikha', 'Shaikha@gmail.com', 'Shaikha Alqahtani', 'User',null);
insert into USERS values('Rawan48', 'CS', 'Rawan48#', 'Rawan@gmail.com', 'Rawan Almahdi ', 'User',null);
insert into USERS values('Razan299', 'CS', 'Razan4228', 'Razan@gmail.com', 'Razan Alqarni', 'User',null);
insert into USERS values('Asayel0', 'CS', 'Asayel009', 'Asayel@gmail.com', 'Asayel ALyami', 'User',null);
insert into USERS values('Bashayer32', 'CS', '*Bashayer37', 'Bashayer@gmail.com', 'Bashayer Allail', 'User',null);
insert into USERS values('Esraa6', 'CS', 'Esraa92', 'Esraa@gmail.com', 'Esraa Alyami', 'User',null);
insert into USERS values('Shaikha33', 'CS', '@Shaikha33@', 'Shaikha33@gmail.com', 'Shaikha Alhajri', 'User',null);
insert into USERS values('Norah10', 'CS', 'NorahMoh2', 'Norah111@gmail.com', 'Norah Mohammad', 'User',null);
insert into USERS values('Khadeja93', 'CS', 'Khadeja9399@', 'Khadeja@gmail.com', 'Khadeja Alahmar', 'User',null);
insert into USERS values('Maymonah20', 'CS', '#Maymonah4', 'Maymonah@gmail.com', 'Maymonah ALhamd', 'User',null);
insert into USERS values('Dema11', 'CS', 'De0201ma', 'Dema@gmail.com', 'Dema Alghamdi', 'User',null);
insert into USERS values('Norah_S', 'CS', 'Nn012300', 'NorahS@gmail.com', 'Norah Alsalhi', 'User',null);
insert into USERS values('Zainab_R', 'CS', 'Zz1188#cs', 'ZainabR@gmail.com', 'Zainab Alramadhan', 'User',null);
insert into USERS values('Maen', 'CS', 'Mm9911nn', 'Maen@gmail.com', 'Maen Alhammadi', 'User',null);

# Experts
insert into USERS values('Thowiba83', 'CS', 'Thowiba93337', 'teahmed@iau.edu.sa', 'Thowiba', 'Expert',18);
insert into USERS values('Reem27', 'CS', 'Reem38', 'ralshammari@iau.edu.sa', 'Reem', 'Expert',16);
insert into USERS values('Raja97', 'CS', 'Raja83', 'rhalyafer@iau.edu.sa', 'Raja', 'Expert',13);
insert into USERS values('Hind27', 'CS', 'Hind83', 'haaalssayed@iau.edu.sa', 'Hind', 'Expert',10);
insert into USERS values('Hessa990', 'CS', 'Hessa90', 'hssalmutairi@iau.edu.sa', 'Hessa', 'Expert',8);
insert into USERS values('Ezaz20', 'CS', 'Ezaz80', 'emaldahasi@iau.edu.sa', 'Ezaz', 'Expert',10);
insert into USERS values('Leen10', 'CS', 'Leen@112', 'leen@iau.edu.sa', 'Leen', 'Expert',6);

CREATE TABLE TEAM(
	SerialNumber INT primary key auto_increment,
	TeamName VARCHAR(25) unique not null
);
alter table TEAM auto_increment = 1;
insert into TEAM (TeamName) values('Geniuses');
insert into TEAM (TeamName) values('Group2');
insert into TEAM (TeamName) values('Shaikha Alqahtani\'s Team');
insert into TEAM (TeamName) values('Shaikha Alhajri\'s Team');
insert into TEAM (TeamName) values('Norah Mohammad\'s Team');
insert into TEAM (TeamName) values('Masuma\'s Team');
insert into TEAM (TeamName) values('Dema Alghamdi\'s Team');
insert into TEAM (TeamName) values('Shahad\'s Team');
insert into TEAM (TeamName) values('Group9');

# Team Members
CREATE TABLE CONSISTS_OF(
	SerialNumber INTEGER REFERENCES TEAM(SerialNumber),
	UserNameU VARCHAR(100) REFERENCES USERS(UserNameU)
);

insert into CONSISTS_OF values(1, 'naa887');
insert into CONSISTS_OF values(1, 'Masuma25');
insert into CONSISTS_OF values(1, 'Munera55');
insert into CONSISTS_OF values(1, 'Reem33');
insert into CONSISTS_OF values(1, 'Nada66');
insert into CONSISTS_OF values(1, 'Shahad22');

-- insert into CONSISTS_OF values(2,'NorahAly76');
-- insert into CONSISTS_OF values(2,'Manar78');
-- insert into CONSISTS_OF values(2,'NorahAlmut3');
-- insert into CONSISTS_OF values(2,'ManarMuh23');
-- insert into CONSISTS_OF values(2,'Maryam8');

insert into CONSISTS_OF values(3, 'Shaikha90');
insert into CONSISTS_OF values(3, 'Bashayer32');
insert into CONSISTS_OF values(3, 'Asayel0');
insert into CONSISTS_OF values(3, 'Razan299');
insert into CONSISTS_OF values(3, 'Rawan48');
insert into CONSISTS_OF values(3, 'Esraa6');

insert into CONSISTS_OF values(4, 'Shaikha33');
insert into CONSISTS_OF values(4, 'Norah10');

insert into CONSISTS_OF values(5, 'Norah10');
insert into CONSISTS_OF values(5, 'Naa887');
insert into CONSISTS_OF values(5, 'Lama88');

insert into CONSISTS_OF values(6, 'Masuma25');
insert into CONSISTS_OF values(6, 'ManarMuh23');
insert into CONSISTS_OF values(6, 'Khadeja93');
insert into CONSISTS_OF values(6, 'Maymonah20');

insert into CONSISTS_OF values(7, 'Dema11');
insert into CONSISTS_OF values(7, 'Shahad22');

insert into CONSISTS_OF values(8, 'Shahad22');
insert into CONSISTS_OF values(8, 'Norah_S');
insert into CONSISTS_OF values(8, 'Zainab_R');
insert into CONSISTS_OF values(8, 'Maen');


CREATE TABLE PROJECT(
	Pnumber INTEGER primary key auto_increment,
	Plevel VARCHAR(50) not null,
	ContactInfo VARCHAR(200) not null,
	CreationDate Date not null,
	Title VARCHAR(50) not null,
	Descripe VARCHAR(200) not null,
	UploadMethod VARCHAR(50) not null,
	Comments VARCHAR(200) null,
	Likes INTEGER not null default 0,
	DisLikes INTEGER not null default 0,
	User_Name VARCHAR(50) not null REFERENCES USERS(UserNameU),
	Team_Number int null REFERENCES TEAM(SerialNumber),
    Project_Type VARCHAR(20) not null check ( Project_Type in ( 'Course', 'Expert', 'Graduation') )
);
alter table PROJECT auto_increment = 1;

insert into PROJECT (Plevel, ContactInfo, CreationDate, Title, Descripe, UploadMethod, Comments, Likes, DisLikes, User_Name, Team_number,Project_Type) values('Intermediate', 'naa887@outlook.com', '2022-03-04', 'IRON GATE', 'Code hosting platform that serves students at the university in all faculties of all specialties and levels.', 'File', 'Great', 1 , 0, 'Shahad22', 1,'Course');
insert into PROJECT (Plevel, ContactInfo, CreationDate, Title, Descripe, UploadMethod, Comments, Likes, DisLikes, User_Name, Team_number,Project_Type) values('Simple', 'sh12@outlook.com', '2020-03-04', 'Delivery Service', 'Providing delivery services for customers and employees.', 'File', 'Excellent', 1, 0, 'Shahad22', 8,'Course');
insert into PROJECT (Plevel, ContactInfo, CreationDate, Title, Descripe, UploadMethod, Comments, Likes, DisLikes, User_Name, Team_number,Project_Type) values('Simple', '0550445037', '2019-05-09', 'Lamoda Salon', 'The idea of this project is to create a code to book beauty salon appointments', 'File', 'Excellent', 1, 0, 'Naa887', 5,'Course');
insert into PROJECT (Plevel, ContactInfo, CreationDate, Title, Descripe, UploadMethod, Comments, Likes, DisLikes, User_Name, Team_number,Project_Type) values('Simple', 'Twitter @GT22', '2019-06-02', 'Game Top', 'The site contains different types of games for more than one age group, where the users can choose the appropriate games for their age.', 'File', 'Very Good', 1, 0, 'Shahad22', 7,'Course');
insert into PROJECT (Plevel, ContactInfo, CreationDate, Title, Descripe, UploadMethod, Comments, Likes, DisLikes, User_Name, Team_number,Project_Type) values('Intermediate', 'Twitter @EDC1', '2019-06-02', 'ETHAR DONATING CENTER', 'Is a system provides to you Many ways to donate to those people in needs, Whether with money, food, or clothes.', 'File', 'Very Good', 1, 0, 'Masuma25', 6,'Course');
insert into PROJECT (Plevel, ContactInfo, CreationDate, Title, Descripe, UploadMethod, Comments, Likes, DisLikes, User_Name, Team_number,Project_Type) values('Simple', 'Twitter @BankSys', '2022-05-25', 'Bank System', ' A program that simulates automatic teller machines for depositing, withdrawing, and displaying accounts', 'File', 'Very Good', 1, 0, 'Masuma25', 6,'Course');
insert into PROJECT (Plevel, ContactInfo, CreationDate, Title, Descripe, UploadMethod, Comments, Likes, DisLikes, User_Name, Team_number,Project_Type) values('Intermediate', 'Email 2190003739@iau.edu.sa', '2019-05-25', 'Computer science club', 'Computer club website design', 'File', 'Very Good', 1, 0, 'Shaikha90', 3,'Course');
insert into PROJECT (Plevel, ContactInfo, CreationDate, Title, Descripe, UploadMethod, Comments, Likes, DisLikes, User_Name, Team_number,Project_Type) values('Intermediate', 'Email 2190003739@iau.edu.sa', '2019-08-20', 'Tawah restarurant', 'Rahima Restaurant website', 'File', 'Great', 1, 0, 'Shaikha90', 3,'Course');
insert into PROJECT (Plevel, ContactInfo, CreationDate, Title, Descripe, UploadMethod, Comments, Likes, DisLikes, User_Name, Team_number,Project_Type) values('Advanced', 'Email nouraxm11@gmail.com', '2020-03-13', 'Smart City model', 'Smart city model uses information and communication technology to improve operational efficiency in the future and provide a better one by using the Internet of Things', 'File', 'Good', 1, 0, 'Shaikha33', 4,'Course');
insert into PROJECT (Plevel, ContactInfo, CreationDate, Title, Descripe, UploadMethod, Comments, Likes, DisLikes, User_Name , Project_Type) values('Advanced', 'Email jdhf1@gmail.com', '2019-03-13', 'Smart airport system', 'Smart airport system', 'File', 'Very Good', 1, 0, 'Leen10', 'Expert');
insert into PROJECT (Plevel, ContactInfo, CreationDate, Title, Descripe, UploadMethod, Comments, Likes, DisLikes, User_Name , Project_Type) values('Advanced', 'Email jdhf1@gmail.com', '2023-01-4', 'Control system', 'Control the computer through voice', 'File', 'Great', 1, 0, 'Rawan48', 'Graduation');


CREATE TABLE Project_files(
Pnumber INTEGER REFERENCES PROJECT(Pnumber),
Title VARCHAR(50) REFERENCES PROJECT(Title),
Files longtext not null);


CREATE TABLE Project_Language(
	Pnumber INTEGER REFERENCES PROJECT(Pnumber),
    Prog_language VARCHAR(50)
);
insert into Project_Language values(1, 'Java');
insert into Project_Language values(1, 'MySQL');

insert into Project_Language values(2, 'C++');

insert into Project_Language values(3, 'C++');

insert into Project_Language values(4, 'HTML');
insert into Project_Language values(4, 'CSS');

insert into Project_Language values(5, 'Java');

insert into Project_Language values(6, 'C++');

insert into Project_Language values(7, 'Java');
insert into Project_Language values(7, 'MySQL');

insert into Project_Language values(8, 'PHP');
insert into Project_Language values(8, 'Javascript');

insert into Project_Language values(9, 'Python');


CREATE TABLE COURSE(
	CourseCode VARCHAR(10) primary key,
	CName VARCHAR(50) not null,
	Clevel INTEGER not null
);
insert into COURSE values('COMP121', 'Computer Applications', 3);
insert into COURSE values('CS211', 'Introduction to computing', 4);
insert into COURSE values('CS221', 'Fundamentals of programming', 5);
insert into COURSE values('CS311', 'Object Oriented Programming1', 7);
insert into COURSE values('CS321', 'Object Oriented Programming2', 8);
insert into COURSE values('CIS321', 'Data base', 8);
insert into COURSE values('CIS423', 'Web based systems', 10);

CREATE TABLE HAS(
	CourseCode VARCHAR(10) REFERENCES COURSE(CourseCode),
    Pnumber INTEGER REFERENCES PROJECT(Pnumber)
);
insert into HAS values('CS311', 1);
insert into HAS values('CIS321', 1);
insert into HAS values('CS221', 2);
insert into HAS values('CS221', 3);
insert into HAS values('COMP121', 4);
insert into HAS values('CS311', 5);
insert into HAS values('CS221', 6);
insert into HAS values('CS221', 7);
insert into HAS values('CIS321', 7);
insert into HAS values('CIS423', 8);
insert into HAS values('COMP121', 9);


CREATE TABLE EVALUATES(
	UserNameE VARCHAR(20) REFERENCES EXPERT(UserNameE),
	Pnumber INTEGER REFERENCES PROJECT(Pnumber)
);
insert into EVALUATES values('Thowiba83', 1);
insert into EVALUATES values('Reem27', 6);
insert into EVALUATES values('Raja97', 5);
insert into EVALUATES values('Hind27', 3);
insert into EVALUATES values('Hessa990', 7);
insert into EVALUATES values('Ezaz20', 1);

set @project_num = 3;

call add_like(@project_num); -- --To add likes 
call add_dislike(@project_num); -- --To add dislikes 


-- -- The information of team number 3
select * from PROJECT where team_number = 3; 

-- -- The information of shahad
select * from PROJECT where User_Name = 'Shahad22';

-- -- To display the number of project and name of tame foe specifict user 
select CONSISTS_OF.SerialNumber, TEAM.teamName from CONSISTS_OF, TEAM where UserNameU = 'Shahad22' and CONSISTS_OF.SerialNumber = TEAM.SerialNumber;

-- -- To show the project with order
select * from PROJECT order by likes desc;

-- -- To show the userse with alphabetic order
select * from USERS order by Nickname asc;




-- -- To desplay the project name with couse
create view project_prog as select PROJECT.title, Project_language.prog_language from PROJECT, Project_language where PROJECT.Pnumber = Project_language.Pnumber;

-- -- To desplay the project name with level
create view project_course as select PROJECT.title, HAS.CourseCode from PROJECT,HAS where PROJECT.Pnumber = HAS.Pnumber;

-- -- To desplay the project name with language
create view project_level as select title, Plevel from PROJECT;

-- --  To show the tame numbe with numbe rof project
select Team_Number, NoProjects(Team_Number) as NoProjects  from project group by Team_Number order by Team_Number;

-- -- To show the username , passowrd , type
select UserNameU,UPassword,UserType from users;

-- -- Function To count the number of project for each course
select CourseCode , Count_Project(CourseCode) as Count_Project  from HAS group by CourseCode having  Count_Project>=2 order by Count_Project desc;

 -- -- Function To count the number of user for each type
select UserType, Total_User(UserType) As No_Of_Users from USERS group by UserType;

-- -- To display the username and project that use c++ language
select User_Name,Title from PROJECT where exists(select Prog_language from Project_Language where Project_Language.Pnumber=PROJECT.Pnumber AND Prog_language='C++');

-- -- To show the year_experience of each expert
select UserNameU,year_experience from USERS where year_experience between 10 And 20 order by year_experience desc ;

-- -- To display all information for evaluates and project
select * from evaluates inner join PROJECT on PROJECT.Pnumber=evaluates.Pnumber;

-- -- To display the projects ( 'Expert' ,  'Graduation')
select Title , Project_Type from PROJECT where Project_Type in  ( 'Expert' ,  'Graduation');  


-- --test
DELETE from PROJECT where Pnumber = 9; 

