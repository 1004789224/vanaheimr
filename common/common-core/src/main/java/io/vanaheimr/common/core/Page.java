package io.vanaheimr.common.core;

import java.util.Collection;

public record Page<T>(
        Collection<T> items,
        long totalCount
) {
}