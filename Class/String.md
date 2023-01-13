# String(java.lang.String)
- 문자열 생성, 추출, 비교, 찾기, 분리, 변환 등을 제공하는 클래스

<br>

## String 메소드
- [Oracle API Documents](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/String.html)

- ```charAt(int index)``` : 특정 위치의 문자 리턴
    ```java
    String str = "String 메소드";
    str.charAt(3); // str의 인덱스가 3번인 문자 i 리턴
    ```

- ```contains(CharSequence s)``` : s 문자열 포함 여부
    ```java
    str.contains("Str"); // str에 "Str" 문자열이 포함되어 있으면 true, 아니면 flase 리턴
    ```

- ```equals(Object object)``` : 두 문자열 비교
    ```java
    String str2 = "string 메소드";
    str.equals(str2); // str과 str2의 문자열을 비교해서 같으면 true, 아니면 false 리턴
    ```

- ```indexOf(String str)``` : 문자열 내에서 주어진 문자열의 위치 리턴
    ```java
    str.indexOf("메소드"); // str에 "메소드"가 포함된 인덱스 번호 7 리턴
    ```

- ```length()``` : 총 문자 수 리턴
    ```java
    str.length(); /// str의 길이 10 리턴
    ```

- ```replace​(CharSequence target, CharSequence replacement)``` : 특정 문자열을 대체 문자열로 변경
    ```java
    str.replace("String", "string"); // str의 String이 string으로 변경
    ```

- ```replaceAll​(String regex, String replacement)``` : 문자열에 포함되어 있는 특정 문자열을 모두 대체 문자열로 변경
    ```java
    String randomStr = "1d4w9d8g6w8";
    randomStr.replaceAll("[0~9]", "0"); // randomStr에 포함된 숫자를 모두 0으로 대체 후 출력
    ```

- ```substring(int beginIndex, int endIndex)``` : 문자열 잘라내기
    ```java
    str.substring(3); // str의 3번 인덱스부터 끝까지 잘라낸 문자열 리턴
    str.substring(3,7); // str의 3~6번 인텍스를 잘라낸 문자열 리턴
    ```

- ```trim()``` : 앞뒤 공백을 제거한 새로운 문자열 리턴
    ```java
    String newStr = "       Hello  Java~! "; // 앞 뒤 공백을 제거한 "Hello  Java" 리턴
    ```

- ```valueOf(int i)``` : 기본 타입값을 문자열로 리턴
    ```java
    int age = 20;
    String.valueOf(age); // age가 String 문자열 타입으로 변환
    ```