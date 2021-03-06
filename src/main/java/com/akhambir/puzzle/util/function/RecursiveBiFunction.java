package com.akhambir.puzzle.util.function;

import java.util.function.BiFunction;

@FunctionalInterface
public interface RecursiveBiFunction<T, U, R> {

    R apply(final T t, final U u, final BiFunction<T, U, R> self);
}
