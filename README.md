SDLC Breakdown for This Task

1. Requirement Analysis 
. Input unsorted-names-list.txt 
. Output : sorted-names-list.txt 
. Sorting Rule: Sort by last name, then by given names.
2. System Design
Implementation(Java, SOLID Applied) 
. SRP : Each class does one thing(eg, sorting, reading, writing). 
. OCP : Sorting logic can be extended without modifying core. 
. DI : Passes sevices to controller(Main.java). 
. ISP & LSP : Uses Interfaces for flexibility
3. Test cases also implemented    


# Name Sorter

A console app that sorts names by last name, then given names.  
Prints the sorted list to screen and writes it to `sorted-names-list.txt`.

## Build
mvn clean package

Run:
java -jar target/name-sorter-1.0-SNAPSHOT.jar unsorted-names-list.txt

Test
mvn test
