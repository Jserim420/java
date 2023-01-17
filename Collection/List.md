# List 컬렉션
- 객체를 일렬로 늘어놓은 구조

<br>

## List 메소드
- ```toArray()``` : List를 Array로 변환
    ```java
    List<String> strList = new ArrayList<>();
    String[] strArray = strList.toArray(new String[10]);
    // strList 리스트를 크기가 10인 strArray 배열로 변환
    ```