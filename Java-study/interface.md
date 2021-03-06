# 인터페이스(interface)
- 객체의 사용 방법을 정의한 타입
- 개발 코드가 인터페이스의 메소드를 호출하면 인터페이스는 객체의 메소드를 호출
- 개발 코드를 수정하지 않고, 사용하는 객체를 변경할 수 있도록 하기 위해 사용
- **하나의 객체가 아니라 여러 객체들과 사용이 가능하므로 어떤 객체를 사용하느냐에 따라 실행 내용과 리턴값이 상이**

<br><Br>

## 인터페이스 선언하기

```java
interface 인터페이스명 {
    // 상수
    타입 상수명 = 값 ;
    // 추상 메소드
    타입 메소드명(매개변수, ···);
    // 디폴트 메소드 
    default 타입 메소드명(매개변수, ···) {···}
    // 정적 메소드
    static 타입 메솓명(매개변수) {···}
}
```
1. **상수 필드** 
    - 인터페이스에 고정된 값
    - 런타임 시에 데이터를 바꿀 수 없으며, 선언시 반드시 초기값을 대입

2. **추상 메소드**
    - 객체가 가지고 있는 메소드를 설명한 것
    - 호출할 때 어떤 매개값이 필요하고, 리턴값이 무엇인지만 알려줌
    - 실제 실행부는 (구현)객체가 가지고 있음

3. **디폴트 메소드**
    - 인터페이스에 선언되지만 사실 (구현)객체가 가지고 있는 인스턴스 메소드
    - *추상 메소드가 아닌 인스턴스 메소드이므로 구현 객체가 있어야 사용 가능*
    - 인터페이스의 모든 구현 객체가 가지고 있는 기본 메소드
    - 메소드 오버라이딩을 통해 재정의한 메소드 호출 가능
    - 기존 구현 클래스 코드 수정없이 디폴트 메소드를 생성가능 ( + 새로운 구현 클래스도 함께 생성 )
4. **정적 메소드**
    - 디폴트 메소드와 달리 객체가 없어도 인터페이스만으로도 선언 가능

<Br>

## 구현 클래스
- 인터페이스에 선언된 추상 메소드의 실체 메소드 선언
- 인터페이스의 모든 메소드는 기본적으로 ```public``` 접근 제한을 갖기 때문에 ```public```보다 더 낮은 접근 제한으로 작성 불가
```java
public class 구현클래스명 implements 인터페이스명 {
    //인터페이스에 선언된 추상 메소드의 실체 메소드 선언
}
```
- 구현 클래스가 작성되면 new 연산자로 객체 생성 가능

<br>

## 구현 객체
1.  인터페이스 변수를 선언하고 구현 객체를 대입
    ```
    // 방법1
    인터페이스 변수;
    변수 = 구현객체;

    // 방법2 
    인터페이스 변수 = 구현객체;
    ```

2. 익명 구현 객체
- 1회성 객체 생성 시 사용(임시 작업 스레드)
    ```java
    인터페이스 변수 = new 인터페이스() {
        //인터페이스에 선언된 추상 메소드의 실체 메소드 선언
    }
    ```

