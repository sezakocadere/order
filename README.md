## Order Application

### About The Project
This project is a **Maven Java console application** about where a customer can create orders, save and view their invoices. 


| Method | Info |
|--|--|
| getTotalInvoiceByMonth | returns invoice totals for the given month  |
| getTotalInvoiceByMonth | returns invoice totals for the current month |
| filterInvoiceOverGivenAmount | returns invoices over given amount |
| filterInvoiceUnderGivenAmount | returns invoices under given amount |
| averageOfInvoices | returns average of invoices |
| getAverageInvoiceOfOrdersAndSellersByMonth | returns map of seller list - their average invoices by given month |
| getCustomersGivenCharOfFullName | returns list customers with the given letter in their full names |
| getCustomerNamesByGivenAmountUnderOrders | returns list customers full names by given amount under invoices |


### Clone The Repo:
``` $ git clone https://github.com/sezakocadere/order.git ```

### Example Output:

```
Welcome to the order program! 

All customers listed.. 
{1=Customer(fullName=Seza KOCADERE, createdTime=2022-06-09), 2=Customer(fullName=Slim Shady, createdTime=2022-06-05), 3=Customer(fullName=Albert Einstein, createdTime=2022-06-01), 4=Customer(fullName=Nikola Tesla, createdTime=2022-06-02), 5=Customer(fullName=Stephen Hawking, createdTime=2022-06-01)}

List of customers contains c in their full name 
[Customer(fullName=Seza KOCADERE, createdTime=2022-06-09)]

Total invoice of customers registered in the system in June: 17561 TRY

Total invoice of customers registered in the system in currently month: 0 TRY

All invoice of system:
8300 TRY
8620 TRY
398 TRY
178 TRY
65 TRY

Invoices Of More Than 1500 TRY
[8300, 8620] TRY

Average invoices Of More Than 1500 TRY
8460 TRY

Invoices Of Less Than 1500 TRY
[398, 178, 65] TRY

List of customers names by invoices of less than 500 TRY
[Albert Einstein, Nikola Tesla, Stephen Hawking]

Sectors of sellers with average invoice of less than 750 TRY in June :
[TECHNOLOGY, FOOD, ELECTRONICS, BOOKS]
```


### Scenario

- [x] The concepts of final, static, overload, override, constructor, inheritance, polymorphism, encapsulation, List, Set, Map should be used
- [x] It is enough to work on the main method
- [x] Try to write in accordance with SOLID principles
- [x] Create a Maven project
- [x] Run the maven commands and add the output

- [x] List all customers
- [x] Create new customers
- [x] List customers with the letter 'C' in their full name
- [x] List the total amount of invoices for customers who signed up in June
- [x] List all invoices in the system
- [x] List invoices over 1500TL in the system
- [x] Calculate the average of invoices over 1500TL in the system
- [x] List the names of customers with invoices under 500TL in the system
- [x] Lists the companies in which the average invoices for the month of June are below 750


### Maven Clean Output:

```
/Library/Java/JavaVirtualMachines/jdk-17.0.1.jdk/Contents/Home/bin/java -Dmaven.multiModuleProjectDirectory=/Users/kocadere/Desktop/order -Djansi.passthrough=true -Dmaven.home=/Applications/IntelliJ IDEA CE.app/Contents/plugins/maven/lib/maven3 -Dclassworlds.conf=/Applications/IntelliJ IDEA CE.app/Contents/plugins/maven/lib/maven3/bin/m2.conf -Dmaven.ext.class.path=/Applications/IntelliJ IDEA CE.app/Contents/plugins/maven/lib/maven-event-listener.jar -javaagent:/Applications/IntelliJ IDEA CE.app/Contents/lib/idea_rt.jar=58410:/Applications/IntelliJ IDEA CE.app/Contents/bin -Dfile.encoding=UTF-8 -classpath /Applications/IntelliJ IDEA CE.app/Contents/plugins/maven/lib/maven3/boot/plexus-classworlds.license:/Applications/IntelliJ IDEA CE.app/Contents/plugins/maven/lib/maven3/boot/plexus-classworlds-2.6.0.jar org.codehaus.classworlds.Launcher -Didea.version=2022.3.1 clean
[INFO] Scanning for projects...
[INFO] 
[INFO] -------------------------< org.example:order >--------------------------
[INFO] Building order 1.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ order ---
[INFO] Deleting /Users/kocadere/Desktop/order/target
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  0.113 s
[INFO] Finished at: 2023-01-31T17:27:47+03:00
[INFO] ------------------------------------------------------------------------

Process finished with exit code 0

```


### Maven Install Output:

```
/Library/Java/JavaVirtualMachines/jdk-17.0.1.jdk/Contents/Home/bin/java -Dmaven.multiModuleProjectDirectory=/Users/kocadere/Desktop/order -Djansi.passthrough=true -Dmaven.home=/Applications/IntelliJ IDEA CE.app/Contents/plugins/maven/lib/maven3 -Dclassworlds.conf=/Applications/IntelliJ IDEA CE.app/Contents/plugins/maven/lib/maven3/bin/m2.conf -Dmaven.ext.class.path=/Applications/IntelliJ IDEA CE.app/Contents/plugins/maven/lib/maven-event-listener.jar -javaagent:/Applications/IntelliJ IDEA CE.app/Contents/lib/idea_rt.jar=58412:/Applications/IntelliJ IDEA CE.app/Contents/bin -Dfile.encoding=UTF-8 -classpath /Applications/IntelliJ IDEA CE.app/Contents/plugins/maven/lib/maven3/boot/plexus-classworlds.license:/Applications/IntelliJ IDEA CE.app/Contents/plugins/maven/lib/maven3/boot/plexus-classworlds-2.6.0.jar org.codehaus.classworlds.Launcher -Didea.version=2022.3.1 install
[INFO] Scanning for projects...
[INFO] 
[INFO] -------------------------< org.example:order >--------------------------
[INFO] Building order 1.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ order ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 0 resource
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ order ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 11 source files to /Users/kocadere/Desktop/order/target/classes
[INFO] 
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ order ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory /Users/kocadere/Desktop/order/src/test/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ order ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ order ---
[INFO] No tests to run.
[INFO] 
[INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ order ---
[INFO] Building jar: /Users/kocadere/Desktop/order/target/order-1.0-SNAPSHOT.jar
[INFO] 
[INFO] --- maven-install-plugin:2.4:install (default-install) @ order ---
[INFO] Installing /Users/kocadere/Desktop/order/target/order-1.0-SNAPSHOT.jar to /Users/kocadere/.m2/repository/org/example/order/1.0-SNAPSHOT/order-1.0-SNAPSHOT.jar
[INFO] Installing /Users/kocadere/Desktop/order/pom.xml to /Users/kocadere/.m2/repository/org/example/order/1.0-SNAPSHOT/order-1.0-SNAPSHOT.pom
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  1.144 s
[INFO] Finished at: 2023-01-31T17:29:20+03:00
[INFO] ------------------------------------------------------------------------

Process finished with exit code 0

```
