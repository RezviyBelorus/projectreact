package react.chapter_4.error_handling;

import reactor.core.publisher.Flux;

public class RetryWhen {
    public static void main(String[] args) {
        Flux.<String>error(new IllegalArgumentException())
            .doOnError(System.out::println)
            .retryWhen(companion -> companion.take(2))
//            .retry(3)
            .subscribe(v -> System.out.println("hello: " + v));
    }
}
