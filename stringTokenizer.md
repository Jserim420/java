# StringTokenizer
- 문자열이 한 종류의 구분자로 연결되어 있을 경우 ```StringTokenizer```클래스를 사용해 문자열을 분리해 낼 수 있다.
- ```StringTokenizer``` 객체를 생성할 때 첫 번째 매개값으로 전체 문자열을 주고, 두번째 매개값으로 구분값을 주면 된다.   
    ```java
    StringTokenizer st = new StringTokenizer("문자열","구분자");
    ```
- 구분자를 생략하면 space(공백)가 기본 구분자가 된다.
    ```java
    StringTokenizer st = new StringTokenizer("문자열");
    ```
- 구분자도 토큰에 포함할지 여부를 정할 수도 있다.
    ```java
    StringTokenizer st = new StringTokenizer("문자열","구분자",true/false);
    // true는 토큰에 포함, false는 토큰에 미포함이며 생략하면 false가 기본이 된다.
    ```

```java
String phoneNo = "010-1234-5678";
StringTokenizer st = new StringTokenizer(phoneNo, "-");
// 문자열이 "-"로 구분되어 있는 경우
```

<br>

- ```StringTokenizer``` 객체가 생성되면 부분 문자열을 분리해 낼 수 있는데, 다음 메소드를 이용해 전체 토큰 수, 남아 있는 토큰 여부를 확인한 후 토큰을 읽는다.
    - int형 ```countTonkens()``` : 꺼내지 않고 남아 있는 토큰의 수
    - boolean형 ```hasMoreTokens()``` : 남아 있는 토큰이 있는지 여부
    - String형 ```nextToken()``` : 토큰을 하나씩 꺼내옴
- ```nextToken()``` 메소드로 토큰을 하나 꺼내오면 ```StringTokenizer``` 객체에는 해당 토큰이 없어진다.
- 만약 ```StringTokenizer``` 객체에서 더 이상 가져올 토큰이 없다면 ```nextToken()``` 메소드는 ```java.util.NoSuchElementException``` 예외를 발생
    <br>
    >    ```nextToken()```을 사용하기 전에 ```hasMoreTokens()``` 메소드로 꺼내올 토큰이 있는지 조사한 후 ```nextToken()``` 메소드를 호출하는 것이 좋다.

<br>
<Br>

## StringTokenizer 예시
```java
import java.util.StringTokenizer;

public class StringTokenizerExample {
    public static void main(String[] args){
        String text = "010-1234-5678";

        //전체 토큰 수를 얻어 for문으로 루핑
        StringTokenizer st = new StringTokenizer(text,"-");
        int countToken = st.countTokens();
        for(int i=0; i<countToken; i++){
            String token = st.nextToken();
            System.out.println(token);
        }

        System.out.println();

        // 남아 있는 토큰을 확인하고 while문으로 루핑
        StringTokenizer st2 = new StringTokenizer(text,"-");
        while(st2.hasMoreTokens()){
            String token = st.nextToken();
            System.out.println(token);
        }
    }
}
```

