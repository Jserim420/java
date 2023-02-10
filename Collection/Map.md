# Map 컬렉션 ```Interface Map <K,V>```
- 키 ```Key``` 와 값 ```Value``` 으로 구성된 ```Entry 객체``` 를 저장하는 구조
- 키와 값은 모두 객체이며, 키는 중복으로 저장될 수 없지만 값은 중복 저장 가능
    
    ![Map](https://blog.kakaocdn.net/dn/b3gy9V/btqEiNHEghR/RvrymgKHYbqQoI0Ek5rgL0/img.png)
- ```HashMap``` , ```Hashtable``` , ```LinkedHashMap``` , ```Properties``` , ```TreeMap``` 등

<br>

## Map 메소드
```java
Map<String, Integer> map = new HashMap<String, Integer>();
```
- [Oracle API Doc](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Map.html)

- ```clear()``` : 모든 ```Map.Entry(키와 값)```을 삭제
    ```java
    map.clear();
    ```

- ```containsKey(Object key)``` , ```containsValue(Object value)``` : 주어진 키/값 이 있는지 확인
    ```java
    map.containsKey("Java"); // 키 Java 가 있는지 확인 후 boolean 리턴  
    map.containsValue(10); // 값 10 이 있는지 확인 후 boolean 리턴
    ```

- ```entrySet()``` : 키와 값의 쌍으로 구성된 모든 ```Map.Entry 객체```를 ```Set 객체``` 에 담아서 리턴
    ```java
    map.entrySet(); // map 객체에 있는 모든 쌍을 Set에 담아서 리턴, 반환 타입 Set<Map.Entry<K,V>>
    ```

- ```get(Ojbect key)``` : 주어진 키가 있는 값을 리턴
    ```java
    map.get("Java"); // 키 Java 와 쌍을 이루는 값을 리턴
    ```

- ```isEmpty()``` : 컬렉션이 비어 있는지 확인
    ```java
    map.isEmpty(); // map 객체가 비어있는지 확인
    ```

- ```keySet()``` : 모든 키를 ```Set 객체```에 담아 리턴
    ```java
    map.keySet(); // map 객체의 모든 키를 Set 객체에 담아 리턴, 반환타입 Set<K>
    ```

- ```put(K key, V value)``` : 주어진 키로 값을 저장하며, 새로운 키일 경우 ```null``` 리턴, 동일한 키가 있을 경우 값을 대체하고 이전 값을 리턴
    ```java
    map.put("Java", 10);
    // 새로운 키일 경우 : null 리턴
    // 기존에 키 Java가 있을 경우, 값을 10으로 대체하고 이전 값 리턴 
    ```

- ```remove(Object key)``` : 주어진 키와 일치하는 ```Map.Entry 객체``` 를 삭제하고 값 리턴
    ```java
    map.remove("Java") // 키 Java 로 이루어진 객체 쌍 삭제
    ```

- ```size()``` : 저장된 키의 총 개수를 리턴
    ```java
    map.size();
    ```

- ```values()``` : 저장된 모든 값을 ```Colllection```에 담아서 리턴 
    ```java
    map.values(); // 반환타입 Collection<V>
    ```

<br>

## [```Map.Entry```](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Map.Entry.html)
- ```public static interface Map.Entry<K,V>```
- 키와 값을 가지고 있는 객체
- ```Map Entry``` 에 대한 객체를 불러오는 유일한 방법은 반복자를 사용하는 것이며, ```Map.Entry 객체``` 는 반복 기간 동안에만 유효

<br>

## 저장된 전체 객체를 대상으로 키/값 얻기
1. ```keySet()``` 메소드
    ```java
    Map<K,V> map = ··· ; // Map 객체 선언
    Set<K> keySet = map.keySet(); // map의 모든 키를 Set 객체에 담아 리턴
    Iterator<K> keyIterator = keySet.Iterator(); // 반복자
    while(keyIterator.hasNext()) { // 반복자를 통해 키가 있을 경우
        K newKey = keyIterator.next(); // 키 얻기
        V newValue = map.get(newKey); // 얻은 키를 통해 map 객체의 값 얻기
    }
    ```

2. ```entrySet()``` 메소드
    ```java
    Map<K,V> map = ··· ; // Map 객체 선언
    Set<Map.Entry<K,V>> entrySet = map.entrySet(); // map객체의 키,값 쌍을 가지고 있는 Map.Entry를 Set 객체로 리턴
    Iterator<Map.Entry<K,V>> entryIterator = entrySet.Iterator(); // 반복자
    while(entryIterator.hasNext()) { // 키,값 쌍(Map.Entry) 이 있을 경우
        Map.Entry<K,V> entry = entryIterator.next(); // Map.Entry 객체 얻기
        K newKey = entry.getKey(); // Map.Entry 객체의 키 얻기
        V newValue = entry.getValue(); // Map.Entry 객체의 값 얻기
    }
    ```