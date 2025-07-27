# Java Multithreading Examples

This repository contains a collection of Java examples demonstrating various multithreading concepts and utilities in Java. It serves as a practical reference for Java developers working with concurrent programming.

## Overview

The project includes examples of:

- Basic thread creation and management
- Thread synchronization techniques
- Higher-level concurrency utilities from `java.util.concurrent`
- Thread pools and executors
- Locks and atomic operations

## Examples Included

- **Basic Thread Operations**
  - Thread creation (`MultiThreadingLearning.java`, `MultiThreadingLearning2.java`)
  - Main thread operations (`MainThreadLearning.java`)
  - Thread priorities (`ThreadPriority.java`)
  - Daemon threads (`DaemonThread.java`)
  - Thread joining (`JoinThread.java`)
  - Thread termination (`StopThreadLearning.java`)

- **Thread Synchronization**
  - Monitor locks (`MonitorLock.java`)
  - Inter-thread communication (`InterThreadCommunication.java`)
  - Producer-consumer pattern (`ProducerConsumerProblemThread.java`)
  - Shared resources management (`SharedResource.java`)

- **Concurrency Utilities**
  - Executor Services (`ExecutorServiceExample.java`)
  - Thread Pool Executors (`ThreadPoolExecutorExample.java`)
  - Future and Callable (`FutureExample.java`, `CallableExample.java`)
  - CompletableFuture (`CompletableFutureExample.java`)

- **Locks and Synchronizers**
  - ReentrantLock (`ReentrantLockExample.java`)
  - ReadWriteLock (`ReadWriteLockExample.java`)
  - StampedLock (`StampedLockExample.java`)
  - Semaphores (`SemaphoreLockExample.java`)
  - Lock-free Compare-And-Swap (CAS) operations (`LockFreeCASExample.java`)

## How to Use

Each Java class contains a standalone example that can be run independently. The classes include:
- Commented code explaining the concepts
- Working examples of the particular multithreading feature
- A main method to demonstrate the functionality

To run an example:

```bash
# Compile
javac -d ./target/classes src/main/java/com/shadangi54/example/<ClassName>.java

# Run
java -cp ./target/classes com.shadangi54.example.<ClassName>
```

## Requirements

- Java 8 or higher

## License

This project is open-source and available for educational purposes.