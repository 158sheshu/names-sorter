## SDLC Breakdown for This Task

## 1. Requirement Analysis 
. Input unsorted-names-list.txt 
. Output : sorted-names-list.txt 
. Sorting Rule: Sort by last name, then by given names.
## 2. System Design
## Implementation(Java, SOLID Applied) 
. SRP : Each class does one thing(eg, sorting, reading, writing). 
. OCP : Sorting logic can be extended without modifying core. 
. DI : Passes sevices to controller(Main.java). 
. ISP & LSP : Uses Interfaces for flexibility
## 3. Test cases also implemented    


# Name Sorter

A console app that sorts names by last name, then given names.  
Prints the sorted list to screen and writes it to `sorted-names-list.txt`.

## Build
mvn clean package

## Run
java -jar target/name-sorter-1.0-SNAPSHOT.jar unsorted-names-list.txt

## Test
mvn test

## Projet Execution Flow:
1. Main.java is the starting point of the execution
2. Which takes the unsorted-names-list.txt from command line arguments
3. Using FileNameReader which reads PersonNames from the given file.
4. Using NameSorterService to sort PersonNames(Sorting execution takes place).
5. Writes the sorted Names to Console.
6. Using FileNameWriter which writes the sorted PersonNames to sorted-names-list.txt file.    

