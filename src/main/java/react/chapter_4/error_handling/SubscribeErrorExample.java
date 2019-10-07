package react.chapter_4.error_handling;

import reactor.core.publisher.Flux;

public class SubscribeErrorExample {
    public static void main(String[] args) {
        Flux<Integer> flux = Flux.range(1, 20)
            .map(v -> v + 1)
            .map(v -> {
                if (v < 10) {
                    return v + 2;
                } else {
                    throw new RuntimeException("cya " + v);
                }
            });

        flux.subscribe(
            v -> System.out.println("RECEIVED: " + v),
            error -> System.out.println("CAUGHT " + error)
        );


    }
}
