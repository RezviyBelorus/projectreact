package react.chapter_4.error_handling;

import reactor.core.publisher.Flux;

import java.util.function.Predicate;

public class OnErrorReturnExample {
    public static void main(String[] args) {
        Flux<Integer> flux_1 = Flux.range(1, 10)
            .map(v -> {
                if (v == 5) {
                    throw new RuntimeException("cya: " + v);
                } else {
                    return v + 1;
                }
            })
            .onErrorReturn(44);


        Flux<Integer> flux_2 = Flux.just(5, 10)
            .map(v -> {
                if (v == 5) {
                    throw new RuntimeException("cya: " + v);
                } else {
                    return v + 1;
                }
            })
            .onErrorReturn(e -> e.getMessage().equals("cya: 5"), 55);

        flux_1.subscribe(v -> System.out.println(v));
        flux_2.subscribe(v -> System.out.println(v));

        Predicate<Integer> predicate = i -> i < 10;
    }
}
