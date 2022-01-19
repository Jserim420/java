# Scanner
- 기본적인 데이터 타입을 ```Scanner```를 통해 입력받을 수 있다.
- 공백(Space) 또는 줄 바꿈(Enter)을 기준으로 읽는다.
- ```Scanner``` 사용시 ```util``` 패키지의 ```Scanner``` 클래스를 호출해야 한다.
```java
import java.util.Scanner;
```

- ```Scanner``` 사용하기
    - 객체 생성
    ```java
    Scanner sc = new Scanner(System.in);
    ```
    - Scnnaer 입력 메소드
    ```java
    sc.nextByte()		// byte 형 입력 및 리턴
    sc.nextShort()		// short 형 입력 및 리턴
    sc.nextInt()		// int 형 입력 및 리턴
    sc.nextLong()		// long 형 입력 및 리턴
 
    sc.nextFloat()		// float 형 입력 및 리턴
    sc.nextDouble()		// double 형 입력 및 리턴
 
    sc.nextBoolean()	// boolean 형 입력 및 리턴
 
    sc.next()			// String 형 입력 및 리턴 (Space 기준)
    sc.nextLine()		// String 형 입력 및 리턴 (Enter 기준)
    ```
    문자를 입력받는 ```nextChar()```는 없으므로, ```charAt()```을 사용

<Br>

## Scanner를 통한 char 입력
- ```Scanner.next()```를 통해 입력받은 다음, ```String.charAt()```으로 char를 꺼낸다.
```java
Scanner sc = new Scanner(Sytsem.in);
sc.next().charAt(0); // String에 담겨있는 데이터의 첫번째 문자를 리턴한다.
```