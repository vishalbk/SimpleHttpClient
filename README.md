[![Build Status](https://travis-ci.org/vishalbk/SimpleHttpClient.svg?branch=master)](https://travis-ci.org/vishalbk/SimpleHttpClient) [![Coverage Status](https://coveralls.io/repos/github/vishalbk/SimpleHttpClient/badge.svg?branch=master)](https://coveralls.io/github/vishalbk/SimpleHttpClient?branch=master)

# Simple HTTP Client (SHC)
-----------------------------

## Introduction
A simple HTTP Client built on top of Apache HTTP Client APIs and depends basically on 
- org.apache.httpcomponents.httpclient

The primary goals to build this client was to :

- Have an easy to use HTTP client with minimal dependency footprint, unlike Spring RestTemplate a popular option which requires Spring core, web context dependencies and might not be suitable for projects which are using the legacy spring versions.
- Makes it easier to call JSON based REST APIs, with built in support for Jackson backed JSON serializing and unserializing.
- Directly use request/response POJOs for making JSON REST calls.
- Flexible API to support custom message converters, detailed exception capturing and reporting.
- Well documented with Javadocs available for all the packages and classes.
- Supports Basic Authentication.

## Usage

The Simple HTTP Client API currently provides support for the following HTTP requests as of now:

- HTTP GET
- HTTP POST

Support for other HTTP methods can also be added easily by referring to the already existing code of GET Request and POST request implementations.

The SHC API provides two levels of abstractions when making client calls : 
1. String Request/Response based calls
2. Jackson Compatible POJO based calls

### String Request/Response Based calls
- __Get Call With Basic Authentication__
```Java
    String url = "https://httpbin.org/get";
    AHttpGetRequest  aHttpGetRequest = new AHttpGetRequest();
    AHttpClientResponse aHttpClientResponse = aHttpGetRequest.executeGet(url,"username", "password");
``` 
> **Also see:**
>  AHttpGetRequestTest.java for complete call and use.

- __Post Call With basic Authentication__
```Java
String url = "https://httpbin.org/post";
String request = "{\"referenceID\":\"SASL\",\"bodID\":123456789,\"country\":\"US\"}";

AHttpPostRequest aHttpPostRequest = = new AHttpPostRequest();
AHttpClientResponse aHttpClientResponse = aHttpPostRequest.executePost(url, request,"username","password");

System.out.println(aHttpClientResponse.getResponseBody());
```
>**Also see:** 
>AHttpPostRequestTest.java for complete call and use.

### Jackson Compatible POJO based calls
SHC supports pojo based calls, with inbuilt support of request marshalling and response unmarshalling which is delegated to the ObjectMapper API of Jackson. Custom message converters can also be used.

- __GET call using a Jackson Compatible Response POJO__
```Java
String url = "https://httpbin.org/get?param1=test&param2=value";

SGetClient<HttpBinGetResponse> sGetClient = new SGetClient<HttpBinGetResponse>(url,HttpBinGetResponse.class);
SClientResponse<HttpBinGetResponse> response = sGetClient.getRequest();

System.out.println(response.getResponse());
```
>**Also See**
> - SGetClientTest.java for complete implementation
> - MessageConverter.java for message converter contract
> - JacksonMessageConverter for JSON Message converter

- __POST call using a Jackson Compatible Request & Response POJO__
```Java
String url = "https://httpbin.org/post";

// Jackson Compatible Request POJO
HttpBinPostRequest postRequest = new HttpBinPostRequest("SASL","122321", "United States");

SPostClient<HttpBinPostRequest, HttpBinPostResponse> sPostClient = new SPostClient<HttpBinPostRequest, HttpBinPostResponse>(url, postRequest, HttpBinPostResponse.class);
SClientResponse<HttpBinPostResponse> response = sPostClient.postRequest();

System.out.println(response.getResponse());
```
>**Also See**
> - SPostClientTest.java for complete implementation
> - MessageConverter.java for message converter contract
> - JacksonMessageConverter for JSON Message converter

## JAVADOCS
The javadocs for the SHC is available under the javadocs folder, which can be seen by checking the folder out.


## Build Instructions
1. mvn clean install should build the project jar.