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

- [```iterator()```](https://github.com/Jserim420/java/blob/main/Collection/Iterator.md) : 저장된 객체를 한 번씩 가져오는 반복자 리턴
    ```java
    Set<String> set = new HashSet<String>();
    Iterator<String> iterator = set.iterator();
    ```
    
- ```remove(Object o)``` : 주어진 객체 삭제

- ```size()``` : 저장되어 있는 총 객체 수 리턴

<br><br>

# ```HashSet```
- ```Set 인터페이스```의 구현 클래스로, 객체들을 순서 없이 저장하고 동일한 객체는 중복 저장하지 않는다.
- 동일한 객체란 꼭 같은 인스턴스를 뜻하지는 않는다.

## ```HashSet```의 객체 저장 순서
1. 객체를 저장하기 전에 먼저 객체의 ```hashCode()``` 메소드를 호출해 해시코드를 얻어낸다.
2. 1에서 얻어낸 해시코드와 이미 저장되어 있는 객체들의 해시코드를 비교한다.
3. 동일한 해시코드가 있다면 다시 ```equals()``` 메소드로 두 객체를 비교해 ```true``` 가 나오면 동일한 객체로 판단한다. (중복 저장 X)

- 문자열을 저장 할 경우 : 같은 문자열을 갖는 String 객체는 동일한 객체로, 다른 문자열을 갖는 ```String``` 객체는 다른 객체로 간주
    -``` String클래스```에 ```hashCode()```와 ```equals()``` 메소드가 재정의 되어 있기 때문
    - ```hashCode()``` 와 ```equals()``` 오버라이딩을 통해 사용자 정의 클래스에서 객체의 동일성을 직접 판단할 수 있다. 

<br><br>

# ```TreeSet``` (java.util.TreeSet<<E>E>)
- 검색 기능을 강화시킨 ```Map 컬렉션```
- [이진트리](https://github.com/Jserim420/Computuer_Science/blob/main/Data_Structure/NonLinear.md#%ED%8A%B8%EB%A6%AC-%EC%A2%85%EB%A5%98) 를 이용해 계층적 구조를 가지면서 객체를 저장

![TreeSet](https://user-images.githubusercontent.com/81462623/218412921-e97c2393-a65e-4f4e-ae18-2819cc8bdb95.png)
- 노드의 구성 : 노드값 Value + 왼쪽 값 + 오른쪽 값

```java
TreeeSet<E> treeSet = new TreeSet<E>();
```

<br>

## [TreeSet 클래스의 메소드](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/TreeSet.html)

> 검색
- ```ceiling(E e)``` : 주어진 객체와 동등한 객체가 있으면 리턴, 없으면 바로 위의 객체 리턴
- ````first()```` : 제일 낮은 객체 리턴
- ````floor(E e)```` : 주어진 객체와 동등한 객체가 있으면 리턴, 없으면 바로 아래의 객체 리턴
- ````higher(E e)```` : 주어진 객체보다 바로 위 객체 리턴
- ````last()```` : 제일 높은 객체 리턴
- ````lower(E e)```` : 주어진 객체보다 바로 아래 객체 리턴
- ````pollFirst()```` : 제일 낮은 객체를 꺼내오고 컬렉션에서 제거
- ````pollLast()```` : 제일 높은 객체를 꺼내오고 컬렉션에서 제거

> 정렬
- ```descendingIterator()``` : 내림차순으로 정렬된 ```Iterator``` 리턴
- ```descendingSet()``` : 내림차순으로 정렬된 ```[NavigableSet](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/NavigableSet.html)``` 리턴
    - 정렬 순서를 바꾸고 싶으면 ```dexcendingSet()```을 두번 호출

> 범위 검색
- ```headSet(E toElement, boolean inclusive)``` : 주어진 객체보다 낮은 객체들은 ```NavigableSet``` 으로 리턴
    - 주어진 객체 포함 여부는 ```inclusive``` 에 따라 달라짐
    ```java
    TreeSet<String> treeSet = new TreeSet<String>();
    NavigableSet<String> rangeSet = treeSet.headSet("K", false);
    // "K"를 포함하지 않은 다음 "L"부터의 단어 검색
    ```
- ```tailSet(E fromElement, booleadn inclusive)``` : 주어진 객체보다 높은 객체들은 ```NavigableSet``` 으로 리턴
    - 주어진 객체 포함 여부는 ```inclusive``` 에 따라 달라짐
    ```java
    NavigableSet<String> rangeSet = treeSet.tailSet("A", ture) 
    // "A"을 포함하여 "A"부터의 단어 검색
    ```
- ``subSet(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive)`` : 시작과 끝으로 주어진 객체 사이의 객체들을 ```NavigableSet``` 으로 리턴
    - 시작과 끝 객체의 포함 여부는 ```fromInclusive```, ```toInclusive```에 따라 달라짐
    ```java
    TreeSet<String> treeSet = new TreeSet<String>();
    NavigableSet<String> rangeSet = treeSet.subSet("A", true, "D", true) // A~D 사이의 단어 검색
    ```