# hash()와 hashCode()
- ```Objects.hash (Object value)``` : 매개값으로 주어진 값들을 이용해 해시 코드를 생성
    - 주어진 매개값들로 배열을 생성하고 ```Arrays.hashCode(Object[])```를 호출해 해시코드를 얻고 이 값을 리턴
    - 클래스가 ```hashCode()```를 재정의할 때 리턴값을 생성하기 위해 사용
- 클래스가 여러가지 필드를 가지고 있을 때 이 필드드로부터 해시코드를 생성하게 되면 **동일한 필드값을 가지는 객체는 동일한 해시코드를 가질 수 있다.**
- ```Objects.hashCode (Object o)``` 와 ```o.hashCode()```의 리턴값은 동일

<br>

## 예시
```java
public class HashCodeExample {
    public static void main(String[] args) {
        Student s1 = new Student(1, "홍길동");
        Student s2 = new Student(1, "홍길동");
        System.out.println(s1.hashCode());
        System.out.println(Objects.hashCode(s2));
    }

    static class Student{
        int sno;
        String name;
        Student(int sno, String name) {
            this.sno = sno;
            this.name = name;
        }

        @Override
        public int hashCode() {
            return Objects.hash(sno, name); // sno과 name으로 주어진 값들을 이용해 해시코드 생성
        }
    }
}
```
> 동일한 필드값을 가지는 객체는 같은 해시코드를 갖는다.
```
s1.hashCode() = Object.hashCode(s2)
```