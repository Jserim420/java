# Buffered 입출력

## BufferdReader/BufferedWriter : Buffer에 있는 입출력(IO) 클래스
- 입/출력된 데이터가 바로 전달되지 않고 중간에 버퍼링이 된 후 전달
- 버퍼스트림을 InputStreamReader/OutputStreamWriter를 같이 사용하게 되면 효율적인 입출력이 가능하다.
- scanner를 통해 입력 받을경우 Space와 Enter 모두 경계로 인식하기 때문에 입력받은 데이터를 가공하기 편리하다.
- BufferedReader는 Enter만 경계로 인식하고 받은 데이터가 String으로 고정되기 때문에 데이터를 가공하는 작업이 필요하다.
- 많은 양의 데이터를 입력받을 경우 BufferedReader를 사용하는 것이 효율성이 높다.

<br>

## BufferedReader

```java
BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//BufferedReader 선언하기
String s = bf.readLine();
// BufferedReader는 데이터가 String으로 고정되기 때문에 bf에서 읽은 데이터의 값 s는 String이다.
int i = Integer.paseInt(bf.readLine());
// String형 s를 int형으로 형변환하기 위함이다.
```
- ButteredReader에서 읽어들인 데이터의 값은 String으로 고정되기 때문에 필요에 따라 형변환을 한다.
- 예외처리 : try-catch 또는 throws IOException

<br>

## Read한 데이터 가공하기
- Read한 데이터는 Line단위로만 나눠지기 때문에 공백단위로 데이터를 가공하려면 따로 작업을 해주어야 한다.

1. StringTokenizer 
    ```java
    StringTokenizer st = new StringTokenizer(s);
    int a = Integer.parseInt(st.nextToken());
    ```
    - StringTokenizer는 <a>여기</a>를 참조

2. String.split(" ");
    ```java
    String array[] = s.split(" ");
    ``` 
    - String.split();은 <a>여기</a>를 참조


<br>

## BufferedWriter
- 일반적인 출력은 System.out.println(); 을 사용한다.
- 많은 양의 데이터를 출력할 때는 BufferedWriter를 사용
```java
BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//BufferedWriter 선언
String s = "Hello"; // 출력할 문자열
bw.write(s); // 출력
bw.newLine(); // 줄바꿈
bw.flush(); // 남아있는 데이터 모두 출력
bw.close(); // 스트림을 닫음
```
- 반드시 flush(), colse()를 호출해 마무리를 해주어야 한다.
- bw.write는 자동Enter기능이 없기 때문에 필요에 따라 \n을 추가해야 한다.

<br>

## BufferedWriter로 int형 출력
```java
BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
bw.write(100);
bw.flush();
bw.close();
```
결과 
> d (아스키코드로 출력됨)

```java
BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
bw.write(100+"");
bw.flush();
bw.close();
```
결과
> 100 (정상출력) 

String형으로 변환시켜주면 정상출력된다.