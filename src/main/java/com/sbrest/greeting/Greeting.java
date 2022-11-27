package com.sbrest.greeting;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Greeting {

   @GetMapping("/")
   public String getGreeting(){
      return "Hi, Welcome to SimpliLearn PG FSD";
   }

   @GetMapping("/{name}")
   public String sayGreeting(@PathVariable() String name) {
      return "Welcome, " + name.toUpperCase();
   }


}
