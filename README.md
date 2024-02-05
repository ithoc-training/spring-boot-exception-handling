# Spring Boot Exception Handling

## Overview
Spring Boot provides a global exception handling that can be defined once for the application and used
at several sites from within the controller layer.

## Implementation
1. Create an exception that derives from *RuntimeException*. 
2. Create a *ControllerAdvice* with one *ExceptionHandler* for each error case of the REST API.
3. Handle error cases in the *RestController* and just throw the previously defined exception in case of occurrence.

## Testing
```shell
curl --location 'http://localhost:18085/api/items/42'
```
Note that the ID 42 does not exist, thus an error is responded by the REST API resource.
