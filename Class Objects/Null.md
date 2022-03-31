# isNull()
- ```Objects.isNull(Object obj)``` : 매개값이 ```null```일 경우 ```true``` 리턴

<br>

# nonNull()
- ```nonNull(Object obj)``` : 매개값이 ```not null```일 경우 ```true``` 리턴

<br>

# requireNonNull()
- ```requireNonNull(T obj)``` : 매개값이 ```not null```일 경우 ```obj``` 리턴, ```null```일 경우 ```NullPointerException``` 예외 발생
- ```requireNonNull(T obj, String message)``` : 매개값이 ```not null```일 경우 ```obj``` 리턴, ```null```일 경우 ```NullPointerException```의 예외 메시지 제공
- ```requireNonNull(T obj, Supplier<String> msgSupplier)``` : 매개값이 ```not null```일 경우 ```obj``` 리턴, ```null```일 경우 ```NullPointerException(msySupplier.get())```

<br>
<br>

# 예시
```java
String name = "홍길동";
String name2 = null;
System.out.println(Objects.requireNonNull(name));

try {
    String name = Objects.requireNonNull(name2, "이름이 없습니다.");
} catch(Exception e) {
    System.out.println(e.getMessage());
}
```