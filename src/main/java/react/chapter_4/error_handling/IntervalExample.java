package react.chapter_4.error_handling;

import reactor.core.publisher.Flux;

import java.time.Duration;

public class IntervalExample {
    public static void main(String[] args) throws InterruptedException {
        Flux<String> flux = Flux.range(1, 10)
            .interval(Duration.ofSeconds(1))
            .map(v -> {
                if (v < 3) {
                    return "tick " + v;
                }
                throw new RuntimeException("boom");
            })
            .onErrorResume(v -> Flux.just("A"))
            .onErrorReturn("Uh oh");

        flux.subscribe(System.out::println);

        Thread.sleep(20_000);
    }
}
