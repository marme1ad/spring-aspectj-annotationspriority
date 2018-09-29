# spring-aspectj-annotationspriority

_Spring 5_, _AspectJ 1.9.1_ based minimal example for defining join points to introduce annotations priority: method-level annotation should overwrite class-level one.
Quick example for Stack Overflow [question >>](https://stackoverflow.com/questions/52506915/various-pointcut-expression-scopes-trigger-multiple-advice-calls-unexpectedly)

To start tomcat server run next command from the repository root:

```sh
$ mvn org.apache.tomcat.maven:tomcat7-maven-plugin:2.2:run
```

Then open in browser: `http://localhost:8080/hello/sayhello`, in the log you will see:

```
[http-bio-8080-exec-1] INFO com.stackoverflow.ProcedureAspect - com.stackoverflow.HelloController#hello([SECURE])
[http-bio-8080-exec-1] INFO com.stackoverflow.ProcedureAspect - com.stackoverflow.HelloService#doNonAnnotatedCall([message])
[http-bio-8080-exec-1] INFO com.stackoverflow.ProcedureAspect - com.stackoverflow.HelloService#doCall([SECURE])
```
