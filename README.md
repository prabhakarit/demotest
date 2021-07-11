# Test Data Reporter

</BR>
<b>Please note</b>
</BR>
<ul>
<li>Update samples under /resources/testdata/sample1...</li>
<li>Under any sample folder need to have 2 files, 1) csv format definition json and 2) csv data file</li>
<li>To Add new sample folders. <br/>Update sample folder name in <a href="https://github.com/prabhakarit/demotest/blob/master/src/main/java/com/Application.java">Application</a> </li>
<li>How to build ?, run ./mvnw spring-boot:run</li>
</ul>

</BR></BR>

<b>Please find the coding exercise below :</b>
</BR>
Input : 
</BR>
"Given a string with the following data (it includes multiple lines):
</BR>
2343225,2345,us_east,RedTeam,ProjectApple,3445s
</BR>
1223456,2345,us_west,BlueTeam,ProjectBanana,2211s
</BR>
3244332,2346,eu_west,YellowTeam3,ProjectCarrot,4322s
</BR>
1233456,2345,us_west,BlueTeam,ProjectDate,2221s
</BR>
3244132,2346,eu_west,YellowTeam3,ProjectEgg,4122s
</BR>
</BR>
Structure : </BR>
The data is organized into columns delimited by a comma(,) in the following order:</BR>
customerId,contractId,geozone,teamcode,projectcode,buildduration</BR>
Interpretation :</BR>
The first line of data would then be interpreted as</BR>
  2343225 is the customerId</BR>
  2345 is the contractId</BR>
  us_east is the geozone</BR>
  RedTeam is the teamcode</BR>
  ProjectApple is the projectcode</BR>
  3445s is the buildduration</BR>
Outcome :</BR>
Using one of the following programming languages - JAVA/JAVA8, write code that takes </BR>the entire multiline string and produces a report containing the following:</BR>
  The number of unique customerId for each contractId.</BR>
  The number of unique customerId for each geozone.</BR>
  The average buildduration for each geozone.</BR>
  The list of unique customerId for each geozone."</BR>
 </BR></BR>
Please consider the following guidelines in your code</BR>
1.       &emsp;Create a properly structured code for ex. eclipse or IntelliJ based</BR>
2.       &emsp;Proper Naming of the classes</BR>
3.       &emsp;Documenting what is the purpose of the classes</BR>
4.       &emsp;Clean code.</BR>
5.       &emsp;Design Patterns.</BR>
6.       &emsp;Design Principles.</BR>
7.       &emsp;Test Cases(TDD) : Test Cases</BR>
8.       &emsp;Commit the code in Github.com</BR>
I request you to solve the problem submit the code via github.</BR>
Let’s keep the ETA as .14th July.</BR>
