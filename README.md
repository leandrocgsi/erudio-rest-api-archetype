# Erudio REST API Archetype(erudio-rest-api-archetype)

This is one archetype that can give you power to create a simple REST API in minutes. The generated project REST service that provides some RESTful endpoints protected by OAuth 2. This archetype is based in [Erudio API OAUTH2](https://github.com/leandrocgsi/erudio-api-oauth2). This project incorporates the new Java-based configuration support, now available in Spring Security OAuth 2.0. 


# Open Source Used Projects

The following Open Source projects are used in this sample app:

* [Spring Boot](http://projects.spring.io/spring-boot/)
* [Spring MVC](http://docs.spring.io/spring/docs/current/spring-framework-reference/html/mvc.html)
* [Spring Security](http://projects.spring.io/spring-security/)
* [Spring Security OAuth](http://projects.spring.io/spring-security-oauth/)
* [Spring Data JPA](http://projects.spring.io/spring-data-jpa/)
* [Swagger](http://swagger.io/) see more [here](http://jakubstas.com/spring-jersey-swagger-create-documentation/) and [here](http://jakubstas.com/spring-jersey-swagger-exposing-documentation/)
* [Groovy](http://www.groovy-lang.org/)
* [Jasper Reports](http://community.jaspersoft.com/)
* [Orika Mapper](http://orika-mapper.github.io/orika-docs/converters.html)
* [Hibernate](http://hibernate.org/)

# How to use this Archetype?

First you need clone this project in your computer. This can be done with following command line.

```
git clone https://github.com/leandrocgsi/erudio-rest-api-archetype.git
```

Open the generated source folder, that can be should look like the image below.

![OpenFolder](https://github.com/leandrocgsi/erudio-rest-api-archetype/blob/master/img/1-OpenFolder.png?raw=true)

Execute following comand line in your folder.

```
mvn clean install
```
It's can be should look like the image below.

![CleanInstall](https://github.com/leandrocgsi/erudio-rest-api-archetype/blob/master/img/2-CleanInstall.png?raw=true)

Now go to the directory where you want to create your project and run the command below.

```
mvn archetype:generate 
	-DarchetypeGroupId=br.com.erudio
	-DarchetypeArtifactId=erudio-rest-api-archetype
	-DarchetypeVersion=0.1.0
	-DgroupId=br.com.your.domain
	-DartifactId=your-project-name
```

It's can be should look like the image below.

![GenerateProject](https://github.com/leandrocgsi/erudio-rest-api-archetype/blob/master/img/3-GenerateProject.png?raw=true)

Maven ask if you need change version of your project and your package base as is highlighted in red in the image below. If you dont want any change just type Enter Enter. If everything is gonna be OK you should see one image similar to following. Your project was created with success ;-)

![Building1](https://github.com/leandrocgsi/erudio-rest-api-archetype/blob/master/img/4-Building.png?raw=true)

Now we just import our project in favorite IDE (Eclipse in this example). Go to menu File >> Import >> Maven >> Existing Maven Projects >> Next.

![Importing1](https://github.com/leandrocgsi/erudio-rest-api-archetype/blob/master/img/9-Importing.png?raw=true)

![Importing2](https://github.com/leandrocgsi/erudio-rest-api-archetype/blob/master/img/10-Importing.png?raw=true)

![Importing3](https://github.com/leandrocgsi/erudio-rest-api-archetype/blob/master/img/11-Importing.png?raw=true)

![CreatingSourceFolders1](https://github.com/leandrocgsi/erudio-rest-api-archetype/blob/master/img/12-CreatingSourceFolders.png?raw=true)

![CreatingSourceFolders2](https://github.com/leandrocgsi/erudio-rest-api-archetype/blob/master/img/13-CreatingSourceFolders-CreatingSourceFolders.png?raw=true)

![Final](https://github.com/leandrocgsi/erudio-rest-api-archetype/blob/master/img/14-Final.png?raw=true)
