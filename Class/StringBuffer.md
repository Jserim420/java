# StringBuffer

## string 과의 차이 
- ```string```은 고정 길이의 불변문자열이므로 객체 변경시 객체가 변경되는 것이 아니라 새로운 객체를 생성하여 변경된다.
- ```StringBuffer```는 객체 변경시 객체 자체가 변경되기 때문에 가변 문자열이다.
- 문자열의 변경이 잦은 경우 ```String``` 대신 ```StringBuffer```를 사용한다.


<br>

## StringBuffer 선언
- 기본 생성자
```java
StringBuffer stringBuffer = new StringBuffer();
```
- int 값을 인자로 하는 생성자 : buffer의 사이즈를 지정
```java
StringBuffer stringBuffer = new StringBuffer(10);
```
- String 문자열을 인자로 하는 생성자
```java
StringBuffer stringBuffer = new StringBuffer("String");
```
<Br>

## StringBuffer 메소드
- [Oracle API Documnets](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/StringBuffer.html)

- ```append(String str)``` : 문자열 추가
```java
stringBuffer.append("Buffer"); // 문자열이 맨 뒤에 추가됨
```

- ```length()``` , ```capacity()``` : 문자열 길이, 할당된 버퍼의 개수 
```java
stringBuffer.length(); // 실제로 버퍼에 저장되어 있는 문자열의 길이
stringBuffer.capacity(); // 할당된 버퍼의 길이
```

- ```insert(int offset, String str)``` : 시작 인덱스를 지정하여 원하는 위치에 삽입
```java
stringBuffer.insert(10,"String"); // 10번째 인덱스에 String 문자열 추가
```

- ```reverse()``` : 문자열 뒤집기
```java
stringBuffer.reverse();
```

- ```delete(int start, int end)``` , ```deleteCharAt(int index)``` : 문자열 삭제
```java
stringBuffer.delete(4,7); // 4번 인덱스부터 6번 인덱스까지 문자열 삭제
stringBuffer.deleteCharAt(4); // 4번 인덱스 문자 삭제
```


- ```replace(int start, int end, String str)``` : start ~ (end-1)의 문자열 치환
```java
stringBuffer.replace(4,7,"Str"); // 4~6번의 문자열을 Str 로 치환
```
