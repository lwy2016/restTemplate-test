RestTemplate

|HTTP method|RestTemplate methods|
|:-----:|:----:|
|DELETE|delete|
|GET|getForObject|
|.|getForEntity|
|HEAD|headForHeaders|
|OPTIONS|optionsForAllow|
|POST|postForEntity|
|.|postForObject|
|PUT|put|
|any|exchange|
|.|execute|

RestTemplate默认使用HttpMessageConverter实例将HTTP消息转换成POJO 或 从POJO转换成HTTP消息

## 1. getForObject
第一个是URI，第二个是期望返回类型，第三个是对应参数列表：无限个对应参数值或map键值对或没有
````
public <T> T getForObject(String url, Class<T> responseType, Object... uriVariables){}
public <T> T getForObject(String url, Class<T> responseType, Map<String, ?> uriVariables)
public <T> T getForObject(URI url, Class<T> responseType)
````
getForObject() 比getForEntity()多包含了将HTTP转成POJO的功能
但是getForObject没有处理response的能力
因为它拿到手的就是成型的POJO,省略了很多response的信息

## 2.getForEntity
获取响应的HTTP头相关信息，可以调用getForEntity,此方法返回ResponseEntity,包含了头信息
````
public <T> ResponseEntity<T> getForEntity(String url, Class<T> responseType, Object... uriVariables){}
public <T> ResponseEntity<T> getForEntity(String url, Class<T> responseType, Map<String, ?> uriVariables){}
public <T> ResponseEntity<T> getForEntity(URI url, Class<T> responseType){}
````
返回的请求信息
````
getHeaders()返回请求头
getHeaders().getDate()
getHeader().getContentType()
getHeader().getVary()
getHeader().getCacheControl()
getBody()返回请求体,即给定的POJO
getStatusCode()返回值和状态信息，如 200 OK
getStatusCodeValue()返回状态值，如 200
````

## 3. postForObject
第一个是URI，第二个是Post参数，可以是HttpEntity，或者是某个POJO对象，POJO对象在这种情况下会自动转成HTTPEntity，第三个参数是期望返回的类型
````
public <T> T postForObject(String url, @Nullable Object request, Class<T> responseType, Object... uriVariables) throws RestClientException {}                                   
public <T> T postForObject(String url, @Nullable Object request, Class<T> responseType, Map<String, ?> uriVariables)  throws RestClientException {}
public <T> T postForObject(URI url, @Nullable Object request, Class<T> responseType) throws RestClientException {}
````

## 4. postForEntity
