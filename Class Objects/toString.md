# Objects.toString()
- 객체의 문자 정보 리턴
- ```toString(Object o, [String nullDefault])```
    - ```not null```이면 ```o.toString()```리턴
    - ```null```이면 ```"null"``` 또는 두번째 매개값 ```nullDefault``` 리턴

<br>

## 예시
```java
String name = "홍길동";
String name2 = null;

System.out.println(Objcects.toString(name));
System.out.println(Objcects.toString(name2));
System.out.println(Objcects.toString(name2, "이름이 없다" ));
```
> 결과
```
홍길동
null
이름이 없다.
```