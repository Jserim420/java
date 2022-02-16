# toString()

- 객체가 가지고 있는 정보나 값을 문자열로 만들어 리턴
-  기본적으로 ```Object``` 클래스의 ```toString()```은 ```클래스명@16진수해시코드``` 로 구성된 문자 정보 리턴

<br>
<br>

## 선언
1. java 패키지의 클래스 사용
    ``` java
    Object obj1 = new Object();
    Date obj2 = new Date();
    
    System.out.println(obj1.toString());
    System.out.prinltln(Obj2.toString());
    ```
    <br>

2. 오버라이딩(함수 재정의)
    ```java
    public class myInfo{
        private String name;
        private int age;

        public myInfo(String name, int age){
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString(){
        return name + ", " + age + "세";
        }
    }   
    ```
    ```java
    public class myInfoExample {
    public static void main(String[] args){
        myInfo myinfo = new myInfo("홍길동", 20);

        String strObj = myinfo.toString();
        System.out.println(strObj);
        System.out.println(myInfo); 
        // myInfo.toString()을 자동 호출해서 리턴 값 얻은 후 출력
        }
    }
    ```
    - 매개값이 개본 타입일 경우, 해당 값 그대로 출력
    - **매개값으로 객체를 주면 객체의 ```toString()```메소드를 호출해 리턴값을 받아 출력**

<Br>

3. ```Integer.toString();``` 
- 숫자(Int)를 문자열(String)로 변환

    ```java
    String s1 = Integer.toString(123)
    String s2 = Integer.toString(456);
    String result = s1 + s2;

    System.out.println(s1);
    System.out.println(s2);
    System.out.println(result);
    ```
    
    > 결과
    ```
    123
    456
    123456
    ```