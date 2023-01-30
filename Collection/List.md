# List 컬렉션
- 객체를 일렬로 늘어놓은 구조
- 객체를 인덱스로 관리하기 때문에, 객체를 저장하면 자동 인덱스가 부여되고 인덱스로 객체를 다루는 기능을 제공
- 객체 자체를 저장하는 것이 아니라 객체의 번지를 참조하며, 동일한 객체를 중복 젖ㅇ할 경우 동일한 번지가 참조

<br>

## List 메소드
- ```add(E element)``` , ```add(int index, E element)``` : 주어진 객체를 추가
    ```java
    List<String> strList = new ArrayList<>();
    strList.add("java"); // strList 맨 끝에 삽입
    strList.add(2, "Java"); // strList의 2번 인덱스에 Java 삽입
    ```

- ```clear()``` : 저장된 모든 객체 삭제
    ```java
    strList.clear();
    ```

- ```contains(Object o)``` : 주어진 객체가 저장되어 있는지 확인
    ```java
    strList.contains("Java");
    ```

- ```get(int index)``` : 주어진 인덱스에 저장된 객체 리턴
    ```java
    strList.get(1);
    ```

- ```isEmpty()``` : 컬렉션이 비어 있는지 조사
    ```java
    strList.isEmpty();
    ```

- ```remove(int index)``` , ```remove(Object o)``` : 저장된 객체 삭제
    ```java
    strList.remove(0); // 0번 인덱스 객체 삭제
    strList.remove("Java"); 
    ```

- ```size()``` : 저장되어 있는 총 객체 수 리턴
    ```java
    strList.size();
    ```


- ```set(int index, E element)``` : 주어진 인덱스에 저장된 객체를 주어진 객체로 변경
    ```java
    strList.set(0, "JAVA");
    ```


- ```toArray()``` : List를 Array로 변환
    ```java
    String[] strArray = strList.toArray(new String[10]);
    // strList 리스트를 크기가 10인 strArray 배열로 변환
    ```

<br>

# ```ArrayList```
- List 인터페이스의 구현 클래스
- ```ArrayList``` 는 배열과는 다르게 저장 용량을 초과한 객체들이 들어오면 자동적으로 용량이 증가
![ArrayList](https://t1.daumcdn.net/cfile/tistory/995E66395B1CFD7D10?original)

## ArrayList 특징
- ```ArrayList``` 에 객체를 추가하면 뒤에서 부터 차례대로 저장된다.
- ```ArrayList``` 에서 특정 인덱스의 객체를 제거하면, 바로 뒤 인덱스부터 마지막 인덱스까지 모두 앞으로 1씩 당겨진다.
![ArrayList.remove](https://t1.daumcdn.net/cfile/tistory/99C515395B1CF0FD37?original)
- ```ArrayList``` 에서 특정 인덱스에 객체를 추가하면, 바로 뒤 인덱스부터 마지막 인덱스까지 모두 뒤로 1씩 밀려난다.

    > <b>빈번한 객체 삭제와 삽입</b>이 일어난다면 ```ArrayList``` 보다는 ```LinkedList``` 를 사용하는 것이 좋으며, <b>인덱스 검색이나 마지막에 객체를 추가하는 경우</b> 에는 ```ArrayList``` 가 더 좋은 성능을 발휘

<Br>

# ```Vector```
- ```ArrayList``` 와 동일한 내부구조
- ```Vetor``` 생성 : 저장할 객체 타입을 차입 파라미터로 표기 후 기본 생성자 호출
    ```java
    List<E> list = new Vector<E>();
    ```
## ArrayList 와 다른 점
- 동기화된 ```synchronized``` 메소드로 구성되어 있기 때문에 멀티 스레드가 동시에 이 메소드를 실행할 수 없고, 하나의 스레드가 실행을 완료해야만 다른 스레드를 실행
    > ```Thread Safe``` : 멀티 스레드 환경에서 안전하게 객체를 추가, 삭제

<br>

# ```LinkedList```
- ```ArrayList``` 와 사용 방법은 똑같지만 내부 구조는 완전히 상이
- ```LinkedList``` 는 ```ArrayList``` 와는 다르게, 인접 참조를 링크해서 체인처럼 관리
    ![LinkedList](https://blog.kakaocdn.net/dn/dQ7bEz/btqRxZ4MX46/lKb7vOWlf9VJDDiAfnKuEk/img.jpg)
- 특정 인덱스의 객체를 제거하면 앞뒤 링크만 변경되고 나머지 링크는 변경되지 않는다.

## ```ArrayList``` VS ```LinkedList```
- 순차적으로 추가, 삭제 하는 경우 : ```ArrayList``` 가 유리
- 중간에 추가, 삭제 하는 경우 : ```LinkedList``` 가 유리
- 검색 : ```ArrayList``` 가 유리