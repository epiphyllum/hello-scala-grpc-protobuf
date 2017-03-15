Example of Scala Protobuf and gRPC
==================================

References
----------

 * http://www.grpc.io/
 * https://scalapb.github.io/
 * https://developers.google.com/protocol-buffers/

How to test
-----------

 1. Run this project (`sbt run`)
 2. Use a gRPC client to make a request (you can use my fork of grpcc which
    fixes a critical issue:
    https://github.com/rodrigosetti/grpcc/tree/handle-dot-delimited)

```console
$ grpcc -a localhost:4080 -p src/main/protobuf/hello.proto -i
? What package you want to use? com.example.proto

Connecting to Greeter on localhost:4080. Available globals:

  client - the client connection to Greeter
    sayHello (HelloRequest, callback) returns HelloReply

  printReply - function to easily print a server reply (alias: pr)

Greeter@localhost:4080> client.sayHello({ name: 'Foo' }, pr)
EventEmitter {}
Greeter@localhost:4080> 
{
  "message": "Hello Foo!"
}
```

