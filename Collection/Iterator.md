# Interface Iterator<<E>E>
- ```package java.util```

<br>

## 반복자
- 객체 지향 프로그래밍에서 배열이나 그와 유사한 자료구조의 내부요소를 순회하는 객체
- 컬렉션 인터페이스를 상속받는 클래스들에 대해 Iterator 인터페이스 사용 가능
- [반복문이 있는데 왜 반복자를 사용할까?](https://stackoverflow.com/questions/22267919/iterator-vs-for)
    ```
    - 인덱스가 없는 컬렉션을 다루기에 Iterator 가 더 적합하다.
    - for-each 반복문이 할 수 없는 반복도중 요소 제거가 가능한 Iterator
    - for-each는 처음부터 끝까지만 반복(요소를 제어할 수 없다)
    - 인덱스를 사용해 접근하는 것은 배열 컬렉션에서 효과적
    - get(i)에 접근하려고 할때마다 i번째 요소까지 모든 요소를 반복해야 하기에 성능이 나빠진다.
    - 인덱스가 없는 Set 컬렉션의 경우, for문대신에 for-each문을 사용하지만, 요소를 순회하다가 값을 수정 및 삭제를 하면 ConcurrentModificationException 예외가 발생한다.
    ```
- 반복자 ```Iterator``` 의 장점
    - 컬렉션에서 요소 제어
    - 리스트를 양방향(앞뒤) 으로 반복
    - 리스트의 요소 여부 확인 가능

<br>

## Iterator 메소드
- [Oracle API Doc](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Iterator.html)
- ```hasNext()``` : 가져올 객체가 있으면 true, 없으면 false 리턴
- ```next()``` : 다음 요소 반환
    ```java
    Set<String> set = new HashSet<String>();
    Iterator<String> iterator = set.iterator();
    while(iterator.hasNext() { // 반환할 객체가 없을때까지
        String myStr = iterator.next(); // 다음 요소를 반환
    })
    ```
- ```remove()``` : 반복자가 반환한 마지막 요소 제거
    ```java
    if(myStr.equals("Java")) { // 반환된 요소 myStr이 "Java"와 같으면
        iterator.remove(); // 해당 요소를 제거
    }
    ```