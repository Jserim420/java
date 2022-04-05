# 스레드
- 멀티 스레드 : 하나의프로세스가 두 가지 이상의 작업을 처리
- 하나의 스레드는 하나의 코드 실행 흐름이기 때문에 한 프로세스 내에 스레드가 두 개라면 두 개의 코드 실행 흐름이 생긴다.
- 멀티 스레드는 하나의 프로세스 내부에 생성되기 때문에 하나의 스레드가 예외를 발생시키면 프로세스 자체가 종료될 수 있어 다른 스레드에게 영향을 미친다.

<br>

## 메인 스레드
자바 애플리케이션의 메인 스레드는 ```main()```메소드를 실행하면서 시작
- 메인 스레드는 필요에 따라 작업 스레드들을 만들어서 병렬로 코드를 수행
- 멀티 스레드 애플리케이션은 실행 중인 스레드가 하나라도 있다면 프로세스는 종료되지 않는다.

<br>

## 작업 스레드
메인 작업 이외에 추가적인 병렬 작업의 수만큼 스레드 생성

- 작업스레드 생성하기
    1. Thread 클래스로부터 직접 생성
        - 생성자 호출
        ```java
        Thread thread = new Thread(Runnabe target)
        ```
        - ```Runnable``` 구현 클래스 생성
        
        ```Runnable```은 작업 스레드가 실행할 수 있는 코드를 가지고 있는 객체
        ```java
        class Task implements Runnable {
            public void run() {
                스레드가 실행할 코드;
            }
        }
        ```
        - 작업 스레드 생성
        ```java
        Runnable task = new Task();
        Thread thread = new Thread(task);
        ```
        - 작업 스레드 실행
        ```java
        thread.start();
        ```
    2. ```Thread``` 하위 클래스로부터 생성
        - Thread 클래스를 상속한 후 run 메소드 재정의
        ```java
        public class WorkerThread extends Thread {
            @Override
            public void run() {
                //스레드가 실행할 코드
            }
            Thread thread = new WorkerThread();
        }
        ```
        - 작업 스레드 실행
        ```java
        thread.start();
        ```

## 스레드이름
```java
// 스레드 이름 설정하기
thread.setName("스레드 이름");

// 스레드 이름 가져오기
thread.getName();

// 현재 스레드 참조 얻기(해당 코드를 실행하는 스레드 객체 얻기)
Thread thread = Thread.currentThread();
```

<br>

## 스레드 우선순위
- 스레드 스케줄링 : 스레드의 개수가 코어의 수보다 많을 경우, 스레드를 어떤 순서에 의해 동시성으로 실행할 것인가를 결정
    - 우선순위 방식 : 우선순위가 높은 스레드가 실행 상태를 더 많이 가지도록 스케줄링, 코드로 제어 가능
        - ```Thread``` 클래스의 ```setPriority()``` 메소드 사용
    - 순환 할당 방식 : 시간 할당량을 정해 하나의 스레드를 정해진 시간만큰 실행하고 다시 다른 스레드를 실행하는 방식, 코드로 제어 불가

```java
// 우선순위 변경하기
thread.setPriority(우선순위);

// Thread 클래스의 상수를 사용한 우선순위
thread.setPriority(Thread.MAX_PRIORITY); // 10
thread.setPriority(Thread.NORM_PRIORITY); // 5
thread.setPriority(Thread.MIN_PRIORITY); // 1
```

<br>

## 동기화 메소드와 동기화 블록
- 스레드가 사용 중인 객체를 다른 스레드가 변경할 수 없도록 하려면 스레드 작업이 끝날 때까지 객체에 잠금을 걸어 다른 스레드가 사용할 수 없도록 해야한다.
- 동기화 메소드
    ```java
    public synchronized void method() {
        임계 영역; // 단 하나의 스레드만 실행
    }
    ```
- 동기화 블록
    ```java
    public void method() {
        // 여러 스레드가 실행 가능한 영역

        synchronized(공유객체) {
            임계 영역 // 단 하나의 스레드만 실행
        }

        // 여러 스레드가 실행 가능한 영역
    }
    ```
- [예시](https://github.com/Jserim420/java/tree/main/java-example/Thread/threadExample)