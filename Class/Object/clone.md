# clone()
- 객체 복제 : 원본 객체의 필드값과 동일한 값을 가지는 새로운 객체를 생성
- 원본 객체를 안정하게 보호하기 위해 사용
- 얕은 복제 : 단순이 필드값을 복사해서 객체를 복제
- 깊은 복제 : 참조하고 있는 객체도 복제

<br><br>

## 앝은 복제(thin clone)
- 단순히 필드값을 복사해서 객체를 복제하는 것
- 필드가 기본 타입일 경우 값 복사
- 필드가 참조 타입일 경우 객체의 번지가 복사
- ```clone()``` : 자신과 동일한 필드값을 가진 얕은 복제된 객체를 리턴
    - 원본 객체는 반드시 ```java.lang.Cloneable``` 인터페이스를 구현
    - ```CloneNotSupportedException``` 예외 처리가 필요

```java
public class Member implements Cloneable {
    public String id;
    public String name;

    public Member(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Member getMember() {
        Member cloned = null;
        try{
            cloned = (Member) clone();
        } catch (CloneNotSupportedException e) { }
        return clone();
    }
}
```
- **원본 객체 생성 후 복제 객체를 생성해 값을 변경해도 원본 객체의 데이터는 변화가 없다.**

<Br>

## 깊은 복제(deep clone)
- 얕은 복제
    - 참조 타입 필드는 번지만 복제되기 때문에 원본 객체의 필드와 복제 객체의 필드는 같은 객체를 참조
    - 복제 객체에서 참조 객체를 변경하면 원본 객체도 변경된 객체를 가지게 됨
- 깊은 복제 : 참조하고 있는 객체도 복제
    - ```Oject```의 ```clone()``` 메소드를 재정의해서 참조 객체를 복제하는 코드를 직접 작성

```java
public class Member implements Cloneable {
    public String name;
    public int age;
    public int[] scores;
    public Car car;

    public Member(String name, int age, int[] scores, Car car) {
        this.name = name;
        this.age = age;
        this.scores = scores;
        this.car = car;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        // 얕은 복사를 해서 name, age를 복제
        Member cloned = (Member) super.clone(); // Object의 clone()을 호출
        // 깊은 복제
        cloned.scores = Arrays.copyOf(this.scores, this.scores.length);
        cloned.car = new Car(this.car.model);
        // 깊은 복제된 Member 객체 리턴
        return cloned;
    }

    public Member getMember() {
        Member cloned =  null;
        try{
            cloned = (Member) clone();
        } catch(CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return cloned;
    }
}

```
- **원본 객체 생성 후 복제 객체를 생성해 값을 변경해도 원본 객체 참조 객체의 데이터는 변화가 없다.**