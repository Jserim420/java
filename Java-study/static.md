# ```Static```

## 정적 멤버
- 클래스에 고정된 멤버로서 객체를 생성하지 않고 사용할 수 있는 필드와 메소드
- 객체(인스턴스)에 소속된 멤버가 아니라 클래스에 소속된 멤버이기 때문에 클래스 멤버라고도 한다.
```
static 타입 필드 [ = 초기값];
static 리턴타입 메소드이름 (매개변수선언, ···) {···}
```
> 필드를 선언할 때 인스턴스 필드로 선언할 것인가, 정적 필드로 선언할 것인가?
- 객체마다 가지고 있어야 할 데이터라면 **인스턴스 필드**로, 객체마다 가지고 있을 필요성이 없는 공용적인 데이터라면 **정적 필드 static**로 선언
- 정적 멤버 사용
    ```
    클래스. 필드;
    클래스. 메소드(매개값, ···);
    ```
    정적 필드와 정적 메소드는 원칙적으로 클래스 이름으로 접근해야 하지만 객체 참조 변수로도 접근이 가능 (하지만 클래스 이름으로 접근하는 것이 좋다.)

    ```java
    public class Speed {
        static int speedA = 100;
        static int plus(int a, int b){
            ···
        }
    }
    ```
    ```java
    // 클래스 이름으로 접근
    int result = 10 * Speed.speedA;
    int resultA = Speed.puls(10, 30); 

    // 객체 참조 변수로 접근
    Speed mySpeed = new Speed();
    int result = mySpeed.speedA + 10;
    int resultA = mySpedd.plus(1,2);    
    ```

<br>

## 정적 초기화
- 인스턴스 필드는 생성자에서 초기화하지만 정적 필드는 객체 생성 없이도 사용해야 하므로 **생성자에서 초기화 작업을 할 수 없다.**
- 정적 필드를 위한 초기화 작업은 **정적 블록**을 사용한다.
```java
public class Introduce {
    static String university = "한국대";
    static String name = "홍길동";
    static String intro;

    static {
        intro = university + " " + name;
    }
}

public class IntroduceEx {
    public static void main(String[] args){
        System.out.println(Introduce.intro);
    }
}
```
- 정적 블록은 클래스가 메모리로 로딩될 때 자동적으로 실행
- 클래스 내부에 여러개가 선언되어도 상관없으며, 클래스가 메모리로 로딩될 때 선언된 순서대로 실행

<br>

## 정적 메소드와 블록 선언
- 객체가 없어도 실행 되기 때문에, 이들 **내부에 인스턴스 필드나 인스턴스 메소드를 사용할 수 없**으며, 객체 자신의 참조인 **```this``` 키워드도 사용이 불가능**
- 인스턴스 멤버를 사용하고 싶다면 객체를 먼저 생성하고 참조 변수로 접근해야 함

```java
public class Speed{
    int speedA = 100;
    void method1() {···}

    static int SpeedB = 200;
    static void method2() {···}

    static{
        speedA = 10; // 컴파일 에러
        this.speedA = 10; // 컴파일 에러
        method1(); // 컴파일 에러

        speedB = 10;
        method2();
    }

    staic void method3() {
        Speed mySpeed = new Speed();
        mySpeed.speedA = 6;
        mySpeed.method1();
    }
}
```

> main() 함수도 정적(static) 함수 이므로, 객체 생성 없이 인스턴스 필드와 인스턴스 메소드를 main() 함수에서 바로 사용할 수 없다.

<br>

# ```final```
- 초기값이 저장되면 이것이 최종적인 값이 되어 프로그램 실행 도중 수정할 수 없다.
```
final 타입 필드명 [ = 초기값 ];
```
- 초기값을 주는 방법 : 필드 선언 시, 생성자(매개값)
    ```java
        public class Person {
            final String nation = "대한민국";
            final Stirng koResident;
            String name;
            
            public Person(String koR, String name){
                koResident=koR;
                this.name=name;
            }
        }
    ```
    ```java
    public class PersonExample{
        public static void main(String[] args){
            Person person1 = new Person("000000-0000000", "홍길동");
            // final 필드 값은 수정 불가
        }
    }
    ```

<br>

# 상수(```static final```)
- 상수 : 불변의 값을 저장하는 필드

    > ```final``` 필드는 왜 상수라고 하지 않는가?

    - 불변의 값(상수)은 객체마다 저장할 필요가 없는 공용성을 띄고 있으며, 여러가지 값으로 초기화 될 수 없다.
    - 하지만, final 필드는 객체마다 저장되고, 생성자의 매개값을 통해 여러가지 값을 가질 수 있다.
- 상수는 ```static```이면서 ```final``` 이어야 한다.
- ```static final```은 객체마다 저장되지 않고, 클래스에만 포함되며, 한 번 초기값이 저장되면 변경할 수 없다. 
    ```java
    static final 타입 상수명 [ = 초기값 ];
    ```

- 초기화
    - 초기값이 단순 값일 경우 선언 시에 주고, 복잡한 초기화일 경우 정적 블록에서 한다.

```java
public class Earth {
    static final double EARTH_RADIUS = 6400;
    static final double EARTH_SURFACE_AREA;

    static{
        EARTH_SURFACE_AREA = 4 * math.PI * EARTH_RADIUS * EARTH_RADIUS;
    }
}
```
```java
public static void main(String[] args){
    System.out.println("지구의 반지름 : " + EARTH_RADIUS + "km");
    System.out.println("지구의 표면적 : " + EARTH_SURFACE_AREA + "km^2");
}
```
    