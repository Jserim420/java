# equals()
- 객체 비교 : 비교 연산자인 == 과 동일한 결과를 리턴
- 두 객체가 논리적으로 동등한 객체라면 ```true```를, 그렇지 않으면 ```false```를 리턴
- 같은 객체이건, 다른 객체이건 상관없이 객체가 저장하고 있는 데이터가 동일할때 ```true```리턴

<Br>

## ```eqauls()``` 사용
```java
public static String main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String str = sc.next();
    if(str.equals("홍길동")) {
        return "홍길동";
    } else return str;
}
```

> 결과
```
입력받은 ```str```이 "홍길동"과 같으면 "홍길동"을 리턴,
그렇지 않으면 ```str```을 리턴
```

## ```eqauls()``` 메소드 재정의
- 매개값이 기준 객체와 동일한 타입의 객체인지 ```instanceof``` 연산자로 먼저 확인해야 함
```java
// eqauls() 메소드 재정의
@Override
public boolean equals(obj insatnceof Member) { // 매개값이 Member타입인지 확인
    // Member 타입으로 강제 타입 변환하고 id 필드값이 동일한지 검사한 후 , 동일하다면 true 리턴
    Member member = (Member) obj;
    if(id.equals(member.id)) {
        return true;
    }
    return false;
}
```