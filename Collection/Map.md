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

<br><br>

# ```HashMap```
```java
Map<K, V> map = new HashMap<K, V>();
// K: key타입, V: value타입
```

- ```Map 인터페이스```를 구현한 대표적인 Map 컬렉션
- ```HashMap```의 '키'로 사용할 객체는 ```hashCode()```와 ```equals()``` 메소드를 재정의해 동등 객체가 될 조건을 정해야 한다
    ```
    동등 객체 조건
    
    1. hashCode()의 리턴값이 동일
    2. equals() 메소드가 true를 리턴

    키 타입을 String으로 사용할 경우 
    - 문자열이 같으면 동등객체가 될 수 있도록 메소드가 재정의 되어 있음
    ```
- 키와 값의 타입은 기본 타입을 사용할 수 없고 클래스 및 인터페이스 타입만 가능

<br><br>

# ```Hashtable```
```java
Map<K, V> map = new Hashtable<String, IntegerK, V>();
// K: key타입, V: value타입
```
- ```HashMap```과 동일한 내부 구조를 가지고 있어, ```Hashtable```의 키로 사용될 객체도 동등 객체가 될 조건을 정해야 한다.

- ```Hashtable``` 은 ```HashMap``` 과 달리, 동기화된 ```synchronized``` 메소드로 구성되어 있기 때문에 멀티 스레드가 동시에 이 메소드를 실행 불가능

<br>

## [Properties (java.util.Properties)](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Properties.html)
- Hashtable의 하위 클래스 ```extends Hashtable<Object, Object>```
- Hashtable과의 차이점 : 키와 값을 String 타입으로 제한 
- 애플리케이션의 옵션 정보, 데이터베이스 연결 정보, 국제화 정보가 저장된 프로퍼티 ```.properties``` 파일을 읽을 때 주로 사용

    ```
    프로퍼티 파일
    - 키와 값이 = 기호로 연결되어 있는 텍스트 파일, ISO 8859-1 문자셋
    - 문자셋으로 직접 표현할 수 없는 한글은 유니코드로 변환
    ```

<br>

## 프로퍼티 파일 읽기
- ```Properties``` 객체 생성 후 , ```load()``` 호출
- 프로퍼티 파일은 일반적으로 클래스 파일 ```.class``` 과 함께 저장
- ```load()``` : 프로퍼티 파일로부터 데이터를 읽기 위해 FileReader 객체를 매개 값으로 받는다.
    ```java
    Properties properties = new Properties();
    properties.load(new FileReader("프로퍼티 파일 경로"));
    ```

- ```getResource()``` : 클래스 파일을 기준으로 상대 경로를 이용해 프로퍼티 파일의 경로 얻기
    - ```getResource()```는 주어진 파일의 상대 경로를 URL 객체로 리턴
- ```getPath()``` : 해당 URL 파일의 절대 경로 리턴
    ```java
    String path = 클래스.class.getResource("프로퍼티 파일 경로").getPath()
    ```

- ```getProperty()``` : ```Properties``` 객체에서 해당 키의 값 읽기
    - ```Properties``` 도 ```Map 컬렉션``` 이므로 ```get()``` 메소드를 사용할 수 있지만, ```get()``` 메소드는 값을 ```Object``` 타입으로 리턴하므로 일반적으로 ```getProperty()``` 사용
