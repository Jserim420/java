# Collection (컬렉션)
- 객체를 수쥡해 저장하는 역할
- 배열의 문제점을 해결하고 자료구조를 바탕으로 객체들을 효율적으로 추가, 삭제, 검색할 수 있도록 ```java.util``` 패키지에 컬렉션과 관련된 인터페이스와 클래스들을 포함
- 컬렉션 프레임워크 : 몇 가지 인터페이스를 통해 다양한 컬렉션 클래스를 이용할 수 있도록 함
- 주요 인터페이스
    - ```Collection``` : 
        - [List](https://github.com/Jserim420/java/blob/main/Collection/List.md) : 순서를 유지하고 저장
            - ArrayList, Vector, LinkedList
        - Set : 순서를 유지하지 않고 저장
            - HashSet, TreeSet
    - Map : 키와 값을 하나의 쌍으로 저장
        - HashMap, Hashtable, TreeMap, Properties

<br>
<br>

### 배열의 단점
- 배열은 쉽게 생성하고 사용할 수 있지만, 저장할 수 있는 객체 수가 배열을 생성할 때 결정되기 때문에 불특정 수의 객체를 저장에 문제가 발생
- 배열의 객체를 삭제 했을 때 해당 인덱스가 비게 되는 문제가 발생