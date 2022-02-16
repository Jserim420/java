# parseInt()
- 문자열(String) 을 숫자(int) 으로 변환
- ```Integer.parseInt();```

<br>
<br>

## 사용하기
```java
Integer.parseInt(String s)
Integer.parseInt(String s, int radix) // 첫번째 인자의 값을 두번째 인자의 값(해당 진수의 값)으로 변환
```

## 예시
```java
int a = Integer.parseInt("10");
int b = Integer.parseInt("1001",8);
```
<br>

---

<br>

```java
int a = Integer.parseInt("123")
int b = Integer.parseInt("456");
result = a + b;
System.out.println(a);
System.out.println(b);
System.out.println(result);
```
>결과
```java
123
456
579
```