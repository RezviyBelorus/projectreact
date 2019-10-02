package react.chapter_4;

import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

public class FluxJust {
    public static void main(String[] args) {
        Flux<String> seq1 = Flux.just("foo", "bar", "foobar");
        List<String> iterable = Arrays.asList("foo", "bar", "foobar");
        Flux<String> seq2 = Flux.fromIterable(iterable);

        Flux<Integer> range = Flux.range(5, 3);
        range.subscribe();

        range.subscribe(i -> System.out.println(i));
    }
}
