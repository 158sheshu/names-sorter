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
3. Run mvn clean install
   java -jar target/name-sorter-1.0-SNAPSHOT.jar unsorted-names-list.txt
4. Test cases also implemented    
