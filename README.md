# gwt-dynatablerf-spring

The GWT-Project contains an example-project dynatablerf, which demonstrates the RequestFactory in GWT. The RequestFactory is especially usuful for creating CRUD-like application, e.g. applicions that create, read, update and store data in a database. However, the example project doesn't persist data, as that is left upon the reader.
As adding persistency isn't as straight forward, I've updated the example project to store data using Spring and JPA/Hibernate, the most popular frameworks in enterprise-environments.

Features
--------
* All client-state lives at the client, as is custom for GWT-projects
* Spring-components can be used straight-forward as GWT-Services.
* Entities are looked up using an entity-manager. 

