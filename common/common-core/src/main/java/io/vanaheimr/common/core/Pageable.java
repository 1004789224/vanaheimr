package io.vanaheimr.common.core;

import java.util.Collection;

public record Pageable<T>(
        Collection<T> items,
        long totalCount
) {
}