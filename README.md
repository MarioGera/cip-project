# Music Streaming Service
# 📄 Description

This API creates a music service,managing song libraries,artist profiles,playlists and user preferences. The system supports streaming,downloading and user feedback.

## Base URL

[http://localhost:8080/](http://localhost:8080/)

---

# Endpoints

StartFragment

# 1.Get all artists

**HTTP Method**: `GET`

**Endpoint**: `/artists`

**Description**: Retrieves a list of all artists.

**Request Headers**:

None

Request Body:

None Responses: 200 OK:

``` java
[
  {
    "id": 1,
    "name": "Artist One",
    "genre": "Rock"
  },
  {
    "id": 2,
    "name": "Artist Two",
    "genre": "Pop"
  }
]

 ```

EndFragment

# StartFragment

## 2\. Add new artist

StartFragment

**HTTP Method:** `POST`

**Endpoint**: `/artists`

**Description**: Adds a new artist.

**Request Headers:**

EndFragment  
StartFragment`Content-Type: application/json`EndFragment

StartFragment**Request Body**:EndFragment

``` java
{
  "name": "New Artist",
  "genre": "Jazz"
}

 ```

StartFragment

**Responses**:

**201 Created**:

EndFragment

``` java
{
  "id": 3,
  "name": "New Artist",
  "genre": "Jazz"
}

 ```

StartFragment**400 Bad Request**: Invalid inputEndFragment

EndFragment

## **Getting started guide**

`List the steps or points required to start using your APIs. Make sure to cover everything required to reach success with your API as quickly as possible.`

To start using the ((add APIs here)), you need to -

`The points given below are from The Postman API's documentation. You can reference it to write your own getting started guide.`

- You must use a valid API Key to send requests to the API endpoints. You can get your API key from Postman's [integrations dashboard](https://go.postman.co/settings/me/api-keys).
    
- The API has [rate and usage limits](https://learning.postman.com/docs/developer/postman-api/postman-api-rate-limits/).
    
- The API only responds to HTTPS-secured communications. Any requests sent via HTTP return an HTTP 301 redirect to the corresponding HTTPS resources.
    
- The API returns request responses in JSON format. When an API request returns an error, it is sent in the JSON response as an error key.
    

## Authentication

`Add details on the authorization keys/tokens required, steps that cover how to get them, and the relevant error codes.`

The ((product name)) API uses ((add your API's authorization type)) for authentication.

`The details given below are from the Postman API's documentation. You can reference it to write your own authentication section.`

Postman uses API keys for authentication. You can generate a Postman API key in the [API keys](https://postman.postman.co/settings/me/api-keys) section of your Postman account settings.

You must include an API key in each request to the Postman API with the X-Api-Key request header.

### Authentication error response

If an API key is missing, malformed, or invalid, you will receive an HTTP 401 Unauthorized response code.

## Rate and usage limits

`Use this section to cover your APIs' terms of use. Include API limits, constraints, and relevant error codes, so consumers understand the permitted API usage and practices.`

`The example given below is from The Postman API's documentation. Use it as a reference to write your APIs' terms of use.`

API access rate limits apply at a per-API key basis in unit time. The limit is 300 requests per minute. Also, depending on your plan, you may have usage limits. If you exceed either limit, your request will return an HTTP 429 Too Many Requests status code.

Each API response returns the following set of headers to help you identify your use status:

| Header | Description |
| --- | --- |
| `X-RateLimit-Limit` | The maximum number of requests that the consumer is permitted to make per minute. |
| `X-RateLimit-Remaining` | The number of requests remaining in the current rate limit window. |
| `X-RateLimit-Reset` | The time at which the current rate limit window resets in UTC epoch seconds. |

### 503 response

An HTTP `503` response from our servers indicates there is an unexpected spike in API access traffic. The server is usually operational within the next five minutes. If the outage persists or you receive any other form of an HTTP `5XX` error, [contact support](https://support.postman.com/hc/en-us/requests/new/).

### **Need some help?**

`Add links that customers can refer to whenever they need help.`

In case you have questions, go through our tutorials ((link to your video or help documentation here)). Or visit our FAQ page ((link to the relevant page)).

Or you can check out our community forum, there’s a good chance our community has an answer for you. Visit our developer forum ((link to developer forum)) to review topics, ask questions, and learn from others.

`You can also document or add links to libraries, code examples, and other resources needed to make a request.`
# 📁 Folder: User 


## End-point: Get authenticated user
Gets information about the authenticated user.
### Method: GET
>```
>https://api.getpostman.com/me
>```
### Response: 200
```json
{
    "user": {
        "id": 12345678,
        "username": "taylor-lee",
        "email": "taylor.lee@example.com",
        "fullName": "Taylor Lee",
        "avatar": "https://example.com/user/r5u9qpvmujfjf6lbqmga.jpg",
        "isPublic": true
    },
    "operations": [
        {
            "name": "mock_usage",
            "limit": 1000000,
            "usage": 110276,
            "overage": 0
        },
        {
            "name": "monitor_request_runs",
            "limit": 10000000,
            "usage": 1141750,
            "overage": 0
        },
        {
            "name": "api_usage",
            "limit": 1000000,
            "usage": 16240,
            "overage": 0
        },
        {
            "name": "custom_domains",
            "limit": 25,
            "usage": 25,
            "overage": 0
        },
        {
            "name": "serverless_requests",
            "limit": 10000,
            "usage": 0,
            "overage": 0
        },
        {
            "name": "integrations",
            "limit": 5000,
            "usage": 1018,
            "overage": 0
        },
        {
            "name": "cloud_agent_requests",
            "limit": 1000000,
            "usage": 1615,
            "overage": 0
        }
    ]
}
```

### Response: 429
```json
{
    "error": "rateLimited",
    "message": "Rate limit exceeded. Please retry after 1669048687"
}
```


⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃
# 📁 Folder: Collections 


## End-point: Create a collection
Creates a collection using the [Postman Collection v2 schema format](https://schema.postman.com/json/collection/v2.1.0/docs/index.html). Include a `collection` object in the request body that contains the following required properties:

*   `info` — An **object** that contains the following properties:
    *   `name` — A **string** value that contains the collection's name.
    *   `schema` — A **string** that contains a URL to the collection's schema. For example, the `https://schema.getpostman.com/collection/v1` URL.
*   `item` — An **object** that contains the HTTP request and response information.
    *   `request` — An **object** that contains the collection's request information. For a complete list of values, refer to the `definitions.request` entry in the [collection.json schema file](https://schema.postman.com/json/collection/v2.1.0/collection.json). If you pass an empty object for this value, the system defaults to an untitled GET request.

**Note:**

*   For a complete list of available property values for this endpoint, use the following references available in the [collection.json schema file](https://schema.postman.com/json/collection/v2.1.0/collection.json):
    *   `info` object — Use the `definitions.info` entry.
    *   `item` object — Use the `definitions.items` entry.
*   For all other possible values, refer to the [collection.json schema file](https://schema.postman.com/json/collection/v2.1.0/collection.json).
### Method: POST
>```
>https://api.getpostman.com/collections
>```
### Headers

|Content-Type|Value|
|---|---|
|Content-Type|application/json|


### Body (**raw**)

```json
{
    "collection": {
        "info": {
            "name": "",
            "schema": ""
        },
        "item": [
            {
                "request": {}
            }
        ]
    }
}
```

### Query Params

|Param|value|
|---|---|
|workspace||


### Response: 200
```json
{
    "collection": {
        "id": "12ece9e1-2abf-4edc-8e34-de66e74114d2",
        "name": "Test Collection",
        "uid": "12345678-12ece9e1-2abf-4edc-8e34-de66e74114d2"
    }
}
```

### Response: 400
```json
{
    "error": {
        "name": "instanceFoundError",
        "message": "The specified item already exists.",
        "details": {
            "item": "collection",
            "id": "12ece9e1-2abf-4edc-8e34-de66e74114d2"
        }
    }
}
```

### Response: 400
```json
{
    "error": {
        "name": "malformedRequestError",
        "message": "Found 1 errors with the supplied collection.",
        "details": [
            ": must have required property 'info'"
        ]
    }
}
```

### Response: 429
```json
{
    "error": "rateLimited",
    "message": "Rate limit exceeded. Please retry after 1669048687"
}
```


⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: Get a collection
Gets information about a collection. For a complete list of this endpoint's possible values, use the [collection.json schema file](https://schema.postman.com/json/collection/v2.1.0/collection.json).
### Method: GET
>```
>https://api.getpostman.com/collections/
>```
### Query Params

|Param|value|
|---|---|
|access_key||


### Response: 200
```json
{
    "collection": {
        "info": {
            "name": "Test Collection",
            "description": "This is a test collection that makes a tiny request to Postman Echo service to get the list of request headers sent by a HTTP client.",
            "_postman_id": "12ece9e1-2abf-4edc-8e34-de66e74114d2",
            "schema": "https://schema.getpostman.com/json/collection/v2.0.0/collection.json",
            "updatedAt": "2022-06-16T20:21:13.000Z",
            "fork": {
                "label": "Test Fork",
                "createdAt": "2022-06-16T19:51:44.069Z",
                "from": "12345678-12ece9e1-2abf-4edc-8e34-de66e74114d2"
            }
        },
        "item": [
            {
                "name": "Test GET Response",
                "id": "82ee981b-e19f-962a-401e-ea34ebfb4848",
                "event": [
                    {
                        "listen": "test",
                        "script": {
                            "id": "7d2334fc-a84a-4c3d-b26c-7529afa4c0ae",
                            "exec": [
                                "pm.test(\"Status code is 200\", function () {",
                                "    pm.response.to.have.status(200);",
                                "});"
                            ],
                            "type": "text/javascript"
                        }
                    }
                ],
                "request": {
                    "url": "https://echo.getpostman.com/headers",
                    "method": "GET",
                    "header": [
                        {
                            "key": "Content-Type",
                            "value": "application/json"
                        }
                    ]
                },
                "response": []
            }
        ]
    }
}
```

### Response: 200
```json
{
    "collection": {
        "info": {
            "name": "Test Collection",
            "description": "This is a test collection that makes a tiny request to Postman Echo service to get the list of request headers sent by a HTTP client.",
            "_postman_id": "12ece9e1-2abf-4edc-8e34-de66e74114d2",
            "schema": "https://schema.getpostman.com/json/collection/v2.0.0/collection.json",
            "updatedAt": "2022-06-16T20:21:13.000Z",
            "fork": {
                "label": "Test Fork",
                "createdAt": "2022-06-16T19:51:44.069Z",
                "from": "12345678-12ece9e1-2abf-4edc-8e34-de66e74114d2"
            }
        },
        "item": [
            {
                "name": "Test GET Response",
                "id": "82ee981b-e19f-962a-401e-ea34ebfb4848",
                "event": [
                    {
                        "listen": "test",
                        "script": {
                            "id": "7d2334fc-a84a-4c3d-b26c-7529afa4c0ae",
                            "exec": [
                                "pm.test(\"Status code is 200\", function () {",
                                "    pm.response.to.have.status(200);",
                                "});"
                            ],
                            "type": "text/javascript"
                        }
                    }
                ],
                "request": {
                    "url": "https://echo.getpostman.com/headers",
                    "method": "GET",
                    "header": [
                        {
                            "key": "Content-Type",
                            "value": "application/json"
                        }
                    ]
                },
                "response": []
            }
        ]
    }
}
```

### Response: 404
```json
{
    "error": {
        "name": "instanceNotFoundError",
        "message": "We could not find the collection you are looking for"
    }
}
```

### Response: 429
```json
{
    "error": "rateLimited",
    "message": "Rate limit exceeded. Please retry after 1669048687"
}
```


⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: Delete a collection
Deletes a collection.
### Method: DELETE
>```
>https://api.getpostman.com/collections/
>```
### Response: 200
```json
{
    "collection": {
        "id": "12ece9e1-2abf-4edc-8e34-de66e74114d2",
        "uid": "12345678-12ece9e1-2abf-4edc-8e34-de66e74114d2"
    }
}
```

### Response: 404
```json
{
    "error": {
        "name": "instanceNotFoundError",
        "message": "The specified item does not exist.",
        "details": {
            "item": "collection",
            "id": "12ece9e1-2abf-4edc-8e34-de66e74114d2"
        }
    }
}
```

### Response: 429
```json
{
    "error": "rateLimited",
    "message": "Rate limit exceeded. Please retry after 1669048687"
}
```


⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: Update a collection
Updates a collection using the [Postman Collection v2 schema format](https://schema.postman.com/json/collection/v2.1.0/docs/index.html). Include a `collection` object in the request body that contains the following required properties:

- `info` — An **object** that contains the following properties:
    - `name` — A **string** value that contains the collection's name.
    - `schema` — A **string** that contains a URL to the collection's schema. For example, the `https://schema.getpostman.com/collection/v1` URL.
- `item` — An **object** that contains the HTTP request and response information.
    - `request` — An **object** that contains the collection's request information. For a complete list of values, refer to the `definitions.request` entry in the [collection.json schema file](https://schema.postman.com/json/collection/v2.1.0/collection.json). If you pass an empty object for this value, the system defaults to an untitled GET request.

**Note:**

- For a complete list of available property values for this endpoint, use the following references available in the [collection.json schema file](https://schema.postman.com/json/collection/v2.1.0/collection.json):
    - `info` object — Use the `definitions.info` entry.
    - `item` object — Use the `definitions.items` entry.
- For all other possible values, refer to the [collection.json schema file](https://schema.postman.com/json/collection/v2.1.0/collection.json).
    

### Important

Use caution when using this endpoint. The system will replace the existing collection with the values passed in the request body.
### Method: PUT
>```
>https://api.getpostman.com/collections/
>```
### Headers

|Content-Type|Value|
|---|---|
|Content-Type|application/json|


### Body (**raw**)

```json
{
    "collection": {
        "info": {
            "name": "",
            "schema": ""
        },
        "item": [
            {
                "request": {}
            }
        ]
    }
}
```

### Response: 200
```json
{
    "collection": {
        "id": "12ece9e1-2abf-4edc-8e34-de66e74114d2",
        "name": "Test Collection",
        "uid": "12345678-12ece9e1-2abf-4edc-8e34-de66e74114d2"
    }
}
```

### Response: 403
```json
{
    "error": {
        "name": "forbiddenError",
        "message": "You do not have enough permissions to perform this action."
    }
}
```

### Response: 404
```json
{
    "error": {
        "name": "instanceNotFoundError",
        "message": "The specified item does not exist.",
        "details": {
            "item": "collection",
            "id": "12ece9e1-2abf-4edc-8e34-de66e74114d2"
        }
    }
}
```

### Response: 400
```json
{
    "error": {
        "name": "malformedRequestError",
        "message": "Found 2 errors with the supplied collection.",
        "details": [
            ": must have required property 'item'",
            "info: must have required property 'schema'"
        ]
    }
}
```

### Response: 400
```json
{
    "error": {
        "name": "collectionMismatchError",
        "message": "The collection ID in the path does not match the collection ID in the request body."
    }
}
```

### Response: 429
```json
{
    "error": "rateLimited",
    "message": "Rate limit exceeded. Please retry after 1669048687"
}
```


⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: Get all collections
Gets all of your [collections](https://www.getpostman.com/docs/collections). The response includes all of your subscribed collections.
### Method: GET
>```
>https://api.getpostman.com/collections
>```
### Query Params

|Param|value|
|---|---|
|workspace||


### Response: 200
```json
{
    "collections": [
        {
            "id": "dac5eac9-148d-a32e-b76b-3edee9da28f7",
            "name": "Cloud API",
            "owner": "12345678",
            "createdAt": "2022-04-12T10:29:46.000Z",
            "updatedAt": "2022-04-12T10:29:56.000Z",
            "uid": "12345678-dac5eac9-148d-a32e-b76b-3edee9da28f7",
            "isPublic": true
        },
        {
            "id": "12ece9e1-2abf-4edc-8e34-de66e74114d2",
            "name": "Test Collection",
            "owner": "12345678",
            "createdAt": "2022-01-13T10:21:46.000Z",
            "updatedAt": "2022-02-12T11:29:56.000Z",
            "uid": "12345678-12ece9e1-2abf-4edc-8e34-de66e74114d2",
            "isPublic": false,
            "fork": {
                "label": "Test Fork",
                "createdAt": "2022-06-16T19:51:44.069Z",
                "from": "12345678-12ece9e1-2abf-4edc-8e34-de66e74114d2"
            }
        },
        {
            "id": "f695cab7-6878-eb55-7943-ad88e1ccfd65",
            "name": "Postman Echo",
            "owner": "12345678",
            "createdAt": "2021-04-11T09:18:26.000Z",
            "updatedAt": "2022-05-01T15:29:32.000Z",
            "uid": "12345678-f695cab7-6878-eb55-7943-ad88e1ccfd65",
            "isPublic": true
        }
    ]
}
```

### Response: 200
```json
{
    "collections": [
        {
            "id": "dac5eac9-148d-a32e-b76b-3edee9da28f7",
            "name": "Cloud API",
            "owner": "12345678",
            "createdAt": "2022-04-12T10:29:46.000Z",
            "updatedAt": "2022-04-12T10:29:56.000Z",
            "uid": "12345678-dac5eac9-148d-a32e-b76b-3edee9da28f7",
            "isPublic": true
        }
    ]
}
```

### Response: 429
```json
{
    "error": "rateLimited",
    "message": "Rate limit exceeded. Please retry after 1669048687"
}
```


⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃
