# 자바 기본 API 클래스
- [Oracle API Documents](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/module-summary.html)

## java.lang.*
- 자바 프로그램의 기본적인 클래스를 담고 있는 패키지(import 없이 사용)
- [Object](https://github.com/Jserim420/java/tree/main/Class/Object) : 자바 클래스의 최상위 클래스
- [System] : 입출력, JVM종료, 쓰레기 수집기 요청
- [Class] : 클래스를 메모리로 로딩
- [String](https://github.com/Jserim420/java/blob/main/Class/String.md) : 문자열을 저장 및 정보 수집
- [StringBuffer](https://github.com/Jserim420/java/blob/main/Class/StringBuffer.md), [StringBuilder] : 문자열 저장 및 조작
- [Math] : 수학 함수
- [Wrapper] : 기본 타입의 데이터 객체 사용


## java.util.*
- [Arrays](https://github.com/Jserim420/java/blob/main/Class/Arrays.md) : 배열을 조작
- [Calendar] : OS의 날짜와 시간 수집
- [Date] : 날짜와 시간정보 저장
- [Objects](https://github.com/Jserim420/java/tree/main/Class/Objects.md) : 객체 비교, 널 여부 조사
- [Scaaner](https://github.com/Jserim420/java/blob/main/Class/Scanner.md) : 키보드 입력
- [StringTokenizer](https://github.com/Jserim420/java/blob/main/Class/StringTokenizer.md) : 특정 문자로 구분된 문자열 뽑기
- [Random] : 난수 생성

## java.io.*
- 데이터를 외부에서 입출력하는 작업을 담고 있는 패키지
- [File] : 파일 시스템의 파일 정보 수집
- [Console] : 콘솔로부터 문자를 입출력
- [InputStream/OutPutStream] : 바이트 단위 입출력을 위한 최상위 입출력 스트림
- [FileInputStream/DataInputStream/ObjectInputStream/PrintStream/BufferedInputStream···] : 바이트 단위 입출력을 위한 하위 스트림
- [Reader/Writer] : 문자 단위 입출력을 위한 최상위 입출력 스트림
- [BufferedReader/BufferedWriter](https://github.com/Jserim420/java/blob/main/Class/Bufferd_wr.md) : 문자 단위 입출력을 위한 하위 스트림