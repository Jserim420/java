# 중첩 클래스와 중첩 인터페이스
- 클래스 내부에 선언한 클래스
- 클래스가 특정 클래스와 관계를 맺을 경우 관계 클래스를 클래스 내부에 선언하는것이 좋다.
- ***인터페이스도 클래스 내부에 선언할 수 있다.***
```java
class ClassName{
    class NestedClassName{
    } // 중첩 클래스
}

class ClassName{
    interface NestedInterfaceName{
    } // 중첩 인터페이스
}
```
- 중첩 인터페이스는 주로 UI 프로그래밍에서 이벤트를 처리할 목적으로 활용

<br><Br>

# 중첩 클래스
1. 멤버 클래스 : 클래스의 멤버로서 선언되는 중첩 클래스
    - 인스턴스 멤버 클래스 
        ```JAVA
        class A{
            class B{···}
        }
        ```
        - A 객체를 생성해야만 사용할 수 있는 B 중첩 클래스
    - 정적 멤버 클래스
        ```java
        class A{
            static class B{···}
        }
        ```
        - A 클래스로 바로 접근할 수 있는 B 중첩 클래스
2. 로컬 클래스 : 메소드 내부에서 선언되는 중첩 클래스
    ```java
    class A{
        void method(){
            class B{···}
        }
    }
    ```
    - ```method()```가 실행될 때만 사용할 수 있는 B 중첩 클래스

<br>

## 인스턴스 멤버 클래스
- ```static``` 키워드 없이 선언된 클래스
- 인스턴스 멤버 클래스는 인스턴스 필드와 메소드만 선언이 가능하고 *정적 필드와 메소드는 선언할 수 없다*.
    ```java
    class A{
        class B{
            B() { }
            int field1;
            void method1() { }
        }
    }
    ```
- **A 클래스 외부에서 인스턴스 멤버 클래스 B의 객체를 생성하려면 먼저 A 객체를 생성하고 B 객체를 생성해야 한다.**
    ```java
    A a = new A()
    A.B b = a.new B();
    b.field1 = 1;
    b.method1();
    ```

<br>

## 정적 멤버 클래스
- ```static``` 키워드로 선언된 클래스
- 정적 멤버 클래스는 *모든 종류의 필드와 메소드를 선언*할 수 있다.
    ```java
    Class A{
        static class C{
            c() { }
            int field1;
            static int field2;
            void method1() { }
            static void method2() { }
        }
    }
    ```
- **A 클래스 외부에서 정적 멤버 클래스 C의 객체를 생성하기 위해서는 A 객체를 생성할 필요가 없고, 바로 C 객체를 생성한다.**
    ```java
    A.C c = new A.C();
    c.field1 = 2;
    c.metohd1();
    A.C.field2 = 3;
    A.C.metohd2();
    ```

<br>

## 로컬 클래스
- 메소드 내에서 선언된 클래스
- 로컬 클래스는 *접근 제한자 및 ```static```을 붙일 수 없*다. (메소드 내부에서만 사용되므로 접근을 제한할 필요가 없음)
- 로컬 클래스 *내부에는 정적 필드와 메소드를 선언할 수 없*다.
- 로컬 클래스는 메소드가 실행될 때 **메소드 내에서 객체를 생성하고 사용해야 한다.**
    ```java
    void method() {
        class DownloadThread extends Thread {···}
        DownloadThread thread = new DownloadThread();
        thread.start();
    }
    ```

<br><br>

# 중첩 클래스의 접근 제한
## 바깥 필드와 메소드에서의 사용 제한
- **인스턴스 멤버 클래**스는 바깥 클래스의 인스턴스 필드의 초기값이나 인스턴스 메소드에서 객체를 생성할 수 있으나
- *정적 필드의 초기값이나 정적 메소드에서는 객체를 생성할 수 없다*.
- **정적 멤버 클래스**는 *모든 필드의 초기값이나 모든 메소드에서 객체를 생성할 수 있다*.
    ```java
    public class A{

        B field1 = new B();
        C field2 = new C();

        void method1() {
            B var1 = new B();
            C var2 = new C();
        }

        static B fieldB = new B(); // ERROR
        static C fieldC = new C();

        static void method2() {
            B var1 = new B(); // ERROR
            C var2 = new C();
        }
        class B{ }
        static class C{ }
    }
    ```

<br>

## 멤버 클래스에서의 사용 제한
- **인스턴스 멤버 클래스 안**에서는 *바깥 클래스의 모든 필드와 모든 메소드에 접근 가능*
- **정적 멤버 클래스 안**에서는 *바깥 클래스의 정적 필드와 메소드에만 접근*할 수 있고 인스턴스 필드와 메소드는 접근할 수 없다.

    ```java
    class A{
        int field1;
        void method1() { }

        static int field2;
        static void method2() { }

        class B{
            void method() {
                field 1 = 10;
                method1();

                field2 = 20;
                method2();
            }
        }

        static class C{
            void method() {
                field 1 = 10; // ERROR
                method1(); // ERROR

                field2 = 20;
                method2();
            }
        }
    }
    ```

<br>

## 로컬 클래스에서의 사용 제한
- 로컬 클래스 내부에서는 바깥 클래스의 필드나 메소드를 제한 없이 사용 가능
- 메소드의 매개 변수나 로컬 변수를 로컬 클래스에서 사용할 때
    - 로컬 클래스에서 사용 가능한 것은 ```final```로 선언된 매개 변수와 로컬 변수뿐
    - ```final``` 선언을 하지 않아도 여전히 ```final```의 특성을 갖는다는 의미
    - ```final``` 키워드가 있따면 로컬 클래스의 메소드 내부에 지역 변수로 복사되지만, ```final``` 키워드가 없다면 로컬 클래스의 필드로 복사

```java
public class Outter{
    public void method1(int arg){
        int localVariable = 1;
        arg = 10; // ERROR
        localVariable = 2; // ERROR
        class Inner{
            int result = arg + localVariable;
        }
    }
}
```

<br>

## 중첩 클래스에서 바깥 클래스 참조 얻기
- 참조 : 클래스 내부에서 ```this```는 객체 자신의 참조
- 중첩 클래스에서 ```this``` 키워드를 사용하면 바깥 클래스의 객체 참조가 아니라 중첩 클래스의 객체 참조가 된다.
```java
바깥클래스.this.[필드 또는 메소드()] ;
this.[필드 또는 메소드()];
// 두 개는 서로 다른 객체를 참조한다.
```