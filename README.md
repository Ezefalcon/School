# School

A) Considering the structure of a school, create the diagram that describes the
domain model and relationship between entities. Some of the possible entities
may be Principal, Employee, Student and Janitor. Try to apply the concepts of
Hierarchy, Abstract Class and Interface.

Answer:

    This is the diagram, this could be a possibility of the model, assuming 
    the Principal and the Janitor have a different behavior or attributes 
    from Employee. If they don't have a different behavior it can be done by 
    just adding a rol attribute to the Employee class.
    
![alt text](https://i.gyazo.com/36e97d0b6bd2f9ec9a87fcf29e2d0edd.png)

----
B) Implement a Java method that returns all the students in the school grouped
by the first letter of their last name.

Answer: 

    See the implementation in the StudentRepositoryImpl

[https://github.com/Ezefalcon/School/blob/master/src/com/teracode/hiring/school/repository/StudentRepositoryImpl.java](https://github.com/Ezefalcon/School/blob/master/src/com/teracode/hiring/school/repository/StudentRepositoryImpl.java)
    
----
C) Implement a java method that returns all students taking a specific subject.
Please consider that the students cannot be repeated, this needs to be verified.

Answer: 

    This can be accomplished  using the DataStructure Set, it does not accept duplicates. It
    checks that every item inserted in the set is not equal to any of the items in 
    the already added ones, this is accomplished by the Equals and Hashcode methods.
    See the implementation in the StudentRepositoryImpl
    [https://github.com/Ezefalcon/School/blob/master/src/com/teracode/hiring/school/repository/StudentRepositoryImpl.java](https://github.com/Ezefalcon/School/blob/master/src/com/teracode/hiring/school/repository/StudentRepositoryImpl.java)

----
D) Create at least two different database table structure diagrams to describe the
possible ways that the domain could be translated to the database. Explain
pros and cons of each structure.

Answer:

![alt text](https://gyazo.com/48d633c93292d547115a7da5740e8b95.png)

In this first approach, the principal and janitor have a 1 to 1 relation with employee,
the student has a many to many relation with the subject. A student can have many subjects
and a subject many students.

Pros:

    - Scalability to add different types of employees
    
Cons:

    - Create a different table for every type of employee
    
----
![alt text](https://gyazo.com/ca3cd8b4f7e8fdfa3ead14cc43616fbc.png)

In the second approach, I removed the person table, and made the attributes part of 
employee and student. There is a problem with this structure, let's say we want to add
the parents of the students, we will need to create another table with almost the same attributes
as employee or student.

Pros:

    - Less joins

Cons:

    - Less scalability, if we want to add another type of "person" we will need to add 
    those attributes to every class.
    
----
E)Having the following query:

    SELECT * FROM janitor j
        INNER JOIN employee e
        ON e.id = j.id
        INNTER JOIN p.id = j.id
        ON p.id = j.id
    WHERE j.workingArea = 'Hallway';

Our query is taking too long to respond. What changes would you do to the query
and/or the database to make it go faster if we only need the first and last name of
the janitor?

Answer:

    If we only need the first and last name, it will be useless to get all the 
    attributes from those tables, we can select only the lastName and firstName 
    from the db.
    
    SELECT * FROM janitor j
        INNER JOIN employee e
        ON e.id = j.id
        INNTER JOIN p.id = j.id
        ON p.id = j.id
    WHERE j.workingArea = 'Hallway';
    
----
F) Consider that we have a query that joins many tables and takes too long to
return the values. We know as a fact that the tables involved do not update
too often, but we still use this query many times in a day (consider it a report).
What would you do to be able to get these results faster?

Answer:

    If we don't need to update or insert we can create an Index in the database, 
    this will create a pointer to the data, so the database can access to it faster. 
    
----
G) Using the model create a query that returns all the students with age between
19 and 21. Take into account that the age is not a column on the table, we have
a field for birth date. How would you optimize this query?

Answer:

    In postgreSQL:
    SELECT * FROM students s WHERE
    EXTRACT(YEAR FROM age(s.fecha_nacimiento)) > 18

----
H) We need to build a new application and we want to be able to have the
   business logic on the database engine instead of having it in our Java code. Can
   you suggest a way of doing this? As an example, how would you persist a
   student? What are the pros and cons of this?
   
Answer:

       The database can have functions and triggers in the database that can help you 
       accomplish this requirement.
       You can persist an student the same way we used to.
       INSERT INTO student (first_name, last_name, birth_date)
       VALUES ("Name", "LastName", "1990-02-07");
       We can have a TRIGGER or constraints that checks the inserted values.
   
Pros:
    
    - Business logic in a single application

Cons: 

    - It may affect the performance of the database
    

----
Exercise 2:

A) Create the domain model diagram with all the possible entities, its attributes
and relationships

Answer:

![alt text](https://gyazo.com/900443c70e18097b79ec58fde1740fc8.png)
    
    A simple user entity, a room, responsible of how a meet is created, updated
    or removed. And meet with a start and end, with an organizer user and a list 
    of participants.
    
----
B) Deliver diagrams of the user interface for each step of a booking process.

    See the simple layout on
[https://ezefalcon.github.io/School/BookingLayout/index.html](https://ezefalcon.github.io/School/BookingLayout/index.html)
    
    First of all, you have to login, in this example you are already logged in 
    as User. Now go to Bookings in the navbar.
    
[https://ezefalcon.github.io/School/BookingLayout/bookings.html](https://ezefalcon.github.io/School/BookingLayout/bookings.html)

    You can book a meeting filling the inputs, with this we can generate a payload
    (the organizer will be the logged user) and post to an endpoint in an api.
    
    Example of the payload in JSON:
    
    {
      "name":"room1",
      "participants": {
        "username": "Juan",
        "username": "John"
      },
      "start": "07/02/2019 16:00:00",
      "end": "07/02/2019 17:00:00"
    }
    
----
C) Considering that meetings cannot last less than 15 minutes and more than 3
hours, also meetings cannot overlap with each other in the same room, deliver
the validation method that is in charge to verify these rules.

Answer:

    See the implemented methods in the Room model.
[https://github.com/Ezefalcon/School/blob/master/src/com/teracode/hiring/bookings/model/Room.java](https://github.com/Ezefalcon/School/blob/master/src/com/teracode/hiring/bookings/model/Room.java)
