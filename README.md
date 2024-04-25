# bank-transactions

## Project description

This project was build using java with Spring Boot as framework and H2 as database

It was based to complete the pic-pay challenge from: https://github.com/PicPay/picpay-desafio-backend?tab=readme-ov-file

## Installation

1. Clone this repo:

```bash
git clone https://github.com/JoaoVellenich/bank-transactions.git
```

2. Open the project using any IDE and run the code.

## API Endpoints

### User API

#### Create User

Make a POST request to this URL:

```markdown
POST - http://localhost:8080/api/v1/users/createUser
```

With this body:

```json
{
  "fuelName": "YOUR NAME",
  "email": "YOUR EMAIL",
  "password":"ANY PASSWORD",
  "document": "YOUR DOCUMENT NUMBER",
  "userType": "COMMON or TRADER",
  "balance": BALANCE VALUE
}
```

#### Get User

Make a GET request to this URL:

```markdown
GET - http://localhost:8080/api/v1/users/{THE USER ID}
```

### Transaction API

#### Create transaction

Make a POST request to this URL:

```markdown
POST - http://localhost:8080/api/v1/transactions/
```

With this body

```json
{
  "payerId": PAYER ID,
  "receiverId": RECEIVER ID,
  "value": TRANSACTION VALUE
}
```

## Database

This project use a H2 database
