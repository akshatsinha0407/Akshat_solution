# JPA vs Hibernate vs Spring Data JPA

When working with databases in Java applications, the terms JPA, Hibernate, and Spring Data JPA are often used together. Although they are closely related, each serves a different purpose.

## JPA (Java Persistence API)

JPA is not a framework; it is a specification that defines how Java objects should be mapped to and managed in a relational database.

* It provides a set of interfaces and annotations.
* It does not contain any implementation.
* It defines standards that ORM frameworks must follow.

Example:

```java
@Entity
@Table(name = "employee")
public class Employee {
}
```

## Hibernate

Hibernate is an Object Relational Mapping (ORM) framework that implements the JPA specification.

Its primary responsibility is to map Java objects to database tables and handle database operations.

Key features:

* Automatic object-table mapping
* HQL (Hibernate Query Language)
* Caching support
* Transaction management

Hibernate can be used either through JPA or through its own native APIs.

Example:

```java
Session session = sessionFactory.openSession();
Transaction tx = session.beginTransaction();

session.save(employee);

tx.commit();
session.close();
```

In this approach, the developer is responsible for managing sessions and transactions manually.

## Spring Data JPA

Spring Data JPA is not a JPA implementation. Instead, it is a layer built on top of JPA implementations such as Hibernate.

Its main goal is to reduce boilerplate code and simplify data access operations.

Repository definition:

```java
public interface EmployeeRepository
        extends JpaRepository<Employee, Integer> {
}
```

Saving data:

```java
employeeRepository.save(employee);
```

Spring Data JPA automatically provides common CRUD operations, pagination, sorting, and query generation, allowing developers to focus more on business logic rather than persistence code.

## Relationship

```text
JPA (Specification)
      ↓
Hibernate (Implementation)
      ↓
Spring Data JPA (Abstraction Layer)
```

* JPA defines the standard.
* Hibernate implements the standard.
* Spring Data JPA simplifies the use of Hibernate and other JPA providers.

## Real-World Analogy

Think of it like driving a car:

* JPA = Traffic rules
* Hibernate = The car itself
* Spring Data JPA = An automatic car

Traffic rules define how driving should work.

The car provides the actual implementation.

An automatic car makes driving easier by handling many tasks automatically.

