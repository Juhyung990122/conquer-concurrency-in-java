package com.techcoursetalk.concurrency.synchronizedInJava;

import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/atomic")
public class AtomicController {

    private AtomicInteger atomicCount = new AtomicInteger(0);


    @PostMapping("/increase")
    public ResponseEntity<Void> increaseAtomicCount() {
        atomicCount.addAndGet(1);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/count")
    public ResponseEntity<AtomicInteger> getAtomicCount() {
        return ResponseEntity.ok(atomicCount);
    }
}
