package react.chapter_4.error_handling;

import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicInteger;

public class DoFinallyExample {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(0);

        Flux<Integer> integerFlux = Flux.range(1, 10)
            .map(v -> {
                if (v == 5) {
                    throw new RuntimeException("cya: " + v);
                } else {
                    return v + 1;
                }
            })
            .doOnSubscribe(s -> atomicInteger.incrementAndGet())
            .doFinally(s -> System.out.println("stats: " + atomicInteger.get()))
            .onErrorResume(e -> {
                System.out.println("CAUGHT");
                return Flux.range(6, 10);
            });


        integerFlux.subscribe(v -> System.out.println(v));
    }
}
