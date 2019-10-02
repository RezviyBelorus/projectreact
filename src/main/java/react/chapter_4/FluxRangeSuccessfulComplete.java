package react.chapter_4;

import reactor.core.publisher.Flux;

public class FluxRangeSuccessfulComplete {
    public static void main(String[] args) {
        Flux<Integer> ints = Flux.range(1, 4);

        ints.subscribe(
                i -> System.out.println(i),
                error -> System.out.println(error.getMessage()),
                () -> System.out.println("Done")
        );
    }
}
