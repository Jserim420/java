# ```instanceof ```
- 매개값의 타입을 조사할 때 주로 사용
- 메소드 내에서 갖에 타입 변환이 필요할 경우 반드시 매개값이 어떤 객체인지 ```instanceof``` 연산자로 확인하고 안전하게 강제 타입 변환을 해야 한다.

```java
boolean result = 객체 instance 타입
```
- ```instaceof``` 연산자의 왼쪽에는 객체가, 오른쪽에는 타입이 온다.
- 왼쪽의 객체가 오른쪽의 인스턴스 즉 우항의 타입으로 객체가 생성되었다면 true를, 그렇지 않으면 false를 반환한다.

<Br>
<Br>
<Br>

# 타입 변환

## 자동 타입 변환
- 프로그램 실행 도중, 자동적으로 타입 변환이 일어나는 것
- 자식 타입을 부모 타입으로 변환
    ```java
    부모클래스 변수 = new 자식클래스();
    ```
- 자식은 부모의 특징과 기능을 상속받기 때문에 부모와 동일하게 취급

    ```java
    Cat catA = new Cat();
    // Cat 타입이고 Cat객체를 참조하는 catA 생성
    Animal animalA = cat();
    // Animal 타입이고 Cat객체를 참조하는 animalA 생성
    // Cat 타입이고 Cat 객체를 참조하는 animalA를 Animal 타입으로 형변환하여 생성
    ```
    - **catA와 animalA는 타입이 다르지만 같은 객체를 참조한다.** 
- 바로 위의 부모가 아니더라도 상속 계층에서 상위 타입이라면 자동 타입 변환이 일어날 수 있다,
- **부모 타입으로 자동 타입 변환된 이후에는 부모 클래스에 선언된 필드와 메소드만 접근이 가능하다.**
- **하지만 메소드가 자식 클래스에서 오버라이딩 되었다면 자식 클래스의 메소드가 대신 호출된다.**

<br>

## 강제 타입 변환
- 부모 타입을 자식 타입으로 변환
- **자식 타입이 부모 타입으로 자동 변환한 후, 다시 자식 타입으로 변활할 때 강제 타입 변환을 사용할 수 있다.**
    ```java
    자식클래스 변수 = (자식클래스) 부모클래스타입;
    // 부모클래스타입은 자식 타입이 부모타입으로 변환된 상태이다.
    ```
    - 자식 타입에 선언된 필드와 메소드를 꼭 사용해야할 경우 강제 타입 변환을 사용

<br>
<Br>

## 예시
```java
public class Parent{

}
```
```java
public class Child extends Parent{

}
```
```java
public class extendExample{
    public static void methodA(Parent parent){
        if(parent istanceof Child){ 
            // 매개값 parent가 Child 객체를 참조하는지 확인
            Child c1 = (Child) parent;
            // Parent형이지만 Child 객체를 참조하는 매개값 parent를 Child 타입으로 강제 형변환하여 c1을 생성
            System.out.println("methodA - 변환성공");
        } else System.outprintln("methodA - 변환실패") ;
    }

    public static void methodB(Parent parent){
        Child c1 = (Child) parent;
        Systme.out.println("methodB - 변환성공");
    }

    public static void main(String[] args){
        Parent p1 = new Child(); 
        // Child 객체를 참조하는 Child 타입을 p1에 Parent타입으로 형변환하여 생성
        methodA(p1);
        methodB(p1);

        Parent p2 = new Parent();
        // Parent 객체를 참조하고 Parent 타입인 p2를 생성
        methodA(p2);
        methodB(p2);
    }
}
```