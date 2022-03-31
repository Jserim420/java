# compare(T a, T b, Comparator <<T>T>c)
- 두 객체를 비교자(Conmparator)로 비교해서 int 값 리턴
- Comparator<<T>T> : 제네릭 인터페이스 타입으로 두 객체를 비교하는 compare(T a, T b)가 정의되어 있음
    ```java
    public interface Comparator<T> {
        int compare(T a, T b);
    }
    ```
- compare(T a, T b) : 비교할 객체 타입 T
- comapre() 메소드의 리턴 타입은 int인데, a가 b보다 작으면 음수, 같으면 0, 크면 양수를 리턴하도록 구현 클래스를 만들어 놓는다.


## 예시
```java
public class ComapreExample {
    public static void main(String[] args) {
        Student s1 = new Student(1);
        Student s2 = new Student(1);
        Student s3 = new Student(2);

        int result = Object.compare(s1, s2, new StudentComparator());
        System.out.println(result);
        result = Object.compare(s1, s3, new StudentComparator());
        System.out.println(result);
    }

    static class Student{
        int sno;
        Student(int sno) {
            this.sno = sno;
        }
    }

    static calss StudentComparator implements Comparator<Student> {
        @Override
        public int compare(Student o1, Student o2) {
            /* if(o1.sno<o2.sno) return -1;
            else if(o1.sno == o2.sno) return 0;
            else return 1 */
            // 위와 아래의 코드는 동일한 결과값을 출력
            return Integer.compare(o1.sno, o2.sno);
        }
    }
}
```
>결과
```
0
-1
```