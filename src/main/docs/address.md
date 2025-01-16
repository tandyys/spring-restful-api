# Adress API Spec

## Create address

Endpoint: /api/contacts/{id}/addresses

Method: POST

Request header:

- X-API-TOKEN: {login_session_token} -> Mandatory

Request Body:

```json
{
  "street": "street",
  "city": "city",
  "province": "province",
  "country": "country",
  "postalCode": "postalCode"
}
```

Response Body (success):

```json
{
  "data": {
    "id": "id",
    "street": "street",
    "city": "city",
    "province": "province",
    "country": "country",
    "postalCode": "postalCode"
  }
}
```

Response Body (fail):

```json
{
  "errors": "detailed_error_description"
}
```

## Update address

Endpoint: /api/contacts/{idContact}/addresses/{idAddress}

Method: PUT

Request header:

- X-API-TOKEN: {login_session_token} -> Mandatory

Request Body:

```json
{
  "street": "street",
  "city": "city",
  "province": "province",
  "country": "country",
  "postalCode": "postalCode"
}
```

Response Body (success):

```json
{
  "data": {
    "id": "id",
    "street": "street",
    "city": "city",
    "province": "province",
    "country": "country",
    "postalCode": "postalCode"
  }
}
```

Response Body (fail):

```json
{
  "errors": "detailed_error_description"
}
```

## Get address

Endpoint: /api/contacts/{idContact}/addresses/{idAddress}

Method: GET

Request header:

- X-API-TOKEN: {login_session_token} -> Mandatory

Response Body (success):

```json
{
  "data": {
    "id": "id",
    "street": "street",
    "city": "city",
    "province": "province",
    "country": "country",
    "postalCode": "postalCode"
  }
}
```

Response Body (fail):

```json
{
  "errors": "detailed_error_description"
}
```

## Remove address

Endpoint: /api/contacts/{idContact}/addresses/{idAddress}

Method: DELETE

Request header:

- X-API-TOKEN: {login_session_token} -> Mandatory

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

## List addresses

Endpoint: /api/contacts/{idContact}/addresses

Method: GET

Request header:

- X-API-TOKEN: {login_session_token} -> Mandatory

Response Body (success):

```json
{
  "data": [
    {
      "id": "id",
      "street": "street",
      "city": "city",
      "province": "province",
      "country": "country",
      "postalCode": "postalCode"
    }
  ]
}
```

Response Body (fail):

```json
{
  "errors": "detailed_error_description"
}
```
