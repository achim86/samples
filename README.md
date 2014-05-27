# Samples

## Prerequesites

### Git
Check [Git Documentation](http://git-scm.com/book/en/Getting-Started-Installing-Git "Reference to Git documentation") for a detailed installation description.

### Maven
Check [Maven Getting Started Guide](http://maven.apache.org/guides/getting-started/maven-in-five-minutes.html "Reference to Maven Getting Started Guide") for a detailed installation description.

## Ordering System First Iteration

### Installation
Navigate to project foler and execute 
    mvn clean install

### Execution
Run packaged Tomcat in target folder via <code>java -jar standalone-tomcat.jar</code> or start Tomcat via Maven executing <code>mvn tomcat7:run</code>.
The started Tomcat is accessible under http://localhost:8080/all-in-one.
