# Contact API Specs

## Create Contact

Endpoint: /api/contacts/create

Method: POST

Request header:

- X-API-TOKEN: {login_session_token} -> Mandatory

Request Body:

```json
{
  "firstName": "First Name",
  "lastName": "Last Name",
  "phoneNumber": "Phone Number"
}
```

Response Body (success):

```json
{
  "data": {
    "id": "id",
    "firstName": "First Name",
    "lastName": "Last Name",
    "phoneNumber": "Phone Number"
  }
}
```

Response Body (fail):

```json
{
  "errors": "detailed_error_description"
}
```

## Update Contact

Endpoint: /api/contacts/{id}

Method: PATCH (Partial update data)

Request header:

- X-API-TOKEN: {login_session_token} -> Mandatory

Request Body:

```json
{
  "firstName": "New First Name",
  "lastName": "New Last Name",
  "phoneNumber": "New Phone Number"
}
```

Response Body (success):

```json
{
  "data": {
    "firstName": "New First Name",
    "lastName": "New Last Name",
    "phoneNumber": "New Phone Number"
  }
}
```

Response Body (fail):

```json
{
  "errors": "detailed_error_description"
}
```

## Get Contact

Endpoint: /api/contacts/{id}

Method: GET

Request header:

- X-API-TOKEN: {login_session_token} -> Mandatory

Response Body (success):

```json
{
  "data": {
    "id": "id",
    "firstName": "First Name",
    "lastName": "Last Name",
    "phoneNumber": "Phone Number"
  }
}
```

Response Body (fail):

```json
{
  "errors": "detailed_error_description"
}
```

## Search Contact

Endpoint: /api/contacts

Method: GET

Query Param:

- name String, using LIKE for first or last name
- phone String, using LIKE for the phone
- page Integer, start from 0 (default)
- size Integer, default 10

Request header:

- X-API-TOKEN: {login_session_token} -> Mandatory

Response Body (success):

```json
{
  "data": [
    {
      "id": "id",
      "firstName": "First Name",
      "lastName": "Last Name",
      "phoneNumber": "Phone Number"
    }
  ],
  "paging": {
    "currentPage": 0,
    "totalPage": 10,
    "size": 10
  }
}
```

Response Body (fail):

```json
{
  "errors": "detailed_error_description"
}
```

## Remove Contact

Endpoint: /api/contacts/{id}

Method: DELETE

Request header:

- X-API-TOKEN: {login_session_token} -> Mandatory

Request Body:

Response Body (success):

```json
{
  "data": "OK!"
}
```

Response Body (fail):

```json
{
  "errors": "detailed_error_description"
}
```
