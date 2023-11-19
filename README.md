# multi-threading-java


<details>
<summary>1 Introduction</summary>

### Motiviation and OS fundamentals
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


</details>
