package react.chapter_4;

import reactor.core.Disposable;
import reactor.core.publisher.Flux;

public class FluxSubscribe {
    public static void main(String[] args) {
        Flux<Integer> ints = Flux.range(1, 20);

        Disposable done = ints.subscribe(
                i -> System.out.println(i),
                error -> System.out.println(error.getMessage()),
                () -> System.out.println("Done"),
                sub -> sub.request(5)
        );


    }
}
