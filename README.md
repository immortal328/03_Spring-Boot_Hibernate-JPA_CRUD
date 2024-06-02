<h1>Spring-Boot Hibernate / JPA</h1>

Crafted a dynamic Spring Boot Hibernate/JPA project facilitating complete only <strong>GET</stron> class to fetch data from DB. based Student model attribute like id, lastNmae, std and id std 
you can ignore where im doing delete operation using GET call

It is just for the practice repository: refer another repository with name : Spring-Boot_REST-API_CRUD


The project offers two sets of REST endpoints: 
  - the first set, accessible via '/v1/entityManager', employs EntityManager for CRUD functionality.
      - GET : "/v1/entityManager/student/{id}"
      - GET : "/v1/entityManager/students/std/{std}"
      - GET : "/v1/entityManager/allStudent"
      - GET : "/v1/entityManager/student/lastName/{lastName}"
      - GET : "/v1/entityManager/update/lastName/{lastName}/id/{id}"
      - GET : "/v1/entityManager/delete/id/{id}"
      - GET : "/v1/entityManager/deleteAll"
      - POST : "/insertByEM"

      - 
  - the second set, available at '/v1/JPA', extends the JPARepository for similar operations.
      - GET : "/v1/JPA/student/{id}"
      - GET : "/v1/JPA/students/std/{std}"
      - GET : "/v1/JPA/allStudent"
      - GET : "/v1/JPA/student/lastName/{lastName}"
      - GET : "/v1/JPA/update/lastName/{lastName}/id/{id}"
      - GET : "/v1/JPA/delete/id/{id}"
      - GET : "/v1/JPA/deleteAll"
      - POST : "/insertByJPA"
    
MySQL is the chosen database, with connection configurations streamlined through a YAML file for seamless deployment on localhost.
