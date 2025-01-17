# User API Specs

## Register User

Enpoint: /api/users/register

Method: POST

Request body:

```json
{
  "email": "email",
  "password": "password",
  "username": "username"
}
```

Response body (success):

```json
{
  "data": "OK!"
}
```

Response body (fail):

```json
{
  "errors": "detailed_error_description"
}
```

## Log in user

Endpoint: /api/users/auth/login

Method: POST

Request body:

```json
{
  "email": "email",
  "password": "password"
}
```

Response body (success):

```json
{
  "data": {
    "token": "session_token",
    "expiredAt": "expired_token_data_in_millisecond"
  }
}
```

Response body (fail):

```json
{
  "errors": "detailed_error_description"
}
```

## Update user

Endpoint: /api/users/current

Method: PATCH (Partial data update)

Request header:

- X-API-TOKEN: {login_session_token} -> Mandatory

Request body:

```json
{
  "username": "username", // Partial update
  "password": "password" // Partial update
}
```

Response body (success):

```json
{
  "data": "OK!"
}
```

Response body (fail):

```json
{
  "errors": "detailed_error_description"
}
```

## Get user

Endpoint: /api/users/current

Method: GET

Request header:

- X-API-TOKEN: {login_session_token} -> Mandatory

Response body (success):

```json
{
  "data": {
    "email": "email",
    "username": "username"
  }
}
```

Response body (fail):

```json
{
  "errors": "detailed_error_description"
}
```

## Log out

Endpoint: /api/users/auth/logout

Method: DELETE

Request header:

- X-API-TOKEN: {login_session_token} -> Mandatory

Response body (success):

```json
{
  "data": "OK!"
}
```
