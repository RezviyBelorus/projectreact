package react.chapter_4;

import reactor.core.publisher.Flux;

public class FluxRangeWithError {
    public static void main(String[] args) {
        Flux<Integer> ints = Flux.range(1, 4)
                .map(i -> {
                    if (i <= 3) {
                        return i;
                    }
                    throw new RuntimeException("Got to 4");
                });

        ints.subscribe(i -> System.out.println(i), error -> System.out.println("Error: " + error.getMessage()));

        ints.subscribe(
                i -> System.out.println(i),
                error -> System.out.println(error.getMessage()),
                () -> System.out.println("Done")
        );
    }
}
