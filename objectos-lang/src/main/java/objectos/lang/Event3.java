/*
 * Copyright (C) 2022-2022 Objectos Software LTDA.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package objectos.lang;

/**
 * A log event that takes three arguments.
 *
 * @param <T1> the type of the first log argument
 * @param <T2> the type of the second log argument
 * @param <T3> the type of the third log argument
 *
 * @since 0.2
 */
public final class Event3<T1, T2, T3> extends Event {

  /**
   * Creates a new event instance.
   *
   * @param source
   *        a name to identify the source class this event is bound to
   * @param key
   *        a key that uniquely identifies this event within the given
   *        {@code source}
   * @param level
   *        the logging level of this event
   */
  public Event3(String source, Object key, Level level) {
    super(source, key, level);
  }

  /**
   * Creates a new DEBUG log event.
   *
   * <p>
   * The {@code source} and the {@code key} values are inferred from the method
   * immediately calling this method.
   *
   * <p>
   * The <strong>{@code source}</strong> value is the binary name of class
   * enclosing the method calling this method.
   *
   * <p>
   * The <strong>{@code key}</strong> value is a string containing the file
   * name, a colon ':' and the line number where this method has been invoked.
   *
   * @param <T1> the type of the log argument
   * @param <T2> the type of the second log argument
   * @param <T3> the type of the third log argument
   *
   * @return a new DEBUG log event
   */
  public static <T1, T2, T3> Event3<T1, T2, T3> debug() {
    return create(Level.DEBUG, Event3::new);
  }

  /**
   * Creates a new ERROR log event.
   *
   * <p>
   * The {@code source} and the {@code key} values are inferred from the method
   * immediately calling this method.
   *
   * <p>
   * The <strong>{@code source}</strong> value is the binary name of class
   * enclosing the method calling this method.
   *
   * <p>
   * The <strong>{@code key}</strong> value is a string containing the file
   * name, a colon ':' and the line number where this method has been invoked.
   *
   * @param <T1> the type of the log argument
   * @param <T2> the type of the second log argument
   * @param <T3> the type of the third log argument
   *
   * @return a new ERROR log event
   */
  public static <T1, T2, T3> Event3<T1, T2, T3> error() {
    return create(Level.ERROR, Event3::new);
  }

  /**
   * Creates a new INFO log event.
   *
   * <p>
   * The {@code source} and the {@code key} values are inferred from the method
   * immediately calling this method.
   *
   * <p>
   * The <strong>{@code source}</strong> value is the binary name of class
   * enclosing the method calling this method.
   *
   * <p>
   * The <strong>{@code key}</strong> value is a string containing the file
   * name, a colon ':' and the line number where this method has been invoked.
   *
   * @param <T1> the type of the log argument
   * @param <T2> the type of the second log argument
   * @param <T3> the type of the third log argument
   *
   * @return a new INFO log event
   */
  public static <T1, T2, T3> Event3<T1, T2, T3> info() {
    return create(Level.INFO, Event3::new);
  }

  /**
   * Creates a new TRACE log event.
   *
   * <p>
   * The {@code source} and the {@code key} values are inferred from the method
   * immediately calling this method.
   *
   * <p>
   * The <strong>{@code source}</strong> value is the binary name of class
   * enclosing the method calling this method.
   *
   * <p>
   * The <strong>{@code key}</strong> value is a string containing the file
   * name, a colon ':' and the line number where this method has been invoked.
   *
   * @param <T1> the type of the log argument
   * @param <T2> the type of the second log argument
   * @param <T3> the type of the third log argument
   *
   * @return a new TRACE log event
   */
  public static <T1, T2, T3> Event3<T1, T2, T3> trace() {
    return create(Level.TRACE, Event3::new);
  }

  /**
   * Creates a new WARN log event.
   *
   * <p>
   * The {@code source} and the {@code key} values are inferred from the method
   * immediately calling this method.
   *
   * <p>
   * The <strong>{@code source}</strong> value is the binary name of class
   * enclosing the method calling this method.
   *
   * <p>
   * The <strong>{@code key}</strong> value is a string containing the file
   * name, a colon ':' and the line number where this method has been invoked.
   *
   * @param <T1> the type of the log argument
   * @param <T2> the type of the second log argument
   * @param <T3> the type of the third log argument
   *
   * @return a new WARN log event
   */
  public static <T1, T2, T3> Event3<T1, T2, T3> warn() {
    return create(Level.WARN, Event3::new);
  }

}