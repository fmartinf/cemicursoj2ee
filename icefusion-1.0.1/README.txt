ICEfusion 1.0.1
Enterprise-ready ICEfaces Facelets components and JEE stack 
http://icefusion.googlecode.com

Portions (c) 2009 by Rainer Eschen, Apache License 2.0
http://blog.rainer.eschen.name/icefaces
http://twitter.com/rainwebs

Based on ICEfaces 1.8.1 and AppFuse 2.0.2
http://www.icefaces.org
http://www.appfuse.org

--------------------------------------------------------------------------------
 Running ICEfaces
--------------------------------------------------------------------------------

We use the Jetty that is part of Maven. So you do not have to install a Web
container. But, the project expects an installed MySQL 5.1 with the password 
"icefaces" (follow the instructions at the end of this file).

The steps:

* For first time use execute first-time-run.bat to initialize MySQL with a
  database schema. Ignore the errors that come from standard AppFuse tests
  that are no longer valid for ICEcube.

* After this and with each following application start use run.bat. It opens a
  command window for the container log.
* When Jetty is ready open your Web browser with http://localhost:8080 
  to start the ICEcube menu.

I skipped the login that is delivered by AppFuse to keep things simple. 
Because of this all your changes are kept as part of the session until you 
close the command window or your session times out (after 30 minutes).

--------------------------------------------------------------------------------
 AppFuse Adaptations
--------------------------------------------------------------------------------

### ICEfusion 1.0 ###

The following files were changed:

pom.xml - New dependencies and JBoss + Java.net repository added, 
	support of MySQL 5.1.6 (password has to be set to "icefaces")
web.xml - Deleted ajax4jsf, dwr; added ICEfaces-specific
faces-config.xml - added ICEfaces-specific

Ajax4JSF, DWR and the separate Facelets had to be skipped because of possible
conflicts with ICEfaces. ICEfaces is used with its integrated Facelets
distribution instead.

Additional files start with icefusion*.*, except from default.jsp.
Have a look at the SVN. The first revision is the original archetype result.
Still have to delete stuff that became useless.

--------------------------------------------------------------------------------
AppFuse Basic JSF Archetype
--------------------------------------------------------------------------------

If you're reading this then you've created your new project using Maven and
appfuse-basic-jsf.  You have only created the shell of an AppFuse Java EE
application.  The project object model (pom) is defined in the file pom.xml.
The application is ready to run as a web application. The pom.xml file is
pre-defined with Hibernate as a persistence model and JSF as the web framework.

To get started, please complete the following steps:

1. Download and install a MySQL 5.x database from 
   http://dev.mysql.com/downloads/mysql/5.0.html#downloads.

2. Run "mvn jetty:run-war" and view the application at http://localhost:8080.

3. More information can be found at:

   http://appfuse.org/display/APF/QuickStart+Guide

