# 예외처리

## 예외
- 예외 : 사용자의 잘못된 조작 또는 개발자의 잘못된 코딩으로 인해 발생하는 프로그맬 오류로, 예외가 발생되면 프로그램은 곧바로 종료
- 예외 처리 : 프로그램을 종료하지 않고 정상 실행 상태가 되도록 유지
- 일반 예외 (컴파일러 체크 예외) : 컴파일 하는 과정에서 예외 처리 코드가 필요한지 검사하는 예외 - ```Exception```  상속
- 실행 예외 : 컴파일 과정에서 예외 처리 코드를 검사하지 않는 예외 - ```Exception``` 과 ```RuntimeException``` 상속

<br>

## 실행예외 
- 자바 컴파일러가 체크하지 않기 때문에 오로지 개발자의 경험에 의해 예외 처리 코드를 삽입해야 함

    1. ```NullPointerException``` : 객체가 없는 상태에서 객체를 사용하려고 했을 때 나타나는 예외
    2. ```ArrayIndexOutOfBoundsException``` : 배열에서 인덱스 범위를 초과하여 사용할 경우 나타나는 예외
        - 예외를 발생시키지 않기 위해서는 배열값을 읽기 전에 배열의 길이를 먼저 조사하고 사용하도록 한다.
    3. ```NumberFormatException``` : 숫자로 변환될 수 없는 문자가 포함되어 있는 문자열을 숫자로 리턴하고자 하는 경우 나타나는 예외
    4. ```ClassCastException``` : 억지로 타입변환을 시도할 경우 나타나는 예외
        - 예외를 발생시키지 않기 위해서는 타입 변환 전에 타입 변환이 가능한지 ```instanceof``` 연산자로 확인한다.

<br><br>

# 예외 처리 코드(```try- catch-```)
- 예외가 발생했을 경우 프로그램의 갑작스러운 종료를 막고, 정상 실행을 유지할 수 있도록 처리하는 코드
    ```java
    try { // 1
        예외 발생 코드 
    } catch(예외 클래스 e) { // 2
        예외 처리 
    } finally { //3
        항상 실행되는 코드 
    }
    ```
   
- 정상 실행되었을 경우 : 1 -> 3
- 예외가 발생되었을 경우 : 1 -> 2 -> 3
- ```try 블록```과 ```catch 블록```에서 return문을 사용하더라도 ```finally 블록```은 항상 실행

<br>

## 다중 catch
- 발생되는 예외 별로 예외 처리 코드를 다르게 할 때 사용

    ```java
    try {
        예외1 발생코드

        예외2 발생코드
    } catch(예외클래스1 e) {
        예외처리1
    } catch(예외클래스2 e) {
        예외처리2
    }
    ```
    - ```catch 블록```이 여러개라 할지라도 단 하나의 ```catch 블록```만 실행
    - try 블록에서 동시다발적으로 예외가 발생하지 않고, 하나의 예외가 발생하면 즉시 실행을 멈추고 해당 ```catch 블록```으로 이동

- 예외1에 ```Exception``` (모든 예외를 포함하는 클래스) 를 작성하면 하위 클래스의 ```catch 블록```이 실행되지 않기 때문에 예외1에 ```Exception```을 작성하지 않도록 한다.

<br>

## 멀티 catch
- 하나의 ```catch 블록```에서 여러 개의 예외를 처리할 수 있다.
```java
try {
    예외1 발생코드

    예외2 발생코드
} catch (예외클래스1 | 예외클래스2) {
    예외처리
}
```

<br><br>

# 예외 떠넘기기
- 메소드를 호출한 곳으로 예외를 떠넘긴다.
- ```throws``` : 메소드 선언부 끝에 작성되어 메소드에서 처리하지 않은 예외를 호출한 곳으로 떠넘기는 역할
```java
리턴타입 메소드명(매개변수, ···) throws 예외클래스1, 예외클래스2, ··· {
}

리턴타입 메소드명(매개변수, ···) throws Exception {
} // 모든 예외를 넘김
```
- ```throws``` 키워드가 붙어있는 메소드는 반드시 ```try 블록``` 내에서 호출
- ```catch 블록```에서 떠넘겨 받은 예외를 처리
    ```java
    public void method1() {
        try {
            method2();
        } catch (예외클래스 e) {
            예외처리    
        }   
    }

    public void method2() thorws 예외클래스 {
        예외 발생 코드
    }
    ```

<br><Br>

# 사용자 정의 예외
- 사용자 정의 예외 : 애플리케이션 서비스와 관련된 예외

<Br>

## 사용자 정의 예외 클래스 
- 일반 예외로 선언할 경우 ```Exception```을 , 실행 예외로 선언할 경우 ```RuntimeException```을 상속
```java
public class XXXException extends Exception | RuntimeException {
    // 매개 변수가 없는 생성자
    public XXXException() { }
    
    // 예외 메시지를 전달하기 위한 String 타입의 매개 변수를 갖는 생성자
    public XXXException(String message) {
        super(message);
    }
}
```

<Br>

## 예외 발생 시키기
    
```java
throw new XXXException();
throw new XXXException("전달 메시지");
```

- 예외 객체를 생성할 때는 둘 중 어떤 생성자를 사용해도된다.
- ```catch 블록```에서 예외 메시지가 필요하면 예외 메시지를 갖는 생성자를 이용한다.

<br>

```java
try {
    method();
} catch(XXXException e) {
    예외처리
}
```

- 대부분 자신을 호출한 곳에서 예외를 처리하도록 ```throws``` 키워드로 예외를 떠넘긴다.
- ```throws``` 키워드를 포함하고 있는 메소드는 호출한 곳에서 예외 처리를 해줘야 한다.

<Br><Br>

# 예외 정보 얻기
- 모든 예외 객체는 ```Exception``` 클래스를 상속하기 때문에 ```Exception```이 가지고 있는 메소드들은 모든 예외 객체에서 호출 가능

<Br>

## 예외 메시지 얻기 ```getMessage()```
- 예외 메시지는 ```getMessage()``` 메소드의 리턴값으로 얻을 수 있다.
```java
catch(Exception e) {
    String message = e.getMessage();
}
```

<Br>

## 예외 발생 코드 추적 ```printStackTrace()```
- 예외 발생 코드를 추적해 모두 콘솔에 출력
```java
catch(Exception e) {
    String message = e.getMessage();

    e.printStackTrace();
}
```