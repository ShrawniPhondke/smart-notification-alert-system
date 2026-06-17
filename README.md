# Smart Notification Alert System

## Overview

Smart Notification Alert System is a microservices-based backend project built using Java, Spring Boot, Apache Kafka, PostgreSQL, and Docker.

The system allows users to register and authenticate using JWT. Whenever a new user registers, an event is published to Kafka. The Notification Service consumes the event, sends a welcome email, and stores notification history in PostgreSQL.

---

## Architecture

User Registration

↓

User Service

↓

Kafka Producer

↓

Kafka Topic (user-registered)

↓

Notification Service

↓

Welcome Email

↓

Notification History Database

---

## Tech Stack

### Backend

* Java 17
* Spring Boot
* Spring Security
* JWT Authentication
* Spring Data JPA

### Database

* PostgreSQL

### Messaging

* Apache Kafka

### Email

* Spring Mail
* Gmail SMTP

### DevOps

* Docker
* Docker Compose

### Documentation

* Swagger / OpenAPI

---

## Features

### User Service

* User Registration
* User Login
* JWT Authentication
* Protected Profile API
* PostgreSQL Integration
* Kafka Event Publishing

### Notification Service

* Kafka Consumer
* Welcome Email Sending
* HTML Email Templates
* Notification History Tracking
* Notification REST API

---

## APIs

### User Service

#### Register User

POST /api/users/register

```json
{
  "name": "John",
  "email": "john@example.com",
  "password": "123456"
}
```

#### Login User

POST /api/users/login

```json
{
  "email": "john@example.com",
  "password": "123456"
}
```

#### Get Profile

GET /api/users/profile

Authorization: Bearer JWT_TOKEN

---

### Notification Service

#### Get Notification History

GET /notifications

Response:

```json
[
  {
    "id": 1,
    "email": "john@example.com",
    "status": "SENT",
    "sentAt": "2026-06-16T18:30:00"
  }
]
```

---

## Database Tables

### users

| Column   | Type   |
| -------- | ------ |
| id       | Long   |
| name     | String |
| email    | String |
| password | String |

### notifications

| Column | Type      |
| ------ | --------- |
| id     | Long      |
| email  | String    |
| status | String    |
| sentAt | Timestamp |

---

## Kafka Flow

1. User registers.
2. User Service saves user in PostgreSQL.
3. User Service publishes email to Kafka topic `user-registered`.
4. Notification Service consumes event.
5. Welcome email is sent.
6. Notification record is saved in PostgreSQL.

---

## Future Enhancements

* AWS SES Integration
* SMS Notifications
* Notification Statistics Dashboard
* Retry Mechanism for Failed Notifications
* Dockerized Microservices Deployment
* Kubernetes Deployment

---

## Author

**Shrawni Phondke**

Final Year Information Technology Student

Java Backend Developer | Spring Boot | PostgreSQL | Kafka
