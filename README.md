# Erudio RESTful API Archetype

This is one archetype that can give you power to create a simple REST API in minutes. The generated project REST service that provides some RESTful endpoints protected by OAuth 2. This archetype is based in [Erudio API OAUTH2](https://github.com/leandrocgsi/erudio-api-oauth2). This project incorporates the new Java-based configuration support, now available in Spring Security OAuth 2.0. 

# Open Source Projects Used

The following Open Source projects are used in this sample app:

* [Spring Boot](http://projects.spring.io/spring-boot/)
* [Spring MVC](http://docs.spring.io/spring/docs/current/spring-framework-reference/html/mvc.html)
* [Spring Security](http://projects.spring.io/spring-security/)
* [Spring Security OAuth](http://projects.spring.io/spring-security-oauth/)
* [Spring Data JPA](http://projects.spring.io/spring-data-jpa/)
* [Swagger](http://swagger.io/) see more [here](http://jakubstas.com/spring-jersey-swagger-create-documentation/) and [here](http://jakubstas.com/spring-jersey-swagger-exposing-documentation/)
* [Groovy](http://www.groovy-lang.org/)
* [Jasper Reports](http://community.jaspersoft.com/)
* [Apache POI](https://poi.apache.org/)
* [Orika Mapper](http://orika-mapper.github.io/orika-docs/converters.html)
* [Hibernate](http://hibernate.org/)
* [X-Stream](http://x-stream.github.io/)
* [Travis CI](https://travis-ci.org/)

# Architectural Style

* [RESTful](http://docs.oracle.com/javaee/6/tutorial/doc/gijqy.html)
* [HATEOAS](http://timelessrepo.com/haters-gonna-hateoas)
* [Microservices](http://martinfowler.com/articles/microservices.html)
* [SOA Concepts](http://www.ibm.com/developerworks/webservices/tutorials/ws-soa-ibmcertified/ws-soa-ibmcertified.html)

# Em português

*Sobre REST*

* [Web Services](http://www.semeru.com.br/blog/web-services/)
* [RESTful Web Services](http://www.semeru.com.br/blog/restful-web-services/)
* [HTTP Status Codes](http://www.semeru.com.br/blog/http-status-codes-em-servicos-rest/)
* [Do zero ao REST em 5 minutos com SpringBoot](http://www.semeru.com.br/blog/do-zero-ao-rest-em-5-minutos-com-springboot/)
* [Criando o primeiro endpoint REST com SpringBoot](http://www.semeru.com.br/blog/criando-o-primeiro-endpoint-rest-com-springboot/)
* [Documentando aplicações REST com SpringBoot e Swagger](http://www.semeru.com.br/blog/documentando-aplicacoes-restfull-com-springboot-e-swagger/)
* [Entendendo HATEOAS](http://www.semeru.com.br/blog/entendendo_hateoas/)
* [Aplicações RESTful HATEOAS com SpringBoot](http://www.semeru.com.br/blog/aplicacoes-restfull-hateoas-com-springboot/)

*Sobre Groovy e Java na mesma aplicação*

* [Usando código Groovy (o Java com esteróides) juntamente com código Java](http://www.semeru.com.br/blog/usando-codigo-groovy-o-java-com-esteroides-juntamente-com-codigo-java/)
* [Usando código Groovy (o Java com esteróides) juntamente com código Java em um projeto com Spring Boot](http://www.semeru.com.br/blog/usando-codigo-groovy-o-java-com-esteroides-juntamente-com-codigo-java-em-um-projeto-com-spring-boot/)

*Sobre Groovy*

* [Curso Básico de Grails](https://www.youtube.com/playlist?list=PL18bbNo7xuh_dvHiIjegSsbwRq9JPmZL2)


*Se especialize*

[<img src="https://github.com/leandrocgsi/SpringBootPlayground/blob/master/Images/banner_blog_udemy_course_sring_boot.jpg?raw=true">](https://www.udemy.com/restful-apis-do-0-a-nuvem-com-springboot-e-docker/?couponCode=GTHB_REPOS_SALE2019)


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
mvn archetype:generate \
  -DarchetypeGroupId=br.com.erudio \
  -DarchetypeArtifactId=erudio-rest-api-archetype \
  -DarchetypeVersion=0.1.0 \
  -DgroupId=br.com.your.domain \
  -DartifactId=your-project-name \
  -Dversion=1.0-SNAPSHOT \
  -Dpackage=br.com.your.domain
```

It's can be should look like the image below.

![GenerateProject](https://github.com/leandrocgsi/erudio-rest-api-archetype/blob/master/img/3-GenerateProject.png?raw=true)

Maven ask if you need change version of your project and your package base as is highlighted in red in the image below. If you dont want any change just type Enter Enter. If everything is gonna be OK you should see one image similar to following. Your project was created with success ;-)

![Building1](https://github.com/leandrocgsi/erudio-rest-api-archetype/blob/master/img/4-Building.png?raw=true)

# How to import your project

Now we just import our project in favorite IDE (Eclipse in this example). Go to menu File >> Import >> Maven >> Existing Maven Projects >> Next.

![Importing1](https://github.com/leandrocgsi/erudio-rest-api-archetype/blob/master/img/9-Importing.png?raw=true)

As on image bellow type your Root Directory (where we found your code) and click in Browse >> Finish.

![Importing2](https://github.com/leandrocgsi/erudio-rest-api-archetype/blob/master/img/10-Importing.png?raw=true)

Probably you see the following errors, dont be worry just click in Finish again.

![Importing3](https://github.com/leandrocgsi/erudio-rest-api-archetype/blob/master/img/11-Importing.png?raw=true)

Now we dont see our Groovy code this is because these code is out of default Maven lifecycle. To fix this we just need click with right button over our project and select New >> Source Folder.

![CreatingSourceFolders1](https://github.com/leandrocgsi/erudio-rest-api-archetype/blob/master/img/12-CreatingSourceFolders.png?raw=true)

In next window in Folder Name type *src/main/groovy*, repeat this proccess with *src/test/groovy* and *src/test_components/java*

![CreatingSourceFolders2](https://github.com/leandrocgsi/erudio-rest-api-archetype/blob/master/img/13-CreatingSourceFolders-CreatingSourceFolders.png?raw=true)

Now we have one structure similar to image bellow. As you can see, on *Markers tab*, we have some erros but dont be worry just click with right button and delete they.

![Final](https://github.com/leandrocgsi/erudio-rest-api-archetype/blob/master/img/14-Final.png?raw=true)

Now to execute your project [click here](https://github.com/leandrocgsi/erudio-api-oauth2) and follow the steps.
