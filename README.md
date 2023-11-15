# Performance testing of web frameworks using Bombardier

In this project we utilize [Bombardier](https://github.com/codesenberg/bombardier) to conduct simple load-testing.

The subject of our tests is the GET `/heroes/1` endpoint, which queries the 'heroes' table for a 'hero' entity by ID.
The associated 'hero' entity will have its field 'level' modified based on a counter, which resides in the Controller.
This has been implemented in order to mitigate caching.

## Requirements

* x86-64
* Linux/Unix
* [Docker](https://www.docker.com/products/docker-desktop/)
* [JDK 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
* [Maven](https://maven.apache.org/)


## Startup

The script "up" creates our database and starts the specified application based on arguments:
```
1. docker-compose -f docker/heroes/docker-compose.yml up -d
2.1 mvn spring-boot:run -f spring-boot-jdbc/pom.xml
2.2. mvn spring-boot:run -f spring-boot-webflux-r2dbc/pom.xml
```

The associated `docker-compose` also contains initialization scripts for creating our database and inserting test rows.


## Shutdown

The script "down" removes our database container:
```
1.docker-compose -f docker/heroes/docker-compose.yml down
```

## My Hardware Specs

### CPU

```
Intel(R) Core(TM) i7-1165G7 @ 2.80GHz (4 cores, 8 threads)
```

### RAM

```
32 GB
```

## Vanilla Spring Boot with JDBC

### 10 Concurrent Connections, 10000 Requests
```plaintext
Command: bombardier -m GET localhost:8080/heroes/1 -c 10 -n 10000
Statistics        Avg      Stdev        Max
  Reqs/sec      1257.67     120.55    1440.96
  Latency        7.95ms     0.99ms    31.54ms
  HTTP codes:
    1xx - 0, 2xx - 10000, 3xx - 0, 4xx - 0, 5xx - 0
    others - 0
  Throughput:     0.89MB/s
 ```

### 50 Concurrent Connections, 10000 Requests 
```plaintext
Command: bombardier -m GET localhost:8080/heroes/1 -c 50 -n 10000
Statistics        Avg      Stdev        Max
  Reqs/sec      1204.09     127.07    1433.73
  Latency       41.47ms     3.90ms    92.54ms
  HTTP codes:
    1xx - 0, 2xx - 10000, 3xx - 0, 4xx - 0, 5xx - 0
    others - 0
  Throughput:     0.85MB/s
 ```

### 100 Concurrent Connections, 10000 Requests
```plaintext
Command: bombardier -m GET localhost:8080/heroes/1 -c 100 -n 10000
Statistics        Avg      Stdev        Max
  Reqs/sec      1191.75     139.86    1713.61
  Latency       83.64ms    10.66ms   269.06ms
  HTTP codes:
    1xx - 0, 2xx - 10000, 3xx - 0, 4xx - 0, 5xx - 0
    others - 0
  Throughput:   861.02KB/s
 ```

### 250 Concurrent Connections, 10000 Requests
```plaintext
Command: bombardier -m GET localhost:8080/heroes/1 -c 250 -n 10000
Statistics        Avg      Stdev        Max
  Reqs/sec      1188.36     149.74    1439.17
  Latency      208.14ms    22.79ms   582.02ms
  HTTP codes:
    1xx - 0, 2xx - 10000, 3xx - 0, 4xx - 0, 5xx - 0
    others - 0
  Throughput:   859.36KB/s
 ```

### 500 Concurrent Connections, 10000 Requests
```plaintext
Command: bombardier -m GET localhost:8080/heroes/1 -c 10 -n 10000
Statistics        Avg      Stdev        Max
  Reqs/sec      1220.48     174.07    2902.90
  Latency      401.70ms    60.74ms      0.87s
  HTTP codes:
    1xx - 0, 2xx - 10000, 3xx - 0, 4xx - 0, 5xx - 0
    others - 0
  Throughput:     0.86MB/s
 ```

### 2500 Concurrent Connections, 25000 Requests
```plaintext
Command: bombardier -m GET localhost:8080/heroes/1 -c 2500 -n 25000
Statistics        Avg      Stdev        Max
  Reqs/sec       401.86    2182.33   45602.77
  Latency         6.74s      3.06s     19.80s
  HTTP codes:
    1xx - 0, 2xx - 3149, 3xx - 0, 4xx - 0, 5xx - 0
    others - 21851
  Errors:
    dial tcp [::1]:8080: connectex: No connection could be made because the target machine actively refused it. - 17741
       timeout - 4110
  Throughput:    52.27KB/s
 ```


## Spring Boot WebFlux with R2DBC

### 10 Concurrent Connections, 10000 Requests
```plaintext
Command: bombardier -m GET localhost:8080/heroes/1 -c 10 -n 10000
Statistics        Avg      Stdev        Max
  Reqs/sec      4242.66     395.24    4747.89
  Latency        2.35ms   598.21us    35.32ms
  HTTP codes:
    1xx - 0, 2xx - 10000, 3xx - 0, 4xx - 0, 5xx - 0
    others - 0
  Throughput:     2.75MB/s
 ```

### 50 Concurrent Connections, 10000 Requests
```plaintext
Command: bombardier -m GET localhost:8080/heroes/1 -c 50 -n 10000
Statistics        Avg      Stdev        Max
  Reqs/sec      4459.91     707.80    6318.56
  Latency       11.21ms     6.64ms   244.03ms
  HTTP codes:
    1xx - 0, 2xx - 10000, 3xx - 0, 4xx - 0, 5xx - 0
    others - 0
  Throughput:     2.89MB/s
 ```

### 100 Concurrent Connections, 10000 Requests
```plaintext
Command: bombardier -m GET localhost:8080/heroes/1 -c 100 -n 10000
Statistics        Avg      Stdev        Max
  Reqs/sec      4634.43     654.16    6620.50
  Latency       21.53ms    13.42ms   254.55ms
  HTTP codes:
    1xx - 0, 2xx - 10000, 3xx - 0, 4xx - 0, 5xx - 0
    others - 0
  Throughput:     3.01MB/s
 ```

### 250 Concurrent Connections, 10000 Requests
```plaintext
Command: bombardier -m GET localhost:8080/heroes/1 -c 250 -n 10000
Statistics        Avg      Stdev        Max
  Reqs/sec      4442.67     851.09    6222.31
  Latency       55.90ms    21.16ms   423.48ms
  HTTP codes:
    1xx - 0, 2xx - 10000, 3xx - 0, 4xx - 0, 5xx - 0
    others - 0
  Throughput:     2.87MB/s
 ```

### 500 Concurrent Connections, 10000 Requests
```plaintext
Command: bombardier -m GET localhost:8080/heroes/1 -c 500 -n 10000
Statistics        Avg      Stdev        Max
  Reqs/sec      4581.87    1002.97    9452.95
  Latency      106.10ms    27.42ms   356.11ms
  HTTP codes:
    1xx - 0, 2xx - 10000, 3xx - 0, 4xx - 0, 5xx - 0
    others - 0
  Throughput:     2.97MB/s
 ```

### 2500 Concurrent Connections, 25000 Requests
```plaintext
Command: bombardier -m GET localhost:8080/heroes/1 -c 2500 -n 25000
Statistics        Avg      Stdev        Max
  Reqs/sec      3532.44    2371.40   30110.29
  Latency      706.18ms   324.09ms      3.33s
  HTTP codes:
    1xx - 0, 2xx - 25000, 3xx - 0, 4xx - 0, 5xx - 0
    others - 0
  Throughput:     2.22MB/s
 ```

## Golang Gin with Bun

### 10 Concurrent Connections, 10000 Requests
```plaintext
Command: bombardier -m GET localhost:8080/heroes/1 -c 10 -n 10000
Statistics        Avg      Stdev        Max
  Reqs/sec       908.54     262.00    1729.76
  Latency       11.03ms     9.70ms    91.43ms
  HTTP codes:
    1xx - 0, 2xx - 10000, 3xx - 0, 4xx - 0, 5xx - 0
    others - 0
  Throughput:   665.95KB/s
 ```

### 50 Concurrent Connections, 10000 Requests
```plaintext
Command: bombardier -m GET localhost:8080/heroes/1 -c 50 -n 10000
Statistics        Avg      Stdev        Max
  Reqs/sec       844.80     484.33    4062.98
  Latency       62.80ms    49.06ms   265.43ms
  HTTP codes:
    1xx - 0, 2xx - 10000, 3xx - 0, 4xx - 0, 5xx - 0
    others - 0
  Throughput:   583.94KB/s
 ```

### 100 Concurrent Connections, 10000 Requests
```plaintext
Command: bombardier -m GET localhost:8080/heroes/1 -c 100 -n 10000
Statistics        Avg      Stdev        Max
  Reqs/sec      2823.61    1693.89    7586.94
  Latency       35.68ms    35.69ms   329.06ms
  HTTP codes:
    1xx - 0, 2xx - 10000, 3xx - 0, 4xx - 0, 5xx - 0
    others - 0
  Throughput:     1.97MB/s
 ```

### 250 Concurrent Connections, 10000 Requests
```plaintext
Command: bombardier -m GET localhost:8080/heroes/1 -c 250 -n 10000
Statistics        Avg      Stdev        Max
  Reqs/sec      3662.85    2296.23   12146.79
  Latency       70.79ms    54.21ms   461.63ms
  HTTP codes:
    1xx - 0, 2xx - 10000, 3xx - 0, 4xx - 0, 5xx - 0
    others - 0
  Throughput:     2.50MB/s
 ```

### 500 Concurrent Connections, 10000 Requests
```plaintext
Command: bombardier -m GET localhost:8080/heroes/1 -c 500 -n 10000
Statistics        Avg      Stdev        Max
  Reqs/sec      3652.13    2302.18   11292.50
  Latency      135.97ms   105.69ms      0.92s
  HTTP codes:
    1xx - 0, 2xx - 10000, 3xx - 0, 4xx - 0, 5xx - 0
    others - 0
  Throughput:     2.57MB/s
 ```

### 2500 Concurrent Connections, 25000 Requests
```plaintext
Command: bombardier -m GET localhost:8080/heroes/1 -c 2500 -n 25000
Statistics        Avg      Stdev        Max
  Reqs/sec      3998.95    2770.36   16837.75
  Latency      658.39ms   473.92ms      4.08s
  HTTP codes:
    1xx - 0, 2xx - 25000, 3xx - 0, 4xx - 0, 5xx - 0
    others - 0
  Throughput:     2.66MB/s
 ```