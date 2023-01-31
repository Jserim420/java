# Set 컬렉션
- 저장 순서를 유지하는 ```List 컬렉션``` 과는 다르게, ```Set 컬렉션```은 저장 순서가 유지되지 않아 저장할 때의 순서와 나올 때의 순서가 다를 수 있다.
- 객체를 중복해서 저장할 수 없고, 하나의 null만 저장 가능
- ```HashSet```, ```LinkedHashSet```, ```TreeSet``` 등

## Set 인터페이스의 메소드
- [Oracle API Documents](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Set.html)

- ```add(E e)``` : 주어진 객체 저장

- ```clear()``` : 저장된 객체 모두 삭제

- ```contains(Object o)``` : 주어진 객체가 저장되어 있는지 확인

- ```isEmpty()``` : 컬렉션이 비어 있는지 확인

- ```iterator()``` : 저장된 객체를 한 번씩 가져오는 반복자 리턴
    ```java
    Set<String> set = new HashSet<String>();
    Iterator<String> iterator = set.iterator();
    ```
    
- ```remove(Object o)``` : 주어진 객체 삭제

- ```size()``` : 저장되어 있는 총 객체 수 리턴
