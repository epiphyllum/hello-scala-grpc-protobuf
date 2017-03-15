package com.example

import java.util.concurrent.TimeUnit

import com.example.proto.GreeterGrpc.Greeter
import com.example.proto.{GreeterGrpc, HelloReply, HelloRequest}
import io.grpc.ServerBuilder

import scala.concurrent.{ExecutionContext, Future}


object Main extends App {

  val server = ServerBuilder.forPort(4080).addService(GreeterGrpc.bindService(new GreeterImpl, ExecutionContext.global)).build.start

  sys.addShutdownHook {
    if (!server.shutdown().awaitTermination(5, TimeUnit.SECONDS)) {
      server.shutdownNow()
    }
  }

  server.awaitTermination()
}

class GreeterImpl extends Greeter {

  override def sayHello(request: HelloRequest): Future[HelloReply] =
    Future.successful(HelloReply(s"Hello ${request.name}!"))
}
