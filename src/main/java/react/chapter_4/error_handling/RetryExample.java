package react.chapter_4.error_handling;

import reactor.core.publisher.Flux;
import reactor.util.function.Tuple2;

import java.time.Duration;

public class RetryExample {
    public static void main(String[] args) throws InterruptedException {
        Flux<Tuple2<Long, String>> flux = Flux.range(1, 10)
            .interval(Duration.ofSeconds(1))
            .map(v -> {
                if (v < 3) {
                    return "tick " + v;
                }
                throw new RuntimeException("boom");
            })
            .retry(1)
            .elapsed();

        flux.subscribe(System.out::println);

        Thread.sleep(20_000);
    }
}
