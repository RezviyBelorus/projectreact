package react.chapter_4.error_handling;

import reactor.core.publisher.Flux;

public class OnErrorResume {
    public static void main(String[] args) {
        Flux<Integer> integerFlux = Flux.range(1, 10)
            .map(v -> {
                if (v == 5) {
                    throw new RuntimeException("cya: " + v);
                } else {
                    return v + 1;
                }
            })
            .onErrorResume(e -> {
                System.out.println("CAUGHT");
                return Flux.range(6, 10);
            });


        integerFlux.subscribe(v -> System.out.println(v));
    }
}
