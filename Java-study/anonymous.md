# 익명(annoymous) 객체
- 이름이 없는 객체
- 단독으로 생성할 수 없고 클래스를 상속하거나 인터페이스를 구현해야만 생성 가능
- 필드의 초기값이나 로컬 변수의 초기값, 매개 변수의 매개값으로 주로 대입

<br>

## 익명 자식 객체 생성
- 자식 클래스가 재사용되지 않고 오로지 해당 필드와 변수의 초기값으로만 사용할 경우라면 익명 자식 객체를 생성해서 초기값으로 대입하는 것이 좋다.
    ```java
    부모클래스 [필드|변수] = new 부모클래스(매개값, ···) {
        //필드, 메소드 ···
    };
    ```
- **생성자를 선언할 수 없다.**

1. 필드를 선언할 때 초기값으로 익명 자식 객체를 생성해서 대입
    ```java
    class A{
        Parent field = new Parent() {
            int childField();
            void childMethod() { }
            @Override
            void parentMthod() { }
        };
    }
    ```
2. 메소드 내에서 로컬 변수를 선언할 때 초기값으로 익명 자식 객체를 생성해서 대입
    ```java
    class A{
        void method() {
            Parent localVar = new Parent() {
            int childField();
            void childMethod() { }
            @Override
            void parentMthod() { }
            };
        }
    }
    ```
3. 메소드의 매개 변수가 부모 타입일 경우 메소드 호출 코드에서 익명 자식 객체를 생성해 매개값으로 대입
    ```java
    class A{
        void method1(Parent parent) { }

        void method2() {
            method1(
                new Parent() {
                    int childField();
                    void childMethod() { }
                    @Override
                    void parentMthod() { }
                }
            );
        }
    }
    ```

- **익명 자식 객체에 새롭게 정의된 필드와 메소드는 익명 자식 객체 내부에서만 사용되고, 외부에서는 필드와 메소드에 접근할 수 없다.**

<br>

## 익명 구현 객체 생성
- 구현 클래스가 재사용되지 않고, 오로지 해당 필드와 변수의 초기값으로만 사용하는 경우라면 익명 구현 객체를 초기값으로 대입하는 것이 좋다.
    ```java
    인터페이스 [필드|변수] = new 인터페이스() {
        // 인터페이스에 선언된 추상 메소드의 실체 메소드 선언
        // 필드, 메소드 ···
    };
    ```
    - 중괄호{} 에는 인터페이스에 선언된 모든 추상 메소드드르이 실체 메소드를 작성해야 한다.
- 추가적으로 필드와 메소드를 선언할 수 있지만, 실체 메소드에서만 사용이 가능하고 외부에서는 사용하지 못한다.
1. 필드를 선언할 때 초기값으로 익명 구현 객체를 생성해서 대입
    ```java
    class A{
        RemoteControl field = new RemoteControl() {
            @Override
            void trunOn() { }
        };
    }
    ```
2. 메소드 내에서 로컬 변수를 선언할 때 초기값으로 익명 구현 객체를 생성해서 대입
    ```java
    class A{
        void method1() {
            RemoteControl localVar = new RemoteControl() {
                @Override
                void turnOn() { }
            }
        };
    }
    ```
3. 메소드의 매개 변수가 인터페이스 타입일 경우, 메소드 호출 코드에서 익명 구현 객체를 생성해 매개값으로 대입
    ```java
    class A{
        void method1(RemoteControl rc){ }
        void method2() {
            method1(
                new RemoteControl() {
                    @Override
                    void trunOn();
                }
            );
        }
    }
    ```

<br>

## 익명 객체의 로컬 변수 사용
- 익명 객체 내부에서는 바깥 클래스의 필드나 메소드는 제한 없이 사용할 수 있다.
- 메소드의 매개 변수나 로컬 변수를 익명 객체에서 사용할 때
    - 익명 객체 내부에서 메소드의 매개 변수나 로컬 변수를 사용할 경우, 이 변수들은 ```final``` 특성을 가져야 한다.
- **익명 객체에서 사용된 매개 변수와 로컬 변수는 모두 ```final``` 특성**을 갖는다.
```java
public class Annoymous{
    private int field;

    public void method(final int arg1, int arg2){
        final int var1 = 0;
        int var2 = 0;

        field = 10;

        arg1=29; // ERROR
        arg2=20; // ERROR
        var1=30; // ERROR
        var2=30; // ERROR

        Calculatable clac = mew Calculatable() {
            @Override
            public int sum() {
                int reuslt = field + arg1 + arg2 + var1 + var2;
                return result;
            }
        };

    }
}
```