AutoComplete functionality using Scala, Play & ReactiveMongo
============================================================
Play 2.5.x application with [ReactiveMongo](http://reactivemongo.org/) - reactive, asynchronous and non-blocking Scala driver for MongoDB.

This is a classic AutoComplete application, backed by a MongoDB database. It demonstrates:
- Achieving, Futures to use more idiomatic error handling.
- Accessing a MongoDB database, using [ReactiveMongo](http://reactivemongo.org/).
- Replaced the embedded JS & CSS libraries with [WebJars](http://www.webjars.org/).
- Play and Scala-based template engine implementation
- Bootswatch-United with Twitter Bootstrap to improve the look and feel of the application

-----------------------------------------------------------------------
### Prerequisite
-----------------------------------------------------------------------
- Pre Installed MongoDB if you do not have it already. You can get it from here: [https://docs.mongodb.com/manual/installation/)
- Create DB `autocomplete` by executing `$ use autocomplete`
- Create collection `countries` by executing `$ db.createCollection("countries")`
- Import CSV data into `countries` collection
```
$ mongoimport --db autocomplete --collection countries --type csv --headerline --file /resources/contries.csv
```
- Create wildcard text indexes `db.countries.createIndex({"$**": "text"})`

-----------------------------------------------------------------------
### Deploy Instructions
-----------------------------------------------------------------------
* Clone the project into your local system `$ git clone git@github.com:anand-singh/playing-autocomplete.git`
* To run the Play framework 2.5.x, you need JDK 8 or later
* Install Typesafe Activator if you do not have it already. You can get it from here: [download](http://www.playframework.com/download)
* Execute `$ bin/activator clean compile` to build the product
* Execute `$ bin/activator run` to execute the product
* playing-autocomplete should now be accessible at localhost:9000

-----------------------------------------------------------------------
###References :-
-----------------------------------------------------------------------
* [Play Framework](http://www.playframework.com/)
* [ReactiveMongo](http://reactivemongo.org/)
* [Bootstrap](http://getbootstrap.com/css/)
* [Bootswatch-United](http://bootswatch.com/united/)
* [WebJars](http://www.webjars.org/)
