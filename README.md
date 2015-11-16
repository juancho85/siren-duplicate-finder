# siren-duplicate-finder
Java command line program to find duplicate siren numbers in a text file.

## How to run the program
Prerequisite: Having java jre (version 1.7 or higher) installed

Open a shell in the folder containing duplicates.jar and type the following :

```
java -jar duplicates.jar {path/to/file.txt}

```

The program can be called with an optional parameter: The path to a file containing siren numbers.
For example:
java -jar duplicates-0.0.1-SNAPSHOT.jar /usr/sirens.txt

If no file is provided, then a default file, that is shipped with the .jar, is used.

## Compilation on GNU/Linux
Compiling the sources requires having java jdk 1.7 and maven 3.3

### Java
-install java jdk version 1.7:

```
sudo apt-get install openjdk-7-jdk
```

Check that the installation was correct by typing "java -version" or alternatively "java --version"

You should get something similar to this

```
java version "1.7.0_55"
OpenJDK Runtime Environment (IcedTea 2.4.7) (7u55-2.4.7-1ubuntu1~0.12.10.1)
OpenJDK Client VM (build 24.51-b03, mixed mode, sharing)
```

### JAVA_HOME
Define the JAVA_HOME environment variable and make it point to the jdk installation folder.
Check that the value was correctly set
```
export JAVA_HOME=/usr/lib/jvm/java-7-openjdk-i386/
echo $JAVA_HOME
/usr/lib/jvm/java-7-openjdk-i386
```

### Maven
-install Apache Maven 3.3:
Download maven 3.3 from the following page https://maven.apache.org/download.cgi
Extract it in the directory of your choice
Add the bin directory of the created directory apache-maven-3.3.3 to the PATH environment variable
```
export PATH=/opt/apache-maven-3.3.3/bin:$PATH
```

Confirm with "mvn -v" in a new shell. The result should look similar to

Apache Maven 3.3.3 (7994120775791599e205a5524ec3e0dfe41d4a06; 2015-04-22T13:57:37+02:00)
Maven home: /home/juancho/Desktop/apache-maven-3.3.3
Java version: 1.7.0_55, vendor: Oracle Corporation
Java home: /usr/lib/jvm/java-7-openjdk-i386/jre
Default locale: en_US, platform encoding: UTF-8
OS name: "linux", version: "3.5.0-17-generic", arch: "i386", family: "unix"

### Building the project
Open a shell in the root of the project (siren-duplicate-finder-master)
```
mvn package
```
this will compile the sources and generate a .jar file that can be executed 




