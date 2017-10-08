# TwitterUsingCamel-Karaf

Prerequisite :-
    Maven must be installed
    Camel must be installed
    Karaf must be installed and Running.
    
To run karaf you need to go to
    apache-karaf-X.X.X/bin

And Run

    ./karaf

Now Karf is running. keep this window/terminal open

Go to project folder and run the below command to install the build using Maven

    mvn clean install
    
This will create a bundle by name 1.0.1-SNAPSHOT

Now, to install bundle on Karaf, go to the window/terminal where karaf is running

    install -s mvn:implement.twitter/twitterApp/1.0.1-SNAPSHOT

This will give you a BundleID - note this bundle id
Or you can check the bundle Id in the Karaf running window/terminal

    bundle:list


to start bundle:
start <BundleID>

to update bundle:
update <BundleID>

to stop bundle:
stop <BundleID>


Check the logs for the output of the program-

to diplay logs :-
In the Karaf running window/terminal, run the below command

    logs:display
    
to clear logs :-
In the Karaf running window/terminal, run the below command

    logs:clear
    
