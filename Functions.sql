USE IRON_GATE;
-- -- procedure

-- --To add likes 
Delimiter $
create procedure add_like(in project_num integer)
begin
	update PROJECT set likes = likes + 1 where Pnumber = project_num;
end $
Delimiter ;

-- --To add dislikes 
Delimiter $
create procedure add_dislike(in project_num integer)
begin
	update PROJECT set dislikes = dislikes + 1 where Pnumber = project_num;
end $
Delimiter ;


-- --#function

-- -- To count the number of project for each team
Delimiter $
create function NoProjects( TeamNumber int)returns int deterministic
begin
declare No_Projects int ;
	select count(Pnumber) into No_Projects from PROJECT where Team_Number = TeamNumber;
    return No_Projects;
end $
Delimiter ; 


-- -- To count the number of project for each course
Delimiter $
create function Count_Project(Course_code VARCHAR(10) )returns int deterministic
begin
declare No_Of_Project int;
	select count(CourseCode)into No_Of_Project from HAS where CourseCode=Course_code;
    return No_Of_Project;
end $
Delimiter ;
 
 
 -- -- To count the number of user for each type
 Delimiter $
create function Total_User(User_Type VARCHAR(25) )returns int deterministic
begin
declare No_Of_user int;
	select count(*)into No_Of_user from USERS where UserType=User_Type;
    return No_Of_user;
end $
Delimiter ;
-- drop function Total_User;

-- -- # trigger

-- -- To check the the email is valid or no 
Delimiter $
create trigger Add_Email before insert 
on USERS
for each row 
begin
if new.Email not like '%@%' then signal sqlstate '45000' set message_text="Email must contain @";
end if;
end $
Delimiter ;


-- -- To check the password is validor no 
Delimiter $
create trigger Add_pass before insert 
on USERS
for each row 
begin
if new.UPassword  not like '________%' then signal sqlstate '45000' set message_text="Pass must contain 8 Character";
end if;
end $
Delimiter ;

