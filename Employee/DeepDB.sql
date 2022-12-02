create database DeepDB;
use DeepDB;
create table Student (  ID int primary key auto_increment, FirstName varchar(255) not null,  LastName varchar(255) not null, 
    Phone varchar(255) not null unique,
    Address varchar(255) not null,
    City varchar(255) not null ,
    Email varchar(255) not null unique,
    Qualification varchar(255), 
    Department varchar(255));
    #adding another column into thew table
    alter table Student add Age varchar(255);
    alter table Student add DateOfBirth varchar(255);
    # drop/ delete a a column
    alter table Student drop column Age;
    alter table Student drop column Department;
    # renaming the table
    alter table Student rename to Student_Details;
    #changing the data type of a column
    alter table Student_Details modify column DateOfBirth year;
    #inserting values 
    insert into Student_Details values ("1","Deep","Raj","9088527340","Kakdwip", "Kolkata", "deep@xyz",  "CSE", "24", 2000);
        insert into Student_Details values ("2","Dhiraj","Sen","9088527341","Kakdwip", "Kolkata", "raj@xyz",  "CSE", "24", 2000);
            insert into Student_Details values ("3","Arka","Roy","9088527342","Kakdwip", "Kolkata", "deep@mail",  "CSE", "24", 2000);
                insert into Student_Details values ("4","Dipak","Kumar","9088527343","Kakdwip", "Kolkata", "deep@gmail",  "CSE", "24", 2000);
                    insert into Student_Details values ("5","Debu","Podder","9088527344","Kakdwip", "Kolkata", "raj@hotmail",  "CSE", "24", 2000);
                        insert into Student_Details values ("6","Dakat","Sarkar","9088527345","Kakdwip", "Kolkata", "raj@mail",  "CSE", "24", 2000);
                            insert into Student_Details values ("7","Dhiman","Das","9088527346","Kakdwip", "Kolkata", "raj@gmail",  "CSE", "24", 2000);

    
    
						

