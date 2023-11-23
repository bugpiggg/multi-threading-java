# multi-threading-java

<details>
<summary>1 Introduction</summary>

Motiviation and OS fundamentals
- Why we need Threads?
    - Responsiveness (특히 User Interface에서 더 치명적임) by concurrency = multitasking
    - Performance(짧은 시간안에 더 많은 작업 처리 가능) by parallelism
- Multithreading caveat(경고)
    - Multithreaded programming은 근본적으로 싱글쓰레드 프로그래밍과 다름

- What is thread?
    - 컴퓨터를 켜면 OS가 디스크에서 메모리로 올라옴
    - 우리가 한 어플리케이션을 실행시키면 마찬가지로 디스크에서 메모리로 인스턴스가 생성됨
    - 위 인스턴스는 프로세스/context of application이라고도 불림
    - 이 프로세스는 다른 프로세스와 완전히 독립적임
    - Files, Data(Heap), Code, Main Thread(Stack, Instruction Pointer)로 구성됨
    - 쓰레드 단위에서는 Stack과 IP를 뺀 나머지는 공유됨
    - Stack은 로컬변수들이 저장되고, 함수에 전달되는 메모리 영역/ IP는 수행할 다음 instruction 주소


OS fundamentasl part2

- What is context switch?
    - 프로세스는 다른 프로세스와 독립적으로 수행됨
    - 프로세스는 하나 이상의 스레드를 가지며, 스레드들은 cpu를 점유하기 위해 경쟁함 
    - 그래서 context switch는 스레드 1 수행 -> 스레드 1 멈춤 -> 스레드 2 수행
    - price of multitasking
    - 스레드가 너무 많으면 -> trashing = 실제 작업보다 스레드 매니징에 시간이 더 쓰임
    - 스레드 간의 sw가 프로세스 간의 sw 보다 싸다

 - Thread scheduling
    - First come first serve -> 수행시간이 긴 스레드가 먼저 오면 stravation 발생가능
    - Shortest Job First -> 수행시간이 짧은 스레드가 계속 오면 수행시간 긴거 수행 못함
    - 실제 os에서는 dynamic priority를 사용함 (User Interface UI 에는 우선순위 부여, Stravation 방지)

- Thread vs Process
    - thread
        - if task share a lot of data
        - faster
        - switching is faster
    - process
        - security and stability are higher importance
        - tasks are unrelated

</details>

<details>
<summary>2 Threading fundamentals - Thread Creation</summary>

Thread Creation 1

- Thread.sleep() 함수는 OS로 하여금 현재 쓰레드를 스케줄하지 않도록 지정(loop를 돌거나 하는 것이 아님!!)
    - CPU 점유 안 함

- threadInstance.setPriority(1..10) 를 통해 우선순위를 설정할 수 있음

- thread.setUncaughtExceptionHandler()를 통해 예외처리 핸들러 등록가능

Thread Creation 2

- Thread를 상속하는 클래스를 만들고, run() 함수를 구현하는 방식으로도 쓰레드를 생성할 수 있다.

</details>

<details>
<summary>3 Threading fundamentals - Thread Coordination</summary>

Thread Termination & Daemon Threads 1

<Thread termination>
- 쓰레드는 리소스 점유함 -> 메모리와 커널 리소스. 만약 CPU를 쓰게 되면 CPU cycles과 cache memory 까지
- 만약 쓰레드가 끝나면, 리소스 정리할 필요가 있음
- 쓰레드가 이상하게 동작하면, 멈출 필요가 있음
- **만약 수행중인 쓰레드가 존재하면 application은 멈추지 않음**

<Interrupt 하는 방법>
- interrupt signal을 손수처리하는 코드 추가
- InterruptedException 던지는 method 실행

<데몬 쓰레드>
- 종료되도 상관없는 쓰레드. 애플리케이션동작에 영향을 주지 않기를 원할때
- gracefully 하게 종료되지 않아도 되는 쓰레드


Joining Threads

<Why do we need it?>
- 다른 쓰레드는 독립적으로 동작함
- 쓰레드의 수행은 out of control 임

<How?>
- 쓰레드가 loop를 돌면서 다른 쓰레드가 끝났는지 계속 체크한다 -> 비효율적임
- 좋은 방법은 쓰레드가 go to sleep 하는거임
    - 이를 위해 join을 쓰면 댐


</details>