# Java Multithreading Examples

This repository contains a collection of Java examples demonstrating various multithreading concepts and utilities in Java. It serves as a practical reference for Java developers working with concurrent programming.

## Overview

The project includes examples of:

- Basic thread creation and management
- Thread synchronization techniques
- Higher-level concurrency utilities from `java.util.concurrent`
- Thread pools and executors
- Locks and atomic operations

## Project Structure

This is a simple Java project organized into packages based on functionality:

```
src/com/shadangi54/example/
├── basicthread/          # Basic thread operations and utilities
├── synchronization/      # Thread synchronization mechanisms
├── concurrency/          # High-level concurrency utilities (includes Worker.java)
└── locks/               # Locks and synchronizers
```

## Examples Included

### Basic Thread Operations (`com.shadangi54.example.basicthread`)

- Thread creation (`MultiThreadingLearning.java`, `MultiThreadingLearning2.java`)
- Main thread operations (`MainThreadLearning.java`)
- Thread priorities (`ThreadPriority.java`)
- Daemon threads (`DaemonThread.java`)
- Thread joining (`JoinThread.java`)
- Thread termination (`StopThreadLearning.java`)

### Thread Synchronization (`com.shadangi54.example.synchronization`)

- Monitor locks (`MonitorLock.java`)
- Inter-thread communication (`InterThreadCommunication.java`)
- Producer-consumer pattern (`ProducerConsumerProblemThread.java`)
- Shared resources management (`SharedResource.java`)

### Concurrency Utilities (`com.shadangi54.example.concurrency`)

- Executor Services (`ExecutorServiceExample.java`)
- Thread Pool Executors (`ThreadPoolExecutorExample.java`)
- Scheduled Thread Pool Executor (`ScheduleThreadPoolExecutorExample.java`)
- Fork-Join Pool and RecursiveTask (`ForkJoinPoolExample.java`)
- Future and Callable (`FutureExample.java`, `CallableExample.java`)
- CompletableFuture (`CompletableFutureExample.java`)
- Virtual Threads (`VirtualThreadExample.java`)
- Thread-Local Storage (`ThreadLocalExample.java`)
- Worker utility class (`Worker.java`)

### Locks and Synchronizers (`com.shadangi54.example.locks`)

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

### Compilation and Execution

To compile and run any example:

```bash
# Compile a specific class
javac -d . src/com/shadangi54/example/<package>/<ClassName>.java

# Run the compiled class
java com.shadangi54.example.<package>.<ClassName>

# Examples:
# Compile and run a basic thread example
javac -d . src/com/shadangi54/example/basicthread/MultiThreadingLearning.java
java com.shadangi54.example.basicthread.MultiThreadingLearning

# Compile and run a concurrency example
javac -d . src/com/shadangi54/example/concurrency/ExecutorServiceExample.java
java com.shadangi54.example.concurrency.ExecutorServiceExample

# Compile and run a locks example
javac -d . src/com/shadangi54/example/locks/ReentrantLockExample.java
java com.shadangi54.example.locks.ReentrantLockExample
```

### Compile All Classes at Once

```bash
# Compile all classes in all packages
javac -d . src/com/shadangi54/example/*/*.java

# Or compile package by package
javac -d . src/com/shadangi54/example/basicthread/*.java
javac -d . src/com/shadangi54/example/synchronization/*.java
javac -d . src/com/shadangi54/example/concurrency/*.java
javac -d . src/com/shadangi54/example/locks/*.java
```

## Requirements

- Java 8 or higher
- Java 19+ required for Virtual Threads example

## License

This project is open-source and available for educational purposes.
