package react.chapter_4.error_handling;

import reactor.core.Exceptions;
import reactor.core.publisher.Flux;

public class WrapUnwrapExceptionExample {
    public static void main(String[] args) {
        Flux.range(1, 10)
            .map(v -> {
                try {
                    return convert(v);
                } catch (Exception e) {
                    throw Exceptions.propagate(e);
                }
            })
            .subscribe(v -> System.out.println(v), e -> System.out.println("error: " + e));
    }

    private static String convert(Integer i) throws Exception {
        if (i.equals(3)) {
            throw new Exception("cya");
        }
        return String.valueOf(i);
    }
}
