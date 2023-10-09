package com.terheyden.javextras;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.jetbrains.annotations.NotNull;

/**
 * This annotation is used to mark an entire package as being {@code @NotNull} by default,
 * including all classes, methods, and fields.
 * <p>
 * Extends Jetbrains {@code @NotNull} annotation to be usable at the package level.
 * This is accomplished simply by omitting the {@code @Target} annotation.
 */
@NotNull                             // Apply this annotation to everything
@Documented                          // Include the annotations on THIS annotation in the JavaDocs
@Retention(RetentionPolicy.CLASS)    // Retain this annotation in the bytecode but not runtime
public @interface NotNullByDefault {
}
