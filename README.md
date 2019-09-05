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

B) Implement a Java method that returns all the students in the school grouped
by the first letter of their last name.

Answer: 
    See the implementation in the StudentRepositoryImpl
    [https://github.com/Ezefalcon/School/blob/master/src/com/teracode/hiring/school/repository/StudentRepositoryImpl.java](https://github.com/Ezefalcon/School/blob/master/src/com/teracode/hiring/school/repository/StudentRepositoryImpl.java)
    
C) Implement a java method that returns all students taking a specific subject.
Please consider that the students cannot be repeated, this needs to be verified.

Answer: 
    This can be accomplished  using the DataStructure Set, it does not accept duplicates. It
    checks that every item inserted in the set is not equal to any of the items in 
    the already added ones, this is accomplished by the Equals and Hashcode methods.
    See the implementation in the StudentRepositoryImpl
    [https://github.com/Ezefalcon/School/blob/master/src/com/teracode/hiring/school/repository/StudentRepositoryImpl.java](https://github.com/Ezefalcon/School/blob/master/src/com/teracode/hiring/school/repository/StudentRepositoryImpl.java)

D) Create at least two different database table structure diagrams to describe the
possible ways that the domain could be translated to the database. Explain
pros and cons of each structure.


In this first approach, the principal and janitor have a 1 to 1 relation with employee,
the student has a many to many relation with the subject. A student can have many subjects
and a subject many students.

Pros:

    - Scalability to add different types of employees
    
Cons:

    - Create a different table for every type of employee
![alt text](https://gyazo.com/48d633c93292d547115a7da5740e8b95.png)