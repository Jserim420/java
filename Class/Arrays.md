# Arrays (java.util.Arrays)
- 배열을 다루기 위한 메소드
- ```Arrays```의 모든 메소드는 ```static method``` 이므로 객체를 생성하지 않고 바로 사용

<br>

## Arrays 메소드
- [Oracle API Documents](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Arrays.html)

- ```binarySearch(배열, 찾는값)``` : 전체 배열 항목에서 찾는 값이 있는 인덱스 리턴(배열이 정렬되어 있는 경우에 사용)
    ```java
    String[] stringArr = {"Ant" , "C" , "Github" , "Java"};
    Arrays.binarySearch(stringArr, "C"); // stringArr에 "C"가 포함된 인덱스 1 리턴
    ```

- ```copyOf(원본배열, int newLength)``` , ```copyOfRange(원본배열, int from, int to)``` : 원본 배열을 복사한 배열 리턴
    ```java
    String[] newArr = Arrays.copyOf(stringArr, stringArr.length); // stringArr의 배열의 크기와 같은 newArr에 stringArr전체를 복사
    String[] newArr2 = Arrays.copyOf(newArr, 1, 3); // newArr[1]~newArr[2]를 복사하여 newArr2에 대입
    ```

- ```deepEquals(배열, 배열)```, ```equals(배열, 배열)``` : : 두 배열의 비교
    ```java
    Arrays.equals(stringArr, newArr); // 두 배열 비교(1차 항목의 값만 비교)
    Arrays.deepEquals(stringARr, newArr); // 두 배열 비교(1차 항목이 서로 다른 배열을 참조할 경우 중첩된 배열의 항목까지 비교)
    ```

- ```fill(배열, int val)```, ```fill(배열, int toIndex, int val)``` : 배열의 항목에 동일한 값 저장
    ```java
    ```

- ```sort(배열)``` : 배열을 오름차순으로 정렬
    ```java
    Int[] intArr = {10,2,3,4,0};
    Arrays.sort(intArr); // intArr의 배열을 오름차순으로 정렬 {0, 2, 3, 4, 10}; 
    ```

- ```toString(배열)``` : "[ , , ]" 형태의 배열 항목 문자열 리턴
    ```java
    Arrays.toString(stingArr); 
    ```

