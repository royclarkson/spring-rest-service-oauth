# spring-rest-service-oauth

## Build and Run

Build the app:

```sh
./gradlew clean build
```

Run the app:

```sh
java -jar build/libs/spring-rest-service-oauth-0.1.0.jar
```

## Usage

Request OAuth authorization:

```sh
curl -X POST -vu clientapp:123456 http://localhost:8080/oauth/token -H "Accept: application/json" -d "password=password&username=user&grant_type=password&scope=read%2Cwrite&client_secret=123456&client_id=clientapp"
```

A successful authorization results in the following response:

```json
{"access_token":"ff16372e-38a7-4e29-88c2-1fb92897f558","token_type":"bearer","expires_in":43199,"scope":"read write"}
```

Use the `access_token` returned in the previous request to make the authorized request to the protected endpoint:

```sh
curl http://localhost:8080/greeting -H "Authorization: Bearer <INSERT TOKEN>"
```

If the request is successful, you will see the following:

```json
{"id":1,"content":"Hello, World!"}
```