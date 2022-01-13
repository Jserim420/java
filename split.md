# String.split()
- split함수는 입력받은 데이터를 특정 문자를 기준으로 문자열을 나누어 배열에 저장하여 리턴한다.

<br>

## ExampleCode 1
```java
String s = "010-1234-5678";
String[] phoneNo = s.split("-");
for(int i=0; i<phoneNo.length; i++){
    System.out.println(phoneNo[i]);
}
```
결과
> 010<Br>
1234<br>
5678

- " - " 을 기준으로 문자열을 나누어 배열에 저장

<Br>

## ExampleCode 2
```java
String s2 = "가,나,다,라";
String[] korean = s2.split(",");
for(int i=0; i<korean.length; i++){
    System.out.println(korean[i]);
}
```
결과
> 가<br>
나<br>
다<br>
라
- " , " 를 기준으로 문자열을 나누어 배열에 저장

<br>

## ExampleCode 3
```java
String s3 = "H e l l o";
String[] sayHi = s3.split(" ", 3);
for(int i=0; i<sayHi.length; i++){
    System.out.println(sayhi[i]);
}
```
결과
> H<br>
e<br>
l l o

- " " (Space)를 기준으로 문자열을 나누어 배열에 저장되며, split()하면서 배열의 크기는 3으로 제한했기 때문에 배열의 크기가 3개로만 생성된다.

