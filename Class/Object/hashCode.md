# hashCode()
- *객체 해시코드* : 객체를 식별할 하나의 정수값
- ```hashCode()``` : 객체의 메모리 번지를 이요해 해시코드를 만들어 리턴하기 때문에 객체마다 다른 값을 가지고 있음
- ```hashCode()``` 메소드를 실행해 해시코드 값이 같은지를 확인
    - 해시코드 값이 다름 -> 다른 객체로 판단
    - 해시코드 값이 같음 -> ```equals()``` 메소드로 다시 비교 -> 비교 후 같으면 동등객체, 다르면 다른 객체로 판단

<Br><br>

## ```hashMap```과 ```hashCode```

> Key.java
```java
public class Key {
    public int number;
    public Key(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object object) {
        if(obj instance of Key) {
            Key compareKey = (Key) obj;
            if(this.number) == compareKey.number) {
                return true;
            }
        }
        return false;
    }
}
```

>KeyExample.java
```java
public class KeyExample {
    public static void main(String[] args) {
        //Key 객체를 식별키로 사용해서 String 값을 저장하는 HashMap 객체 생성
        HashMap<Key, String> hashMap = new HashMap<Key, String>;

        //식별키 new Key(1)로 "홍길동"을 저장
        hashMap.put(new Key(1), "홍길동");

        //식별키 new Key(1)로 읽어옴
        String value = hashmap.get(new Key(1));
        System.out.println(value);
    }
}
```
>결과
```
null
```
- ```number``` 필드의 값이 같더라도 ```hashCode()``` 메소드에서 리턴하는 해시코드가 다르기 때문에 다른 식별키로 인식