# MarathonRaceApp
Final Project: Marathon race runners
User Story: A sports company has hired you to write an application that would simulate a
marathon race between interesting groups of participants. They could be slow as a tortoise, as
fast as a hare, and anything in between. The runners differ in their speed and how often they need
to rest. Some may be slow and never rest; others may run fast but lose steam quickly and rest a
lot of the time. Still others could be anything in between.

Requirement
1. Write an object oriented Java program to fulfill above requirement. You need to identify the
classes and their hierarchies. You should also have proper interfaces identified, which
mandates all the required behaviors as described in the problem domain. Provide an
application (user) class as well, which uses these classes to complete the user interaction.
Your program needs to be idiot proof as well. Meaning, you need to validate the user data,
command line arguments etc.
2. Runners Information: The runner’s information will come from one of the input sources.
Your program is capable of reading runners data from:
a. A text File
b. A XML file
c. A derby database (rdbms), or
d. Hard coded default data for two runners
3. You need to provide all four interfaces in the program. The user of your program is free to
use either data source. When program starts, show a menu for the data source to choose
from. User will select one of the choices and provide the name of the data source. You will
read all the runners data from data source and run the race for that many runners. You can
assume that number of runners are unknown, however, it will not exceed 5 runners.
4. In case of default runners, there are only two runners, Tortoise and Hare. You can hard code
these values for them and run the race:
RunnersName RunnersSpeed RestPercentage
Tortoise 10 0
Hare 100 90

5. An example FinalXMLData.xml could look like this, use same element, and attribute names
<?xml version="1.0" encoding="UTF-8"?>
<Runners>
<Runner Name="Tortoise">
<RunnersMoveIncrement>10</RunnersMoveIncrement>
<RestPercentage>0</RestPercentage>
</Runner>
<Runner Name="Hare">
<RunnersMoveIncrement>100</RunnersMoveIncrement>
<RestPercentage>90</RestPercentage>
</Runner>
<Runner Name="Dog">
<RunnersMoveIncrement>50</RunnersMoveIncrement>
<RestPercentage>70</RestPercentage>
</Runner>
<Runner Name="Cat">
<RunnersMoveIncrement>30</RunnersMoveIncrement>
<RestPercentage>75</RestPercentage>
</Runner>
</Runners>

6. An example FinalTextData.txt could look like this:
Tortoise 10 0
Hare 100 90
Dog 50 40
Cat 30 75
7. Create a suitable RunnersDB Derby database as well. The database has only one table
RunnersStats with three fields: Name (VARCHAR(20)), RunnersSpeed (DOUBLE),
RestPercentage(DOUBLE). Write a JDBC interface to read the data from this database.
8. Write JavaDoc comments for all of your interfaces, classes, and methods. Generate a
JavaDoc as well.
9. You should name your Java project <YourName>_JavaCompFinal. For me the name of the
project will be BineetSharma_JavaCompFinal.
10. Create an Eclipse zip file following the document How To Package Your Final.pdf
